package ch.csbe.banking.controller.fx;

import java.sql.Date;
import java.util.Calendar;

import ch.csbe.banking.dao.KarteDao;
import ch.csbe.banking.model.Art;
import ch.csbe.banking.model.Buchung;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class BezugController extends WelcomeController{

	@FXML protected TextField betrag;
	
	public void save(){
		float geld = Float.valueOf(betrag.getText());
		if( geld > karte.getKonto().getKontostand() ){
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Fehler bei Bezug");
			a.setContentText("Gewünschter Betrag zu hoch");
		}else{
			Buchung b = new Buchung(new Date(Calendar.getInstance().getTime().getTime()), geld, Art.AUSGANG, null, karte.getKonto());
			karte.getKonto().setKontostand(karte.getKonto().getKontostand()-geld);
			KarteDao kd = new KarteDao();
			kd.save(karte);
		}
	}
	@FXML public void initialize(){
		super.initialize();
	}
}
