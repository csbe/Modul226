package ch.csbe.hotel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Buchung {
	private Date von;
	private Date bis;
	private float kosten;
	private int anzahlPersonen;
	private Gast gast;
	private List<Zimmer> zimmer = new ArrayList<Zimmer>();

	public Date getVon() {
		return von;
	}

	public void setVon(Date von) {
		this.von = von;
	}

	public Date getBis() {
		return bis;
	}

	public void setBis(Date bis) {
		this.bis = bis;
	}

	public float getKosten() {
		return kosten;
	}

	public void setKosten(float kosten) {
		this.kosten = kosten;
	}

	public int getAnzahlPersonen() {
		return anzahlPersonen;
	}

	public void setAnzahlPersonen(int anzahlPersonen) {
		this.anzahlPersonen = anzahlPersonen;
	}

	public Gast getGast() {
		return gast;
	}

	public void setGast(Gast gast) {
		if(this.gast != gast){
			this.gast = gast;
			gast.addBuchung(this);
		}
	}

	public List<Zimmer> getZimmer() {
		return zimmer;
	}

	public void setZimmer(List<Zimmer> zimmer) {
		this.zimmer = zimmer;
	}
	
	public boolean addZimmer(Zimmer zimmer){
		if(!this.zimmer.contains(zimmer)){
			this.addZimmer(zimmer);
			zimmer.addBuchung(this);
			return true;
		}
		return false;
	}

}
