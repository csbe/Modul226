package ch.csbe.algorithm.fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
		long zahl = 100l;
		System.out.println("\nNach " + fib(zahl) + " Generationen eine Population um " + zahl);
		
		System.out.println(fibonacci(9));
	}
	
	public static int fib(long max){
		long summe = 0, a=0, b=1;
		int count = 0;
		
		while(summe <= max){
			System.out.print(a + " ");
			summe += a+b;
			long tempb = a+b;
			a = b;
			b = tempb;
			count++;
		}
		System.out.print(a + " ");
		return count;
	}
	
	
	
	public static int fibonacci(int a){
	    if (a==1||a==2) return 1;
	    else return fibonacci(a-1)+fibonacci(a-2);
	  }

}
