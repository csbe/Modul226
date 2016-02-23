package ch.csbe.parteiburo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.csbe.parteiburo.dao.Access;
import ch.csbe.parteiburo.dao.Database;
import ch.csbe.parteiburo.model.Ort;
import ch.csbe.parteiburo.model.OrtSektion;
import ch.csbe.parteiburo.model.ParteiBuro;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(App.class);
		
		//logger.info("was geht ab");

		//Access<Ort> aco = new Access<Ort>(Ort.class);
		//Access<ParteiBuro> acpb = new Access<ParteiBuro>(ParteiBuro.class);
		//Access<OrtSektion> acos = new Access<OrtSektion>(OrtSektion.class);
		//Ort ort = aco.getById(1);
		//ParteiBuro pb = acpb.getById(1);
		//OrtSektion os = new OrtSektion(pb, ort);
		//acos.save(os);
		// ParteiBuro pb = new ParteiBuro("Bern");
		// acpb.save(pb);

		/*
		 * Ort o = new Ort("2502","Biel"); Access<Ort> ac = new
		 * Access<Ort>(Ort.class); //ac.save(o);
		 * 
		 * 
		 * Ort o2 = ac.getById(4); System.out.println(o2.getOrt());
		 * 
		 * for(Ort to : ac.getList()){ System.out.println(to.getOrt()); }
		 */

		//Database.close();
	}
}
