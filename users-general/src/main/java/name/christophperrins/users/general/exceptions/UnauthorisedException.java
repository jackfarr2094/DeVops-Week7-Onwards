package name.christophperrins.users.general.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class UnauthorisedException extends BaseException {

	private static final long serialVersionUID = 5695492645014772537L;

	public UnauthorisedException(String errorMessage, String logMessage) {
		super("Unauthorised access", errorMessage, logMessage, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}
}
