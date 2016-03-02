package ch.csbe.banking.controller.fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WelcomeController {
	
	@FXML
	private Label namelabel;
	
	public void setName(String s){
		namelabel.setText(s);
	}

}
