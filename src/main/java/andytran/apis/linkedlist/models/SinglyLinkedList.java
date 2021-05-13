package andytran.apis.linkedlist.models;

public class SinglyLinkedList {
	private ListNode head;
	private ListNode current;
	
	public SinglyLinkedList(){
		this.head = null;
		this.current = null;
	}
	
	public void insert(ListNode node){
		if(head == null){
			head = node;
			current = head;
		} else {
			current.setNext(node);
			current = current.getNext();
		}
	}
	
	public ListNode getHead(){
		return this.head;
	}
}
