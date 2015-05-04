/*
 * This file will hold array manipulation functions.
 */
public class ArrayManip {
	public static int nElems;
	
	public static int[] insert(int[] myArray, int index, int number) {
		nElems = myArray.length - 1;
		if (nElems + 1 == myArray.length) { //if adding an element runs you out of space
			myArray = allocate(myArray); //allocate more space in array
		}
		
		for (int i = nElems; i >= index; i--) {
			myArray[i+1] = myArray[i]; //shift elements to the right
		}
		myArray[index] = number; //insert new value
		nElems++; //increment count of elements
		return myArray;
	}
	
	public static int[] delete(int[] myArray, int index) {
		nElems = myArray.length - 1;
		for (int i = index; i < nElems; i++) {
			myArray[i] = myArray[i+1]; //shift elements left to delete
		}
		return myArray;
	}
	
	//This method reverses an array.
	public static int[] reverse(int[] myArray) {
		int temp;
		int length = myArray.length;
		
		for(int i = 0; i < length/2; i++) {
			temp = myArray[i];
			myArray[i] = myArray[length-i-1];
			myArray[length-i-1] = temp;
		}
		return myArray;
	}
	
	//This method will allocate a new array with twice as much space
	public static int[] allocate(int[] myArray){
		int[] myArrayb = new int[2 * myArray.length];
		for (int i = 0; i <= nElems; i++) {
			myArrayb[i] = myArray[i]; 
		}
		myArray = myArrayb;
		return myArray;
	}
}
