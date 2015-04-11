package view;

import java.awt.Color;

import javax.swing.JMenu;
/*
 * Denne klassen skal konstruere meny linjen på toppen  av applikasjonen , den inneholder :
 * Fil 
 * Funksjoner
 * Hjelp
 * 
 * 
 * 
 */
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import metainfo.CodeAccounting;



@CodeAccounting( 
		 teamId = "ØGLAA ", 
		 author = {"Anders Borg Larsen","Andrea Abrahamsen","Gjermund Vedvik","Linda Fermann","Øyvind Gautestad"}, 
		 valueimo = 10, 
		 valueito = 7 
		) 
public class MainMenuBar extends JMenuBar {

	public MainMenuBar() {
		setBackground(Color.LIGHT_GRAY);
		buildFileMenu();
		buildFunctionMenu();
		buildHelpMenu();

	}
	
	/*
	 * 
	 * test
	 */
																						// LEGGER TIL MENY ELEMENT HJELP
	private void buildHelpMenu() {
		JMenu helpMenu = new JMenu("Hjelp");	
		
		JMenuItem about = new JMenuItem("Om utviklerene");
		JMenuItem doc = new JMenuItem("Dokumentasjon");
		JMenuItem manual = new JMenuItem("Bruker Manual");

		
		helpMenu.add(doc);
		helpMenu.add(manual);
		helpMenu.add(about);
		add(helpMenu);
	}
																							// LEGGER TIL MENY ELEMENT FUNKSJONER
	private void buildFunctionMenu() {
		JMenu functionMenu = new JMenu("Funksjoner");	
		
		JMenuItem download = new JMenuItem("Last ned alt");
		
		functionMenu.add(download);
		add(functionMenu);
		
	}
																								//LEGGER TIL MENY ELEMENT FIL
	private void buildFileMenu() {
		JMenu fileMenu = new JMenu("Fil");
		
		JMenuItem logOut = new JMenuItem("Logg Av");
		JMenuItem close = new JMenuItem("Avslutt");

		
		fileMenu.add(logOut);
		fileMenu.add(close);
		add(fileMenu);
	}

}
