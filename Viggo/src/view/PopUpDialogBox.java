package view;

import java.awt.Component;

import javax.swing.JOptionPane;

public class PopUpDialogBox extends JOptionPane {
	
	public PopUpDialogBox(Component parentComponent, String text, String type){
		if(type.equals("error")){
			showMessageDialog(parentComponent, text, "Feilmelding", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
