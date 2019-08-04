package com.coders.list;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode<Integer> list = ListNode.createRandomLinkedList(10);
		System.out.println("Original List:    	    " + list.toDataOnlyString());

		ListNode<Integer> reverseList = reverseApproach1(list);
		System.out.println("Reversed List:    	    " + reverseList.toDataOnlyString());

		list = reverseApproach1(reverseList);
		reverseList = reverse(list, 4, 12);
		System.out.println("Reversed SubList: 	    " + reverseList.toDataOnlyString());

		list = reverse(reverseList, 4, 12);
		System.out.println("Reversed K=4 interval List: " + reverseKInterval(list, 4).toDataOnlyString());
	}

	// Reverse a single linked list
	private static ListNode<Integer> reverseApproach1(ListNode<Integer> head) {
		if (head == null)
			return null;
		ListNode<Integer> node = head;
		while (node.next != null) {
			ListNode<Integer> tmp = node.next;
			node.next = tmp.next;
			tmp.next = head;
			head = tmp;
		}
		return head;
	}
	
	// Reverse a single linked list
	private static ListNode<Integer> reverseApproach2(ListNode<Integer> head) {
		ListNode<Integer> prev=null;
		ListNode<Integer> curr=head;

		while (curr!= null) {
			ListNode<Integer> tmp = curr.next;
			curr.next = prev;
			prev=curr;
			curr=tmp;
		}
		return prev;
	}

	// Reverse a single linked list at every K interval
	private static ListNode<Integer> reverseKInterval(ListNode<Integer> node, int k) {
		ListNode<Integer> tail = new ListNode<>(0, null);
		ListNode<Integer> dummyHead = new ListNode<>(0, tail);

		while (node != null) {
			int count = 1;
			ListNode<Integer> subHead = node;
			while (node.next != null && k != count) {
				ListNode<Integer> tmp = node.next;
				node.next = tmp.next;
				tmp.next = subHead;
				subHead = tmp;
				count++;
			}
			// if sublist size is smaller than K leave it unchanged, hence calling reverse
			// to reverse subHead to original subhead.
			if (count != k && subHead.next != null) {
				subHead = reverseKInterval(subHead, count);
			}
			tail.next = subHead;
			tail = node;
			//node is pointing to last element of sublist. Hence node.next points to head of new sublist.
			if (node != null) {
				node = node.next;
			}
		}

		return dummyHead.next.next;
	}

	// Reverse a single linked sublist in given range
	private static ListNode<Integer> reverse(ListNode<Integer> head, int start, int end) {

		if (head == null)
			return null;
		ListNode<Integer> dummyHead = new ListNode<>(0, head);
		ListNode<Integer> prevHead = dummyHead;
		int count = 1;
		while (head != null && count++ < start) {
			head = head.next;
			prevHead = prevHead.next;
		}
		ListNode<Integer> node = head;
		while (node.next != null && (start++ < end)) {
			ListNode<Integer> tmp = node.next;
			node.next = tmp.next;
			tmp.next = head;
			head = tmp;
			prevHead.next = head;
		}
		return dummyHead.next;
	}
}
