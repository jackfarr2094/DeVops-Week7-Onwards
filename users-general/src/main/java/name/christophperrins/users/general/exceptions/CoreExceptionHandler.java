package name.christophperrins.users.general.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CoreExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<Object> handleException(BaseException ex, WebRequest request){
		System.out.println(ex.getBody().toString());
		return handleExceptionInternal(ex, ex.getBody(), ex.getHttpHeaders(), ex.getHttpStatus(), request);
	}
	
}
