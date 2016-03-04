package ch.csbe.banking.controller.fx;

import java.io.IOException;

import ch.csbe.banking.App;
import ch.csbe.banking.helper.Session;
import ch.csbe.banking.model.Karte;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WelcomeController {
	Karte karte;

	@FXML private Label kundename;
	@FXML private Label bankname;
	
	public void self() throws IOException {
		Parent p = FXMLLoader.load(App.class.getResource("view/welcome.fxml"));
		Stage s = (Stage)kundename.getScene().getWindow();
		s.setScene(new Scene(p));
		s.show();
	}
	

	public void bezug() throws IOException {
		Parent p = FXMLLoader.load(App.class.getResource("view/geldbezug.fxml"));
		Stage s = (Stage)kundename.getScene().getWindow();
		s.setScene(new Scene(p));
		s.show();
	}

	public void einzahlen() throws IOException {
		Parent p = FXMLLoader.load(App.class.getResource("view/einzahlen.fxml"));
		Stage s = (Stage)kundename.getScene().getWindow();
		s.setScene(new Scene(p));
		s.show();
	}

	public void bestellen() {

	}

	public void anzeigen() throws IOException {
		Parent p = FXMLLoader.load(App.class.getResource("view/kontostand.fxml"));
		Stage s = (Stage)kundename.getScene().getWindow();
		s.setScene(new Scene(p));
		s.show();
	}

	public void ueberweisen() throws IOException {
		Parent p = FXMLLoader.load(App.class.getResource("view/ueberweisen.fxml"));
		Stage s = (Stage)kundename.getScene().getWindow();
		s.setScene(new Scene(p));
		s.show();
	}

	public void aendern() throws IOException {
		Parent p = FXMLLoader.load(App.class.getResource("view/pinaendern.fxml"));
		Stage s = (Stage)kundename.getScene().getWindow();
		s.setScene(new Scene(p));
		s.show();
	}

	@FXML
	public void initialize() {
		karte = Session.getInstance().<Karte> get("karte");
		System.out.println(karte);
		kundename.setText(karte.getKunde().getName());
		bankname.setText(karte.getKonto().getBank().getName());
	}

}
