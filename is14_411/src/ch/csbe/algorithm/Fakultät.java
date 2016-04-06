package ch.csbe.algorithm;

public class Fakultät {

	public static void main(String[] args) {
		System.out.println(fakultaetLoop(5));
		System.out.println(fakultaet(5));

	}
	
	public static int fakultaetLoop(int zahl){
		int produkt = 1;
		while(zahl > 0){
			produkt*=zahl--;
		}
		return produkt;
	}
	

	public static int fakultaet(int zahl){
		if(zahl<2) return 1;
		return zahl*fakultaet(zahl-1);
	}
	
}
