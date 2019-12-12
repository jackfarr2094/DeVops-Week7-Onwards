package name.christophperrins.users.general.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class FormattingException extends BaseException{

	private static final long serialVersionUID = -1171631873287726544L;

	public FormattingException(String logMessage, String responseText) {
		super("Formatting Error", logMessage, responseText, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}
