/*
 * Implementation of a stack using a Linked List
 * A stack is LIFO
 */
public class StackLinkedList<T> {
	public class Node<T>{ //Node subclass
		T data;
		Node next;
		Node(T data){
			this.data = data;
		}
	}
	//Instance Variables
	private int size;
	Node top;
	StackLinkedList(){ //Constructor
		size = 0;
		top = null;
	}
	//Adds item to the top of the stack
	public void push(T data){
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		size++;
	}
	//Removes item from the top of the stack
	public T pop(){
		if(isEmpty()){
			return null;
		}
		T data = (T)top.data;
		top = top.next;
		size--;
		return data;
	}
	//Retrieves the item on top of the stack
	public T top(){
		return (T)top.data;
	}
	//Prints the entire stack
	public void printStack(){
		Node current = top;
		if(isEmpty()){
			return;
		}
		for(Node i = top; i != null; i = i.next){
			System.out.print(i.data + " ");
		}
		System.out.println();
	}
	
	/*
	 * Methods to get the size of the stack and to check if it is empty.
	 */
	public Boolean isEmpty(){ //checks if stack is empty
		if(size == 0){
			System.out.println("Stack is empty!");
			return true;
		}
		return false;
	}
	public int getSize(){ //returns the size of the stack
		return size;
	}
}
