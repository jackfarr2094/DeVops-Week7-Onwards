package name.christophperrins.users.general.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException{

	private static final long serialVersionUID = -6448645787037749716L;

	public BadRequestException(String logMessage, String returnedMessage) {
		super("BadRequest", logMessage, returnedMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
}
