package Stack;

import java.util.Stack;

public class StackProblems {

	public String reverseString(String str) {
		Stack<Character> stk = new Stack<Character>();
		char[] arr=str.toCharArray();
		for(char c:arr) {
			stk.push(c);
		}
		
		for(int i =0; i< str.length();i++){
//			System.out.print(stk.peek()+"-");
			arr[i]=stk.pop();
		}
//		System.out.println(new String(arr));
		return new String(arr);
	}
	
	public int[] nextGreaterEle(int[] arr) {
		
		int j=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>arr[0]) {
				arr[j]=arr[i];
				j++;
				break;
			}
		}
		
		
		return arr;
		
	}
	
	public int[] nextGreaterEle1(int[] arr) {
		return arr;
		
	}
	
	public static void main(String[] args) {
		StackProblems prb = new StackProblems();
		System.out.println(prb.reverseString("Karthikeyan"));
	}
}
