package ch.csbe.fx.login;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class NextController {
	@FXML protected TextArea textarea;
	public void set(String text){
		textarea.setText(text);;
	}
}
