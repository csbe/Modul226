package ch.csbe.banking.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Buchung")
public class Buchung {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private Date datum;
	@Column
	private float betrag;
	@Column
	private Art art;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="eingangfk")
	private Konto eingang;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="ausgangfk")
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
		if(this.eingang!=eingang){
			this.eingang = eingang;
			if(!this.eingang.getBuchungeingang().contains(this))
				this.eingang.getBuchungeingang().add(this);
		}
	}

	public Konto getAusgang() {
		return ausgang;
	}

	public void setAusgang(Konto ausgang) {
		if(this.ausgang!=ausgang){
			this.ausgang = ausgang;
			if(!this.ausgang.getBuchungausgang().contains(this))
				this.ausgang.getBuchungausgang().add(this);
		}
	}

}
