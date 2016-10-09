package andytran.apis.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import andytran.apis.APIsApplication;
import andytran.apis.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = APIsApplication.class)
public class NumberControllerITest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testGetPiHappyPath() throws Exception{		
		mockMvc
			.perform(get("/api/number/pi?precision=5"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("3.14159")));
	}
	
	@Test
	public void testGetPiSadPath() throws Exception{		
		mockMvc
			.perform(get("/api/number/pi?precision=-1"))
			.andExpect(status().isBadRequest())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8));
	}
	
	@Test
	public void testGetFibonacciHappyPath() throws Exception{
		mockMvc
			.perform(get("/api/number/fibonacci?limit=5"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result[0]", is(1)))
			.andExpect(jsonPath("$.result[1]", is(1)))
			.andExpect(jsonPath("$.result[2]", is(2)))
			.andExpect(jsonPath("$.result[3]", is(3)))
			.andExpect(jsonPath("$.result[4]", is(5)));
	}
	
	@Test
	public void testGetFibonacciSadPath() throws Exception{
		mockMvc
			.perform(get("/api/number/fibonacci?limit=0"))
			.andExpect(status().isBadRequest())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8));
	}
	
	@Test
	public void testConvertHappyPath() throws Exception{
		mockMvc
			.perform(get("/api/number/convert/12?from=DECIMAL&to=BINARY"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result.abbr", is("bin")))
			.andExpect(jsonPath("$.result.numStr", is("1100")));
	}
	
	@Test
	public void testConvertSadPath() throws Exception{
		mockMvc
			.perform(get("/api/number/convert/12?from=DECIMAL&to=POUND"))
			.andExpect(status().isBadRequest())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8));
	}
	
}
