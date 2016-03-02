package ch.csbe.banking.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The Account class which contains the username and a
 * sha256 hashed password
 * @author ebuchs
 */
public class Account {
	private String username;
	private String password;
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

}
