package andytran.apis.linkedlist.services;

import org.springframework.stereotype.Service;

import andytran.apis.linkedlist.models.ListNode;
import andytran.apis.linkedlist.models.SinglyLinkedList;

@Service
public class LinkedListServiceImpl implements LinkedListService {

	@Override
	public ListNode reverse(ListNode head) {
		if(head == null){
			return null;
		}
		
		ListNode tail = head;
		while(tail.getNext() != null){
			tail = tail.getNext();
		}
		
		reverseRecursive(head);
		return tail;
	}
	
	private void reverseRecursive(ListNode head){
		if(head.getNext() == null){
			return;
		} 
		
		reverse(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
	}
	
	@Override
	public ListNode mergeSortedLists(ListNode l1, ListNode l2){
		SinglyLinkedList linkedList = new SinglyLinkedList();
		
		while(l1 != null || l2 != null){
			int val1 = l1 != null ? l1.getVal() : Integer.MAX_VALUE;
			int val2 = l2 != null ? l2.getVal() : Integer.MAX_VALUE;
			
			if(val1 < val2){
				linkedList.insert(new ListNode(val1));
				l1 = l1.getNext();
			} else {
				linkedList.insert(new ListNode(val2));
				l2 = l2.getNext();
			}
		}
		
		return linkedList.getHead();
	}

}
