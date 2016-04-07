package ch.csbe.banking.controller.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceContext;

import org.icefaces.ace.event.RowEditEvent;

import ch.csbe.banking.dao.Database;
import ch.csbe.banking.model.Kunde;

@ManagedBean
@ViewScoped
public class KundeBean implements Serializable{

	private List<Kunde> kunden;
	@PersistenceContext
    private Database entityManager = Database.getInstance();
	private Kunde kunde;
	
	public KundeBean(){
		kunden = (List<Kunde>)entityManager.getSession().createQuery("from Kunde").list();
		kunde = new Kunde();
	}
	
	public List<Kunde> getKunden(){
		return kunden;
	}
	
	public String save(){
		Database.getInstance().getSession().save(kunde);
		Database.getInstance().getSession().flush();
		Database.getInstance().closeSession();
		kunde = new Kunde();
		return "next";
	}

	public void save(RowEditEvent e){
		Database.getInstance().getSession().update((Kunde)e.getObject());
		Database.getInstance().getSession().flush();
		Database.getInstance().closeSession();
	}
	
	public void setKunden(List<Kunde> kunden) {
		this.kunden = kunden;
		for(Kunde k : kunden){
			Database.getInstance().getSession().update(k);
			Database.getInstance().getSession().flush();
		}
		Database.getInstance().closeSession();
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	
	
	
}
