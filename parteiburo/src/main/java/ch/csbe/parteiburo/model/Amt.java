package ch.csbe.parteiburo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Amt")
public class Amt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 32)
	private String bezeichnung;
	@Column(length = 4)
	private String kuerzel;

	public Amt() {
		super();
	}

	public Amt(String bezeichnung, String kuerzel) {
		super();
		this.bezeichnung = bezeichnung;
		this.kuerzel = kuerzel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

}
