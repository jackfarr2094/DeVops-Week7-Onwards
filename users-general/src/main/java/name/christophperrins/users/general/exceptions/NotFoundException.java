package name.christophperrins.users.general.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {

	private static final long serialVersionUID = 2855883948921214743L;

	public <S> NotFoundException(Class<S> classNotFound, String errorMessage) {
		super(classNotFound.getSimpleName() + " not found", errorMessage, "The requested item could not be found", new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
