package com.coders.list;

/**
* 
* @author deepak1037
*
*/
public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	public ListNode(T data, ListNode<T> next) {
		this.data = data;
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}
