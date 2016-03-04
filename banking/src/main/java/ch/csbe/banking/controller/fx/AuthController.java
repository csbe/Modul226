package ch.csbe.banking.controller.fx;

import java.io.IOException;

import ch.csbe.banking.App;
import ch.csbe.banking.dao.KarteDao;
import ch.csbe.banking.helper.Session;
import ch.csbe.banking.model.Karte;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;

public class AuthController {

	@FXML
	private TextField karte;
	@FXML 
	private PasswordField pin;
	
	public void auth() throws IOException{
		KarteDao kd = new KarteDao();
		Karte k = kd.auth(karte.getText(), pin.getText());
		if(k == null){
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Fehler bei Anmeldung");
			a.setContentText("Kartennummer oder Pin falsch");
			a.show();
		}else{
			Session.getInstance().getMap().put("karte", k);
			FXMLLoader loader = new FXMLLoader(App.class.getResource("view/welcome.fxml"));
			Parent p = loader.load();
			Scene scene = new Scene(p);
			Stage s = (Stage)karte.getScene().getWindow();
			s.setScene(scene);
			s.setTitle("Welcome");
			//WelcomeController wc = loader.<WelcomeController>getController();
			//wc.setKarte(k);
		}
	}
	
}
