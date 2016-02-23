package ch.csbe.parteiburo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import ch.csbe.parteiburo.controller.OrtController;
import ch.csbe.parteiburo.dao.Database;
import ch.csbe.parteiburo.model.Ort;

public class OrtControllerTest {

	OrtController controller;
	int id;
	Logger logger;

	@Before
	public void setUp() throws Exception {
		controller = new OrtController(new Ort());
		logger = LogManager.getLogger(OrtControllerTest.class);
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Session geschlossen");
		Database.close();
	}

	@Test
	public void testSave() {
		Ort o = new Ort("2502", "Biel");
		controller.setOrt(o);
		controller.save();
		id = controller.getAccess().lastInsertedId();
		logger.info("letzte eingefügte ID " + id);
		Ort oad = Database.getSession().get(Ort.class, id);
		assertEquals(oad.getPlz(), o.getPlz());
	}

	@Test
	public void testGetSingle() {
		id = controller.getAccess().lastInsertedId();
		Ort o = new Ort();
		o.setId(id);
		controller.setOrt(o);
		Ort oad = controller.getSingle();

		assertEquals(oad.getId(), id);
	}

	@Test
	public void testGetAll() {
		List<Ort> orte = controller.getAll();
		assertNotEquals(orte.size(), 0);
	}

	@Test
	public void testUpdate() {
		int id = controller.getAccess().lastInsertedId();
		Ort o = new Ort();
		o.setId(id);
		controller.setOrt(o);
		Ort oad = controller.getSingle();
		oad.setOrt("Supermann");
		//controller.update();
		logger.info("Ort: " + oad.getOrt());
		Ort ort = new Ort();
		ort.setId(id);
		controller.setOrt(ort);
		Ort neuerort = controller.getSingle();
		logger.info("Ort: " + neuerort.getOrt());
		assertEquals(oad.getOrt(), neuerort.getOrt());
	}

}
