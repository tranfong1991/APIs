package andytran.apis.linkedlist.services;

import andytran.apis.linkedlist.models.ListNode;

public interface LinkedListService {
	ListNode reverse(ListNode head);
	ListNode mergeSortedLists(ListNode l1, ListNode l2);
}
