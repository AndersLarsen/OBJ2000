package model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LoginValidator extends PlainDocument {
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if (str == null)
			return;
		
		if(offs < 30){
			
			String oldString = getText(0, getLength());
			String newString = oldString.substring(0, offs) + str + oldString.substring(offs); //inserter str i oldString
			
			try {
				super.insertString(offs, newString, a);
			} 
			catch (NumberFormatException e) {
				System.out.println("Hei");
			}
		
		}
	}
}
