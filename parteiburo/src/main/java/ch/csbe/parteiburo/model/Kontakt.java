package ch.csbe.parteiburo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="Kontakt")
public class Kontakt {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String information;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="KontaktTyp", joinColumns={
			@JoinColumn(name="kontaktfk", nullable=false, updatable=false)
			},
			inverseJoinColumns = {
			@JoinColumn(name="typfk", nullable=false,updatable=false)
			}
	)
	private List<Typ> types;

	public Kontakt() {
		super();
		types = new ArrayList<Typ>();
	}

	public Kontakt(String information, List<Typ> types) {
		super();
		this.information = information;
		this.types = types;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public List<Typ> getTypes() {
		return types;
	}

	public void setTypes(List<Typ> types) {
		this.types = types;
	}

}
