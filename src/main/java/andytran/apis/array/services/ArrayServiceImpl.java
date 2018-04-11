package andytran.apis.array.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ArrayServiceImpl implements ArrayService {

	@Override
	public int getMaxWaterVolume(List<Integer> heights) {
		if(heights.isEmpty()){
			return 0;
		}
		
		int head = 0;
		int tail = heights.size() - 1;
		int maxVolume = 0;
		
		while(head != tail){
			int n1 = heights.get(head);
			int n2 = heights.get(tail);
			
			maxVolume = Math.max(maxVolume, Math.min(n1, n2) * (tail - head));
			if(n1 < n2){
				head++;
			} else {
				tail--;
			}
		}
		return maxVolume;
	}

}
