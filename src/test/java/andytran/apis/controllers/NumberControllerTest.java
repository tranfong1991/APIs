package andytran.apis.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	public void testGetPiHappyPath() throws Exception{
		when(numberService.getPi(anyInt())).thenReturn("3.14159");
		
		mockMvc
			.perform(get("/api/number/pi"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("3.14159")));
	}
	
	@Test
	public void testGetPiSadPath() throws Exception{
		when(numberService.getPi(anyInt())).thenReturn(null);
		
		mockMvc
			.perform(get("/api/number/pi?precision=-1"))
			.andExpect(status().isBadRequest())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is((String)null)));
	}
}
