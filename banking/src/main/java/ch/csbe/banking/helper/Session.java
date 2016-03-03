package ch.csbe.banking.helper;

import java.util.HashMap;
import java.util.Map;

public class Session {
	
	private static Session instance;
	private Map<String, Object> elements = new HashMap<String, Object>();
	
	public static Session getInstance(){
		if(instance == null){
			instance = new Session();
		}
		return instance;
	}
	
	public Map<String, Object> getMap(){
		return elements;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key){
		return (T) elements.get(key);
	}
	
	
	private Session(){
		
	}
	
}
