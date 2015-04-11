import controller.LoginController;
import model.ServerCommunicatorModel;
import view.LoginView;

/*
 * Eksamen IS-OBJ2000
* November desember 2013
* Oppgaven ligger på denne url-en:
* 
* https://docs.google.com/document/d/1MSUNgFhwFI9Kr1wdNMcdRuhrE_aSsukT4Jl7TZuW30s/edit?usp=sharing

* ********************
* Krav til besvarelsen:
* *********************
* 
* 
* Besvarelse n skal bestå av: 
* å	et lesbart datamedium som CD, DVD eller USB-memory
* å	en rapport i papirutskrift som presenterer besvarelsens tekniske sider
* å	en kort veiledning i papirutskrift for en vanlig bruker av det programmet som er laget
* 
* Ved vurderingen legges det vekt på tilgjengelighet og presentasjon.
* Med tilgjengelighet menes det hvor lett det er, for den som skal vurdere produktet, å tilegne seg både oversikt og innsikt i det som er laget.
* Med presentasjon menes det hvilket estetisk inntrykk alle deler av produktet etterlater. Dette veies opp mot innholdet, som må stå i forhold til presentasjonen.  
* Et svårt tiltalende inntrykk kan ikke veie opp for manglende innhold.

* Besvarelsen skal leveres på høgskoletorget den 17. desember innen klokken 13:00.

 */
public class EntryPoint {
	
	public EntryPoint(){
		LoginView loginView = new LoginView();
		ServerCommunicatorModel serverCommunicatorModel = new ServerCommunicatorModel();
		LoginController loginController = new LoginController(loginView, serverCommunicatorModel);
	}
	
	public static void main(String[] args) {
		new EntryPoint();
		
		
	}

}
