package andytran.apis.services.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import andytran.apis.models.Unit;
import andytran.apis.models.UnitType;

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
		assertEquals("3", numberService.convert("011", UnitType.BINARY, UnitType.DECIMAL).getNum());
		assertEquals("100", numberService.convert("1100100",  UnitType.BINARY, UnitType.DECIMAL).getNum());
	}
	
	@Test
	public void testDecimalToBinary(){
		assertEquals("0", numberService.convert("0", UnitType.DECIMAL,  UnitType.BINARY).getNum());
		assertEquals("1001010110", numberService.convert("598", UnitType.DECIMAL,  UnitType.BINARY).getNum());
	}
	
	@Test
	public void testCelsiusToFahrenheit(){
		assertEquals("32.0", numberService.convert("0", UnitType.CELSIUS, UnitType.FAHRENHEIT).getNum());
		assertEquals("132.8", numberService.convert("56", UnitType.CELSIUS, UnitType.FAHRENHEIT).getNum());
	}
	
	@Test
	public void testCelsiusToKelvin(){
		assertEquals("273.15", numberService.convert("0", UnitType.CELSIUS, UnitType.KELVIN).getNum());
		assertEquals("329.15", numberService.convert("56", UnitType.CELSIUS, UnitType.KELVIN).getNum());
	}
	
	@Test
	public void testFahrenheitToCelsius(){
		assertEquals("0.0", numberService.convert("32", UnitType.FAHRENHEIT, UnitType.CELSIUS).getNum());
		assertEquals("25.0", numberService.convert("77", UnitType.FAHRENHEIT, UnitType.CELSIUS).getNum());
	}
	
	@Test
	public void testFahrenheitToKelvin(){
		assertEquals("273.15", numberService.convert("32", UnitType.FAHRENHEIT, UnitType.KELVIN).getNum());
		assertEquals("268.15", numberService.convert("23", UnitType.FAHRENHEIT, UnitType.KELVIN).getNum());
	}
	
	@Test
	public void testKelvinToCelsius(){
		assertEquals("0.0", numberService.convert("273.15", UnitType.KELVIN, UnitType.CELSIUS).getNum());
		assertEquals("56.0", numberService.convert("329.15", UnitType.KELVIN, UnitType.CELSIUS).getNum());
	}
	
	@Test
	public void testKelvinToFahrenheit(){
		assertEquals("31.9", numberService.convert("273.15", UnitType.KELVIN, UnitType.FAHRENHEIT).getNum().substring(0, 4));
		assertEquals("22.9", numberService.convert("268.15", UnitType.KELVIN, UnitType.FAHRENHEIT).getNum().substring(0, 4));
	}
	
}
