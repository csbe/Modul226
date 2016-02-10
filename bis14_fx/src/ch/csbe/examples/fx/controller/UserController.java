package ch.csbe.examples.fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Dialogs;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserController implements Initializable{

	@FXML private TextField username;
	@FXML private Pane pane;
	
	
	public void save() throws IOException{
		Stage s = (Stage)username.getScene().getWindow();
		//Dialogs.showInformationDialog(s, username.getText(), 
			//    "Information Dialog", "Titel");
		Parent p = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
		Scene scene = new Scene(p);
		s.setScene(scene);
	}
	
	public void clear(){
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//TimePic
		//pane.getChildren().add(e);
	}
	
}
