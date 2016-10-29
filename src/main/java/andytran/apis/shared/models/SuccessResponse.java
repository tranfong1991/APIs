package andytran.apis.shared.models;

public class SuccessResponse<T> implements APIResponse{
	
	private T result;
		
	public SuccessResponse(T result){
		this.result = result;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
}
