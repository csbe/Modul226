package ch.csbe.banking.dao;

import org.hibernate.Query;

import ch.csbe.banking.model.Konto;


public class KontoDao {
	public Konto getKarte(String nummer){
		Query q = Database.getInstance().getSession().createQuery("from Konto where nr = :nr");
		q.setParameter("nr", nummer);
		return (Konto)q.uniqueResult();
	}
	
	public String save(Konto k){
		String id = (String)Database.getInstance().getSession().save(k);
		Database.getInstance().getSession().flush();
		return id;
	}
}
