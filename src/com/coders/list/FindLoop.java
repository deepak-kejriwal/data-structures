package com.coders.list;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
public class FindLoop {

	public static void main(String[] args) {
		ListNode<Integer> list1 = ListNode.createRandomLinkedList(10);
		ListNode<Integer> list2 = ListNode.createRandomLinkedList(10);
		ListNode<Integer> head1 = list1;
		while (list1.next != null) {
			list1 = list1.next;
		}
		ListNode<Integer> head2 = list2;
		while (list2.next != null) {
			list2 = list2.next;
		}
		list1.next = head2;
		list2.next = head2;
		int expected=head2.data;
		int actual=findLoop(head1);
		System.out.println("value is: "+actual+" "+(actual==expected));
	}

	public static int findLoop(ListNode<Integer> head) {
		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				break;//collision, 2 pointers meet
			}
		}
		
		if(fast==null||fast.next==null) return -1;
		
		slow=head;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return fast.data;
	}
}
