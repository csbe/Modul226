package ch.csbe.parteiburo.controller;

import java.util.List;

import ch.csbe.parteiburo.dao.Access;
import ch.csbe.parteiburo.model.Ort;

public class OrtController {

	private Access<Ort> access;
	private Ort ort;
	
	public OrtController(Ort ort){
		this.ort = ort;
		access = new Access<Ort>(Ort.class);
	}
	
	public void save(){
		access.save(ort);		
	}
	
	public Ort getSingle(){
		ort = access.getById(ort.getId());
		return ort;
	}
	
	public List<Ort> getAll(){
		return access.getAll();
	}
	
	public void update(){
		access.update(ort);
	}
	
	public void delete(){
		access.delete(ort);
	}
	
	public void setOrt(Ort o){
		ort = o;
	}
	
	public Ort getOrt(){
		return ort;
	}
	
	public Access<Ort> getAccess(){
		return access;
	}
	
}
