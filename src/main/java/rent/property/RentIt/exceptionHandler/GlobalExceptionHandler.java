package rent.property.RentIt.exceptionHandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import rent.property.RentIt.error.ErrorResponse;
import rent.property.RentIt.exception.DuplicateOwnerException;
import rent.property.RentIt.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex){
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("User does not exists", details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = DuplicateOwnerException.class)
	public ResponseEntity<Object> handleDuplicateOwnerException(DuplicateOwnerException ex){
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("One property cannot have two owners", details);
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
}
