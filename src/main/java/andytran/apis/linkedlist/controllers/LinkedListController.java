package andytran.apis.linkedlist.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.linkedlist.models.ListNode;
import andytran.apis.linkedlist.models.SinglyLinkedList;
import andytran.apis.linkedlist.services.LinkedListService;
import andytran.apis.shared.exceptions.BadRequestException;
import andytran.apis.shared.models.APIResponse;
import andytran.apis.shared.utils.ControllerUtils;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "api/linkedlist")
@Api(tags="Linked List APIs", produces="application/json")
public class LinkedListController {
	
	@Autowired
	private LinkedListService linkedListService;
	
	@RequestMapping(value = "reverse", method = RequestMethod.GET)
	public APIResponse reverse(@RequestParam List<Integer> list){
		ListNode head = linkedListService.reverse(toSinglyLinkedList(list).getHead());
		if(head == null) {
			throw new BadRequestException();
		}
		return ControllerUtils.makeSuccessResponse(toList(head));
	}
	
	@RequestMapping(value = "mergesortedlists", method = RequestMethod.GET)
	public APIResponse mergeSortedLists(@RequestParam List<Integer> l1, @RequestParam List<Integer> l2){
		ListNode merged = linkedListService.mergeSortedLists(toSinglyLinkedList(l1).getHead(), toSinglyLinkedList(l2).getHead());
		return ControllerUtils.makeSuccessResponse(toList(merged));
	}
	
	private SinglyLinkedList toSinglyLinkedList(List<Integer> list){
		SinglyLinkedList linkedList = new SinglyLinkedList();
		list.forEach(num -> {
			linkedList.insert(new ListNode(num));
		});
		return linkedList;
	}
	
	private List<Integer> toList(ListNode head){
		if(head == null){
			return null;
		}
		
		List<Integer> list = new ArrayList<>();
		while(head != null){
			list.add(head.getVal());
			head = head.getNext();
		}
		return list;
	}
	
}
