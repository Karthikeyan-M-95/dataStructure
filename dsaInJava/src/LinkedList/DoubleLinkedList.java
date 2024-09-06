package LinkedList;

import java.util.NoSuchElementException;

public class DoubleLinkedList {
	
	protected Node head;
	protected int length;
	
	protected class Node{
		protected int data;
		protected Node next;
		protected Node prev;
		
		Node(int val){
			this.data=val;
			this.next=this.prev=null;
		}
	}

	protected DoubleLinkedList() {
		head=null;
		length=0;
	}
	
	public void printLit() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" --> ");
			temp=temp.next;
		}
		System.out.println(temp);
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public Node getLastElement() {
		Node temp= head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		return temp;
	}
	
	public void printListReverse() {
		Node temp = this.getLastElement();
		while(temp.prev!=null) {
			System.out.print(temp.data+" -> ");
			temp=temp.prev;
		}
		System.out.println(temp.data);
	}
	
	public void addElement(int val) {
		
		Node node= new Node(val);
		if(head == null) {
			head= node;
		}
		else {
					
		Node temp= head;
		while(temp.next != null) {
			temp=temp.next;
		}
		temp.next=node;
		node.prev=temp;
		
		}
		length++;
	}
	
	public void addElementAtFirst(int val) {
		Node node= new Node(val);
		if(isEmpty())
			head = node;
		else {
			node.next=head;
			head.prev=node;
			head=node;
		}
		length++;
	}

	public void addElementAtLast(int val) {
		Node node= new Node(val);
		if(head == null) {
			head= node;
		}
		else {
					
		Node temp= head;
		while(temp.next != null) {
			temp=temp.next;
		}
		temp.next=node;
		node.prev=temp;
		
		}
		length++;
		
	}
	
	public void addNodeAtPos(int val, int pos) {
		Node node= new Node(val);
		if(pos <= 0) {
			throw new IllegalArgumentException("Invalid Input");
		}
		else if(pos==1){
			this.addElementAtFirst(val);
		}
		else {
			int count=1;
			Node temp = head;
			while(count<pos-1 && temp != null) {
				temp = temp.next;
				count++;
			}
//			System.out.println(temp.data+" - Adding Node Pos");
			if(temp==null)
				return;
			node.next=temp.next;
			temp.next.prev=node;
			node.prev=temp;
			temp.next=node;
		}
		length++;
	}
	
	public void deleteFirstNode() {
		if(head==null) {
			throw new IllegalArgumentException("This is a Empty List");
		}
		Node temp = head;
		head=head.next;
		head.prev=null;
		temp.next=null;
		length--;
	}
	
	public void deleteLastNode() {
		if(head==null) {
			throw new NoSuchElementException("This is a Empty List");
		}
		Node temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		Node prev = temp.prev;
		prev.next=null;
		temp.prev=null;
		length--;
		
	}
	
	public void deleteNodeAtPos(int pos) {
		
		if(pos <= 0) {
			throw new IllegalArgumentException("This is a Invalid position ");
		}
		else if(pos==1){
			this.deleteFirstNode();
		}
		else {
			int count=1;
			Node temp = head;
			while(count<pos-1 && temp != null) {
				temp = temp.next;
				count++;
			}
		Node next= temp.next.next;
		temp.next=next;
		next.prev=temp;
			
		}
		length--;
	}
	
	public static void main(String[] args) {
		System.out.println("Double Linked List");
		DoubleLinkedList dll= new DoubleLinkedList();
		dll.addElement(10);
		dll.addElement(80);
		dll.addElement(20);
		dll.addElement(30);
		dll.addElement(40);
		dll.addElement(50);
		dll.addElementAtFirst(100);
		dll.addNodeAtPos(102, 4);
		dll.printLit();
//		dll.printListReverse();
		
//		dll.deleteFirstNode();
//		dll.printLit();

//		dll.deleteLastNode();
//		dll.printLit();
		
		dll.deleteNodeAtPos(4);
		dll.printListReverse();
		dll.printLit();
//		System.out.println(dll.length());
	}
}
