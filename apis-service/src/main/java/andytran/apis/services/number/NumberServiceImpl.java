package andytran.apis.services.number;

import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService{

	@Override
	public Integer getSum(int x, int y) {
		return x+y;
	}
	
}
