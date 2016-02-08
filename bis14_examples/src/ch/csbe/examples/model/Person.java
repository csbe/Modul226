package ch.csbe.examples.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ch.csbe.examples.data.MyList;

public class Person {

	private String name;
	private String vorname;
	private Benutzer benutzer;
	private List<Taetigkeit> taetigkeiten;

	public Person() {
		super();
		taetigkeiten = new ArrayList<Taetigkeit>();
	}

	public Person(String name, String vorname, Benutzer benutzer) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.benutzer = benutzer;
		taetigkeiten = new LinkedList<Taetigkeit>();
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

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
	
	/**
	 * The method add the Taetigkeit to the List when it is not contains
	 * in the list and add this person to the taetigkeit
	 * @param t is the Taetigkeit which is added to the Taetigkeiten List
	 */
	public void addTaetigkeit(Taetigkeit t){
		if(!taetigkeiten.contains(t)){
			taetigkeiten.add(t);
			t.setPerson(this);
		}
	}

	public List<Taetigkeit> getTaetigkeiten() {
		return taetigkeiten;
	}

	public void setTaetigkeiten(List<Taetigkeit> taetigkeiten) {
		this.taetigkeiten = taetigkeiten;
	}

}
