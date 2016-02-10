package ch.csbe.examples.fx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Zeitverwaltung extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage stage) throws IOException{
		Parent p = FXMLLoader.load(getClass().getResource("view/user.fxml"));
		Scene scene = new Scene(p);
		stage.setTitle("Bis14 Anwendung");
		stage.setScene(scene);
		stage.show();
	}

}
