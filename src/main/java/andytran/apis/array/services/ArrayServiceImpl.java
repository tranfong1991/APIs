package andytran.apis.array.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ArrayServiceImpl implements ArrayService {

	@Override
	public int maxWaterVolume(int[] heights) {
		if(heights.length == 0){
			return 0;
		}
		
		int head = 0;
		int tail = heights.length - 1;
		int maxVolume = 0;
		
		while(head != tail){
			int n1 = heights[head];
			int n2 = heights[tail];
			
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
	
	@Override
	public void rotateMatrix(int[][] matrix){
		int n = matrix.length;
        double layers = Math.ceil(n / 2.0);
        
        for(int layer = 0; layer < layers; layer++){
            int[] save = new int[n - layer - 1];
            
            //top
            for(int col = layer; col < n - layer - 1; col++){
                save[col] = matrix[layer][col];
                matrix[layer][col] = matrix[n - col - 1][layer];
            }
            
            //right
            for(int row = layer; row < n - layer - 1; row++){
                int temp = matrix[row][n - layer - 1];
                matrix[row][n - layer - 1] = save[row];
                save[row] = temp;
            }
            
            //bottom
            for(int col = n - layer - 1; col > layer; col--){
                int temp = matrix[n - layer - 1][col];
                matrix[n - layer - 1][col] = save[n - col - 1];
                save[n - col - 1] = temp;
            }
            
            //left
            for(int row = n - layer - 1; row > layer; row--){
                matrix[row][layer] = save[n - row - 1];
            }
        }
	}
	
	@Override
	//Kadane's Algorithm
	public int maxSubArray(int[] nums){
		int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum = Math.max(nums[i], nums[i] + sum);
            max = Math.max(sum, max);
        }
        
        return max;
	}
	
	@Override
	public boolean canJump(int[] nums){
		int minSteps = 1;
		int lastIndex = nums.length - 1;
		
		for(int i = lastIndex - 1; i >= 0; i--){
			if(nums[i] >= minSteps){
				minSteps = 1;
			} else {
				minSteps++;
			}
		}
		
		return minSteps == 1;
	}

}
