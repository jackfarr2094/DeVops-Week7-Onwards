package name.christophperrins.users.general.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Hashing {

	public static String hash(String text) {
		return DigestUtils.sha256Hex(text);
	}
}
