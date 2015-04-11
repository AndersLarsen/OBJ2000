package model;

 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.swing.JFrame;


public class ZipExpert extends JFrame {

	static String sessionId = "-479917601";
	static String SESSIONREQUEST = "http://oo.hive.no/vlnch/client?service=getzip&sessionid="
			+ sessionId;
	File targetDir = new File("test");
	
	public ZipFile saveZipFileDataToFile(URL url){
		//System.out.println("start save zip");
		ZipFile zipFile = null;
		if (!targetDir.exists()) {
			targetDir.mkdirs();
	      }
		try {
			InputStream in = new BufferedInputStream(url.openStream(), 2048); 		//spesialisering: leser ut datastrøm
			File zip = File.createTempFile("arc", ".zip", targetDir); 				//lager en temporær fil i ønsket mappe
			OutputStream out = new BufferedOutputStream(new FileOutputStream(zip)); //output til fil
			byte[] buffer = new byte[2048]; 										// kopierer fra input til output
			int len = in.read(buffer); 												// bruker til å overføre
			while (len >= 0) {
				//System.out.println("while løkke");
				out.write(buffer, 0, len);
				len = in.read(buffer);
			}
			in.close();
			out.close();
			zipFile = new ZipFile(zip);
			zip.deleteOnExit();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zipFile;
	}
	
	public void extractZipFile(ZipFile zipFile){
		for (Enumeration entries = zipFile.entries(); entries.hasMoreElements(); ) { // enumeration: slags liste, entries(forekomst, fil og folder)
			ZipEntry entry = (ZipEntry) entries.nextElement();
			System.out.println(entry.getName());
			try {
				File tempFile = File.createTempFile(File.separator + entry.getName(), null, targetDir);
				if (!entry.isDirectory()) {
					InputStream in2 = zipFile.getInputStream(entry);

					
					//FileInputStream fin = new FileInputStream(file);
					BufferedReader br = new BufferedReader(new InputStreamReader(in2)); 
					String line; 
					while (( line = br.readLine()) !=null ){ 
						 System.out.println(line); 
					 }
					in2.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void extractZipFile(ZipFile zipFile, String filePathString, String fileType){
		for (Enumeration entries = zipFile.entries(); entries.hasMoreElements(); ) { // enumeration: slags liste, entries(forekomst, fil og folder)
			ZipEntry entry = (ZipEntry) entries.nextElement();
			//System.out.println("test 2 i enum");
			try {

				if (!entry.isDirectory() && filePathString.equals(entry.getName())) {
					String content = "";
					if(fileType.equals("zip")){
						System.out.println("zip");
						ZipInputStream zin = new ZipInputStream(zipFile.getInputStream(entry));
						content = FilePrintZip(zin);
					}
					if(fileType.equals("java") || fileType.equals("txt")){
						System.out.println("Java");
						InputStream in = zipFile.getInputStream(entry);
						content = FilePrint(in);
					}
					
					System.out.println(content);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public String FilePrint(InputStream in){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = "";
		String temp = "";
		try {
			while ((temp = br.readLine()) != null) {
				line += temp;
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	
	public String FilePrintZip(ZipInputStream in){
		
		DataInputStream dataLeser = new DataInputStream(in);
		String line = "";
		String temp = "";
		ZipEntry z = null;
		try {
			while ((z = in.getNextEntry()) != null) {
				temp = ("\r\n\r\nFILNAVN:  **  " + z.getName() + "  **\r\n");
				byte[] b = new byte[(int) z.getSize()];
				dataLeser.readFully(b);
				line = line + temp + new String(b);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
	
	public void ZipExpertzzz() {
		if (!targetDir.exists()) {
	          targetDir.mkdirs();
	      }
		try {
			URL url = new URL(SESSIONREQUEST);
			InputStream in = new BufferedInputStream(url.openStream(), 1024); //spesialisering: leser ut datastrøm
			File zip = File.createTempFile("arc", ".zip", targetDir); //lager en temporær fil i ønsket mappe
			OutputStream out = new BufferedOutputStream(new FileOutputStream(zip)); //output til fil
			//DataInputStream dataLeser = new DataInputStream(in);
			// kopierer fra input til output
			byte[] buffer = new byte[1024];
			int len = in.read(buffer); // bruker til å overføre
			while (len >= 0) {
				out.write(buffer, 0, len);
				len = in.read(buffer);
			}
			
			
			out.close();
			
			//åpner zipfil
			ZipFile zipFile = new ZipFile(zip);
			
			for (Enumeration entries = zipFile.entries(); entries.hasMoreElements(); ) { // enumeration: slags liste, entries(forekomst, fil og folder)
				ZipEntry entry = (ZipEntry) entries.nextElement();
				System.out.println(entry.getName());
				File file = new File(targetDir, File.separator + entry.getName());
				
				// ny kode
				 
				if (!buildDirectory(file.getParentFile())) {
					throw new IOException("Could not create directory: " + file.getParentFile());
				}
				if (!entry.isDirectory()) {
					InputStream in2 = zipFile.getInputStream(entry);
					OutputStream out2 = new BufferedOutputStream(new FileOutputStream(file));
					byte[] buffer2 = new byte[1024];
					int length2 = in.read(buffer2);
					while (length2 >= 0) {
						out.write(buffer2, 0, length2);
						length2 = in.read(buffer2);
					}
					
					//FileInputStream fin = new FileInputStream(file);
					BufferedReader br = new BufferedReader(new InputStreamReader(in2)); 
					String line; 
					while (( line = br.readLine()) !=null ){ 
						 System.out.println(line); 
					 }
					 
					
					in2.close();
					out2.close();
				} else {
					if (!buildDirectory(file)) {
						throw new IOException("Could not create directory: "
								+ file);
					}
				}
				
			}
			
			in.close();
			zip.deleteOnExit();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * JScrollPane jsp = new JScrollPane(t); Container cp =
		 * getContentPane(); cp.add(jsp,"Center"); cp.add(new Panel(),"West");
		 * pack(); //pakker sammen elementer setVisible(true);
		 */

	}
	
	public static boolean buildDirectory(File file) {
		return file.exists() || file.mkdirs(); // hvis filen ikke eksisterer lages direktory (må skrive om!)
	}
	
//	public ZipExpert(){
//		URL url = null;
//		try {
//			url = new URL(SESSIONREQUEST);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ZipFile tempfile = saveZipFileDataToFile(url);
//		extractZipFile(tempfile);
//	}

	public static void main(String[] s) {

		new ZipExpert();
		

	}

}