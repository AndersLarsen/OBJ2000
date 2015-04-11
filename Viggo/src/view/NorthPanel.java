package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class NorthPanel extends JPanel {

	private JPanel logoOnPanel;

	
	public NorthPanel(){
		setPreferredSize(new Dimension(150,150));
		setBackground(new Color(120,150,200));
//		setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY), null));
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
		createLoginPanel();
		putLogo();
		add(logoOnPanel);

		
	}
	
	
	//LAGER LOGINPANEL SOM SKAL FYLLE VINDU
	private void createLoginPanel() {
		logoOnPanel = new JPanel();
		logoOnPanel.setBackground(new Color(120,150,200));	
		logoOnPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		logoOnPanel.setLayout(new GridLayout(0,1));
	}
	
				//SETTER INN EVALANCHE LOGO I LOGINPANEL
	private void putLogo() {
		try {
			JLabel picLabel;
			BufferedImage myPicture = ImageIO.read(new File("./img/evalanche_logo.png"));
			picLabel = new JLabel(new ImageIcon(myPicture));
			logoOnPanel.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
