package ch.csbe.algorithm.sort.quick;

public class Person implements SortType{

	private String name;
	private String vorname;
	
	public Person(String name, String vorname){
		this.name = name;
		this.vorname = vorname;
	}
	
	
	
	public String getName() {
		return name;
	}



	public String getVorname() {
		return vorname;
	}



	@Override
	public int compareTo(Object o) {
		Person p = (Person) o;
		if(name.length()+vorname.length() > p.getName().length()+p.getVorname().length()){
			return 1;
		}else if(name.length()+vorname.length() < p.getName().length()+p.getVorname().length()){
			return -1;
		}
		return 0;
	}
	
	public String toString(){
		return name+vorname;
	}

}
