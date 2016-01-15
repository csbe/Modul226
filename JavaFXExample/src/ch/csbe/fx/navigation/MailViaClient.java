package ch.csbe.fx.navigation;

import java.io.IOException;

public class MailViaClient {
	public static boolean mail(String textaftermailto){
		Runtime rt = Runtime.getRuntime();
		try {
			if(System.getProperty("os.name").startsWith("Windows")){
				rt.exec("start mailto:"+textaftermailto);				
			}else{
				rt.exec("gnome-open mailto:"+textaftermailto);				
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
