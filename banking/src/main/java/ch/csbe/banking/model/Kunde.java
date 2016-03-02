package ch.csbe.banking.model;

import java.util.ArrayList;
import java.util.List;

public class Kunde {
	private String name;
	private String vorname;
	private List<Konto> konten = new ArrayList<Konto>();
	private List<Karte> karten = new ArrayList<Karte>();

	public Kunde() {
		super();
	}

	public Kunde(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public List<Konto> getKonten() {
		return konten;
	}

	public void setKonten(List<Konto> konten) {
		this.konten = konten;
	}

	public List<Karte> getKarten() {
		return karten;
	}

	public void setKarten(List<Karte> karten) {
		this.karten = karten;
	}

}
