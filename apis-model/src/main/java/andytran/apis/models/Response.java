package andytran.apis.models;

public class Response<T> {
	
	private T result;
	
	public Response(){}
	
	public Response(T result){
		this.result = result;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
}
