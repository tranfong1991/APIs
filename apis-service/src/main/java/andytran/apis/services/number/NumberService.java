package andytran.apis.services.number;

import java.util.List;

public interface NumberService {
	String pi(int precision);
	List<Integer> fibonacci(int limit);
	Integer binaryToDecimal(String binary);
	String decimalToBinary(int decimal);
}
