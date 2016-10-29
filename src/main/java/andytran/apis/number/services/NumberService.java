package andytran.apis.number.services;

import java.util.List;

import andytran.apis.number.models.Unit;
import andytran.apis.number.models.UnitType;

public interface NumberService {
	String pi(int precision);
	List<Integer> fibonacci(int limit);
	Unit convert(String numStr, UnitType fromType, UnitType toType);
}
