package ch.csbe.banking.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Bank class contains the Bank name and 
 * other important information about the Bank accounts
 * {@link Account} and the Kontos which are contains to 
 * this Bank {@link Konto}
 * 
 * @author ebuchs
 */
public class Bank {
	private String name;
	private List<Account> account = new ArrayList<Account>();
	private List<Konto> konten = new ArrayList<Konto>();

	public Bank() {
		super();
	}

	public Bank(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public List<Konto> getKonten() {
		return konten;
	}

	public void setKonten(List<Konto> konten) {
		this.konten = konten;
	}
}
