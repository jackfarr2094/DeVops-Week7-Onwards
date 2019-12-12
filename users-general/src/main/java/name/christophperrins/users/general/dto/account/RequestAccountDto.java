package name.christophperrins.users.general.dto.account;

import name.christophperrins.users.general.exceptions.BadRequestException;
import name.christophperrins.users.general.utils.FormatCheck;
import name.christophperrins.users.general.utils.Hashing;

public class RequestAccountDto {

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if(FormatCheck.isAlphaNumeric(username)) {
			this.username = username;			
		} else {
			throw new BadRequestException("user entered "+username, "Username must be Alphanumeric");
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = Hashing.hash(password);
	}
	
	
}
