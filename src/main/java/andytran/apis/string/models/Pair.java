package andytran.apis.string.models;

public class Pair<T, K> {
	
	private T first;
	private K second;
	
	public Pair(T first, K second){
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public K getSecond() {
		return second;
	}

	public void setSecond(K second) {
		this.second = second;
	}

	@Override
	public int hashCode() {
		return first.hashCode() ^ second.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		
		Pair<T, K> pair = (Pair<T, K>)obj;
		if(this.first == null ? pair.first != null : !this.first.equals(pair.first))
			return false;
		if(this.second == null ? pair.second != null : !this.second.equals(pair.second))
			return false;
		
		return true;
	}
	
}
