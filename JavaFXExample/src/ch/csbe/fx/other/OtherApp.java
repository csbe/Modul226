package ch.csbe.fx.other;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OtherApp extends Application{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("anzeigen.fxml"));
	    
        Scene scene = new Scene(root, 600, 400);
    
        stage.setTitle("Web View");
        stage.setScene(scene);
     
        stage.show();
	}


}