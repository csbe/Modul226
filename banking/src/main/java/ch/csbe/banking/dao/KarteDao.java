package ch.csbe.banking.dao;

import org.hibernate.Query;

import ch.csbe.banking.model.Karte;

public class KarteDao {

	public Karte auth(String nummer, String pin){
		Query q = Database.getInstance().getSession().createQuery("from Karte where nummer = :nummer and pin = :pin");
		q.setParameter("nummer", nummer);
		q.setParameter("pin", pin);
		return (Karte)q.uniqueResult();
	}
	
	public String save(Karte k){
		String id = (String)Database.getInstance().getSession().save(k);
		Database.getInstance().getSession().flush();
		return id;
	}
	
}
