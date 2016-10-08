package andytran.apis.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import andytran.apis.models.Response;

public final class ControllerUtils {
	
	private ControllerUtils(){}
	
	public static <T> ResponseEntity<Response<T>> makeResponseEntity(HttpStatus status, T elem){
		return ResponseEntity
				.status(status)
				.body(makeResponse(elem));
	}
	
	public static <T> Response<T> makeResponse(T elem){
		return new Response<>(elem);
	}
	
}
