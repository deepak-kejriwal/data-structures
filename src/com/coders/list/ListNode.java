package com.coders.list;
/**
 * 
 * @author Deepak Kejriwal
 *
 */
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	public ListNode(T data, ListNode<T> next) {
		this.data = data;
		this.next = next;
	}
	@Override
	public String toString() {
		return "[data=" + data + ", next=" + next + "]";
	}
	public String toDataOnlyString() {
		return data + ", " + (next!=null?next.toDataOnlyString():null);
	}
	public static ListNode<Integer> createRandomLinkedList(int elementCount){
		List<Integer> list= IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toList());
		Collections.shuffle(list);
		ListNode<Integer> dummy=new ListNode<Integer>(0,null);
		ListNode<Integer> node=dummy;
		for(int i:list) {
			node.next=new ListNode<Integer>(i,null);
			node=node.next;
		}
		return dummy.next;
	}
}
