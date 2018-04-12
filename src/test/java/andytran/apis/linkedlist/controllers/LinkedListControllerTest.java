package andytran.apis.linkedlist.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
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

import andytran.apis.linkedlist.models.ListNode;
import andytran.apis.linkedlist.models.SinglyLinkedList;
import andytran.apis.linkedlist.services.LinkedListService;
import andytran.apis.shared.utils.TestUtils;

@RunWith(SpringRunner.class)
public class LinkedListControllerTest {

	private static final String BASE_LINKED_LIST_API_URL = "/api/linkedlist";
	
	private MockMvc mockMvc;
	
	@Mock
	private LinkedListService linkedListService;
	
	@InjectMocks
	private LinkedListController controller;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		MockitoAnnotations.initMocks(this);
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
		
		when(linkedListService.reverse(any(ListNode.class))).thenReturn(reversedLinkedList.getHead());
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
		
		when(linkedListService.mergeSortedLists(any(ListNode.class), any(ListNode.class))).thenReturn(merged.getHead());
		mockMvc.perform(get(BASE_LINKED_LIST_API_URL + "/mergesortedlists").param("l1", l1).param("l2", l2))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.result", is(mergedList)));
	}

}
