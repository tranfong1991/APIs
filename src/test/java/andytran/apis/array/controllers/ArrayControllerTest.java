package andytran.apis.array.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
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
	
	@Test
	public void testNextPermutation() throws Exception {
		String[] nums = new String[]{"2", "0", "1", "3"};
		List<Integer> expected = new ArrayList<>();
		expected.add(2);
		expected.add(0);
		expected.add(1);
		expected.add(3);
		
		doNothing().when(arrayService).nextPermutation(any(int[].class));
		mockMvc
			.perform(get(BASE_ARRAY_API_URL + "/nextpermutation").param("nums", nums))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(expected)));
	}
	
	@Test
	public void testRotateMatrix() throws Exception {
		String[] matrix = new String[]{"1","2","3","4"};
		
		List<Integer> row1 = new ArrayList<>();
		row1.add(1);
		row1.add(2);
		
		List<Integer> row2 = new ArrayList<>();
		row2.add(3);
		row2.add(4);
		
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(row1);
		expected.add(row2);
		
		doNothing().when(arrayService).rotateMatrix(any(int[][].class));
		mockMvc
			.perform(get(BASE_ARRAY_API_URL + "/rotatematrix/2").param("matrix", matrix))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(expected)));
	}
	
}
