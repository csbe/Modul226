package ch.csbe.banking.controller.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.csbe.banking.dao.Database;
import ch.csbe.banking.model.Kunde;

@ManagedBean
@ViewScoped
public class KundeBean {

	private List<Kunde> kunden;
	
	public KundeBean(){
		kunden = (List<Kunde>)Database.getInstance().getSession().createQuery("from Kunde").list();
	}
	
	public List<Kunde> getKunden(){
		return kunden;
	}
	
}
