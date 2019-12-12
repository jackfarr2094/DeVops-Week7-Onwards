package name.christophperrins.users.general.utils;

public class FormatCheck {
	
	public static boolean isAlphaNumeric(String text) {
		return text.matches("[0-9a-zA-Z]+");
	}
}
