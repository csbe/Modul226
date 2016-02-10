package ch.csbe.examples.ext.example.sup;

public abstract class Saugetier {
	private float groesse;
	private float gewicht;
	private String bezeichnung;
	protected String gehart = "bückend";

	public Saugetier(String bezeichnung) {
		super();
		this.bezeichnung = bezeichnung;
	}

	public float getGroesse() {
		return groesse;
	}

	public void setGroesse(float groesse) {
		this.groesse = groesse;
	}

	public float getGewicht() {
		return gewicht;
	}

	public void setGewicht(float gewicht) {
		this.gewicht = gewicht;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getGehart() {
		return gehart;
	}

	public void setGehart(String gehart) {
		this.gehart = gehart;
	}
	
	public abstract void example();

}
