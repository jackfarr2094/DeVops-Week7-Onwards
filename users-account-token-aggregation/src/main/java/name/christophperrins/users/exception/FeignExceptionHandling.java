package name.christophperrins.users.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.FeignException;
import name.christophperrins.users.general.exceptions.ForbiddenException;
import name.christophperrins.users.general.exceptions.NotFoundException;
import name.christophperrins.users.general.exceptions.UnauthorisedException;

@ControllerAdvice
public class FeignExceptionHandling {

	@ExceptionHandler(FeignException.class)
	public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
		if(e.status()==HttpStatus.UNAUTHORIZED.value()) {
			throw new UnauthorisedException("Unauthorised feign error", e.getMessage());
		} else if(e.status() == HttpStatus.FORBIDDEN.value()) {
			throw new ForbiddenException("Forbidden feign error", e.getMessage());
		} else if(e.status() == HttpStatus.NOT_FOUND.value()) {
			throw new NotFoundException(Object.class, e.getMessage());
		}
		return "feign error";
		
	}
}
