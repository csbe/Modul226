package ch.csbe.algorithm.sort.quick;

public class Konto implements SortType{

	private float value;
	
	public Konto(float value){
		this.value = value;
	}
	
	public float getValue() {
		return value;
	}

	@Override
	public int compareTo(Object o) {
		Konto o1 = (Konto) o;
		if(this.value > o1.getValue()){
			return 1;
		}else if(this.value < o1.getValue()){
			return -1;
		}
		return 0;
	}
	
	public String toString(){
		return value + "";
	}

}
