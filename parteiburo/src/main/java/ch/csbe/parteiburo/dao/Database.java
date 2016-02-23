package ch.csbe.parteiburo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ch.csbe.parteiburo.model.Amt;
import ch.csbe.parteiburo.model.Kontakt;
import ch.csbe.parteiburo.model.Mitglied;
import ch.csbe.parteiburo.model.MitgliedAmt;
import ch.csbe.parteiburo.model.Ort;
import ch.csbe.parteiburo.model.OrtSektion;
import ch.csbe.parteiburo.model.ParteiBuro;
import ch.csbe.parteiburo.model.Typ;

public class Database {
	
	private static Configuration cfg = new Configuration()
			.addAnnotatedClass(Ort.class)
			.addAnnotatedClass(ParteiBuro.class)
			.addAnnotatedClass(OrtSektion.class)
			.addAnnotatedClass(Amt.class)
			.addAnnotatedClass(Mitglied.class)
			.addAnnotatedClass(MitgliedAmt.class)
			.addAnnotatedClass(Typ.class)
			.addAnnotatedClass(Kontakt.class)
			.setProperty("hibernate.hbm2ddl.auto", "update")
		    //.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
		    //.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/is14")
		    //.setProperty("hibernate.connection.username", "root")
		    //.setProperty("hibernate.connection.password", "r00tpw")
		    //.setProperty("hibernate.show_sql", "true")
		    //.setProperty("hibernate.hbm2ddl.auto", "create") //validate, create, create-drop, update
		    //.setProperty("hibernate.order_updates", "true")
	;
	private static SessionFactory factory = cfg.buildSessionFactory();
	private static Session session;
	
	public static Session getSession(){
		if(factory == null || factory.isClosed()){
			factory = cfg.buildSessionFactory();
		}
		//
		if(session == null || !session.isConnected() || !session.isOpen()){
			session = factory.openSession();
		}
		return session;
	}
	
	public static void close(){
		session.close();
		//factory.close();
	}

}
