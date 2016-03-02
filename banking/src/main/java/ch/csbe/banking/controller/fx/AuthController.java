package ch.csbe.banking.controller.fx;

import ch.csbe.banking.dao.KarteDao;
import ch.csbe.banking.model.Karte;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AuthController {

	@FXML
	private TextField karte;
	@FXML 
	private TextField pin;
	
	public void auth(){
		KarteDao kd = new KarteDao();
		Karte k = kd.auth(karte.getText(), pin.getText());
		if(k == null){
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Fehler bei Anmeldung");
			a.setContentText("Kartennummer oder Pin falsch");
			a.show();
		}else{
			
		}
	}
	
}
