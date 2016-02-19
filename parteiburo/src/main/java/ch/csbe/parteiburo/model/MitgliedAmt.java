package ch.csbe.parteiburo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "MitgliedAmt")
public class MitgliedAmt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "mitgliedfk")
	private Mitglied mitglied;
	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "amtfk")
	private Amt amt;
	@Column
	private Date wahldatum;
	@Column
	private Date wahldauer;

	public MitgliedAmt() {
		super();
	}

	public MitgliedAmt(Mitglied mitglied, Amt amt, Date wahldatum, Date wahldauer) {
		super();
		this.mitglied = mitglied;
		this.amt = amt;
		this.wahldatum = wahldatum;
		this.wahldauer = wahldauer;
	}

	public Mitglied getMitglied() {
		return mitglied;
	}

	public void setMitglied(Mitglied mitglied) {
		this.mitglied = mitglied;
	}

	public Amt getAmt() {
		return amt;
	}

	public void setAmt(Amt amt) {
		this.amt = amt;
	}

	public Date getWahldatum() {
		return wahldatum;
	}

	public void setWahldatum(Date wahldatum) {
		this.wahldatum = wahldatum;
	}

	public Date getWahldauer() {
		return wahldauer;
	}

	public void setWahldauer(Date wahldauer) {
		this.wahldauer = wahldauer;
	}

}
