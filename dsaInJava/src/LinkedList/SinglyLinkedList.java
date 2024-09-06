package LinkedList;

public class SinglyLinkedList {
	
	protected Node head;

	public class Node{
		protected int data;
		protected Node next;
		
		Node(int val){
			this.data=val;
			this.next=null;
		}
	}

	public SinglyLinkedList() {
		this.head=null;
		// TODO Auto-generated constructor stub
	}
	
 	public int length() {
		int count=0;
 		Node temp = head;
		while(temp!= null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	
	public void printList() {
		Node temp = head;
		while(temp!= null) {
			System.out.print(temp.data+" --> ");
			temp=temp.next;
		}
		System.out.println(temp);
	}
	
	public void insertElement(int val) {
		Node node = new Node(val);
		if(head==null) {
			head = node;
		}
		else {
			Node temp = head;
			while(temp.next!= null) {
				temp = temp.next;
			}
			temp.next=node;
		}
	}
	
	public void addElementAtFirst(int val) {
		Node node = new Node(val);
		if(head==null) {
			head = node;
		}
		else {
			node.next=head;
			head=node;
		}
	}
	
	public void addElementAtLast(int val) {
		Node node = new Node(val);
		if(head==null) {
			head = node;
		}
		else {
			Node temp = head;
			while(temp.next!= null) {
				temp = temp.next;
			}
			temp.next=node;
		}
	}
	
	public void addElementAtPos(int val, int pos) {
		Node node = new Node(val);
		if(pos== 1 ) {
			if(head==null)
				head=node;
			else {
				node.next=head;
				head=node;
			}
		}
		else {
			int count=1;
			Node temp= head;
			while(count< pos-1 && temp.next != null) {
				temp=temp.next;
				count++;
			}
			node.next= temp.next;
			temp.next = node;
		}
	}
	
	public int deleteEleAtFirst() {
		if(head == null)
			throw new IllegalArgumentException("Empty List");
		
		int temp = head.data;
		head=head.next;
		
		return temp;
	}
	
	public int delElementAtLast() {
		if(head == null)
			throw new IllegalArgumentException("Empty List");
		Node temp = head;
		Node prev = null;
		while(temp.next!= null) {
			prev=temp;
			temp = temp.next;

		}
		prev.next=null;
		return temp.data;
	}
	
	public int delAtPos(int pos) {
		
	if(pos == 0 || this.length() < pos) {
		throw new IllegalArgumentException("Invalid pos");
	}
	
	if(pos == 1) {
		head= head.next;
	}
		int count=1;
		Node temp = head;
		while(count < pos-1 && temp!=null) {
			temp = temp.next;
			count++;
		}
		int res= temp.next.data;
		temp.next=temp.next.next;
		return res;
	}
	
	public boolean searchEle(int val) {
		Node temp = head;
		while(temp != null) {
			if(temp.data == val)
				return true;
			temp=temp.next;
		}
		return false;
	}
	
	public void reverseList() {
		Node temp = head;
		Node prev = null;
		 while(temp != null) {
			 Node next = temp.next;
			 temp.next = prev;
			 prev = temp;
			 temp = next;
			 
		 }
		 head=prev;
	}
	
	public Node getNodeAtPos(int pos) {
		Node curr = head;
		int count=1;
		while(count<pos) {
			curr=curr.next;
			count++;
		}
//		System.out.println(curr.data);
		return curr;
	}
	
	public Node getLastNode() {
		Node curr=head;
		while(curr.next!=null) {
			curr=curr.next;
		}
		return curr;
	}
	
	public int deleteNthNode(int n) {
		Node fptr=head;
		Node slow=head;
		int count=0;
		while(count<n) {
			fptr = fptr.next;
			count++;
		}

		while(fptr.next!= null) {
			fptr=fptr.next;
			slow=slow.next;
		}
		int res = slow.next.data;
		slow.next=slow.next.next;
		return res;
	}
	
	public void printLoopList() {
		int count =0;
		Node curr = head;
		while(count<10) {
			System.out.print(curr.data + "-> ");
			count++;
			curr=curr.next;
		}
		System.out.println(curr.data);
	}
	
	public void removeDuplicatesInSortedLL() {
		Node temp = head;
		while(temp!=null && temp.next!= null) {
			if(temp.data == temp.next.data) {
				temp.next=temp.next.next;
			}
			else {
				temp = temp.next;
			}
		}
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
//		sll.insertElement(10);
//		sll.insertElement(20);
//		sll.insertElement(30);
//		sll.addElementAtFirst(40);
//		sll.addElementAtLast(50);
//		sll.addElementAtPos(108, 3);
//		sll.printList();
		sll.insertElement(10);
		sll.insertElement(10);
		sll.insertElement(10);
		sll.insertElement(20);
		sll.insertElement(20);
		sll.insertElement(30);
		sll.insertElement(30);
		sll.insertElement(40);
		sll.printList();
		sll.removeDuplicatesInSortedLL();
//		sll.delAtPos(4);
//		System.out.println(sll.length());
//		System.out.println("Delete first ele :"+ sll.deleteEleAtFirst());
//		System.out.println("Delete last ele :"+ sll.delElementAtLast());
//		sll.printList();
//		System.out.println("Delete t pos :"+ sll.delAtPos(5));
//		sll.reverseList();
		
		
//		System.out.println();
//		System.out.println(sll.deleteNthNode(4));
////		sll.reverseList();
	
		sll.printList();
//		Node last =((sll.getLastNode()));
//		last.next = sll.getNodeAtPos(3);
//		sll.printLoopList();
		
	}
}
