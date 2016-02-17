package ch.csbe.parteiburo.dao;

import java.util.List;

import org.hibernate.Query;

public class Access<T> {
	
	final Class<T> type;
	
	public Access(Class<T> type){
		this.type = type;
	}
	

	public void save(T object){
		Database.getSession().save(object);
	}
	
	public T getById(int id){
		return (T) Database.getSession().get(type, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(){
		Query q = Database.getSession().createQuery("from " + type.getSimpleName());
		return (List<T>)q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getList(){
		Query q = Database.getSession().getNamedQuery("all");
		return (List<T>)q.list();
	}
	
}
