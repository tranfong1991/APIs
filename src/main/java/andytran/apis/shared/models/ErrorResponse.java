package andytran.apis.shared.models;

public class ErrorResponse extends APIResponse {
	
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
