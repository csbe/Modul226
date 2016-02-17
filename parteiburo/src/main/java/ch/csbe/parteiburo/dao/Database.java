package ch.csbe.parteiburo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ch.csbe.parteiburo.model.Ort;

public class Database {
	
	private static Configuration cfg = new Configuration()
			.addAnnotatedClass(Ort.class)
		    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
		    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/is14")
		    .setProperty("hibernate.connection.username", "root")
		    .setProperty("hibernate.connection.password", "r00tpw")
		    //.setProperty("hibernate.hbm2ddl.auto", "create") //validate, create, create-drop, update
		    //.setProperty("hibernate.order_updates", "true")
	;
	private static SessionFactory factory = cfg.buildSessionFactory();
	private static Session session;
	
	public static Session getSession(){
		if(session == null){
			session = factory.openSession();
		}
		return session;
	}
	
	public static void close(){
		session.close();
		factory.close();
	}

}
