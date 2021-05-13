package andytran.apis.linkedlist.controllers;

import static org.hamcrest.CoreMatchers.is;
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
import andytran.apis.linkedlist.models.ListNode;
import andytran.apis.linkedlist.models.SinglyLinkedList;
import andytran.apis.shared.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = APIsApplication.class)
public class LinkedListControllerITest {

private MockMvc mockMvc;
	
	private static final String BASE_LINKED_LIST_API_URL = "/api/linkedlist";

	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testReverse() throws Exception {
		String[] list = new String[]{"1", "2", "3"};
		List<Integer> reversed = new ArrayList<>();
		reversed.add(3);
		reversed.add(2);
		reversed.add(1);

		SinglyLinkedList reversedLinkedList = new SinglyLinkedList();
		reversedLinkedList.insert(new ListNode(3));
		reversedLinkedList.insert(new ListNode(2));
		reversedLinkedList.insert(new ListNode(1));
		
		mockMvc.perform(get(BASE_LINKED_LIST_API_URL + "/reverse").param("list", list))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(reversed)));
	}

	@Test
	public void testMergeSortedLists() throws Exception {
		String[] l1 = new String[]{"1", "2", "5"};
		String[] l2 = new String[]{"3"};
		List<Integer> mergedList = new ArrayList<>();
		mergedList.add(1);
		mergedList.add(2);
		mergedList.add(3);
		mergedList.add(5);
		
		SinglyLinkedList merged = new SinglyLinkedList();
		merged.insert(new ListNode(1));
		merged.insert(new ListNode(2));
		merged.insert(new ListNode(3));
		merged.insert(new ListNode(5));
		
		mockMvc.perform(get(BASE_LINKED_LIST_API_URL + "/mergesortedlists").param("l1", l1).param("l2", l2))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(mergedList)));
	}

}
