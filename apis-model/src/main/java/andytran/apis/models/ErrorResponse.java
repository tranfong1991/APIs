package andytran.apis.models;

public class ErrorResponse implements APIResponse {
	
	private String error;
	
	public ErrorResponse(String error){
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
