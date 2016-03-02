package ch.csbe.banking.model;

import java.util.ArrayList;
import java.util.List;

public class Konto {
	private String nr;
	private float kontostand;
	private Bank bank;
	private List<Karte> karten = new ArrayList<Karte>();
	private List<Buchung> buchungen = new ArrayList<Buchung>();
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
