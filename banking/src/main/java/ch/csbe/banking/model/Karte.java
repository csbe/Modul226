package ch.csbe.banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="Karte")
public class Karte {
	@Id
	private String nummer;
	@Column(nullable=false)
	private String pin;
	// TODO Mapping to konto
	@Transient
	private Konto konto;

	public Karte() {
		super();
	}

	public Karte(String nummer, String pin, Konto konto) {
		super();
		this.nummer = nummer;
		this.pin = pin;
		this.setKonto(konto);
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Konto getKonto() {
		return konto;
	}

	public void setKonto(Konto konto) {
		if(this.konto != konto){
			this.konto = konto;
			if(!this.konto.getKarten().contains(this))
				this.konto.getKarten().add(this);
		}
	}

}
