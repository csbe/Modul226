package ch.csbe.parteiburo.controller;

import java.util.List;

import ch.csbe.parteiburo.model.Kontakt;
import ch.csbe.parteiburo.model.Typ;

public class KontaktTypController {
	
	private Kontakt kontakt;
	
	public KontaktTypController(Kontakt kontakt){
		this.kontakt = kontakt;
	}
	
	public List<Typ> getTypes(){
		return kontakt.getTypes();
	}
}
