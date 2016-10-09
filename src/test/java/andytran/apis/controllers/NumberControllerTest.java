package andytran.apis.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.LessThan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import andytran.apis.models.Binary;
import andytran.apis.models.Unit;
import andytran.apis.models.UnitType;
import andytran.apis.services.number.NumberService;
import andytran.apis.utils.TestUtils;

@RunWith(SpringRunner.class)
public class NumberControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private NumberService numberService;
	
	@InjectMocks
	private NumberController numberController;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(numberController).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetPi() throws Exception{
		when(numberService.pi(anyInt())).thenReturn("3.14159");
		mockMvc
			.perform(get("/api/number/pi"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("3.14159")));
	}
	
	@Test
	public void testGetFibonacci() throws Exception{
		List<Integer> dummy = new ArrayList<>();
		dummy.add(1);
		dummy.add(1);
		
		when(numberService.fibonacci(anyInt())).thenReturn(dummy);
		mockMvc
			.perform(get("/api/number/fibonacci"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result[0]", is(1)))
			.andExpect(jsonPath("$.result[1]", is(1)));
	}
	
	@Test
	public void testConvert() throws Exception{
		Unit result = new Binary("1100");
		
		when(numberService.convert(anyString(), any(UnitType.class), any(UnitType.class))).thenReturn(result);
		mockMvc
			.perform(get("/api/number/convert/12?from=DECIMAL&to=BINARY"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result.abbr", is(result.getAbbr())))
			.andExpect(jsonPath("$.result.numStr", is(result.getNumStr())));
	}
	
}
