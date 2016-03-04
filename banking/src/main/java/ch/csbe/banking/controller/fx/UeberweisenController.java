package ch.csbe.banking.controller.fx;

import java.sql.Date;
import java.util.Calendar;

import ch.csbe.banking.dao.BuchungDao;
import ch.csbe.banking.dao.KarteDao;
import ch.csbe.banking.dao.KontoDao;
import ch.csbe.banking.model.Art;
import ch.csbe.banking.model.Buchung;
import ch.csbe.banking.model.Konto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class UeberweisenController extends EinzahlenController{
	
	@FXML TextField fremdkonto;
	
	public void save(){
		float geld = Float.valueOf(betrag.getText());
		
		if( geld < 0 ){
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Fehler bei Bezug");
			a.setContentText("Betrag muss grösser 0 sein");
			a.show();
		}else{
			KontoDao kontod = new KontoDao();
			Konto konto = kontod.getKarte(fremdkonto.getText());
			if(konto == null){
				konto = new Konto(fremdkonto.getText(),0,null,null);
			}
			konto.setKontostand(konto.getKontostand()+geld);
			kontod.save(konto);
			Buchung b = new Buchung(new Date(Calendar.getInstance().getTime().getTime()), geld, Art.AUSGANG, konto, karte.getKonto());
			BuchungDao bd = new BuchungDao();
			bd.save(b);
			karte.getKonto().setKontostand(karte.getKonto().getKontostand()-geld);
			KarteDao kd = new KarteDao();
			kd.save(karte);
		}
		betrag.setText("");
		betrag.requestFocus();
	}
}
