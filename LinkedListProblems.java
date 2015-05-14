/*
 * Linked List problems from Sedgewicks Algorithms 4th ed. The Node class, 
 * head, tail and size methods are located in the MyLinkedList.java file.
 */
public class LinkedListProblems {
	
	/*  1.3.19
	 *  Description: Give a code fragment that removes the last node
	 *  in a linked list whose first node is "first".
	 */
	public void removeLast(){
		Node first = head;
		if(size == 0){
			System.out.println("List is empty!");
			return;
		}
		else if(size == 1){
			head = null;
			size--;
			return;
		}
	
		while(first.next.next != null){
			first = first.next;
		}
		first.next = first.next.next;
		size--;
	}
	
	/*  1.3.20
	 *  Description: Write a method delete() that takes an int argument "k" and
	 *  deletes the kth element in a linked list, if it exists.
	 */
	public void delete(int k){
		Node current = head;
		int count = 1;
		if(size == 0){
			System.out.println("List empty!");
			return;
		}
		if(k > size){
			System.out.println("Element doesn't exist");
			return;
		}
		else if(k == 1){
			head = head.next;
			size--;
			return;
		}
		else if(k == size){
			removeLast();
			return;
		}
		while(count < k-1 && current.next!=null){
			current = current.next;
			count++;
		}
		current.next = current.next.next;
		size--;
	}
	
	/*  1.3.21
	 *  Description: Write a method find() that takes a linked list and a string key
	 *  as arguments and returns true if some node in the list has key as its item
	 *  field, false otherwise.
	 */
	public boolean find(MyLinkedList list, String key) {
		Node current = list.head;
		if(size == 0){
			return false;
		}
		if(head.data.equals(key)){
			return true;
		}
		while(current.next != null){
			current = current.next;
			if(current.data.equals(key)){
				return true;
			}
		}
		return false;
	}
	
	/*  1.3.24
	 *  Description: Write a method removeAfter() that takes a linked-list Node as
	 *  argument and removes the node following the given one(and does nothing if the
	 *  argument of the next field in the argument node is null).
	 */
	public void removeAfter(Node myNode){
		if(myNode != null && myNode.next != null){
			if(myNode.next.next == null){
				tail = myNode;
			}
			myNode.next = myNode.next.next;
			size--;
		}
	}
	
	/*  1.3.25
	 *  Description: Write a method insertAfter() that takes two linked-list Node
	 *  arguments and inserts the second after the first on its list (and does nothing
	 *  if either argument is null). 
	 */
	public void insertAfter(Node location, Node insert){
		if(location != null && insert != null){
			if(tail == location){
				tail = insert;
			}
			insert.next = location.next;
			location.next = insert;
			size++;
		}
	}
	
	/*  1.3.26
	 *  Description: Write a method remove() that takes a linked list and a string key
	 *  as arguments and removes all of the nodes in the list that have key as its
	 *  item field.  
	 */
	public void remove(MyLinkedList list, String key){
		Node current = list.head;
		while(current.next != null && current.data.equals(key)){
			if(current.data.equals(key)){
				head = current.next;
				current = current.next;
				size--;
			}
		}
		while(current.next.next != null){
			if(current.next.data.equals(key)){
				while(current.next.next != null && current.next.data.equals(key)){
				current.next = current.next.next;
				size--;
				}
			}
			current = current.next;
		}
		if(current.next.data.equals(key)){
			current.next = null;
			size--;
		}
	}
	
	/*  1.3.27
	 *  Description: Write a method max() that takes a reference to the first node in
	 *  a linked list as an argument and returns the value of the maximum key in the
	 *  list.  Assume that all keys are positive integers, return 0 if empty.
	 */
	public int max(Node first){
		if(size == 0){
			return 0;
		}
		Node current = first;
		T max = current.data;
		while(current != null){
			if(((Comparable) max).compareTo(current.data) < 0){
				max = current.data;
			}
			current = current.next;
		}
		int result = (Integer)max;
		return result;
	}
	
	/*  1.3.29
	 *  Description: Write a function that takes the first Node in a linked list as
	 *  argument and (destructively) reverses the list, returning the first Node
	 *  in the result.
	 */
	public Node reverse(Node first){
		Node prev = null;
		Node current = first;
		Node next;
		if(size == 0){
			System.out.println("empty");
			return first;
		}
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		first = head;
		return first;
	}
}
