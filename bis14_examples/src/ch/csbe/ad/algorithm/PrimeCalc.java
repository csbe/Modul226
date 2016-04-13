package ch.csbe.ad.algorithm;

public class PrimeCalc {
	
	public boolean isPrime(int zahl, int counter){
		if(counter == 2)
			return true;
		if(zahl%counter==0){
			return false;
		}else{
			return isPrime(zahl,counter-1);
		}
	}

	public boolean isPrime(int zahl){
		if(zahl%2==0 && zahl > 2)
			return false;
		for(int i = zahl/2; i > 1; i--){
			if(zahl%i==0)
				return false;
		}
		return true;
	}
	

	public static void main(String[] args) {
		PrimeCalc pc = new PrimeCalc();
		System.out.println(pc.isPrime(45));
		System.out.println(pc.isPrime(45,45/2));
		System.out.println(pc.isPrime(12));
		System.out.println(pc.isPrime(12,12/2));
		System.out.println(pc.isPrime(5));
		System.out.println(pc.isPrime(5,5/2));
		System.out.println(pc.isPrime(99));
		System.out.println(pc.isPrime(99,99/2));
		System.out.println(pc.isPrime(17));
		System.out.println(pc.isPrime(17,17/2));
	}

}
