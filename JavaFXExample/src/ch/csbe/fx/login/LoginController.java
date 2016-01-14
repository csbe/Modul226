package ch.csbe.fx.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {
	@FXML protected TextField username;
	@FXML protected TextField password;
	
    
    @FXML protected void loginAction(ActionEvent event) throws Exception{
    	
    	if(username.getText().equals("buchs") && password.getText().equals("buchs")){
			//Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			//Stage stage = (Stage) username.getScene().getWindow();
    		/*Stage stageold = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		stageold.close();
    		
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("next.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene((Parent)loader.load()));
			NextController next = loader.<NextController>getController();
			next.set("hallo " + username.getText());
			stage.show();*/
    		
    		//Holt das Aktuelle Fenster "Stage"
    		Stage stage = (Stage) username.getScene().getWindow();
    		//Erstellt einen neuen FXMLLoader - der Statische Weg ist nicht gut,
    		//da der Controller der Resource geladen werden muss um Daten zu übertragen
    		//und der statische Weg dafür nicht möglich ist
    		FXMLLoader loader  = new FXMLLoader(getClass().getResource("next.fxml"));
    		//Mit der geladenen Datei wird eine neue Scene erstellt und dem Fenster hinzugefügt
    		stage.setScene(new Scene((Parent)loader.load()));
    		stage.setTitle("Neuer Titel");
    		//Der Kontroller des fxml wird geladen und steht ab hier zur verfügung
			NextController next = loader.<NextController>getController();
			next.set("hallo " + username.getText());
			
			
    	}else{
    		Alert alert;
    		alert = new Alert(AlertType.ERROR);
			alert.initStyle(StageStyle.UTILITY);
			alert.setTitle("Login falsch");
			alert.setHeaderText("Login message");
			alert.setContentText("Benutzername oder Passwort falsch");
			alert.showAndWait();
    	}
    }
}
