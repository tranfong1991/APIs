package andytran.apis.services.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import andytran.apis.models.Unit;

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
		assertEquals("3", numberService.convert("011", "binary", "decimal").getNum());
		assertEquals("100", numberService.convert("1100100", "binary", "decimal").getNum());
	}
	
	@Test
	public void testDecimalToBinary(){
		assertEquals("0", numberService.convert("0", "decimal", "binary").getNum());
		assertEquals("1001010110", numberService.convert("598", "decimal", "binary").getNum());
	}
	
	@Test
	public void testCelsiusToFahrenheit(){
		assertEquals("32.0", numberService.convert("0", "celsius", "fahrenheit").getNum());
		assertEquals("132.8", numberService.convert("56", "celsius", "fahrenheit").getNum());
	}
	
	@Test
	public void testFahrenheitToCelsius(){
		assertEquals("0.0", numberService.convert("32", "fahrenheit", "celsius").getNum());
		assertEquals("25.0", numberService.convert("77", "fahrenheit", "celsius").getNum());
	}
	
}
