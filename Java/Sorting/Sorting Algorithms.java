
public class Sort {
	
	//Implementation of insertion sort
	public static void insertionSort(int[] myArray) {
		int element = 0;
		for (int i = 1; i < myArray.length; i++) {
			element = myArray[i]; 
			int j = i;
			while (j > 0 && myArray[j-1] > element) {
				myArray[j] = myArray[j-1];
				j--;
			}
			myArray[j] = element;
		}
		
		for (int x: myArray) {
			System.out.print(x + " ");
		}
	}
	//Implementation of Selection Sort
	public static void selectSort(int[] myArray) {
		int temp = 0;
		
		for (int i = 0; i < myArray.length; i++) {
			for (int j = i +1; j < myArray.length; j++) {
				if(myArray[i] > myArray[j]) {
					temp = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = temp;
				}
			}
		}
		for (int x: myArray) {
			System.out.print(x + " ");
		}
	}
	//Implementation of Bubble Sort
	public static void bubbleSort(int[] myArray) {
		int temp = 0;
		for (int i = 0; i < myArray.length; i++) {
			for (int j = 0; j < myArray.length - 1; j++) {
				if (myArray[j] > myArray[j+1]) {
					temp = myArray[j];
					myArray[j] = myArray[j+1];
					myArray[j+1] = temp;
				}
			}
		}
		for (int x: myArray) {
			System.out.print(x + " ");
		}
	}
}
