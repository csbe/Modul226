package ch.csbe.ad.datastructure;

public class StackMain {

	public static void main(String[] args) {
		MyStack<String> s = new MyStackImpl<String>();
		
		s.push("Elem 1");
		s.push("Elem 2");
		
		System.out.println(s.pop());
		
		s.push("Elem 3");
		
		System.out.println(s.pop());
		System.out.println(s.pop());

	}

}
