import java.util.NoSuchElementException;

public class MyDeque<T> {
	public class Node<T>{
		T data;
		Node prev, next;
		public Node(T data){
			this.data = data;
		}
	}
	private Node head, tail; 
	int size;
	MyDeque(){
		int size = 0;
	}
	
	//Methods to add elements
	public void addFirst(T data){
		Node newNode = new Node(data);
		if(size == 0){
			head = newNode;
			tail = head;
		}
		else{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}
	public void addLast(T data){
		Node newNode = new Node(data);
		if(size == 0){
			tail = newNode;
			head = tail;
		}
		else{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}
	
	//Methods to remove and return
	public T removeFirst(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		T value = (T)head.data;
		head = head.next;
		size--;
		if(size == 0){
			tail = null;
		}
		return value;
	}
	public T removeLast(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		if(size == 1){
			removeFirst();
		}
		T value = (T)tail.data;
		Node newTail = tail.prev; //hold pointer to node before tail which will become the new tail
		tail.prev.next = tail.next; //remove the tail
		tail = newTail; //point tail to the new tail
		size--; //decrement size
		return value;
	}
	
	//Methods to return value without removing
	public T peekFirst(){
		return (T)head.data;
	}
	public T peekLast(){
		return (T)tail.data;
	}
	
	//Misc methods
	public boolean isEmpty(){
		return size == 0;
	}
	public int Size(){
		return size;
	}
	public void print(){
		Node current = head;
		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}
