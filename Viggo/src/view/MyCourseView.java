package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import metainfo.CodeAccounting;

@CodeAccounting(teamId = "ØGLAA ", author = { "Anders Borg Larsen",
		"Andrea Abrahamsen", "Gjermund Vedvik", "Linda Fermann",
		"Øyvind Gautestad" }, valueimo = 10, valueito = 7)

public class MyCourseView extends JFrame {

	private WestPanel westPanel;
	
	public MyCourseView() {
			//SETTER ATTRIBUTTER TIL FRAME
		setTitle("Viggo 2000 a space Odyssey");
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize, ySize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			//LEGGER TIL MENY
		setJMenuBar(new MainMenuBar());
		
			//LEGGER TIL MAINPANEL OG ALLE ANDRE PANEL TIL DENNE
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new NorthPanel(),BorderLayout.NORTH);
		mainPanel.add(westPanel = new WestPanel(),BorderLayout.WEST);
		mainPanel.add(new CenterPanel(),BorderLayout.CENTER);
		mainPanel.add(new SouthPanel(),BorderLayout.SOUTH);
		add(mainPanel);
		//gjør ingen forskjell om dette er der eller ikke i forhold til at treet forsvinner hvis vinduet blir for lavt
		((JComponent) getContentPane()).revalidate();
		repaint();
		//setVisible(true); // ta meg bort
	}
	
	public WestPanel getWestPanel(){
		return westPanel;
	}
	

}
