package ch.csbe.examples.ext.example;

import ch.csbe.examples.ext.example.child.Mensch;
import ch.csbe.examples.ext.example.sup.Saugetier;

public class ExApp {

	public static void main(String ... args){
		
		Saugetier s = new Mensch("test");
		System.out.println(s.getBezeichnung());
		System.out.println(s.getGehart());
		
	}
	
	public static void example(String ... param){
		for(String s : param){
			System.out.println(s);
		}
	}
	
}
