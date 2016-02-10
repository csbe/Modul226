package ch.csbe.hotel.model;

import java.util.List;

public class Hotel {

	private String name;
	private String adresse;
	private List<Doppelzimmer> doppelzimmer;
	private List<Einzelzimmer> einzelzimmer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Doppelzimmer> getDoppelzimmer() {
		return doppelzimmer;
	}

	public void setDoppelzimmer(List<Doppelzimmer> doppelzimmer) {
		this.doppelzimmer = doppelzimmer;
	}

	public List<Einzelzimmer> getEinzelzimmer() {
		return einzelzimmer;
	}

	public void setEinzelzimmer(List<Einzelzimmer> einzelzimmer) {
		this.einzelzimmer = einzelzimmer;
	}

}
