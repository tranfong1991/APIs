package andytran.apis.services.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class NumberServiceImplTest {
	
	@InjectMocks
	private NumberServiceImpl numberService;
	
	@Test
	public void testGetPi(){
		assertEquals(null, numberService.getPi(-1));
		assertEquals("3", numberService.getPi(0));
		assertEquals("3.14159", numberService.getPi(5));
		assertEquals("3.141592653589793", numberService.getPi(15));
		assertEquals("3.141592653589793", numberService.getPi(17));
	}
}
