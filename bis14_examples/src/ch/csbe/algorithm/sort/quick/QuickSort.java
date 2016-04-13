package ch.csbe.algorithm.sort.quick;

public class QuickSort {

	private SortType[] array;
	private int length;
	
	public QuickSort(SortType[] array){
		this.array = array;
		this.length = this.array.length;
	}
	
	public void sort(){
		quick(0, length-1);
	}
	
	public void quick(int low, int heigh){
		int i = low, j = heigh;
		SortType half = array[i+(j-i)/2];
		while(i <= j){
			while(array[i].compareTo(half) < 0)
				i++;
			while(array[j].compareTo(half) > 0)
				j--;
			
			if(i <= j){
				swap(i,j);
				i++;
				j--;
			}
			
			if(low < j)
				quick(low,j);
			if(i < heigh)
				quick(i,heigh);
		}
	}
	
	public void swap(int i, int j){
		SortType temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
