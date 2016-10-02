package andytran.apis.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import andytran.apis.models.Response;

public class ControllerUtils {
	
	public static <T> ResponseEntity<Response<T>> makeResponseEntity(HttpStatus status, T elem){
		return ResponseEntity
				.status(status)
				.body(makeResponse(elem));
	}
	
	public static <T> Response<T> makeResponse(T elem){
		return new Response<T>(elem);
	}
	
}
