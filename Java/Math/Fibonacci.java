
public class Fibonacci {
	public static int iterative(int n){ //Most efficient
		int[] myArray = new int[n+1];
		if(n == 0){
			return 0;
		}
		else if(n == 1){
			return 1;
		}
		myArray[0] = 0;
		myArray[1] = 1;
		for(int i = 2; i <= n; i++){
			myArray[i] = myArray[i-1] + myArray[i-2];
		}
		return myArray[myArray.length-1];
	}
	public static int recursive(int n){
		if(n <= 1){
			return n;
		}
		return recursive(n-1) + recursive(n-2);
	}
	public static void main(String[] args){
		for(int i = 0; i < 10; i++){
			System.out.print(iterative(i) + " ");
		}
		System.out.println();
		for(int i = 0; i < 10; i++){
			System.out.print(recursive(i) + " ");
		}
	}
}
