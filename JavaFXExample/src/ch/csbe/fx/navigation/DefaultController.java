package ch.csbe.fx.navigation;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DefaultController {
	
	@FXML protected ScrollPane content; 
	
	/**
	 * erfassen Action lädt die neue Scene
	 * @throws IOException
	 */
	public void erfassenAction() throws IOException{
		FXMLLoader loader = loadRessource("erfassen", "Erfassen");
		ErfassenController erfassen = loader.<ErfassenController>getController();
		erfassen.setContent(content);
		
	}
	
	public void webAction() throws IOException{
		loadRessource("anzeigen", "WebEngine");
	}
	
	public void aboutAction(){
		Alert alert;
		alert = new Alert(AlertType.INFORMATION);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle("About");
		alert.setHeaderText("Simple JavaFX App");
		Hyperlink link = new Hyperlink("buchs.enrico@gmail.com");
		link.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0){
				MailViaClient.mail(link.getText()+"?subject=NaviagtorApp");
				
			}
		});
		FlowPane fp = new FlowPane();
		Text text = new Text("Simple App - by EBuchs\n© 2016 for CsBe\n");
		fp.getChildren().addAll(text,link);
		alert.getDialogPane().contentProperty().set(fp);
		
		//alert.setContentText("Normaler Text");
		alert.initModality(Modality.NONE);
		alert.showAndWait();
	}
	
	public void aboutOwnAction() throws IOException{
		Alert alert;
		alert = new Alert(AlertType.INFORMATION);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle("About");
		alert.setHeaderText("Simple JavaFX App");
		Parent p = FXMLLoader.load(getClass().getResource("about.fxml"));
		alert.getDialogPane().contentProperty().set(p);
		alert.showAndWait();
	}
	
	private FXMLLoader loadRessource(String resource, String title) throws IOException{
		Stage stage = (Stage) content.getScene().getWindow();
		content.getScene().getStylesheets().add("style.css");
		
		FXMLLoader loader  = new FXMLLoader(getClass().getResource(resource+".fxml"));
		
		content.setContent((Parent)loader.load());
		//stage.setScene(new Scene((Parent)loader.load()));
		stage.setTitle(title);
		return loader;
	}

}
