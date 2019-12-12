package name.christophperrins.users.general.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException{

	private static final long serialVersionUID = 5511773089950877237L;

	private String typeOfError;
	private String logMessage;
	private Object body;
	private HttpHeaders httpHeaders;
	private HttpStatus httpStatus;
	
	public BaseException (String typeOfError, String logMessage, Object body, HttpHeaders httpHeaders, HttpStatus httpStatus) {
		this.typeOfError = typeOfError;
		this.logMessage = logMessage;
		this.body = body;
		this.httpHeaders = httpHeaders;
		this.httpStatus = httpStatus;
	}

	final String logMessage() {
		return typeOfError +": " + logMessage;
	}
	
	Object getBody() {
		return body;
	}
	
	HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}
	
	HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
