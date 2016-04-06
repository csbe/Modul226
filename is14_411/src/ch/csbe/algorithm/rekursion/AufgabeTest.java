package ch.csbe.algorithm.rekursion;

import static org.junit.Assert.*;
import static ch.csbe.algorithm.rekursion.Aufgabe_Rekursion.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AufgabeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test1() {
		assertEquals(rek2(5, 5), nrek2(5, 5));
	}

	@Test
	public final void test2() {
		assertEquals(rek2(3, 3), nrek2(3, 3));
	}
	
	@Test
	public final void test3() {
		assertEquals(rek2(4, 7), nrek2(4, 7));
	}
	
	@Test
	public final void test4() {
		assertEquals(rek2(5, 4), nrek2(5, 4));
	}
	
	@Test
	public final void test5() {
		assertEquals(rek2(7, 7), nrek2(7, 7));
	}

}
