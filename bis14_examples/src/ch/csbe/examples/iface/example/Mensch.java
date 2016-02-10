package ch.csbe.examples.iface.example;

public class Mensch implements Saugetier{

	private String bezeichnung;
	
	public Mensch(){
		
	}
	
	public Mensch(String bezeichnung){
		
	}
	
	@Override
	public float getGroesse() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getGewicht() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getBezeichnung() {
		// TODO Auto-generated method stub
		return bezeichnung;
	}

	@Override
	public void setGroesse(float groesse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGewicht(float gewicht) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBezeichnung(String bezeichnung) {
		// TODO Auto-generated method stub
		this.bezeichnung = bezeichnung;
	}

}
