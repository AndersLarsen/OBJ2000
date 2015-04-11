package model;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.zip.ZipFile;

public class ServerCommunicatorModel {
	
	private String sessionRequest = "http://oo.hive.no/vlnch/client?service=authenticate&";
	private String requestBackup = "http://oo.hive.no/vlnch/client?service=backup&sessionid=";
	private String requestGetZip = "http://oo.hive.no/vlnch/client?service=getzip&sessionid=";
	private URL url;
	private XMLDecoder xmlDecoder;
	private CachingResultSetTableModel caching = null;
	private ZipFile zipFile = null;
	
	public ServerCommunicatorModel(){
		
	}
	
	public CachingResultSetTableModel getCaching(){
		return caching;
	}
	
	public ZipFile getZipFile(){
		return zipFile;
	}
	
	public boolean startCommunication(String username, String password){
		sessionRequest = sessionRequest + "username=" + username + "&password=" + password;
		boolean allGood = false;
		
		try {
			allGood = requestLogin();
			allGood = requestBackup();
			requestGetZip();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NullPointerException e){
			e.printStackTrace();
			System.out.println("Feil passord?");
		}
		return allGood;
	}

	private boolean requestLogin() throws MalformedURLException, IOException, NullPointerException{
		url = new URL(sessionRequest);
		xmlDecoder = new XMLDecoder(url.openStream());
		Object object = xmlDecoder.readObject();
		if(object instanceof Properties){
			Properties userProperties = (Properties) object;
			requestBackup = requestBackup + userProperties.getProperty("id");
			requestGetZip = requestGetZip + userProperties.getProperty("id");
			//System.out.println(requestBackup + " " + requestGetZip);
			xmlDecoder.close();
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean requestBackup() throws MalformedURLException, IOException{
		url = new URL(requestBackup);
		xmlDecoder = new XMLDecoder(url.openStream());
		Object object = xmlDecoder.readObject();
		if(object instanceof CachingResultSetTableModel){
			caching = (CachingResultSetTableModel) object;
			xmlDecoder.close();
			return true;
		}
		else{
			return false;
		}
	}
	
	private void requestGetZip() throws MalformedURLException, IOException{
		url = new URL(requestGetZip);
		System.out.println(url);
		ZipExpert zipexpert = new ZipExpert();
		zipFile = zipexpert.saveZipFileDataToFile(url);
		//return false;
	}
	
}
