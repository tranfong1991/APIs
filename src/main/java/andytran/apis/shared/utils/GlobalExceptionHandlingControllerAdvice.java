package andytran.apis.shared.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import andytran.apis.shared.exceptions.BadRequestException;
import andytran.apis.shared.models.APIResponse;

@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<APIResponse> handleBadRequest(){
		return ResponseEntity
				.badRequest()
				.body(ControllerUtils.makeErrorResponse("Bad Request"));
	}
	
}
