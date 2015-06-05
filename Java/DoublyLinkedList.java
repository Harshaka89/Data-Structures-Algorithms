/* 
 * An implementation of a doubly linked list
 */


public class DoublyLinkedList {
	Node head, tail;
	int size = 0;
	
	/*
	 * Methods to add nodes to a doubly linked list
	 */
	public void addHead(int data){
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			size++;
			return;
		}
		head.previous = newNode;
		newNode.next = head;
		head = newNode;
		size++;
	}
	/*
	 * Methods to print the doubly linked list
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
	public void reversePrint(){
		Node current = head;
		if(current == null) {
			return;
		}
		while(current.next != null) { //goes to last node in list
			current = current.next;
		}
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.previous;
		}
		System.out.println();
	}
	
}
