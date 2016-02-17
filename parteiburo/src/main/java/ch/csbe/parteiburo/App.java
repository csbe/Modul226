package ch.csbe.parteiburo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ch.csbe.parteiburo.dao.Access;
import ch.csbe.parteiburo.dao.Database;
import ch.csbe.parteiburo.model.Ort;
import ch.csbe.parteiburo.model.ParteiBuro;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Access<Ort> aco = new Access<Ort>(Ort.class);
    	Access<ParteiBuro> acpb = new Access<ParteiBuro>(ParteiBuro.class);
    	Ort ort = aco.getById(1);
    	ParteiBuro pb = new ParteiBuro("Bern");
    	
    	
    	
    	/*Ort o = new Ort("2502","Biel");
    	Access<Ort> ac = new Access<Ort>(Ort.class);
    	//ac.save(o);
    	
    	
    	Ort o2 = ac.getById(4);
    	System.out.println(o2.getOrt());
    	
    	for(Ort to : ac.getList()){
    		System.out.println(to.getOrt());
    	}*/
    	
    	Database.close();
    }
}
