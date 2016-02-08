package ch.csbe.fx.navigation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NavigatorApp  extends Application{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("navigator.fxml"));
	    
        Scene scene = new Scene(root, 600, 400);
    
        stage.setTitle("Naviation Example");
        stage.setScene(scene);
        //setUserAgentStylesheet(STYLESHEET_CASPIAN);
        stage.show();
	}


}