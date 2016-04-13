package ch.csbe.ad.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		List<String> thelist = new ArrayList<String>();
		thelist.add("test1");
		thelist.add("test2");
		
		Iterator<String> iter = thelist.iterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		
		for(String s : thelist){
			System.out.println(s);
		}
		

	}

}
