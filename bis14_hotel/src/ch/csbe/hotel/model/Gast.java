package ch.csbe.hotel.model;

import java.util.List;

public class Gast {

	private String name;
	private String email;
	private List<Buchung> buchungen;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
			buchung.setGast(this);
			return true;
		}
		return false;
	}

}
