package ch.csbe.examples.model;

import java.util.Date;

public class Taetigkeit {

	private String bezeichnung;
	private Person person;
	private Date von;
	private Date bis;

	public Taetigkeit() {
		super();
	}

	public Taetigkeit(String bezeichnung, Date von, Date bis) {
		super();
		this.bezeichnung = bezeichnung;
		this.von = von;
		this.bis = bis;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		if(this.person != person && this.person != null){
			this.person.getTaetigkeiten().remove(this);
		}
		this.person = person;
		this.person.addTaetigkeit(this);
	}

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

}
