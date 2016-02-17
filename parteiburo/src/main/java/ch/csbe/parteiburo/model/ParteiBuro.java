package ch.csbe.parteiburo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ParteiBuro")
public class ParteiBuro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 16)
	private String kanton;

	public ParteiBuro() {
		super();
	}

	public ParteiBuro(String kanton) {
		super();
		this.kanton = kanton;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKanton() {
		return kanton;
	}

	public void setKanton(String kanton) {
		this.kanton = kanton;
	}

}
