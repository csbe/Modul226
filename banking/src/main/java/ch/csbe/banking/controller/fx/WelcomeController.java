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

	public void bezug() {

	}

	public void einzahlen() {

	}

	public void bestellen() {

	}

	public void anzeigen() throws IOException {
		Parent p = FXMLLoader.load(App.class.getResource("view/kontostand.fxml"));
		Stage s = (Stage)kundename.getScene().getWindow();
		s.setScene(new Scene(p));
		s.show();
	}

	public void ueberweisen() {

	}

	public void aendern() {

	}

	@FXML
	public void initialize() {
		karte = Session.getInstance().<Karte> get("karte");
		System.out.println(karte);
		kundename.setText(karte.getKunde().getName());
		bankname.setText(karte.getKonto().getBank().getName());
	}

}
