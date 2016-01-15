package ch.csbe.fx.navigation;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;

public class ErfassenController{
	
	@FXML protected TextField titel;
	@FXML protected DatePicker datum;
	@FXML protected HTMLEditor text;
	
	protected ScrollPane content;
	
	public void createAction(){
		Text t = new Text(titel.getText()+"\n");
		t.setText(t.getText()+text.getHtmlText());
		content.setContent(t);
	}
	
	public void setContent(ScrollPane content){
		this.content = content;
	}
	

}
