package ch.csbe.ad.datastructure;

import java.util.ArrayList;
import java.util.List;

public class MyStackImpl<E> implements MyStack<E>{

	private List<E> elements  = new ArrayList<E>();
	private int length = 0;
	
	@Override
	public E push(E elem) {
		elements.add(elem);
		length++;
		return elem;
	}

	@Override
	public E pop() {
		E elem = elements.get(length-1);
		elements.remove(length-1);
		length--;
		return elem;
	}

}
