package andytran.apis.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import andytran.apis.models.ErrorResponse;
import andytran.apis.models.APIResponse;
import andytran.apis.models.SuccessResponse;

public final class ControllerUtils {
	
	private ControllerUtils(){}
	
	public static <T> ResponseEntity<APIResponse> makeSuccessResponseEntity(HttpStatus status, T elem){
		return ResponseEntity
				.status(status)
				.body(new SuccessResponse<>(elem));
	}
	
	public static ResponseEntity<APIResponse> makeErrorResponseEntity(HttpStatus status, String error){
		return ResponseEntity
				.status(status)
				.body(new ErrorResponse(error));
	}
	
}
