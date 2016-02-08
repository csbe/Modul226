package ch.csbe.fx.navigation;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebController {

	@FXML protected WebView web;
	@FXML protected TextField url;
	
	public void webAction(){
		WebEngine engine = web.getEngine();
		engine.setJavaScriptEnabled(true);
		engine.setUserAgent("Mozilla/5.0");
		engine.load("http://"+url.getText());
		//engine.load("http://google.ch");
	}
	
}
