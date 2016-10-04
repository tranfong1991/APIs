package andytran.apis.services.number;

import java.util.List;

public interface NumberService {
	String getPi(int precision);
	List<Integer> fibonacci(int limit);
	Integer binaryToDecimal(String binary);
}
