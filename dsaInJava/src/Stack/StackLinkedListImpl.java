package Stack;

import java.util.NoSuchElementException;

public class StackLinkedListImpl {
	
	private Node top;
	private int length;
	
	public class Node{
		
		private int data;
		private Node next;
		
		Node(int val){
			this.data = val;
			next = null;
		}
	}

	public StackLinkedListImpl() {
		top = null;
		length =0;
	}
	
	private int size() {
		return length;
	}
	
	private boolean isEmpty() {
		return length==0;
	}
	
	private void push(int val) {
		Node node = new Node(val);
		node.next=top;
		top = node;
		length++;
	}
	
	private void pop() {
		if(isEmpty()) {
			throw new NoSuchElementException("Empty Stack");
		}else {
			int res = top.data;
			top=top.next;
			length--;
			System.out.println("Element Deleted :"+res);
		}
	}
	
	private int peek() {
		if(isEmpty()) {
			throw new NoSuchElementException("Empty Stack");
		}
		return top.data;
	}
	
	public void print() {
		if(isEmpty()) {
			throw new NoSuchElementException("Empty Stack");
		}
		
		Node temp = top;
		while(temp!=null) {
			System.out.print(temp.data+"--> ");
			temp=temp.next;
		}
		System.out.println(temp);
	}
	
	
	public static void main(String[] args) {
		 StackLinkedListImpl stk = new StackLinkedListImpl();
		 stk.push(10);
		 stk.push(20);
		 stk.push(30);
		 stk.push(50);
		 stk.push(60);
		 stk.print();
		 System.out.println(stk.peek());
		 stk.pop();
		 stk.print();
		 System.out.println(stk.size());
		
	}
}
