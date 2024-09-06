package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class LoopLinkedList {
	
	public Node isListLoop(SinglyLinkedList sll) {
		Node fptr = sll.head;
		Node sptr = sll.head;
		while(fptr != null && fptr.next != null) {
			fptr=fptr.next.next;
			sptr=sptr.next;
			if(fptr == sptr)
				return sptr;
		}
		return null;
	}
	
	public Node findLoopStartElement(SinglyLinkedList sll) {
		
		Node isLoop = this.isListLoop(sll);
		if(isLoop == null) {
			 return null;
		}
		System.out.println("The slow pointer ele is :"+ isLoop.data);
		Node sptr = isLoop;
		Node curr = sll.head;
		while(curr != sptr) {
			curr=curr.next;
			sptr=sptr.next;
		}
	
			
		return sptr;
	}
	
	public void deleteLoop(SinglyLinkedList sll) {
		Node sptr = this.findLoopStartElement(sll);
		Node temp = sll.head;
		while(temp.next != sptr.next) {
			temp=temp.next;
			sptr=sptr.next;
		}
		sptr.next=null;
		
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		
		LoopLinkedList ll = new LoopLinkedList();
		sll.insertElement(10);
		sll.insertElement(20);
		sll.insertElement(30);
		sll.addElementAtFirst(40);
		sll.addElementAtLast(50);
		sll.addElementAtPos(108, 4);
		sll.printList();
//		
		Node last =((sll.getLastNode()));
		last.next = sll.getNodeAtPos(4);
		sll.printLoopList();
//		System.out.println(ll.isListLoop(sll))
		Node ele= ll.findLoopStartElement(sll);
		if(ele != null)
			System.out.println("The loops is present and start from :"+ ele.data);
		else
			System.out.println("This is not a loop");
		ll.deleteLoop(sll);
		
		sll.printList();
		ele= ll.isListLoop(sll);
		if(ele != null)
			System.out.println("The loops is present and start from :"+ ele.data);
		else
			System.out.println("This is not a loop");
		ll.findLoopStartElement(sll);
		
	}

}
