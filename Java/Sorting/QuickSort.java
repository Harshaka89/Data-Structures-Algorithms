/* Description: An implementation of the QuickSort sorting algorithm
*/
public class QuickSort {
	public static void quickSort(int[] A, int start, int end){
		if(start < end){
			int pivotPosition = partition(A, start, end); //Stores position of the pivot
			quickSort(A, start, pivotPosition - 1); //Sorts left side of pivot
			quickSort(A, pivotPosition + 1, end); //Sorts right side of pivot
		}
	}
	public static int partition(int[] A, int start, int end){
		int i = start + 1;
		int temp;
		int piv = A[start]; //Set first element as pivot
		for(int j = start + 1; j <= end; j++){
			if(A[j] < piv){ //Rearrange array by putting elements which are less than pivot 
				temp = A[i]; //on one side and greater than on the other
				A[i] = A[j];
				A[j] = temp;
				i++;
			}
		}
		temp = A[start]; //Swap puts pivot element in proper place
		A[start] = A[i-1];
		A[i-1] = temp;
		return i-1; //Returns the position of the pivot
	}
	
	
	public static void main(String[] args){
		int[] A = {42, 23, 16, 15, 4, 8};
		
		quickSort(A, 0, A.length-1);
		for(int x : A){
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
