package ch.csbe.fahrni;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ch.csbe.fahrni.data.XMLHandler;
import ch.csbe.fahrni.model.Person;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	public static void main(String[] args) {
		Calendar date = new GregorianCalendar(1983, Calendar.OCTOBER, 29);
		Person p = new Person("Muster","Max",date.getTime(),4444);
		//int i = 0;
		try{
			XMLHandler.save(p, "person");
			//i = i/i;
			Person p1 = XMLHandler.<Person>load("person");
			System.out.println(p1.getName());
			
		}catch(IOException e){
			System.out.println("Datei Fehler");
		}catch (ClassCastException e) {
			System.out.println("Cast Fehler");
		}catch(Exception e){
			System.out.println("Sonstiger Fehler");
		}finally{
			System.out.println("Wird immer ausgeführt auch wann fehler passiert");
		}
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene s = new Scene(FXMLLoader.load(App.class.getResource("view/person.fxml")));
		primaryStage.setScene(s);
		primaryStage.setTitle("Person");
		primaryStage.show();
	}

}
