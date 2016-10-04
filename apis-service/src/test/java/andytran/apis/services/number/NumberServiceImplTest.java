package andytran.apis.services.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class NumberServiceImplTest {
	
	@InjectMocks
	private NumberServiceImpl numberService;
	
	@Test
	public void testPi(){
		assertEquals(null, numberService.pi(-1));
		assertEquals("3", numberService.pi(0));
		assertEquals("3.14159", numberService.pi(5));
		assertEquals("3.141592653589793", numberService.pi(15));
		assertEquals("3.141592653589793", numberService.pi(17));
	}
	
	@Test
	public void testFibonacci(){
		List<Integer> series = numberService.fibonacci(10);
		assertThat(series.get(0) == 1);
		assertThat(series.get(1) == 1);
		assertThat(series.get(2) == 2);
		assertThat(series.get(3) == 3);
		assertThat(series.get(4) == 5);
		assertThat(series.get(5) == 8);
	}
	
	@Test
	public void testBinaryToDecimal(){
		assertEquals(new Integer(3), numberService.binaryToDecimal("011"));
		assertEquals(new Integer(10), numberService.binaryToDecimal("1010"));
		assertEquals(new Integer(100), numberService.binaryToDecimal("1100100"));
	}
	
	@Test
	public void testDecimalToBinary(){
		assertEquals("0", numberService.decimalToBinary(0));
		assertEquals("101", numberService.decimalToBinary(5));
		assertEquals("1001010110", numberService.decimalToBinary(598));
	}
	
}
