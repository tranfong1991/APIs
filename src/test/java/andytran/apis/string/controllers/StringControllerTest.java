package andytran.apis.string.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import andytran.apis.shared.utils.TestUtils;
import andytran.apis.string.services.StringService;

@RunWith(SpringRunner.class)
public class StringControllerTest {
	
	private final static String BASE_STRING_API_URL = "/api/string";
	
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
			.perform(get(BASE_STRING_API_URL + "/reverse/hello"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("olleh")));
	}
	
	@Test
	public void testIsPalindrome() throws Exception{
		when(stringService.isPalindrome(anyString())).thenReturn(false);
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/palindrome/world"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(false)));
	}
	
	@Test
	public void testPigLatin() throws Exception{
		when(stringService.pigLatin(anyString())).thenReturn("eatway");
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/piglatin/eat"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("eatway")));
	}
	
	@Test
	public void testLongestNonRepeatingSubstring() throws Exception{
		when(stringService.longestNonRepeatingSubstring(anyString())).thenReturn("abc");
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/lnrs/abcabbbc"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("abc")));
	}
	
	@Test
	public void testUnscramble() throws Exception{
		List<String> dummy = new ArrayList<>();
		dummy.add("question");
		
		when(stringService.unscramble(anyString())).thenReturn(dummy);
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/unscramble/qwertyuytresdftyuioknn"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result[0]", is(dummy.get(0))));
		
	}
	
	@Test
	public void testDankify() throws Exception{
		List<String> dummy = new ArrayList<>();
		dummy.add("donut");
		
		when(stringService.dankify(anyString())).thenReturn(dummy);
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/dankify/donaldkruth"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result[0]", is(dummy.get(0))));
	}
	
	@Test
	public void testLongestPalindrome() throws Exception{
		when(stringService.longestPalindrome(anyString())).thenReturn("elle");
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/longestpalindrome/hellen"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("elle")));
	}
	
	@Test
	public void testIsValidParentheses() throws Exception{
		when(stringService.isValidParentheses(anyString())).thenReturn(false);
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/isvalidparenthesis/(()[)"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(false)));
	}
	
}
