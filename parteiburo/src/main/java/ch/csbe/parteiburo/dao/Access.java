package ch.csbe.parteiburo.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;

import org.hibernate.Query;

public class Access<T> {

	final Class<T> type;

	public Access(Class<T> type) {
		this.type = type;
	}

	public int save(T object) {
		int id = ((Integer) Database.getSession().save(object)).intValue();
		Database.getSession().flush();
		return id;
	}

	public void update(T object) {
		Database.getSession().update(object);
		Database.getSession().flush();
	}

	public T getById(int id) {
		return (T) Database.getSession().get(type, id);
	}

	/**
	 * a simple search method
	 * 
	 * @param where
	 *            in format {"name=:name","and","vorname like :vorname"}
	 * @param data
	 *            a string array with the data when work with like place the %
	 *            sign where you use
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> search(String[] where, String[] data) {
		String hql = "from " + type.getSimpleName();
		if (where.length > 0) {
			hql += " where ";
			for (String w : where)
				hql += w + " ";
		}
		System.out.println(hql);
		Query q = Database.getSession().createQuery(hql);
		int i = 0;
		for (String d : data) {
			Matcher m = Pattern.compile(":[a-zA-Z]*").matcher(where[i]);
			if (m.find()) {
				System.out.println(m.group().replace(":", ""));
				q.setParameter(m.group().replace(":", ""), d);
			}

			i += 2;
		}
		return (List<T>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query q = Database.getSession().createQuery("from " + type.getSimpleName());
		return (List<T>) q.list();
	}

	public void delete(T object) {
		Database.getSession().delete(object);
		Database.getSession().flush();
	}

	/*
	 * Example with named queries from Class
	 */
	@SuppressWarnings("unchecked")
	public List<T> getList() {
		Query q = Database.getSession().getNamedQuery("all");
		return (List<T>) q.list();
	}

	public int lastInsertedId() {
		return ((BigInteger) Database.getSession().createSQLQuery("select last_insert_id()").uniqueResult()).intValue();
	}

	public int maxId() {
		// System.out.println(type.getAnnotation(Entity.class).name());
		return ((Integer) Database.getSession()
				.createSQLQuery("select max(id) from " + type.getAnnotation(Entity.class).name()).uniqueResult())
						.intValue();
	}

}
