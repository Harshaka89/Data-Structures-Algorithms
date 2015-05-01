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
			tail.nextNode = newNode;
			tail = newNode;  //set tail = to the new node
		}
		size++;  //increment size to track number of items in the list
	}
	
	public Node delete(int data) {
		Node nodeToReturn = null;
		if (size == 0) { //checks if list is empty
			System.out.println("List is empty!");
			return null;
		}
		if (size == 1) {
			nodeToReturn = head;
			head = null; //deletes the only item in list by setting head and tail to null
			tail = null; 
			size--; //decrement count of items in the list
			return nodeToReturn;
		}
		
		//get the node before the one we want to delete
		Node nodeBeforeNodeToDelete = findNodeBefore(data);
		//case where we need to delete the head
		if (nodeBeforeNodeToDelete.data == 0) { 
			head = head.nextNode;
		}
		else if (nodeBeforeNodeToDelete!= null) { //runs if a data match was found
			if (tail.data == data) { //if data in the tail matches
				nodeBeforeNodeToDelete.nextNode = null; //deletes the node
				tail = nodeBeforeNodeToDelete; //sets tail to node before the one deleted
			}
			else { //if the data doesn't match, go to node after next node
				nodeBeforeNodeToDelete.nextNode = nodeBeforeNodeToDelete.nextNode.nextNode;
			}
			size--; //decrement count after deletion
		}

		return null;
	}
	
	public Node findNodeBefore (int data) {
		//check the first element for a match
		if (head.data == data) {
			return new Node();
		}
		//assign node as the iterator
		Node node = head;
		
		//iterate through our linked list
		while (node.nextNode != null) {
			if(node.nextNode.data == data) { //checks if next nodes data matches search key
				return node; //if match is found, return the node before node containing data.
			}
			node = node.nextNode; //load the next node
		}
		System.out.println(data + " was not found!"); //if no match is found in the list
		return null;
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
		
		while (myNode.nextNode != null) { //loop through the entire list
			myNode = myNode.nextNode; //load the next node
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
			while (node.nextNode != null) {  //loops through remaining items if they exist
				node = node.nextNode;  //sets node to the next node on each pass
				System.out.print(node.data + " ");  //prints the node
			}
		}
		else {
			System.out.println("List is empty!");
		}
	}
	
	public void reverse(MyLinkedList list) {
		Node left = null;
		Node current = list.head;
		Node right;
		
		while (current != null) {
			right = current.nextNode;
			current.nextNode = left;
			left = current;
			current = right;
		}
		list.head = left;
	}
}
