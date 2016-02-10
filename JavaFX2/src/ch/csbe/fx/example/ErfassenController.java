package ch.csbe.fx.example;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;

public class ErfassenController {

	@FXML
	protected TextField titel;
	@FXML
	protected DatePicker datum;
	@FXML
	protected HTMLEditor text;

	protected ScrollPane content;

	public void createAction() {
		Text t = new Text(titel.getText() + "\n");
		t.setText(t.getText() + text.getHtmlText());
		content.setContent(t);
	}

	@FXML
	public void initialize() {
		System.out.println(Font.getDefault());
		text.setHtmlText("Hallo Text");
		System.out.println(text.getHtmlText());
		
		
		/*Platform.runLater(new Runnable() {

			@Override
			public void run() {
				for(Node n : text.lookupAll(".bottom-toolbar")){
					//ToolBar t = (ToolBar) n;
					Node c = t.getItems().get(1);
					c.setManaged(true);
					ComboBox cb = (ComboBox) c;
					System.out.println(cb.getSelectionModel());
				}
				int i = 0;
				for (Node box : text.lookupAll(".toolbar")) {
					MenuButton tool = (MenuButton) box;
					if(i==0){
						for(Object item : tool.getItems()){
							System.out.println(item.getClass());
						}
					}
					i++;
				}

			}
		});*/
	}

	public void setContent(ScrollPane content) {
		this.content = content;

	}

	/*
	 * { for(Node box:text.lookupAll(".bottom-toolbar")){ ToolBar tool =
	 * (ToolBar)box; Platform.runLater(new Runnable() {
	 * 
	 * @Override public void run() { System.out.println(tool.toString());
	 * for(Node font:tool.getItems()){ System.out.println(font.toString());
	 * 
	 * }
	 * 
	 * } });
	 * 
	 * } }
	 */

}
