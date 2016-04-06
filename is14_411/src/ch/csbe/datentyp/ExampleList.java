package ch.csbe.datentyp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExampleList {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		List<String> l1 = new LinkedList<String>();
		
		for(int i = 0; ; i++){
			String s = "Hallo Welt";
			s += " etwas";
			System.out.println(s.charAt(4));
		}
		
	}

}
