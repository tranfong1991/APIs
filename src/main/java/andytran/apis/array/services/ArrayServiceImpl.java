package andytran.apis.array.services;

import java.util.Arrays;
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

	@Override
	public void nextPermutation(int[] nums) {
		int replacableIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(i + 1 < nums.length){
                if(nums[i] < nums[i+1]){
                    replacableIndex = i;
                }
            }
        }
        
        if(replacableIndex < 0){
            Arrays.sort(nums);
            return;
        }
        
        for(int i = nums.length - 1; i > replacableIndex; i--){
            if(nums[i] > nums[replacableIndex]){
                int temp = nums[replacableIndex];
                nums[replacableIndex] = nums[i];
                nums[i] = temp;
                
                Arrays.sort(nums, replacableIndex + 1, nums.length);
                return;
            }
        }
	}

}
