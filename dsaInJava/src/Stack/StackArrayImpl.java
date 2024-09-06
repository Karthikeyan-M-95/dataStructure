package Stack;

public class StackArrayImpl {
	
	int[] stk ;
	int top =-1;
	
		
	public StackArrayImpl(int cap) {
		stk= new int[cap];
	}
	
	public StackArrayImpl() {
		this(10);
	}
	
	public int length() {
		return stk.length;
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return size() == stk.length;
	}
	
	public int[] resize(int[] arr) {
		int[] newArr = new int[arr.length*2];
		for(int i=0;i<arr.length;i++) {
			newArr[i]=arr[i];
		}
	return newArr;
		}
	
	public void push(int val) {
		if(isFull())
			stk=this.resize(stk);
		top++;
		stk[top]= val;
			
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new IllegalArgumentException("Empty stack exception");
		}
		int data = stk[top];
		top--;
		return data;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new IllegalArgumentException("Empty stack exception");
		}
		return stk[top];
	}

	public static void main(String[] args) {
		
		StackArrayImpl arrImpl = new StackArrayImpl(5);		
		arrImpl.push(15);
		arrImpl.push(20);
		arrImpl.push(30);
		arrImpl.push(40);
		arrImpl.push(50);
		arrImpl.push(60);
//		System.out.println(arrImpl.isFull());
		System.out.println(arrImpl.size());
		System.out.println(arrImpl.length());

		System.out.println(arrImpl.pop());
		
	}
}
