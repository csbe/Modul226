package ch.csbe.banking.dao;

import ch.csbe.banking.model.Buchung;

public class BuchungDao {
	public int save(Buchung k){
		int id = (Integer)Database.getInstance().getSession().save(k);
		Database.getInstance().getSession().flush();
		return id;
	}
}
