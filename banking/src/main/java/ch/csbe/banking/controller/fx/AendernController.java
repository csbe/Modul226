package ch.csbe.banking.controller.fx;

import ch.csbe.banking.dao.KarteDao;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class AendernController extends WelcomeController {
	@FXML
	private PasswordField pin;

	public void save(){
		KarteDao kd = new KarteDao();
		karte.setPin(pin.getText());
		kd.save(karte);
	}
	
	@FXML
	public void initialize() {
		super.initialize();
	}
}
