package andytran.apis.services.number;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService{

	@Override
	public String getPi(int precision) {
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
	
}
