package ch.csbe.fahrni.data;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
/**
 * A simple XML Helper class
 * it can serialize and deserialize objects into and from a xml
 * @author ebuchs
 * @version 1.0
 */
public class XMLHandler {

	/**
	 * Save method save a serializable object under the
	 * user home in the Schreibtisch folder
	 * as a file with filename and the xml extension
	 * @param s is a serializable object
	 * @param filename just the filename
	 * @throws IOException when cant save or other ioexceptions its thrown
	 */
	public static void save(Serializable s, String filename) throws IOException{
		String userhome = System.getProperty("user.home");
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
					new FileOutputStream(new File(userhome + 
							File.separator + "Schreibtisch"+
							File.separator+filename+".xml"))
				));
		encoder.writeObject(s);
		encoder.close();
	}
	
	/**
	 * Save method save a serializable object in a file
	 * @param s is a serializable object
	 * @param file the file which should contain the serializable object
	 * @throws IOException when cant save or other ioexceptions its thrown
	 */
	public static void save(Serializable s, File file) throws IOException{
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
					new FileOutputStream(file)
				));
		encoder.writeObject(s);
		encoder.close();
	}
	
	/**
	 * Deserialize a XML file the file must be place under
	 * the user home in a directory called Schreibtisch
	 * Example: XMLLoader.load('filename'); XMLLoader.<Type>load('filename');
	 * @param filename the filename which should be deserialize
	 * @return the concrete object
	 * @throws IOException when the file cant loaded then throwns
	 * @throws ClassCastException when the object cant casted in the wished type then thrown
	 */
	public static <T> T load(String filename) throws IOException, ClassCastException{
		String userhome = System.getProperty("user.home");
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(
					new FileInputStream(new File(userhome + 
							File.separator + "Schreibtisch"+
							File.separator+filename+".xml"))
				));
		@SuppressWarnings("unchecked")
		T s = (T) decoder.readObject();
		decoder.close();
		return s;
	}
	
	/**
	 * Deserialize a XML file 
	 * Example: XMLLoader.load(file); XMLLoader.<Type>load(file);
	 * @param file File the file which should be deserialize
	 * @return the concrete object
	 * @throws IOException when the file cant loaded then throwns
	 * @throws ClassCastException when the object cant casted in the wished type then thrown
	 */
	public static <T> T load(File file) throws IOException, ClassCastException{
		
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(
					new FileInputStream(file)
				));
		@SuppressWarnings("unchecked")
		T s = (T) decoder.readObject();
		decoder.close();
		return s;
	}
	
}
