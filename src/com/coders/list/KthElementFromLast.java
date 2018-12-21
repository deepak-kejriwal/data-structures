package com.coders.list;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
public class KthElementFromLast {
	private static int N = 25;

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		Stack<String> stk=new Stack<>();
	
		PriorityQueue<String> pq=new PriorityQueue<>();
		LinkedList<String> ll=new LinkedList<>();
		ll.add(null);
		ArrayDeque<String> ad=new ArrayDeque<>();
		ad.add(null);
		
		int[] nums = IntStream.rangeClosed(1, 10300000).toArray();
		ListNode<Integer> root = createLinkedList(nums);
		// System.out.println(root);
		int k = 104;
		int r = 0;

		long start = System.nanoTime();
		for (int i = 0; i < N; i++) {
			r = solution1(root, k);
		}
		long end = System.nanoTime();
		System.out.println(r);
		System.out.println(end - start);

		start = System.nanoTime();
		for (int i = 0; i < N; i++) {
			r = solution2(root, k);
		}
		end = System.nanoTime();
		System.out.println(r);
		System.out.println(end - start);

		start = System.nanoTime();
		for (int i = 0; i < N; i++) {
			r = solution3(root, k);
		}
		end = System.nanoTime();
		System.out.println(r);
		System.out.println(end - start);

		start = System.nanoTime();
		for (int i = 0; i < N; i++) {
			r = getLastElementUsingFor(root);
		}
		end = System.nanoTime();
		System.out.println(r);
		System.out.println(end - start);
		
		start = System.nanoTime();
		for (int i = 0; i < N; i++) {
			r = getLastElementUsingWhile(root);
		}
		end = System.nanoTime();
		System.out.println(r);
		System.out.println(end - start);
	}

	private static int getLastElementUsingWhile(ListNode<Integer> root) {
		ListNode<Integer> prev = null;
		ListNode<Integer> head = root;
		while(head!=null) {
			prev=head;
			head = head.next;
		}
		return prev.data;
	}

	private static int getLastElementUsingFor(ListNode<Integer> root) {
		ListNode<Integer> prev = null;
		ListNode<Integer> head = root;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {

			if (head == null)
				break;
			prev=head;
			head = head.next;
		}
		return prev.data;
	}

	private static int solution1(ListNode<Integer> root, int k) {
		ListNode<Integer> head = root;
		int count = 0;
		while (root != null) {
			root = root.next;
			count++;
		}
		if (count < k)
			return -1;
		for (int i = 0; i < (count - k); i++) {
			head = head.next;
		}
		return head.data;
	}

	private static int solution2(ListNode<Integer> root, int k) {
		ListNode<Integer> head1 = root;
		ListNode<Integer> head2 = root;
		int whileC = 0;
		for (int i = 0; i < k; i++) {
			whileC++;
			if (head1 == null)
				return -1;
			head1 = head1.next;
		}
		while (head1 != null) {
			whileC++;
			whileC++;
			head1 = head1.next;
			head2 = head2.next;
		}
		//System.out.println("s2: " + whileC);
		return head2.data;
	}

	private static int solution3(ListNode<Integer> root, int k) {
		ListNode<Integer> head = null;
		ListNode<Integer> prev = root;
		int whileC = 0;
		int delta = k > 10 ? 0 : 10 - k;
		k = k > 10 ? k : 10;
		int i = 0;
		outer: while (root != null) {
			i = 0;
			for (; i < k; i++) {

				if (root == null)
					break outer;
				root = root.next;
			}

			head = prev;
			prev = root;
			whileC = whileC + i + 2;
		}

		if (head == null)
			return -1;
		i = i % k;

		for (int j = 0; j < i + delta; j++) {
			whileC++;
			head = head.next;
		}
		//System.out.println("s3: " + whileC);
		return head.data;

	}

	private static ListNode<Integer> createLinkedList(int[] nums) {
		ListNode<Integer> next = null;
		for (int x : nums) {
			ListNode<Integer> node = new ListNode<>(x, next);
			next = node;
		}
		return next;
	}

}
