package ch.csbe.parteiburo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="all", query="from Ort")
})
@Entity(name = "Ort")
public class Ort {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 6, nullable = false)
	private String plz;
	@Column(length = 16, nullable = false)
	private String ort;

	public Ort() {
		super();
	}

	public Ort(String plz, String ort) {
		super();
		this.plz = plz;
		this.ort = ort;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

}
