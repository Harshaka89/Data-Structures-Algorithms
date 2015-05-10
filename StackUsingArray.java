import java.util.NoSuchElementException;

/*
 * This is an implementation of a stack data structure using arrays
 * A stack is LIFO.
 */
public class Stack<T> {
	public int size;
	public T myStack[];
	@SuppressWarnings("unchecked")
	public Stack(){
		size = 0;
		myStack = (T[])new Object[100];
	}

	public void push(T data){
		if(size + 1 == myStack.length){ //I could create a method to allocate larger array
			resize(2*myStack.length);
		}
		myStack[size++] = data;
	}
	public T pop(){
		if(isEmpty() == true){
			throw new NoSuchElementException("Stack underflow");
		}
		T data = myStack[size-1];
		myStack[size-1] = null;
		size--;
		//Shrink size of array if necessary
		if(size > 0 && size == myStack.length/4){
			resize(myStack.length/2);
		}
		return data;
	}
	
	public T peek(){
		if(isEmpty() == true){
			throw new NoSuchElementException("Stack underflow");
		}
		return myStack[size-1];
	}
	
	public boolean isEmpty(){
		if(size == 0) {
			return true;
		}
		return false;
	}
	public void printStack() {
		for(int i = 0; i < size; i++) {
			System.out.print(myStack[i] + " ");
		}
		System.out.println();
	}
	public int size(){
		return size;
	}
	public void resize(int newSize){
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[newSize];
		for(int i = 0; i < size; i++){
			temp[i] = myStack[i];
		}
		myStack = temp;
	}
}
