package ch.csbe.algorithm.sort.insert;

public class InsertDataType implements Comparable<InsertDataType>{

	private int zahl;
	public InsertDataType next;
	
	public InsertDataType(int zahl){
		this.zahl = zahl;
	}
	
	public String toString() {
		return zahl + "";
	}
	

	public int getZahl() {
		return zahl;
	}

	@Override
	public int compareTo(InsertDataType o) {
		return this.zahl - o.getZahl();
	}
	
}
