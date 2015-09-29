/*  DESCRIPTION: This program demonstrates the PriorityQueue which is an implementation of a MinHeap
    data structure.  The code below solves the problem of finding the kth smallest item in an array.
*/
import java.util.PriorityQueue;

public class MinHeap {
	public static int find(int[] a, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i = 0; i < a.length; i++){
			queue.add(a[i]);
		}
		int n = 0;
		while(k > 0){
			n = queue.remove();
			k--;
		}
		return n;
	}
	public static void main(String[] args){
		int[] A = { 4, 8, 15, 16, 23, 42 };
		int k = 4;
		System.out.println("4th smallest element: " + find(A, 4));
	}
}
