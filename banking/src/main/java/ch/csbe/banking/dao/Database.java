package ch.csbe.banking.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ch.csbe.banking.model.Account;
import ch.csbe.banking.model.Bank;
import ch.csbe.banking.model.Buchung;
import ch.csbe.banking.model.Karte;
import ch.csbe.banking.model.Konto;
import ch.csbe.banking.model.Kunde;

public class Database {
	
	private static Database instance;
	private Configuration config;
	private SessionFactory factory;
	private Session session;
	
	public static Database getInstance(){
		if(instance == null){
			instance = new Database();
		}
		return instance;
	}
	
	private Database(){
		config = new Configuration()
				.addAnnotatedClass(Karte.class)
				.addAnnotatedClass(Kunde.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(Bank.class)
				.addAnnotatedClass(Konto.class)
				.addAnnotatedClass(Buchung.class);
		factory = config.buildSessionFactory();
	}
	
	public Session getSession(){
		if(session == null || !session.isOpen()){
			session = factory.openSession();
		}
		return session;
	}
	
	public void closeSession(){
		if(session.isOpen())
			session.close();
	}
	
	public void closeConnection(){
		closeSession();
		factory.close();
	}

}
