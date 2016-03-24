package ch.csbe.banking.controller.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ch.csbe.banking.dao.KarteDao;
import ch.csbe.banking.helper.Session;
import ch.csbe.banking.model.Karte;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nummer,pin;
	private boolean fail = false;
	private Karte karte;
	
	public String login(){
		KarteDao kd = new KarteDao();
		karte = kd.auth(nummer, pin);
		if(karte!=null){
			//Session.getInstance().getMap().put("karte", karte);
			fail = false;
			return "welcome";
		}
		fail = true;
		return "index";
	}

	public boolean getFail(){
		return fail;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Karte getKarte() {
		return karte;
	}
	
}
