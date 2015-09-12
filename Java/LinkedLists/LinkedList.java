/*
 * This is a simple implementation of a Linked List data structure.  It currently has the
 * ability to add, delete, find, reverse, print, get the size of, and determine if there is a cycle
 * in the linked list. linkedlist
 */
public class MyLinkedList<T> {
	public class Node<T>{
		T data;
		Node next;
		
		Node(T data){
			this.data = data;
		}
	}
	//Instance variables
	private int size;
	Node head, tail;
	
	//Constructor
	MyLinkedList(){
		size = 0;
		head = null; tail = null;
	}
	
	//Methods to add nodes to a linked list
	public void addHead(T data){ //Adds node to the beginning of a linked list
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		if(tail == null){
			tail = newNode;
		}
		size++;
	}
	public void addTail(T data){ //Adds node to the end of a linked list
		Node newNode = new Node(data);
		if(tail == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	public void addAtNth(int index, T data){ //Adds node to the specified index of a linked list
		Node newNode = new Node(data);
		Node current = head;
		if(index == 1){ //if first element add to the head
			addHead(data);
			return;
		}
		else if(index == size){ //if element is after end of list add to tail
			addTail(data);
			return;
		}
		else if(index < 1 || index > size){ //if index is invalid
			System.out.println("Index out of bounds");
			return;
		}
		for(int i = 0; i < index-2; i++){ //go to location 2 before where we want to insert
			current = current.next;
		}
		newNode.next = current.next; //create link to element after the one we want to insert
		current.next = newNode; //creates link to element we are inserting
		size++;
	}
	
	//Methods to remove nodes from a linked list
	public void removeHead(){ //Removes first node in a linked list
		if(isEmpty()){
			return;
		}
		head = head.next; //
		size--;
		if(size == 0){ //if list now empty, erase tail as well
			tail = null;
		}
	}
	public void removeTail(){ //removes the last node in a linked list
		Node current = head;
		if(isEmpty()){
			return;
		}
		else if(size == 1){
			removeHead();
			return;
		}
		while(current.next.next != null){
			current = current.next;
		}
		current.next = current.next.next; //erase tail
		tail = current; //update tail pointer
		size--;
	}
	public Node removeItem(T data){ //remove data item passed in if it exists
		Node current = head; int count = 1;
		if(isEmpty()){
			return null;
		}
		else if(current.data.equals(data)){
			head = current.next;
			size--;
			return current;
		}
		while(current.next != null && current.next.data.equals(data) == false){
			current = current.next;
			count++;
		}
		if(current.next == null){
			System.out.println(data + " not found!");
			return null;
		}
		Node prev = current.next;
		current.next = prev.next;
		size--;
		if(count == size){ //if data is located in tail, update tail pointer
			tail = current;
		}
		return current;
	}
	public Node removeNth(int index){ //removes element at specified index
		Node current = head;
		if(index == 1){ //if first element add to the head
			removeHead();
			return current;
		}
		else if(index == size){ //if element is after end of list add to tail
			removeTail();
			return current;
		}
		else if(index < 1 || index > size){ //if index is invalid
			System.out.println("Index out of bounds");
			return null;
		}
		for(int i = 0; i < index-2; i++){
			current = current.next;
		}
		Node prev = current.next;
		current.next = prev.next;
		size--;
		return current;
	}
	public void removeAll(){ //Removes all nodes in a linked list
		Node current = head;
		Node temp;
		while(current != null){ //loops through list and deletes each node one by one
			temp = current.next;
			current = temp;
			size--;
		}
		head = null;
		tail = null;
		System.out.println("List has been deleted!");
	}
	
	//Methods to search and print a list.
	public void printList(){ //Traverses list printing each node
		Node current = head;
		if(isEmpty()){
			return;
		}
		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	public void recursivePrint(Node current){ //prints nodes in list recursively
		if(current == null){ //base case
			System.out.println();
			return;
		}
		System.out.print(current.data + " ");
		recursivePrint(current.next);
	}
	public void reverseRecursivePrint(Node current){
		if(current == null){ //base case
			return;
		}
		reverseRecursivePrint(current.next);
		System.out.print(current.data + " ");
	}
	/*
	 * Method find() takes a linkedlist and a key as parameters, it then loops through the
	 * list and returns true if the item is found and false otherwise.
	 */
	public Boolean find(MyLinkedList list, T key){ 
		Node current = list.head;
		if(isEmpty()){ //checks if empty
			return false;
		}
		else if(current.data.equals(key)){
			return true;
		}
		while(current != null && current.data.equals(key) == false){
			current = current.next;
		}
		if(current == null){
			return false;
		}
		return true;
	}
	/*
	 * Method getDataNth() takes in an index and returns the data element at the specified
	 * location. It will return null if list is empty, or if index is out of bounds.
	 */
	public T getDataNth(int index){
		Node current = head;
		int count = 1;
		if(isEmpty()){
			return null;
		}
		else if(index < 1 || index > size){ //if index is invalid
			System.out.println("Index out of bounds");
			return null;
		}
		while(current != null){
			if(count == index){
				return (T)current.data;
			}
			current = current.next;
			count++;
		}
		return null;
	}
	
	/*
	 * Methods to reverse a linked list.
	 */
	public void reverse(MyLinkedList list){
		Node prev = null;
		Node current = list.head;
		Node next = null;
		
		list.tail = list.head;//changes tail pointer to head for when list is reversed
		
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		list.head = prev;
	}
	public void recursiveReverse(Node current){
		if(current.next == null){
			tail = head;
			head = current;
			return;
		}
		recursiveReverse(current.next);
		Node temp = current.next;
		temp.next = current;
		current.next = null;
	}
	
	//Misc Methods
	public boolean isEmpty(){ //Method to check if list is empty
		if(size == 0){
			System.out.println("List is empty!");
			return true;
		}
		return false;
	}
	public int getSize(){
		return size;
	}
}
