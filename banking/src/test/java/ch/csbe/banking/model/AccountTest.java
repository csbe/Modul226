package ch.csbe.banking.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAccount() {
		Account a = new Account();
		assertNotNull(a);
	}

	@Test
	public void testGetUsername() {
		Account a = new Account("user", "pw", new Bank());
		assertEquals("user", a.getUsername());
	}

	@Test
	public void testSetUsername() {
		Account a = new Account();
		a.setUsername("myuser");
		assertEquals("myuser", a.getUsername());
	}

	@Test
	public void testGetPassword() {
		Account a = new Account("user", "password", new Bank());
		String pw = a.getPassword();
		a.setPassword("newpassword");
		System.out.println(a.getPassword());
		assertNotEquals(pw, a.getPassword());
	}

	@Test
	public void testSetPassword() {
		Account a = new Account("user", "password", new Bank());
		System.out.println(a.getPassword());
		assertNotEquals("password", a.getPassword());
	}

}
