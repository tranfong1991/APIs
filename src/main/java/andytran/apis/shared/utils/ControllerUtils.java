package andytran.apis.shared.utils;

import andytran.apis.shared.models.APIResponse;
import andytran.apis.shared.models.ErrorResponse;
import andytran.apis.shared.models.SuccessResponse;

public final class ControllerUtils {
	
	private ControllerUtils(){}
	
	public static <T> APIResponse makeSuccessResponse(T elem){
		return new SuccessResponse<>(elem);
	}
	
	public static APIResponse makeErrorResponse(String error){
		return new ErrorResponse(error);
	}
	
}
