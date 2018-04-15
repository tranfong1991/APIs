package andytran.apis.array.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
public class ArrayControllerITest {
	
	private static final String BASE_ARRAY_API_URL = "/api/array";

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testGetMaxWaterVolume() throws Exception {
		mockMvc
			.perform(get(BASE_ARRAY_API_URL + "/maxwatervolume").param("heights", new String[]{"1", "4", "2", "3", "1", "3"}))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(12)));	
	}
	
	@Test
	public void testNextPermutation() throws Exception {
		String[] nums = new String[]{"1", "3", "2", "0"};
		List<Integer> expected = new ArrayList<>();
		expected.add(2);
		expected.add(0);
		expected.add(1);
		expected.add(3);
		
		mockMvc
			.perform(get(BASE_ARRAY_API_URL + "/nextpermutation").param("nums", nums))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(expected)));
	}

}
