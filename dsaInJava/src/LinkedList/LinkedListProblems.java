package LinkedList;
import LinkedList.SinglyLinkedList.Node;;

public class LinkedListProblems {
	
	public Node mergeSortedList(Node a,Node b) {
		
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.insertElement(0);
		Node head = sll.head;
		Node tail = sll.head;
		while(a!=null && b != null) {
			if(a.data > b.data) {
				tail.next= b;
				b=b.next;
			}else {
				tail.next=a;
				a=a.next;
			}
			tail=tail.next;
		}
		if(a==null)
			tail.next=b;
		else
			tail.next=a;
		return head.next;
	}
	
	public Node addTwoList(Node list1, Node list2) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.insertElement(0);
		Node dummy = sll.head;
		Node tail = dummy;
		int sum=0;
		int carry=0;
		while(list1 !=null || list2!= null) {
			int x= list1!=null ?list1.data:0;
			int y = list2!=null?list2.data:0;
			sum= x+y+carry;
			carry=sum/10;
			System.out.println(carry+" carry over");
			System.out.println(sum%10+" sum over");
			sll.insertElement(sum%10);
			tail=tail.next;
			if(list1!= null)
				list1=list1.next;
			if(list2!=null)
				list2=list2.next;
		}
		if(carry >0)
			sll.insertElement(carry);
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList ll1 = new SinglyLinkedList();
		SinglyLinkedList ll2 = new SinglyLinkedList();
		LinkedListProblems llp = new LinkedListProblems();
		ll1.insertElement(5);
		ll1.insertElement(3);
		ll1.insertElement(7);
		ll1.printList();
		ll2.insertElement(2);
		ll2.insertElement(6);
		ll2.insertElement(6);

		ll2.printList();
//		Node mergeredList = llp.mergeSortedList(ll1.head, ll2.head);
		Node sum = llp.addTwoList(ll1.head, ll2.head);
		while(sum != null) {
			System.out.print(sum.data +" --> ");
			sum =sum.next;
		}
		
		
	}

}
