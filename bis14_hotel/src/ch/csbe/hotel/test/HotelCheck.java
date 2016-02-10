package ch.csbe.hotel.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.csbe.hotel.model.Buchung;
import ch.csbe.hotel.model.Doppelzimmer;
import ch.csbe.hotel.model.Einzelzimmer;
import ch.csbe.hotel.model.Gast;
import ch.csbe.hotel.model.Hotel;

public class HotelCheck {

	Hotel h;
	
	@Before
	public void setUp() throws Exception {
		h = new Hotel();
	}

	@Test
	public void test() {
		h.getDoppelzimmer().add(new Doppelzimmer());
		h.getDoppelzimmer().get(0).setAnzahlBett(4);
		h.getDoppelzimmer().add(new Doppelzimmer());
		h.getEinzelzimmer().add(new Einzelzimmer());
		assertEquals(h.getDoppelzimmer().size(), 2);
	}
	
	@Test
	public void testBuchungGast(){
		Gast g = new Gast();
		Buchung b = new Buchung();
		b.setGast(g);
		assertEquals(g.getBuchungen().size(),1);
	}
	
	@Test
	public void testGastBuchung(){
		Gast g = new Gast();
		Buchung b = new Buchung();
		g.addBuchung(b);
		assertEquals(b.getGast(),g);
	}

}
