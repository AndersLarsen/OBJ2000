package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SouthPanel extends JPanel {

	
	public SouthPanel(){
		setBackground(new Color(120,150,200));
		setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
		Dimension size = getPreferredSize();
		size.height = 50;
		setPreferredSize(size);
	}
}
