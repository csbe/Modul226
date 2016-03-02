package ch.csbe.banking.controller.fx;

import java.io.IOException;

import ch.csbe.banking.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	private TextField name;
	
	@FXML
	public void welcome() throws IOException{
		FXMLLoader loader = new FXMLLoader(App.class.getResource("view/welcome.fxml"));
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		Stage s = (Stage)name.getScene().getWindow();
		s.setScene(scene);
		
		WelcomeController wc = loader.<WelcomeController>getController();
		wc.setName(name.getText());
	}

}
