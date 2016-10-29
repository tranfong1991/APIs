package andytran.apis.string.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
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
import andytran.apis.shared.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = APIsApplication.class)
public class StringControllerITest {
	
	private final static String BASE_STRING_API_URL = "/api/string";

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testReverseHappyPath() throws Exception{
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/reverse/hello"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("olleh")));
	}
	
	@Test
	public void testIsPalindromeHappyPath() throws Exception{
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/palindrome/racecar"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(true)));
	}
	
	@Test
	public void testPigLatinHappyPath() throws Exception{
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/piglatin/eat"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("eatway")));
	}
	
	@Test
	public void testLongestNonRepeatingSubstringHappyPath() throws Exception{		
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/lnrs/abcabbbc"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("abc")));
	}
	
	@Test
	public void testUnscrambleHappyPath() throws Exception{	
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/unscramble/qwertyuytresdftyuioknn"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", Matchers.containsInAnyOrder("quin", "queen", "question")));
	}
	
	@Test
	public void testDankifyHappyPath() throws Exception{
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/dankify/donaldkruth"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", Matchers.contains("donut")));
	}
	
	@Test
	public void testLongestPalindromeHappyPath() throws Exception{
		mockMvc
			.perform(get(BASE_STRING_API_URL + "/longestpalindrome/hellen"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is("elle")));
	}
	
}