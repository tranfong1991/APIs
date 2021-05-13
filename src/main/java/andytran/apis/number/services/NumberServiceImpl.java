package andytran.apis.number.services;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import andytran.apis.number.models.Unit;
import andytran.apis.number.models.UnitFactory;
import andytran.apis.number.models.UnitType;

@Service
public class NumberServiceImpl implements NumberService{

	@Override
	public String pi(int precision) {
		if(precision < 0)
			return null;
		if(precision > 15)
			precision = 15;
		
		BigDecimal pi = new BigDecimal("0.0");
		BigDecimal oneSixteenth = new BigDecimal("0.0625");
		BigDecimal one = new BigDecimal("1");
		BigDecimal two = new BigDecimal("2");
		BigDecimal four = new BigDecimal("4");
		BigDecimal five = new BigDecimal("5");
		BigDecimal six = new BigDecimal("6");
		BigDecimal eight = new BigDecimal("8");
		
		MathContext mc = new MathContext(1000);
		for(int k = 0; k <= precision; k++){
			BigDecimal term = oneSixteenth.pow(k);
			BigDecimal first = four.divide(eight.multiply(BigDecimal.valueOf(k)).add(one), mc);
			BigDecimal second = two.divide(eight.multiply(BigDecimal.valueOf(k)).add(four), mc);
			BigDecimal third = one.divide(eight.multiply(BigDecimal.valueOf(k)).add(five), mc);
			BigDecimal forth = one.divide(eight.multiply(BigDecimal.valueOf(k)).add(six), mc);
			
			pi = pi.add(term.multiply(first.subtract(second).subtract(third).subtract(forth)));
		}
		
		StringBuilder pattern = new StringBuilder();
		pattern.append("0");
		if(precision > 0){
			pattern.append(".");
			for(int i = 0; i<precision; i++){
				pattern.append("0");
			}
		}
		
		NumberFormat formatter = new DecimalFormat(pattern.toString());		
		return formatter.format(pi.doubleValue());
	}

	@Override
	public List<Integer> fibonacci(int limit) {
		if(limit <= 0)
			return new ArrayList<>();
		
		List<Integer> series = new ArrayList<>();
		series.add(1);
		series.add(1);
		
		while(series.get(series.size() - 1) < limit){
			int currentSize = series.size();
			int nextNum = series.get(currentSize - 1) + series.get(currentSize - 2);
			
			if(nextNum > limit)
				break;
			series.add(nextNum);
		}
		
		return series;
	}

	@Override
	public Unit convert(String numStr, UnitType fromType, UnitType toType) {
		Unit fromUnit = UnitFactory.makeUnitInstance(fromType);
		fromUnit.setNumStr(numStr);
		
		return fromUnit.convertTo(toType);
	}

}
