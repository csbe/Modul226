package ch.csbe.parteiburo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "OrtSektion")
public class OrtSektion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private ParteiBuro parteiburo;
	@ManyToOne
	private Ort ort;

	public OrtSektion() {
		super();
	}

	public OrtSektion(ParteiBuro parteiburo, Ort ort) {
		super();
		this.parteiburo = parteiburo;
		this.ort = ort;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ParteiBuro getParteiburo() {
		return parteiburo;
	}

	public void setParteiburo(ParteiBuro parteiburo) {
		this.parteiburo = parteiburo;
	}

	public Ort getOrt() {
		return ort;
	}

	public void setOrt(Ort ort) {
		this.ort = ort;
	}

}
