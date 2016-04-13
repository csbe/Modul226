package ch.csbe.algorithm.sort.selection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SelectionExample {
	
	List<Integer> array = new LinkedList<Integer>();

	public void selectionSort(int l, int r) {
		int min_pos;
		for (int i = l; i < r; i++) {
			min_pos = findMin(i, r);
			swap(i, min_pos);
		}
	}
	
	public void swap(int i, int j){
		int l = array.get(i);
		array.set(i, array.get(j));
		array.set(j, l);
	}

	private int findMin(int n, int r) { // find position with minimal Element
		int min = n;
		for (int i = n + 1; i < r; i++)
			if (array.get(i).compareTo(array.get(min)) < 0)
				min = i;
		return min;
	}

	public static void main(String[] args) {
		SelectionExample se = new SelectionExample();
		se.array.add(45);
		se.array.add(446);
		se.array.add(4);
		
		se.selectionSort(0, se.array.size());
		
		for(int i: se.array){
			System.out.println(i);
		}
		
		
	}

}
