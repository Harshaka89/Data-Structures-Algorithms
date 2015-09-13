/*
 * Implementation of a stack using a Linked List
 * A stack is LIFO
 */
public class StackLinkedList {
	public Node top; //head in normal linked list
	public int size = 0;
	
	public void push(int data){
		Node pushNode = new Node(data);
		pushNode.next = top; //set next node to current top
		top = pushNode; //set new top to the new node
		size++; //increment size of list
	}
	public void pop(){
		if(top == null){
			return;
		}
		top = top.next; //pop the top node
		size--;
	}
	public int top(){ //returns data in top node
		return top.data;
	}
	
	public boolean isEmpty(){ //checks if list is empty
		if(top == null){
			return true;
		}
		return false;
	}
}
