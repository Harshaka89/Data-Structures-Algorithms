/*
 * This is a simple implementation of a Linked List data structure.  It currently has the
 * ability to add, delete, find, reverse and print the items in the list.
 */
public class MyLinkedList {
	
	Node head, tail;
	int size = 0;

	public void add(int data) {
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
	
	public Node deleteData(int data) {
		Node current = head;
		if(size == 0) {
			System.out.println("List is empty!!");
			return null;
		}
		if(current.data == data) { //if the data is in the head
			head = current.next; //set pointer of head to next node deleting it
			return current; 
		}
		/*
		 * Checks if next node is null or if it equals node we want to delete
		 * We then cycle through the list looking for node before the one we want to delete
		 */
		while(current.next != null && current.next.data != data) { 
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
		return current;
	}
	
	public Node find(int data) {
		if (head == null) { //Checks if list is empty
			System.out.println("List is empty!");
			return null;
		}
		if (head.data == data) { //if data found in first node
			System.out.println(data + " was found!");
			return head;
		}
		Node myNode = head;
		
		while (myNode.next != null) { //loop through the entire list
			myNode = myNode.next; //load the next node
			if (myNode.data == data) { //check to see if it matches search key
				System.out.println(data + " was found!"); //if it does print results
				return myNode;
			}
		}
		System.out.println(data + " was not found!"); //if no match found in the list
		return null;
	}
	
	public void traverse() {
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
	
	public void reverse(MyLinkedList list) {
		Node prev = null;
		Node current = list.head;
		Node next;
		
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		list.head = left;
	}
}
