package andytran.apis.services.number;

import java.util.List;

import andytran.apis.models.Unit;

public interface NumberService {
	String pi(int precision);
	List<Integer> fibonacci(int limit);
	Unit convert(String numStr, String fromType, String toType);
}
