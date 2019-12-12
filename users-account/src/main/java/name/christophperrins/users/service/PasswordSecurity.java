package name.christophperrins.users.service;

import name.christophperrins.users.general.utils.Hashing;

public class PasswordSecurity {
	
	public static String securePassword(String password) {
		return applySalt(10, password);
	}
	
	public static boolean checkPassword(String password, Long hashPassword) {
		return securePassword(password).equals(hashPassword);
	}
	
	private static String addSalt(String text) {
		String saltText = "$~#}/%*!£&^+-=(>@)<?";
		StringBuilder saltedText = new StringBuilder(text.length()*2);
		for(int i = 0; i < text.length(); i++ ) {
			int saltPosition = i%20;
			saltedText.append(text.substring(i, i+1));
			saltedText.append(saltText.substring(saltPosition, saltPosition+1));
		}
		return saltedText.toString();
	}
	
	private static String applySalt(int number, String text) {
		for(int i = 0; i < number; i++) {
			text = Hashing.hash(addSalt(text));
		}
		return text;
	}

}
