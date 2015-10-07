/* DESCRIPTION: Implementation of MergeSort sorting algorithm
*/

public class MergeSort {
	public static void mergeSort(int[] A, int start, int end){
		if(start < end){
			int mid = start + (end - start)/2; //Splits array in two parts
			mergeSort(A, start, mid); //Sort first part of array
			mergeSort(A, mid+1, end); //Sort second part of array
			merge(A, start, mid, end); //Merge both parts by comparing elements of both parts
		}
	}
	public static void merge(int A[], int start, int mid, int end){
		int p = start, q = mid+1; //Store starting positions of both parts in temp variables
		int[] temp = new int[end-start+1];
		int k = 0;
		for(int i = start; i <= end; i++){
			if(p > mid){ //Checks if first part comes to an end or not
				temp[k++] = A[q++];
			}
			else if(q > end){ //Checks if second part comes to an end or not
				temp[k++] = A[p++];
			}
			else if(A[p] < A[q]){ //Checks which part has smallest element
				temp[k++] = A[p++];
			}
			else{ 
				temp[k++] = A[q++];
			}
		}
		for(int j = 0; j < k; j++){ //Copy sorted elements back to array
			A[start++] = temp[j];
		}
	}
	
	public static void main(String[] args){
		int[] A = {9, 7, 8, 3, 2, 1};
		
		mergeSort(A, 0, A.length-1);
		for(int x : A){
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
