package ch.csbe.algorithm.sort.quick;

import java.util.Arrays;

public class QuickExample {

	public static void main(String[] args) {
		Konto[] konten = {
				new Konto(34),
				new Konto(12.8f),
				new Konto(5),
				new Konto(68)
		};
		
		QuickSort sorter = new QuickSort(konten);
		
		System.out.println(Arrays.toString(konten));
		
		sorter.sort();
		
		System.out.println(Arrays.toString(konten));
		
		Person p = new Person("Hans","Willi");
		
		Person[] personen = {
				new Person("Muster", "Max"),
				new Person("Schenk", "Nico"),
				new Person("Dolf", "Hans")
		};
		
		QuickSort sorter1 = new QuickSort(personen);
		
		System.out.println(Arrays.toString(personen));
		
		sorter1.sort();
		
		System.out.println(Arrays.toString(personen));
		
	}

}
