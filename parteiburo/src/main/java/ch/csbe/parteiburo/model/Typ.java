package ch.csbe.parteiburo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="Typ")
public class Typ {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@ManyToMany(mappedBy="types", fetch=FetchType.LAZY)
	private List<Kontakt> kontakte;

	public Typ() {
		super();
		kontakte = new ArrayList<Kontakt>();
	}

	public Typ(String name, List<Kontakt> kontakte) {
		super();
		this.name = name;
		this.kontakte = kontakte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Kontakt> getKontakte() {
		return kontakte;
	}

	public void setKontakte(List<Kontakt> kontakte) {
		this.kontakte = kontakte;
	}

}
