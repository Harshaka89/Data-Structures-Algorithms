
public class MyLinkedList {
	
	Node head, tail;
	int size = 0;

	public void add(int data) {
		Node myNode = new Node(data);
		
		if (tail == null) {
			head = myNode;
			tail = myNode;
		}
		else {
			tail.nextNode = myNode;
			tail = myNode;
		}
		size++;
	}
	
	public Node delete(int data) {
		Node nodeToReturn = null;
		if (size == 0) {
			return null;
		}
		if (size == 1) {
			nodeToReturn = head;
			head = null;
			tail = null;
			size--;
			return nodeToReturn;
		}
		
		Node nodeBeforeNodeToDelete = findNodeBefore(data);
		//case where we need to delete the head
		if (nodeBeforeNodeToDelete.data == 0) {
			head = head.nextNode;
		}
		else if (nodeBeforeNodeToDelete!= null) {
			if (tail.data == data) { //handles last item
				nodeBeforeNodeToDelete.nextNode = null;
				tail = nodeBeforeNodeToDelete;
			}
			else {
				nodeBeforeNodeToDelete.nextNode = nodeBeforeNodeToDelete.nextNode.nextNode;
			}
			size--;
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
			if(node.nextNode.data == data) {
				return node;
			}
			node = node.nextNode;
		}
		
		return null;
	}
	
	public Node find(int data) {
		if (head == null) {
			return null;
		}
		if (head.data == data) {
			System.out.println(data + " was found!");
			return head;
		}
		Node myNode = head;
		
		while (myNode.nextNode != null) {
			myNode = myNode.nextNode;
			if (myNode.data == data) {
				System.out.println(data + " was found!");
				return myNode;
			}
		}
		System.out.println(data + " was not found!");
		return null;
	}
	
	public void traverse() {
		if (head != null) {
			Node node = head;
			System.out.print(node.data + " ");
			while (node.nextNode != null) {
				node = node.nextNode;
				System.out.print(node.data + " ");
			}
		}
	}

}
