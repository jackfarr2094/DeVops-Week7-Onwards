package name.christophperrins.users.general.dto.token;

import java.util.Date;

public class AuthTokenDto {

	private String bearerToken;
	private String expireDate;
	private String username;

	public String getBearerToken() {
		return bearerToken;
	}

	public void setBearerToken(String bearerToken) {
		this.bearerToken = bearerToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getExpireDate() {
		return expireDate;
	}
	
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public void setExpireDate(Date expireDate) {
		if (expireDate != null) {
			this.expireDate = expireDate.toString();			
		}
	}
	
	
	
	
}
