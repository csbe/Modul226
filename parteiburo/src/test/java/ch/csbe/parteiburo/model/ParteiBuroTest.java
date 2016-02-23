package ch.csbe.parteiburo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ch.csbe.parteiburo.dao.Access;
import ch.csbe.parteiburo.dao.Database;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParteiBuroTest {

	int id;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testCSearchParteiBuro(){
		Access<ParteiBuro> access = new Access<ParteiBuro>(ParteiBuro.class);
		List<ParteiBuro> pareiburos = access.search(new String[]{"kanton like :kanton"}, 
				new String[]{"Be%"});
		assertNotEquals(0, pareiburos.size());
	}
	
	
	@Test
	public void testASetOrte() {
		Ort ort1 = new Ort("3000", "Bern");
		Ort ort2 = new Ort("3007", "Belp");
		ParteiBuro pb = new ParteiBuro("Solothurn");
		pb.getOrte().add(ort1);
		pb.getOrte().add(ort2);
		Access<ParteiBuro> access = new Access<ParteiBuro>(ParteiBuro.class);
		id = access.save(pb);
		System.out.println("eingefügte id " + id);
		assertNotEquals(0, id);
		
		Database.close();
	}
	
	@Test
	public void testBGetOrte() {
		Access<ParteiBuro> access = new Access<ParteiBuro>(ParteiBuro.class);
		id = access.maxId();
		System.out.println("get id " + id);
		ParteiBuro pbpersistent = access.getById(id);
		assertEquals(2, pbpersistent.getOrte().size());
		Database.close();
	}	

}
