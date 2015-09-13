  	/*
	 * Write a method to reverse a string using a stack.
	 */
public class StackProblems{
	public static String revString(String myString){
		Stack<Character> myStack = new Stack<Character>();
		for(int i = 0; i < myString.length(); i++) {
			myStack.push(myString.charAt(i));
		}
		char[] reverse = new char[myString.length()];
		for(int i = 0; i < myString.length(); i++) {
			reverse[i] = myStack.peek();
			myStack.pop();
		}
		myString = String.valueOf(reverse);
		return myString;
	}
}
