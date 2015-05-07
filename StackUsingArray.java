/*
 * This is an implementation of a stack data structure using arrays
 * A stack is LIFO.
 */
public class Stack {
	public int top;
	public int myStack[];
	public Stack(){ //constructor
		top = -1;
		myStack = new int[100];
	}

	public void push(int data){ //adds element to the stack
		if(top + 1 == myStack.length){ //I could create a method to allocate larger array
			System.out.println("Stack overflow!");
			return;
		}
		top++;
		myStack[top] = data;
	}
	public void pop(){ //delete element from the stack
		if(top == -1){
			System.out.println("Stack is empty!  Unable to pop!");
			return;
		}
		top--;
	}
	public int top(){ //Returns the value on top of the stack
		
		return myStack[top];
	}
	public boolean isEmpty(){ //tests if stack is empty
		if(top == -1) {
			return true;
		}
		return false;
	}
	public void printStack() { //prints the stack
		for(int i = 0; i <= top; i++) {
			System.out.print(myStack[i] + " ");
		}
		System.out.println();
	}
}
