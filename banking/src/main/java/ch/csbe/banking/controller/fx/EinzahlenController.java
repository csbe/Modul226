package ch.csbe.banking.controller.fx;

import java.sql.Date;
import java.util.Calendar;

import ch.csbe.banking.dao.KarteDao;
import ch.csbe.banking.model.Art;
import ch.csbe.banking.model.Buchung;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EinzahlenController extends BezugController{
	public void save(){
		float geld = Float.valueOf(betrag.getText());
		if( geld > 0 ){
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Fehler bei Bezug");
			a.setContentText("Betrag muss grösser 0 sein");
		}else{
			Buchung b = new Buchung(new Date(Calendar.getInstance().getTime().getTime()), geld, Art.EINGANG, karte.getKonto(), null);
			karte.getKonto().setKontostand(karte.getKonto().getKontostand()+geld);
			KarteDao kd = new KarteDao();
			kd.save(karte);
		}
	}
	
	@FXML public void initialize(){
		super.initialize();
	}
}
