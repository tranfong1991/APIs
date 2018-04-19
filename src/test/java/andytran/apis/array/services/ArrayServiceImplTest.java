package andytran.apis.array.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ArrayServiceImplTest {
	
	@InjectMocks
	private ArrayServiceImpl arrayService;

	@Test
	public void testGetMaxWaterVolume() {		
		int[] heights = new int[]{1,4,2,3,1,3};
		
		assertEquals(12, arrayService.maxWaterVolume(heights));
		assertEquals(0, arrayService.maxWaterVolume(new int[0]));
	}
	
	@Test
	public void testNextPermutation() {
		int[] nums = new int[]{1, 8, 2, 0};
		int[] expected = new int[]{2, 0, 1, 8};
		
		arrayService.nextPermutation(nums);
		for(int i = 0; i < expected.length; i++){
			assertEquals(expected[i], nums[i]);
		}
	}

	@Test
	public void testRotateMatrix() {
		int[][] matrix = new int[][]{
			{1,2},
			{3,4}
		};
		
		int[][] expected = new int[][]{
			{3,1},
			{4,2}
		};
		
		arrayService.rotateMatrix(matrix);
		for(int row = 0; row < expected.length; row++){
			for(int col = 0; col < expected[row].length; col++){
				assertEquals(expected[row][col], matrix[row][col]);
			}
		}
	}
	
	@Test
	public void testMaxSubArray() {
		int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int max = arrayService.maxSubArray(nums);
		assertEquals(6, max);
	}
	
	@Test
	public void testCanJump() {
		int[] nums1 = new int[]{2, 3, 1, 1, 4};
		int[] nums2 = new int[]{3, 2, 1, 0, 4};
		
		assertEquals(true, arrayService.canJump(nums1));
		assertEquals(false, arrayService.canJump(nums2));
	}
	
}
