package ch.csbe.banking.controller.fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AnzeigenController extends WelcomeController{

	@FXML private Label kontostand;
	
	@FXML public void initialize(){
		super.initialize();
		kontostand.setText(Float.toString(karte.getKonto().getKontostand()));
	}
	
}
