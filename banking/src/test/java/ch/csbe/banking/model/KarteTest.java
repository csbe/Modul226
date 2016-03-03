package ch.csbe.banking.model;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ch.csbe.banking.dao.Database;
import ch.csbe.banking.dao.KarteDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KarteTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testEAddKunde(){
		KarteDao kd = new KarteDao();
		Karte k = kd.getKarte("111-112");
		Kunde kunde = new Kunde("Muster", "Timon");
		k.setKunde(kunde);
		kd.update(k);
		assertNotNull(kunde.getId());
		//Database.getInstance().closeConnection();
	}
	
	@Test
	public void testDAuth(){
		KarteDao kd = new KarteDao();
		assertNotNull(kd.auth("111-111", "1234"));
	}
	
	@Test
	public void testCFailAuth(){
		Query q = Database.getInstance().getSession().createQuery("from Karte where nummer = :nummer and pin = :pin");
		q.setParameter("nummer", "111-111");
		q.setParameter("pin", "1234adsf");
		Karte k = (Karte)q.uniqueResult();
		assertNull(k);
	}
	
	@Test
	public void testBGetKarte(){
		Karte k = Database.getInstance().getSession().get(Karte.class, "111-111");
		
		assertNotNull(k);
	}

	@Test
	public void testASaveKarte(){
		Karte k = new Karte("111-112", "1234", null,null);
		String id = (new KarteDao()).save(k);
		assertEquals("111-112", id);
		//Database.getInstance().closeConnection();
	}

}
