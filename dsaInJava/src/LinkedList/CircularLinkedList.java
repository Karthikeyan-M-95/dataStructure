package LinkedList;

public class CircularLinkedList {

	private int length;
	private Node head;
	private Node tail;
	
	private class Node{
		
		private int data;
		private Node next;
		
		Node(int val){
			this.data = val;
			this.next = null;
		}
	}
	
	public CircularLinkedList() {
		this.length = 0;
		this.head = this.tail = null;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public int size() {
		return length;
	}
	
	public void printList() {
		
		Node temp = head;
		while(temp != tail ) {
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
	
	public void addElement(int val) {
		Node node =  new Node(val);
		if(head == null) {
			head=tail=node;
			length++;
			return;
		}
		node.next=head;
		tail.next=node;
		tail=node;
		length++;
	}
	
	public void sortCLL() {
//		int len = this.size();
//		Node temp = head;
//		Node head1 = new Node(0);
//		Node tail1= head1;
//		while(len>=0) {
//			tail1.next=temp;
//			temp=temp.next;
//			len--;
//		}
		
	}
	
	public void deleteElement() {
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList cll = new CircularLinkedList();
		cll.addElement(10);
		cll.addElement(20);
		cll.addElement(15);
		cll.addElement(26);
		System.out.println("The length is : "+cll.size());
		cll.printList();
	}

}
