package ch.csbe.is14.ui.extend.example;

public class Tester {

	public static void main(String[] args) {
		Person p = new Person("Buchs", "Enrico");
		Object o = p;
		Person p1 = new Person("Buchs", "Max");
		
		System.out.println("Prüfung mit sich selbst: " + p.equals(p));
		System.out.println("Prüfung mit Objekt: " + p.equals(o));
		System.out.println("Prüfung mit anderer Instanz: " + p.equals(p1));

	}

}
