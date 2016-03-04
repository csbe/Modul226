package ch.csbe.banking.controller.fx;

import java.sql.Date;
import java.util.Calendar;

import ch.csbe.banking.dao.BuchungDao;
import ch.csbe.banking.dao.KarteDao;
import ch.csbe.banking.model.Art;
import ch.csbe.banking.model.Buchung;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EinzahlenController extends BezugController{
	public void save(){
		float geld = Float.valueOf(betrag.getText());
		System.out.println(geld);
		if( geld < 0 ){
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Fehler bei Bezug");
			a.setContentText("Betrag muss grösser 0 sein");
			a.show();
		}else{
			Buchung b = new Buchung(new Date(Calendar.getInstance().getTime().getTime()), geld, Art.EINGANG, karte.getKonto(), null);
			BuchungDao bd = new BuchungDao();
			bd.save(b);
			karte.getKonto().setKontostand(karte.getKonto().getKontostand()+geld);
			KarteDao kd = new KarteDao();
			kd.save(karte);
		}
		betrag.setText("");
		betrag.requestFocus();
	}
}
