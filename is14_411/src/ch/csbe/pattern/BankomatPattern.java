package ch.csbe.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankomatPattern {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^E((F)|(K(SO|GB)*A))$");
		String path = "EK";
		Matcher matcher = pattern.matcher(path);
		System.out.println(matcher.find());
		
		pattern = Pattern.compile("^\\w{1,}[.]?\\w{1,}@\\w{1,}.\\w{2,}[.]?$");
		String mail = "tt@mu.ch";
		Matcher match = pattern.matcher(mail);
		System.out.println(match.find());
		

	}

}
