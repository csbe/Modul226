package ch.csbe.ad.algorithm;

import java.util.Arrays;

public class SearchExample {

	public int search(String[] a, int elem){
		for(int i = 0; i < a.length; i++){
			if(a[i].equals(elem+""))
				return i;
		}
		return -1;
	}
	
	public int binarySearch(String[] a, int elem){
		int l = 0, p, r = a.length-1;
		while(l <= r){
			p = (l+r)/2;
			if(a[p].compareTo(elem+"") < 0){
				l = p+1;
			}else if(a[p].compareTo(elem+"") > 0){
				r = p-1;
			}else
				return p;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int anzahl = 10000000;
		String[] arr = new String[anzahl];
		for(int i = 0; i < anzahl; i++){
			arr[i] = i+"";
		}
	
		int zahl = 9847543;
		
		SearchExample se = new SearchExample();
		Arrays.sort(arr);		
		
		long t = System.currentTimeMillis();		
		System.out.println(se.search(arr, zahl));
		long t1 = System.currentTimeMillis();
		System.out.println("Normaler Search " + (t1-t));

		t = System.currentTimeMillis();	
		System.out.println(se.binarySearch(arr, zahl));
		t1 = System.currentTimeMillis();
		System.out.println("Binary Search " + (t1-t));

	}

}
