package Array;

public class ArrayDSA {

	public void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public int[] removeEven(int[] arr) {
		int count = 0;
		int res[] = null;
		for(int i:arr) {
			if(i%2 != 0)
				count++;
		}
		if(count > 0) {
			res= new int[count];
			int j=0;
			for(int i:arr) {
				if(i%2 != 0) {
					res[j]=i;
					j++;
				}		
			}
		}
		return res;
	}

	public int[] reverseArr(int[] arr, int start, int end) {
		
		while(start<end) {
			int temp = arr[start];
			arr[start]= arr[end];
			arr[end]=temp;
			end--; start++;
		}
		
		return arr;
	}
	
	public int findMin(int[] arr) {
		int min = arr[0];
		for(int j : arr) {
			if(j<min)
				min=j;
		}
		return min;
	}
	
	public int findSecMax(int[] arr) {
		int fmax=Integer.MIN_VALUE;
		int smax = Integer.MIN_VALUE;
		for(int i: arr) {
			if(i> fmax) {
				smax=fmax;
				fmax=i;
			}
			else if(i>smax && i!= fmax) {
				smax=i;
			}
		}
		return smax;
	}
	
	public int[] moveZeroToEnd(int[] arr) {
		int j=0;
		for(int i=1;i<arr.length;i++) {
			System.out.print(arr[j]+ "....."+ arr[i]);
				if(arr[j]==0 && arr[i]!=0) {
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					j++;
				}
			if(arr[j]!=0)
				j++;
			System.out.println("-----------------"+arr[j]+ "....."+ arr[i]);
		}
		return arr;
	}

	public int[] resize(int[] arr, int cap) {
		int newArr[] = new int[cap];
		for(int i=0;i<arr.length;i++) {
			newArr[i]=arr[i];
		}
		return newArr;
	}
	
	public boolean isPalindrome(String str) {
		
		char[] arr = str.toLowerCase().toCharArray();
		int findex = 0;
		int lindex = arr.length-1;
		while(findex<lindex) {
			if(arr[findex] != arr[lindex])
				return false;
			else {
				findex++; lindex--;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		ArrayDSA obj = new ArrayDSA();
		int[] arr1 = new int[6];
//		System.out.println(arr1.length);
		for(int i=0;i<arr1.length;i++) {
			arr1[i]=i+5;
		}
//		arr1[6]=21;
		obj.printArray(arr1);
		int[] res = obj.removeEven(arr1);
//		obj.printArray(res);
//		res = obj.reverseArr(arr1, 0,arr1.length-1	);
//		obj.printArray(res);
//		System.out.println("The min value is: "+ obj.findMin(arr1));
//		int res1 = obj.findSecMax(arr1);
//		System.out.println(res1);
//		res = obj.moveZeroToEnd(arr1);
		
		res = obj.resize(arr1, arr1.length*2);
		obj.printArray(res);
		System.out.println(res.length);
		String str ="Malayalam";
		System.out.println(obj.isPalindrome(str));
	}
}
