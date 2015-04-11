package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

public class MyCourseModel {
	
	private CachingResultSetTableModel caching = null;
	private ZipFile zipFile = null;
	private int row = 0;
	private int column = 7;
	
	private List<String> problemnos = null;
	private List<String> trynos = null;
	private List<String> titles = null;
	private List<String> courses = null;
	private List<String> orgfnames = null;
	private List<String> coursenames = null;

	public MyCourseModel(CachingResultSetTableModel caching, ZipFile zipFile) {
		this.caching = caching;
		this.zipFile = zipFile;
		row = caching.getRowCount();
	}
	
	public MyCourseModel(CachingResultSetTableModel caching) {
		this.caching = caching;
		row = caching.getRowCount();
	}
	
	public CachingResultSetTableModel getCaching(){
		return caching;
	}
	
	public List<String> getCourse(){
		return courses;
	}
	
	public List<String> getCoursename(){
		return coursenames;
	}
	
	public List<String> getProblemno(){
		return problemnos;
	}
	
	public List<String> getTitle(){
		return titles;
	}
	
	public List<String> getTrynos(){
		return trynos;
	}
	
	public List<String> getOrgfnames(){
		return orgfnames;
	}
	
	public void filCoursesCoursenames(){
		String course = "";
		String newCourse = "";
		courses = new ArrayList<String>();
		coursenames = new ArrayList<String>();
		for (int j = 0; j < row; j++) {
			newCourse = (String) caching.getValueAt(j, 3);
			if(!course.equals(newCourse)){
				course = newCourse;
				courses.add(course);
				coursenames.add((String) caching.getValueAt(j, 6));
			}
		}
	}
	
	public void filProblemnoTitles(String myCourse){
		String problem = ""; 
		String newProblem = "";
		problemnos = new ArrayList<String>();
		titles = new ArrayList<String>();
		String course = "";
		for (int j = 0; j < row; j++) {
			newProblem = (String) caching.getValueAt(j, 0);
			course = (String) caching.getValueAt(j, 3);
			if(myCourse.equals(course)){
				if(!problem.equals(newProblem)){
					problem = newProblem;
					problemnos.add(problem);
					titles.add((String) caching.getValueAt(j, 2));
				}
			}
		}
	}

	public void filTrynosOrgfnames(String myCourse, String myProblemno){
		String tryno = ""; 
		String newTryno = "";
		trynos = new ArrayList<String>();
		orgfnames = new ArrayList<String>();
		String course = "";
		String problemno = "";
		for (int j = 0; j < row; j++) {
			newTryno = (String) caching.getValueAt(j, 1);
			course = (String) caching.getValueAt(j, 3);
			problemno = (String) caching.getValueAt(j, 0);
			if(myCourse.equals(course) && myProblemno.equals(problemno)){
				if(!tryno.equals(newTryno)){
					tryno = newTryno;
					trynos.add(tryno);
					orgfnames.add((String) caching.getValueAt(j, 4));
				}
			}
		}
	}	
	
	public String getFileString(String course, String problem, String tryno){
		return course + File.separator + "oppgave" + problem + File.separator + "versjon" + tryno;
	}
	
}
