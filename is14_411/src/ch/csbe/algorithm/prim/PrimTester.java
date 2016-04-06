package ch.csbe.algorithm.prim;

public class PrimTester {

	public static void main(String[] args) {

		/*for (int i = 2; i < 100; i++) {
			if (isPrim(i))
				System.out.print(i + " ");
			if (isPrim(i,i/2))
				System.out.print(i + " ");
		}*/
		
		int zahl = 103003;
		isPrim(zahl);
		isPrim(zahl,zahl/2);
		

	}

	public static boolean isPrim(int zahl) {
		int j = 1;
		for (int i = zahl / 2; i > 1; i--) {
			System.out.println(j++);
			if (zahl % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int j = 1;
	private static boolean isPrim(int zahl, int halb) {
		System.out.println(j++);
		if (halb == 1)
			return true;
		else if (zahl % halb == 0)
			return false;
		else
			return isPrim(zahl, --halb);
	}

}
