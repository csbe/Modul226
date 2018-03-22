package ch.csbe.testing.unit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.csbe.testing.unit.rechner.WaehrungRechner;

public class UmrechnerTest {

	@Test
	public void testEurToCHF() {
		//109.8901...
		//weiterer kommentar inline
		assertEquals(109.8901, WaehrungRechner.EurToCHF(100), 0.0001);
	}

}
