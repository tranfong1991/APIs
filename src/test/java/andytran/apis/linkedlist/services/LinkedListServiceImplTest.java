package andytran.apis.linkedlist.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import andytran.apis.linkedlist.models.ListNode;
import andytran.apis.linkedlist.models.SinglyLinkedList;

@RunWith(SpringRunner.class)
public class LinkedListServiceImplTest {

	@InjectMocks
	private LinkedListServiceImpl linkedListService;
	
	@Test
	public void testReverse() {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.insert(new ListNode(1));
		linkedList.insert(new ListNode(2));
		linkedList.insert(new ListNode(3));
		linkedList.insert(new ListNode(4));
		linkedList.insert(new ListNode(5));
		
		SinglyLinkedList reversedLinkedList = new SinglyLinkedList();
		reversedLinkedList.insert(new ListNode(5));
		reversedLinkedList.insert(new ListNode(4));
		reversedLinkedList.insert(new ListNode(3));
		reversedLinkedList.insert(new ListNode(2));
		reversedLinkedList.insert(new ListNode(1));
		
		ListNode result = linkedListService.reverse(linkedList.getHead());
		ListNode expected = reversedLinkedList.getHead();
		while(result != null){
			assertEquals(expected.getVal(), result.getVal());
			expected = expected.getNext();
			result = result.getNext();
		}
	}
	
	@Test
	public void testMergeLists(){
		SinglyLinkedList l1 = new SinglyLinkedList();
		l1.insert(new ListNode(1));
		l1.insert(new ListNode(3));
		l1.insert(new ListNode(5));
		l1.insert(new ListNode(6));
		
		SinglyLinkedList l2 = new SinglyLinkedList();
		l2.insert(new ListNode(2));
		l2.insert(new ListNode(4));
		
		SinglyLinkedList merged = new SinglyLinkedList();
		merged.insert(new ListNode(1));
		merged.insert(new ListNode(2));
		merged.insert(new ListNode(3));
		merged.insert(new ListNode(4));
		merged.insert(new ListNode(5));
		merged.insert(new ListNode(6));
		
		ListNode result = linkedListService.mergeSortedLists(l1.getHead(), l2.getHead());
		ListNode expected = merged.getHead();
		while(result != null){
			assertEquals(expected.getVal(), result.getVal());
			expected = expected.getNext();
			result = result.getNext();
		}
	}

}
