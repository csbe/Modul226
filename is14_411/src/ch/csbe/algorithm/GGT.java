package ch.csbe.algorithm;

public class GGT {

	public static void main(String[] args) {
		System.out.println(ggt(12, 8));
		System.out.println(kgv(12, 16));
		System.out.println(kgvr(12, 16));
	}

	public static int ggt(int a, int b) {
		while (a != b) {
			if (a > b) {
				a -= b;
			} else {
				b -= a;
			}
		}
		return a;
	}

	public static int kgv(int a, int b) {
		return (a * b) / ggt(a, b);
	}

	public static int kgvr(int a, int b) {
		int tempa = a, tempb = b;

		while (a != b) {
			if (a < b) {
				a += tempa;
			} else {
				b += tempb;
			}
		}
		return a;
	}

}
