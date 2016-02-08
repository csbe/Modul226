package ch.csbe.examples.main;

import java.util.Date;

import ch.csbe.examples.model.Benutzer;
import ch.csbe.examples.model.Person;
import ch.csbe.examples.model.Taetigkeit;

public class Example1 {

	public static void main(String[] args) {
		Benutzer b = new Benutzer("p.muster", "pw");
		Person p = new Person("Mustermann","Peter",b);
		Person p2 = new Person("Langsam", "Sehr", null);
		Taetigkeit t1 = new Taetigkeit("Etwas", new Date(), null);
		Taetigkeit t2 = new Taetigkeit("Anderes", new Date(), null);
		//t1.setPerson(p2);
		//t2.setPerson(p);
		p.addTaetigkeit(t1);
		p.addTaetigkeit(t2);
		
		System.out.println(t1.getPerson().getName());
		
		System.out.println("Person 2: " + p2.getTaetigkeiten().isEmpty());
		
		System.out.println(p.getName() + " " + p.getVorname());
		System.out.println(p.getBenutzer().getUsername());
		
		for(Object o : p.getTaetigkeiten().toArray()){
			Taetigkeit t = (Taetigkeit) o;
			System.out.println(t.getBezeichnung());
		}
		
		
	}

}
