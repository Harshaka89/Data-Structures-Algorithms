/*  DESCRIPTION: This code converts a PriorityQueue which is a MinHeap by default into a MaxHeap by altering
    the Comparator to return o2-o1.  The code below solves the problem of returning the kth largest item
    in the array.
*/
import java.util.PriorityQueue;
import java.util.Comparator;

public class MaxHeap {
	public static int find(int[] a, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
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
		System.out.println("4th largest element: " + find(A, 4));
	}
}
