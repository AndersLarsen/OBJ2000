package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CenterPanel extends JPanel {
	
	public CenterPanel(){
		
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.DARK_GRAY));
	}

}
