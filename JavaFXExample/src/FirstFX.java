import java.awt.Dialog;

import com.sun.java.swing.plaf.gtk.GTKConstants.TextDirection;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FirstFX extends Application{

	Label lb;
	Button btn;
	Text txt;
	TextField tf;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		lb = new Label("Der Text");
		txt = new Text("Example");
		tf = new TextField("Das Field");
		tf.getStyleClass().add("text-field");
		btn = new Button("Click mich");
		btn.getStyleClass().add("button1");
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				lb.setText("Neuer Text");
				txt.setText(tf.getText());
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.initStyle(StageStyle.UTILITY);
				alert.setTitle("Info");
				alert.setHeaderText("Der Titel");
				alert.setContentText(tf.getText());
				alert.showAndWait();
			}
		});
		
		
		VBox root = new VBox();
		
		
		root.getChildren().addAll(lb,tf,txt,btn);
		Scene scene = new Scene(root,500, 300);
		
		scene.getStylesheets().add("style.css");
		stage.setScene(scene);
		stage.setTitle("First Window");
		stage.show();
	}

}
