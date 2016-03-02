package ch.csbe.banking.model;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.csbe.banking.dao.Database;
import ch.csbe.banking.dao.KarteDao;

public class KarteTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAuth(){
		KarteDao kd = new KarteDao();
		assertNotNull(kd.auth("111-111", "1234"));
	}
	
	@Test
	public void testFailAuth(){
		Query q = Database.getInstance().getSession().createQuery("from Karte where nummer = :nummer and pin = :pin");
		q.setParameter("nummer", "111-111");
		q.setParameter("pin", "1234adsf");
		Karte k = (Karte)q.uniqueResult();
		assertNull(k);
	}
	
	@Test
	public void testGetKarte(){
		Karte k = Database.getInstance().getSession().get(Karte.class, "111-111");
		
		assertNotNull(k);
	}

	@Test
	public void testSaveKarte(){
		Karte k = new Karte("111-111", "1234", null);
		String id = (new KarteDao()).save(k);
		assertEquals("111-111", id);
		Database.getInstance().closeConnection();
	}

}
