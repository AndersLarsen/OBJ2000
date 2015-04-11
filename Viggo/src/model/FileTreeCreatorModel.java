package model;

import java.util.Iterator;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileTreeCreatorModel {
	
	private MyCourseModel myCourseModel;
	private CachingResultSetTableModel caching;

	public FileTreeCreatorModel(MyCourseModel myCourseModel){
		this.myCourseModel = myCourseModel;
		this.caching = myCourseModel.getCaching();
	}
	
	public JTree makeTree(String username){
		DefaultMutableTreeNode user = new DefaultMutableTreeNode(caching.getValueAt(0, 5));
		JTree theTree = new JTree(user);
		
		myCourseModel.filCoursesCoursenames();
		//myCourseModel.filProblemnoTitles("KURS0031");
		//myCourseModel.filTrynosOrgfnames("KURS0031", "1");
		
		List<String> courses = myCourseModel.getCourse();
		List<String> problemnos = myCourseModel.getProblemno();
		List<String> titles = myCourseModel.getTitle();
		List<String> trynos = myCourseModel.getTrynos();
		List<String> orgfnames = myCourseModel.getOrgfnames();
		
		for (Iterator<String> iteratorCourse = courses.iterator(); iteratorCourse.hasNext();) {
			String stringCourse = (String) iteratorCourse.next();
			System.out.println("Kurs " + stringCourse);
			DefaultMutableTreeNode courseNode = addAFile(stringCourse, user);
			myCourseModel.filProblemnoTitles(stringCourse);
			problemnos = myCourseModel.getProblemno();
			titles = myCourseModel.getTitle();
			Iterator<String> iteratorTitles = titles.iterator();
			for (Iterator<String> iteratorProblemno = problemnos.iterator(); iteratorProblemno.hasNext();) {
				String stringProblemno = (String) iteratorProblemno.next();
				String stringTitle = (String) iteratorTitles.next();
				System.out.println("Oppgave " + stringProblemno + ": " + stringTitle + "");
				DefaultMutableTreeNode problemNode = addAFile("Oppgave " + stringProblemno + ": " + stringTitle + "", courseNode);
				myCourseModel.filTrynosOrgfnames(stringCourse, stringProblemno);
				trynos = myCourseModel.getTrynos();
				orgfnames = myCourseModel.getOrgfnames();
				Iterator<String> iteratorOrgfnames = orgfnames.iterator();
				for (Iterator<String> iteratorTryno = trynos.iterator(); iteratorTryno.hasNext();) {
					String stringTryno = (String) iteratorTryno.next();
					String stringOrgfname = (String) iteratorOrgfnames.next();
					System.out.print("Versjon " + stringTryno + " (" + stringOrgfname + "), ");
					addAFile("Versjon " + stringTryno + " (" + stringOrgfname + ")", problemNode);
				}
				System.out.println();
			}
		}
		System.out.println();
		
		return theTree;
	}
	
	private DefaultMutableTreeNode addAFile(String fileName, DefaultMutableTreeNode parentFolder) {
		// Creates a new node for the tree
		DefaultMutableTreeNode newFile = new DefaultMutableTreeNode(fileName);
		// Add attaches a name to the node
		parentFolder.add(newFile);
		// return the new node
		return newFile;

	}
}
