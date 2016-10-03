package andytran.apis.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import andytran.apis.services.string.StringService;
import andytran.apis.utils.TestUtils;

@RunWith(SpringRunner.class)
public class StringControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private StringService stringService;

	@InjectMocks
	private StringController stringController;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(stringController).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testReverse() throws Exception{
		when(stringService.reverse(anyString())).thenReturn("olleh");
		
		mockMvc
			.perform(get("/api/string/reverse/hello"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("olleh")));
	}
	
	@Test
	public void testIsPalindrome() throws Exception{
		when(stringService.isPalindrome(anyString())).thenReturn(false);
		
		mockMvc
			.perform(get("/api/string/palindrome/world"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(false)));
	}
	
	@Test
	public void testPigLatin() throws Exception{
		when(stringService.pigLatin(anyString())).thenReturn("eatway");
		
		mockMvc
			.perform(get("/api/string/piglatin/eat"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("eatway")));
	}
	
}
