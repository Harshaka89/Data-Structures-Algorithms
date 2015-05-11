/*
 * This is a simple implementation of a Linked List data structure.  It currently has the
 * ability to add, delete, find, reverse, print, get the size of, and determine if there is a cycle
 * in the linked list.
 */
public class MyLinkedList<T> {
	/*
	 *  Nested Node class definition
	 */
	public class Node {
		T data;
		Node next;
		Node(T data){
			this.data = data;
		}
	}
	Node head, tail;
	int size = 0;
	
	/*
	 *  Methods that add items to the linked list
	 */
	public void add(T data) {
		Node newNode = new Node(data);
		
		if (tail == null) {  //checks if the list is empty
			head = newNode; //if list is empty the new node will be both the head and tail
			tail = newNode;
		}
		else { //if the list isn't empty
			tail.next = newNode;
			tail = newNode;  //set tail = to the new node
		}
		size++;  //increment size to track number of items in the list
	}
	
	public void addHead(T data){ //Adds element to the head of a linked list
		Node newNode = new Node(data);
		newNode.next = head; //links next node to current head
		head = newNode; //links head to newNode which adds it to the list.
	}
	
	public void addAtNth(T data, int location){
		Node newNode = new Node(data);
		if(location == 1) { //if we insert at location 1
			newNode.next = head; //set next node to current head
			head = newNode; //set head to the new node
			return;
		}
		Node temp = head;
		for(int i = 0; i < location -2; i++) { //go to location 2 before where we want to insert
			temp = temp.next;
		}
		newNode.next = temp.next; //create a link to element after the one we want to insert
		temp.next = newNode; //creates the link to the element we are inserting
	}
	
	/*
	 *  Methods that delete items in the linked list
	 */
	public Node deleteData(T data) {
		Node current = head;
		if(size == 0) {
			System.out.println("List is empty!!");
			return null;
		}
		if(current.data.equals(data)) { //if the data is in the head
			head = current.next; //set pointer of head to next node deleting it
			size--;
			return current; 
		}
		/*
		 * Checks if next node is null or if it equals node we want to delete
		 * We then cycle through the list looking for node before the one we want to delete
		 */
		while(current.next != null && current.next.data.equals(data) == false) { 
			current = current.next;
		}
		if(current.next == null) { //if next node is null it means item not found so unable to delete
			return null;
		}
		Node prev = current.next; //create second pointer and set it equal to the next node
		current.next = prev.next; //sets the next link to the one after the next, erasing the data
		size--;
		return current;
	}
	
	public Node deleteNth(int location) { //deletes node from specified location in the list
		Node current = head;
		if(location == 1) { //checks if we want to delete first node
			head = current.next; //deletes first node
			size--;
			return current;
		}
		for(int i = 0; i < location-2; i++) { //loop to node before node we want to delete
			current = current.next;
		}
		if(current.next == null) { //If item wasn't found then return null
			return null;
		}
		Node prev = current.next; 
		current.next = prev.next; //delete node
		size--;
		return current;
	}
	public Node deleteComplete(){ //Deletes entire linked list
		Node current = head;
		Node temp;
		while(current != null) {
			temp = current.next;
			current = temp;
			size--;
		}
		head = null;
		System.out.println("List deleted!");
		return current;
	}
	
	//Searches for an item in the linked list
	public Node find(T data) {
		if (head == null) { //Checks if list is empty
			System.out.println("List is empty!");
			return null;
		}
		if (head.data.equals(data)) { //if data found in first node
			System.out.println(data + " was found!");
			return head;
		}
		Node current = head;
		
		while (current.next != null) { //loop through the entire list
			current = current.next; //load the next node
			if (current.data.equals(data)) { //check to see if it matches search key
				System.out.println(data + " was found!"); //if it does print results
				return current;
			}
		}
		System.out.println(data + " was not found!"); //if no match found in the list
		return null;
	}
	/*
	 *  Methods that print the items in the linked list
	 */
	public void traverse() { //prints the items in a linked list iteratively
		if (head != null) { //checks if list is empty
			Node node = head;
			System.out.print(node.data + " ");  //prints first item
			while (node.next != null) {  //loops through remaining items if they exist
				node = node.next;  //sets node to the next node on each pass
				System.out.print(node.data + " ");  //prints the node
			}
		}
		else {
			System.out.println("List is empty!");
		}
	}
	public void recursivePrint(Node current){ //print a linked list recursively
		if(current == null) { //base case tests if node is null
			return;
		}
		System.out.print(current.data + " "); //if not null print data
		recursivePrint(current.next); //load next element
	}
	public void reverseRecursivePrint(Node current) { //Print a linked list in reversed order recursively
		if(current == null) {
			return;
		}
		reverseRecursivePrint(current.next); //to print reverse order make recursive call before the print
		System.out.print(current.data + " ");
	}
	//Returns the size of the linked list
	public int getSize() {
		Node current = head;
		int count = 0;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	//Returns the data at the Nth element
	public void getDataNth( int location) {
		Node current = head;
		int count = 0;
		while(current != null) {
			count++;
			if(count == location) {
				System.out.println(current.data);
				return;
			}
			current = current.next;
		}
		System.out.println("Node doesn't exist!!");
		return;
	}
	/*
	 *  Methods to reverse a linked list.
	 */
	public void reverse(MyLinkedList list) { //Iteratively reverse
		Node prev = null;
		Node current = list.head;
		Node next;
		
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		list.head = prev;
	}
	public void recursiveReverse(Node current){ //Reverse a linked list recursively
		if(current.next == null) { //base case
			head = current;
			return;
		}
		recursiveReverse(current.next); //recursive call
		Node temp = current.next;
		temp.next = current;
		current.next = null;
	}
	
	/*
	 * Checks to see if there is a cycle in the linked list.  We declare two pointers and they
	 * traverse the list at two different speeds.  The idea is that if there is a cycle they
	 * will end up on the same node eventually and it will return true.  If there is no 
	 * cycly they will return false.
	 */
	public boolean hasCyclePointer() {
		Node pointer1 = head; 
		Node pointer2 = head;
		while(pointer2.next != null && pointer2.next.next != null) {
			pointer1 = pointer1.next; //Speed 1
			pointer2 = pointer2.next.next; //Speed 2
			if(pointer1 == pointer2) { //if there is a cycle they will be on the same node
				return true;
			}
		}
		return false;
	}
}
