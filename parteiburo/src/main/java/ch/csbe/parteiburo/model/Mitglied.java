package ch.csbe.parteiburo.model;

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

@Entity(name = "Mitglied")
public class Mitglied {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ortsektionfk")
	private OrtSektion ortsektion;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ortfk")
	private Ort ort;
	@Column
	private String name;
	@Column
	private String vorname;
	@Column
	private Date geburtsdatum;
	@Column
	private String strasse;

	public Mitglied() {
		super();
	}

	public Mitglied(OrtSektion ortsektion, Ort ort, String name, String vorname, Date geburtsdatum, String strasse) {
		super();
		this.ortsektion = ortsektion;
		this.ort = ort;
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.strasse = strasse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrtSektion getOrtsektion() {
		return ortsektion;
	}

	public void setOrtsektion(OrtSektion ortsektion) {
		this.ortsektion = ortsektion;
	}

	public Ort getOrt() {
		return ort;
	}

	public void setOrt(Ort ort) {
		this.ort = ort;
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

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

}
