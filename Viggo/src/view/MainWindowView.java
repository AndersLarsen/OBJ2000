package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metainfo.CodeAccounting;



@CodeAccounting( 
		 teamId = "ØGLAA ", 
		 author = {"Anders Borg Larsen","Andrea Abrahamsen","Gjermund Vedvik","Linda Fermann","Øyvind Gautestad"}, 
		 valueimo = 10, 
		 valueito = 7 
		) 


public class MainWindowView extends JPanel {
	
	
	
	public MainWindowView(){
		
		setBackground(new Color(120,150,200));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout());
		
		
		
	}
	
	
	

}
