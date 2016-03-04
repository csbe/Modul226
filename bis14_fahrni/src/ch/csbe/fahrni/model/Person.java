package ch.csbe.fahrni.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Person model class which is just a data container
 * implements {@link:java.io.Serializable} because the object should
 * be saved as a xml representation
 * @author ebuchs
 * @version 1.0
 */
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String vorname;
	private Date geburtsdatum;
	private float gehalt;

	/**
	 * The constructor without params its used for deserialize
	 */
	public Person() {
		super();
	}

	/**
	 * the construct with several params
	 * @param name String is the lastname from the person
	 * @param vorname String is the first name from person
	 * @param geburtsdatum {@link:java.util.Date} is the birthdate from the person
	 * @param gehalt float is the actual salary from the person
	 */
	public Person(String name, String vorname, Date geburtsdatum, float gehalt) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.gehalt = gehalt;
	}

	/**
	 * returns the name from person
	 * @return name String from person
	 */
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

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public float getGehalt() {
		return gehalt;
	}

	public void setGehalt(float gehalt) {
		this.gehalt = gehalt;
	}

}
