package name.christophperrins.users.general.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class OtherException extends BaseException{

	private static final long serialVersionUID = -6924566431478846661L;

	public OtherException(String logMessage, Exception e) {
		super("IOException", logMessage, "Error between services has occured", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		e.printStackTrace();
	}

	
}
