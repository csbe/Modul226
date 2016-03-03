package ch.csbe.banking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="Konto")
public class Konto {
	@Id
	private String nr;
	@Column
	private float kontostand;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="bankfk")
	private Bank bank;
	@OneToMany(mappedBy="konto")
	private List<Karte> karten = new ArrayList<Karte>();
	@OneToMany(mappedBy="eingang")
	private List<Buchung> buchungen = new ArrayList<Buchung>();
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="kundefk")
	private Kunde kunde;

	public Konto() {
		super();
	}

	public Konto(String nr, float kontostand, Bank bank, Kunde kunde) {
		super();
		this.nr = nr;
		this.kontostand = kontostand;
		this.setBank(bank);
		this.setKunde(kunde);
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public float getKontostand() {
		return kontostand;
	}

	public void setKontostand(float kontostand) {
		this.kontostand = kontostand;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		if(this.bank != bank){
			this.bank = bank;
			if(!this.bank.getKonten().contains(this))
				this.bank.getKonten().add(this);
		}
	}

	public List<Karte> getKarten() {
		return karten;
	}

	public void setKarten(List<Karte> karten) {
		this.karten = karten;
	}

	public List<Buchung> getBuchungen() {
		return buchungen;
	}

	public void setBuchungen(List<Buchung> buchungen) {
		this.buchungen = buchungen;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		if(this.kunde != kunde){
			this.kunde = kunde;
			if(!this.kunde.getKonten().contains(this))
				this.kunde.getKonten().add(this);
		}
	}

}
