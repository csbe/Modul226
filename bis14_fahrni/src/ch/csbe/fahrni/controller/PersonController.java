package ch.csbe.fahrni.controller;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.csbe.fahrni.data.XMLHandler;
import ch.csbe.fahrni.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class PersonController {

	@FXML private TextField name, vorname, gehalt;
	@FXML private DatePicker geburtsdatum;
	
	public void save(){
		if(name.getText().length()>0&&vorname.getText().length()>0&&
				gehalt.getText().length()>0&&geburtsdatum.getValue()!=null){
			Instant instant = geburtsdatum.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		
			try {
				Person p = new Person(name.getText(),vorname.getText(),
						Date.from(instant),Float.parseFloat(gehalt.getText()));
				FileChooser fc = new FileChooser();
				List<String> ext = new ArrayList<String>();
				ext.add("xml");
				ExtensionFilter ef = new ExtensionFilter("Ext", ext);
				fc.setSelectedExtensionFilter(ef);
				
				File f = fc.showSaveDialog(null);
				
				XMLHandler.save(p, f);
				
				alert(AlertType.INFORMATION, "Person gespeichert", "Die Person wurde erfolgreich gespeichert");
				reset();
			} catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				alert(AlertType.ERROR, "Datei nicht gespeichert", "Datei konnte nicht gespeichert werden");
			}catch (NumberFormatException e) {
				e.printStackTrace();
				alert(AlertType.ERROR, "Ungültiger Datentyp", "Die Gehaltseingabe ist ungültig\nbitte geben Sie eine Zahl ein");
			}
		}else{
			alert(AlertType.WARNING, "Nicht vollständig ausgefüllt", "Bitte geben Sie in alle Pflichtfelder Daten ein");
		}
	}
	
	public void load(){
		FileChooser fc = new FileChooser();
		List<String> ext = new ArrayList<String>();
		ext.add("xml");
		ExtensionFilter ef = new ExtensionFilter("Ext", ext);
		fc.setSelectedExtensionFilter(ef);
		File f = fc.showOpenDialog(null);
		if(f.exists()){
			try {
				Person p = XMLHandler.<Person>load(f);
				name.setText(p.getName());
				vorname.setText(p.getVorname());
				gehalt.setText(p.getGehalt()+"");
				Instant instant = Instant.ofEpochMilli(p.getGeburtsdatum().getTime());
				geburtsdatum.setValue(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate());
				
			} catch (ClassCastException | IOException e) {
				e.printStackTrace();
				alert(AlertType.ERROR, "Datei nicht gefunden", "Datei konnte nicht gefunden oder nicht geladen werden");
			}
		}
	}
	
	public void reset(){
		name.setText("");
		vorname.setText("");
		gehalt.setText("");
		geburtsdatum.setValue(null);
	}
	
	private void alert(AlertType typ, String title, String text){
		Alert a = new Alert(typ);
		a.setTitle(title);
		a.setContentText(text);
		a.show();
	}
	
	
}
