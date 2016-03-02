package ch.csbe.banking.model;

import java.sql.Date;

public class Buchung {
	private Date datum;
	private float betrag;
	private Art art;
	private Konto eingang;
	private Konto ausgang;

	public Buchung(Date datum, float betrag, Art art, Konto eingang, Konto ausgang) {
		super();
		this.datum = datum;
		this.betrag = betrag;
		this.art = art;
		this.eingang = eingang;
		this.ausgang = ausgang;
	}

	public Buchung() {
		super();
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public float getBetrag() {
		return betrag;
	}

	public void setBetrag(float betrag) {
		this.betrag = betrag;
	}

	public Art getArt() {
		return art;
	}

	public void setArt(Art art) {
		this.art = art;
	}

	public Konto getEingang() {
		return eingang;
	}

	public void setEingang(Konto eingang) {
		this.eingang = eingang;
	}

	public Konto getAusgang() {
		return ausgang;
	}

	public void setAusgang(Konto ausgang) {
		this.ausgang = ausgang;
	}

}
