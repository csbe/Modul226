package ch.csbe.algorithm.sort.insert;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class InsertSort {
	
	public static InsertDataType root;
	public static int size = 0;
	
	public void insertSorted(InsertDataType idt){
		InsertDataType e = root;
		while(e.next != null && idt.compareTo(e.next) > 0){
			e = e.next;
		}
		
		idt.next = e.next;
		e.next = idt;
		size++;
	}
	
	public static void main(String[] args) {
		InsertSort is = new InsertSort();
		
		root = new InsertDataType(0); // egal welchen wert da es der root ist
		InsertDataType idt2 = new InsertDataType(6);
		is.insertSorted(idt2);
		is.insertSorted(new InsertDataType(3));
		is.insertSorted(new InsertDataType(7));
		is.insertSorted(new InsertDataType(1));
		is.insertSorted(new InsertDataType(-5));
		
		
		while(root.next != null){
			System.out.println(root.next);
			root = root.next;
		}
		
		
	}
	
	

}
