package ch.csbe.fx.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
	    
        Scene scene = new Scene(root, 600, 400);
    
        stage.setTitle("Login Welcome");
        stage.setScene(scene);
     
        stage.show();
	}


}
