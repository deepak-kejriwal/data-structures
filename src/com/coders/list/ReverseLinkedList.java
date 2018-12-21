package com.coders.list;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode<Integer> list = ListNode.createRandomLinkedList(10);
		System.out.println(list.toDataOnlyString());
		
		ListNode<Integer> reverseList = reverse(list);
		System.out.println(reverseList.toDataOnlyString());
		
		list = reverse(reverseList);
		reverseList = reverse(list,1,10);
		System.out.println(reverseList.toDataOnlyString());
		
		list = reverse(reverseList);
		System.out.println(reverseKInterval(list, 4).toDataOnlyString());
	}

	//Reverse a single linked list
	private static ListNode<Integer> reverse(ListNode<Integer> head) {
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
	//Reverse a single linked list at every K interval
	private static ListNode<Integer> reverseKInterval(ListNode<Integer> node, int k) {

		boolean headFound = false;

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
			//if list size is smaller than K leave it unchanged, hence calling reverse to reverse subHead to original subhead.
			if (count != k && subHead.next != null) {
				subHead = reverseKInterval(subHead, count);
			}
			if (!headFound) {
				dummyHead.next = subHead;
				tail = node;
				headFound = true;
			} else {
				tail.next = subHead;
				tail = node;
			}
			if (node != null) {
				node = node.next;
			}
		}

		return dummyHead.next;
	}
	
	//Reverse a single linked sublist in given range
	private static ListNode<Integer> reverse(ListNode<Integer> head,int start, int end) {
		
		
		if (head == null)
			return null;
		ListNode<Integer> dummyHead = new ListNode<>(0, head);
		int count=1;
		while(head!=null&&count<start) {
			head=head.next;
		}
		ListNode<Integer> node = head;
		while (node.next != null&&(start++<end)) {
			ListNode<Integer> tmp = node.next;
			node.next = tmp.next;
			tmp.next = head;
			head = tmp;
			dummyHead.next=head;
		}
		return dummyHead.next;
	}
}
