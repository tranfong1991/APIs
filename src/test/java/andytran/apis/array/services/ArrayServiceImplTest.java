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
		List<Integer> heights = new ArrayList<>();
		heights.add(1);
		heights.add(4);
		heights.add(2);
		heights.add(3);
		heights.add(1);
		heights.add(3);
		
		assertEquals(12, arrayService.getMaxWaterVolume(heights));
		assertEquals(0, arrayService.getMaxWaterVolume(new ArrayList<>()));
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
	
}
