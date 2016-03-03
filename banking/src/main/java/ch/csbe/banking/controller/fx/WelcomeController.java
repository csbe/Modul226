package ch.csbe.banking.controller.fx;

import ch.csbe.banking.model.Karte;
import ch.csbe.banking.model.Konto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WelcomeController {
	
	private Karte karte;
	
	@FXML
	private Label namelabel;
	
	public void setName(String s){
		namelabel.setText(s);
	}
	
	public void setKarte(Karte k){
		karte = k;
		namelabel.setText(karte.getKunde().getName());
	}

}
