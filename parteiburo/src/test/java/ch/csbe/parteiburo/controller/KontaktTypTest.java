package ch.csbe.parteiburo.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.csbe.parteiburo.controller.KontaktTypController;
import ch.csbe.parteiburo.model.Kontakt;
import ch.csbe.parteiburo.model.Typ;

public class KontaktTypTest {

	List<Typ> typen = new ArrayList<Typ>();
	KontaktTypController controller;
	
	@Before
	public void setUp() throws Exception {
		Typ t = new Typ();
		t.setName("Telefon");
		Typ t1 = new Typ();
		t1.setName("E-Mail");
		typen.add(t);
		typen.add(t1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTypes() {
		Kontakt k = new Kontakt();
		k.setInformation("032 4545 4554");
		controller = new KontaktTypController(k);
		
		k.setTypes(typen);
		
		List<Typ> types = controller.getTypes();
		
		assertEquals(types, typen);
		
	}

}
