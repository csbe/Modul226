package ch.csbe.ad.datastructure;

import java.util.Set;
import java.util.TreeSet;

public class BaumeExample {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		set.add(44);
		set.add(4);
		set.add(46);
		set.add(4);
		
		for(Integer i : set){
			System.out.println(i);
		}
		
		
		TreeSet<String> sset = new TreeSet<String>();

		sset.add("Baum");
		sset.add("Au");
		sset.add("Haus");
		sset.add("Chlous");
		sset.add("Auto");
		
		for(String i : sset){
			System.out.println(i);
		}
		
		sset.forEach(s -> {System.out.println(s);});
		
		//System.out.println(sset.headSet("Chlous"));
		System.out.println(sset.higher("Chlous"));

	}

}
