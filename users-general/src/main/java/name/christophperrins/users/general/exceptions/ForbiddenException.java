package name.christophperrins.users.general.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends BaseException{

	private static final long serialVersionUID = -6732928411068785685L;

	public ForbiddenException(String logMessage, String returnedMessage) {
		super("ForbiddenException", logMessage, returnedMessage, new HttpHeaders(), HttpStatus.FORBIDDEN);
	}
}
