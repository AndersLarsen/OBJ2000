package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginView extends JFrame {
	
	private String[] groupMembers = {"Øyvind Gautestad","Gjermund Vedvik","Linda Fermann","Anders Borg Larsen","Andrea Bøe Abrahamsen"};
	private JLabel[] groupMembersLabels = new JLabel[groupMembers.length];
	private static final long serialVersionUID = 1L;
	
	private JPanel loginPanel;
	private JTextField username;
	private JPasswordField password;
	private JButton loginButton;
	private JButton closeButton;
	private JPanel loginContainer;
	
	public LoginView(){
		int windowWidth = 500;
		int windowHeight = 500;
				//SETTER ATTRIBUTTER TIL VINDUET
		setTitle("Mine Evalancheoppgaver");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(windowWidth,windowHeight);
				//SENTRERER VINDUET
		Toolkit tk 		= Toolkit.getDefaultToolkit();
		Dimension d		= tk.getScreenSize();
		int screenHeight	= d.height;
		int screenWidth	= d.width;
		setLocation((screenWidth / 2) - (windowWidth / 2) , (screenHeight / 2) - (windowHeight / 2));
				//SETTER INN INNHOLD
		createLoginPanel();		
		putLogo();		
		putLogInFormAndButtons();
		putGroupInfo();
		getContentPane().add(loginPanel);
				//TEGNER OG SETTER TIL SYNLIG
		repaint();
		setVisible(true);
	}
	
	public String getUsername() {
		return username.getText();
	}

	public String getPassword() {
		return password.getText();
	}
	
				//LAGER LOGINPANEL SOM SKAL FYLLE VINDU
	private void createLoginPanel() {
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(120,150,200));	
		loginPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		loginPanel.setLayout(new GridLayout(0,1));
	}
	
				//SETTER INN EVALANCHE LOGO I LOGINPANEL
	private void putLogo() {
		try {
			JLabel picLabel;
			BufferedImage myPicture = ImageIO.read(new File("./img/evalanche_logo.png"));
			picLabel = new JLabel(new ImageIcon(myPicture));
			loginPanel.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
			//LAGER LOGINCONTAINER SOM ALLE INNLOGGINGSFELTER SETTES INN I, OG SOM SÅ LEGGES TIL I LOGINPANEL
	private void putLogInFormAndButtons() {
		loginContainer = new JPanel(new GridLayout(0, 1));		
		putInfoOnLogIn();
		putUsernameOnLogIn();
		putPasswordOnLogIn();
		putButtonsOnLogIn();
		loginContainer.setOpaque(false);
		loginPanel.add(loginContainer);
	}
	
			//SETTER INN INFO I LOGINCONTAINER
	private void putInfoOnLogIn() {
		JLabel infoLabel = new JLabel("Vennligst skriv inn gyldig brukernavn og passord.", JLabel.CENTER);
		loginContainer.add(infoLabel);
	}
	
			//SETTER INN USERNAME I LOGINCONTAINER
	private void putUsernameOnLogIn() {
		JPanel usernameContainer = new JPanel(new BorderLayout());
		JLabel usernameLabel = new JLabel("  Brukernavn:");
		username = new JTextField(40);
		usernameContainer.add(usernameLabel, BorderLayout.WEST);
		usernameContainer.add(username, BorderLayout.CENTER);
		usernameContainer.setOpaque(false);
		loginContainer.add(usernameContainer);
	}
	
			//SETTER INN PASSWORD I LOGINCONTAINER
	private void putPasswordOnLogIn() {
		JPanel passwordContainer = new JPanel(new BorderLayout());
		JLabel passwordLabel = new JLabel("  Passord:     ");
		password = new JPasswordField(40);
		passwordContainer.add(passwordLabel, BorderLayout.WEST);
		passwordContainer.add(password, BorderLayout.CENTER);
		passwordContainer.setOpaque(false);
		loginContainer.add(passwordContainer);
	}
	
			//SETTER INN BUTTONS I LOGINCONTAINER
	private void putButtonsOnLogIn() {
		JPanel buttonsContainer = new JPanel(new GridLayout(1,0));
		loginButton = new JButton("Logg inn");
		closeButton = new JButton("Avslutt programmet");
		buttonsContainer.add(loginButton);
		buttonsContainer.add(closeButton);
		getRootPane().setDefaultButton(loginButton);
		buttonsContainer.setOpaque(false);
		loginContainer.add(buttonsContainer);
	}
	
		//SETTER INN INFO OM GRUPPEN I LOGINPANEL
	private void putGroupInfo() {
		JPanel groupInfo = new JPanel(new GridLayout(0,1));
		groupInfo.add(new JLabel());
		groupInfo.add(new JLabel());
		groupInfo.add(new JLabel());
		groupInfo.add(new JLabel("Denne applikasjonen er laget av Gruppe ØGLAA bestående av:", JLabel.CENTER));
		for (int i = 0; i < groupMembers.length; i++) {
			groupMembersLabels[i] = new JLabel(groupMembers[i], JLabel.CENTER);
			groupInfo.add(groupMembersLabels[i]);
		}
		groupInfo.setOpaque(false);
		loginPanel.add(groupInfo);
	}

	public void addListener(ActionListener listener){
		loginButton.addActionListener(listener);
		closeButton.addActionListener(listener);
	}

	public static void main(String[] args) {
		new LoginView();

	}

	
	
}

