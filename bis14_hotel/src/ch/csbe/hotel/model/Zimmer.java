package ch.csbe.hotel.model;

import java.util.List;

public abstract class Zimmer {

	private int zimmernummer;
	private float preis;
	private int stockwerk;
	private boolean minibar;
	private List<Buchung> buchungen;

	public int getZimmernummer() {
		return zimmernummer;
	}

	public void setZimmernummer(int zimmernummer) {
		this.zimmernummer = zimmernummer;
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public int getStockwerk() {
		return stockwerk;
	}

	public void setStockwerk(int stockwerk) {
		this.stockwerk = stockwerk;
	}

	public boolean isMinibar() {
		return minibar;
	}

	public void setMinibar(boolean minibar) {
		this.minibar = minibar;
	}

	public List<Buchung> getBuchungen() {
		return buchungen;
	}

	public void setBuchungen(List<Buchung> buchungen) {
		this.buchungen = buchungen;
	}
	
	public boolean addBuchung(Buchung buchung){
		if(!this.buchungen.contains(buchung)){
			this.buchungen.add(buchung);
			buchung.addZimmer(this);
			return true;
		}
		return false;
	}

}
