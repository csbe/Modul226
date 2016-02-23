package ch.csbe.parteiburo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "ParteiBuro")
public class ParteiBuro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 16)
	private String kanton;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="OrtSektion",joinColumns={
			@JoinColumn(name="parteiburofk", nullable=false, updatable=false,
					foreignKey=@ForeignKey(name="parteiburofk"))},
			inverseJoinColumns = {
			@JoinColumn(name="ortfk", nullable=false,updatable=false,
					foreignKey=@ForeignKey(name="ortfk"))
			}
	)
	private List<Ort> orte = new ArrayList<Ort>();

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

	public List<Ort> getOrte() {
		return orte;
	}

	public void setOrte(List<Ort> orte) {
		this.orte = orte;
	}
	
}
