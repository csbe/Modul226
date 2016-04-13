package ch.csbe.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {

	public static void main(String[] args) {
//		Pattern muster = Pattern.compile("^E(F|K(GB|SO)*A)$");
//		String text = "EKGBGBGBSOSOGBSOGBA";
//		
//		Matcher matcher = muster.matcher(text);
//		
//		if(matcher.find()){
//			System.out.println("Wort gültig");
//		}else{
//			System.out.println("Wort ungültig");
//		}
//		Pattern muster = Pattern.compile("^((\\+|00)[1-9]{2}|0)[1-9]{2}[0-9]{7}$");
//		String text = "+4276490";
//		
//		Matcher matcher = muster.matcher(text);
//		
//		if(matcher.find()){
//			System.out.println("Wort gültig");
//		}else{
//			System.out.println("Wort ungültig");
//		}

		//Pattern muster = Pattern.compile("^\\w+(|[.\\-_]?\\w+)@\\(w{2,}\\.\\w{2,})*\\.?$");
		Pattern muster = Pattern.compile("<script|select|drop");
		String text = "select * from database;";
		
		Matcher matcher = muster.matcher(text);
		
		if(matcher.find()){
			System.out.println("Wort gültig");
		}else{
			System.out.println("Wort ungültig");
		}
		
	}

}
