package andytran.apis.array.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyList;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import andytran.apis.array.services.ArrayService;
import andytran.apis.shared.utils.TestUtils;

@RunWith(SpringRunner.class)
public class ArrayControllerTest {
	
	private static final String BASE_ARRAY_API_URL = "/api/array";

	private MockMvc mockMvc;
	
	@Mock
	private ArrayService arrayService;
	
	@InjectMocks
	private ArrayController arrayController;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(arrayController).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetMaxWaterVolume() throws Exception {
		when(arrayService.getMaxWaterVolume(anyList())).thenReturn(12);
		mockMvc
			.perform(get(BASE_ARRAY_API_URL + "/maxwatervolume").param("heights", new String[]{"1", "4", "2", "3", "1", "3"}))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(12)));	
	}

}
