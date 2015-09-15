public class Search {

	public static void linearSearch(int[] myArray, int key) {
		
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] == key) {
				System.out.println("Found " + key);
				return;
			}
		}
		System.out.println(key + " was not found!");
	}
	
	public static void binarySearch(int[] myArray, int key) {
		int low = 0, high = myArray.length-1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (myArray[mid] == key) {
				System.out.println(key + " was found!");
				return;
			}
			else if (myArray[mid] < key) {
				low = mid + 1;
			}
			else if (myArray[mid] > key) {
				high = mid - 1;
			}
		}
		System.out.println(key + " was not found!");
	}
}
