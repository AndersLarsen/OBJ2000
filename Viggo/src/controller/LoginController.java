package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ServerCommunicatorModel;
import model.MyCourseModel;
import view.LoginView;
import view.MyCourseView;
import view.PopUpDialogBox;

public class LoginController {
	
	private LoginView loginView;
	private ServerCommunicatorModel serverCommunicatorModel;

	public LoginController(LoginView loginView, ServerCommunicatorModel serverCommunicatorModel) {
		this.loginView = loginView;
		this.serverCommunicatorModel = serverCommunicatorModel;
		this.loginView.addListener(new LoginListener());
	}
	
	/*
	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}
	
	public ServerCommunicatorModel getServerCommunicatorModel() {
		return serverCommunicatorModel;
	}

	public void setServerCommunicatorModel(
			ServerCommunicatorModel serverCommunicatorModel) {
		this.serverCommunicatorModel = serverCommunicatorModel;
	}
	*/
	public void createMyCourse(){
		MyCourseView myCourseView = new MyCourseView();
		MyCourseModel myCourseModel = new MyCourseModel(serverCommunicatorModel.getCaching(), serverCommunicatorModel.getZipFile());
		MyCourseController myCourseController = new MyCourseController(myCourseView, myCourseModel);
		loginView.dispose();
	}
	
	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String arg = e.getActionCommand();
			if(arg.equals("Logg inn")) {
				String username = loginView.getUsername();
				String password = loginView.getPassword();

				if((!username.equals("")) && (!password.equals(""))){
					if(serverCommunicatorModel.startCommunication(username, password)){
						createMyCourse();
					} else {
						new PopUpDialogBox(loginView, "Brukernavn og/eller passord er ikke korrekt fylt ut", "error");
					}
				}
				else{
					new PopUpDialogBox(loginView, "Både brukernavn og passord må være fylt ut", "error");
				}
			}
			else if(arg.equals("Avslutt programmet")){
				System.exit(0);
			}
		}
	}

}
