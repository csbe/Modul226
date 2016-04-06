package ch.csbe.algorithm.rekursion;

public class Aufgabe_Rekursion {

	public static void main(String[] args) {

	}

	public static long nrek1(int x, int y) {
		int summe = 0;

		while (x > 0) {
			summe = summe + x + y;
			x--;
		}
		return summe;
	}

	/**
	 * Kombinatorik mit Wiederholung
	 * Formel => A = (N+k-1)!/(N-1)!*k!
	 * Für Aufgabe => summe = (x+y)!/x!*y!
	 * @param x
	 * @param y
	 * @return
	 */
	public static int nrek2(int x, int y) {
		long summe = 1;
		
		/*
		for(int dividend = x+y; dividend > 0; dividend--){
			summe *= dividend;
		}
		
		for(int divisor = x; divisor > 0; divisor--){
			summe /= divisor;
		}
		
		for(int divisor = y; divisor > 0; divisor--){
			summe /= divisor;
		}*/

		summe = fakultaetLoop(x+y)/(fakultaetLoop(x)*fakultaetLoop(y));
		
		
		return (int)summe;
	}
	

	public static long fakultaetLoop(int zahl){
		long produkt = 1;
		while(zahl > 0){
			produkt*=zahl--;
		}
		return produkt;
	}
	

	public static long rek1(int x, int y) {
		if (x <= 0 || y <= 0)
			return 0;
		return x + y + rek1(x - 1, y);
	}

	public static long rek2(int x, int y) {
		if (x <= 0 || y <= 0)
			return 1;
		return rek2(x - 1, y) + rek2(x, y - 1);
	}

}
