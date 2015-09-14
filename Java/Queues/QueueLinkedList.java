/*
 * This is a linked list implementation of a queue.
 * A queue is a FIFO data structure
 */
public class QueueLinkedList<T> {
	public class Node<T>{
		T data;
		Node next;
		Node(T data){
			this.data = data;
		}
	}
	//Instance Variables
	Node first, last;
	private int size;
	QueueLinkedList(){ //Constructor
		size = 0;
		first = null; last = null;
	}
	
	//Adds an element to the queue
	public void enqueue(T data){
		Node newNode = new Node(data);
		if(size == 0){
			newNode.next = first;
			first = newNode;
			last = first;
			size++;
			return;
		}
		else{
			last.next = newNode;
			last = newNode;
			size++;
		}
	}
	//Removes element from the queue
	public T dequeue(){
		if(isEmpty()){
			return null;
		}
		T dataToDequeue = (T)first.data;
		first = first.next;
		size--;
		return dataToDequeue;
	}
	public T peek(){ //Returns value of first element in queue
		return (T)first.data;
	}
	public void printQueue(){ //prints all values stored in the queue
		Node current = first;
		if(isEmpty()){
			return;
		}
		for(Node i = current; i != null; i = i.next){
			System.out.print(i.data + " ");
		}
		System.out.println();
	}
	/*
	 * Methods to check size of queue and if it is empty
	 */
	public Boolean isEmpty(){
		if(size == 0){
			System.out.println("Queue is empty!");
			return true;
		}
		return false;
	}
	public int getSize(){
		return size;
	}
}
