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

}
