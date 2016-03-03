package ch.csbe.banking.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * The Account class which contains the username and a
 * sha256 hashed password
 * @author ebuchs
 */
@Entity(name="Account")
public class Account implements Serializable{
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	@Column
	private String password;
	@Id
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="bankfk")
	private Bank bank;

	public Account() {
		super();
	}

	public Account(String username, String password, Bank bank) {
		super();
		this.username = username;
		this.setPassword(password);
		this.setBank(bank);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * This method sets the password and hashed the 
	 * blank param password
	 * @param password the blank password
	 */
	public void setPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			this.password = md.digest().toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		if(this.bank != bank){
			this.bank = bank;
			if(!this.bank.getAccount().contains(this))
				this.bank.getAccount().add(this);
		}
	}
	
	@Override
	public boolean equals(Object o){
		Account a = (Account)o;
		return a.getBank().getName().equals(this.getBank().getName()) &&
				a.getUsername().equals(this.getUsername());
	}
	
	@Override
	public int hashCode(){
		return this.getUsername().hashCode()+this.getBank().getName().hashCode();
	}

}
