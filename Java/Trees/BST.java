import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>> {
	public Node root;
	public class Node{
		Key key;
		int size;
		Node left, right;
		Node(Key key, int size){
			this.key = key;
			this.size = size;
		}
	}
	
	/*Method to return the value stored at a given key in the BST, if not found it returns null*/
	public Key get(Key key){
		return get(root, key);
	}
	private Key get(Node current, Key key){
		if(current == null){
			return null;
		}
		int cmp = key.compareTo(current.key);
		if(cmp < 0){
			return get(current.left, key);
		}
		else if(cmp > 0){
			return get(current.right, key);
		}
		else{
			return current.key;
		}
	}
	
	/*Method that will search through the tree to find a key, if it finds it the value of the key
	 * will be updated.  If the key isn't found a new node will be created that will store the value.*/
	public void put(Key key){
		root = put(root, key);
	}
	private Node put(Node current, Key key){
		if(current == null) { //If key isnt found current will be null so we will create a new node
			return new Node(key, 1);
		}
		int cmp = key.compareTo(current.key); //compare key passed in, with key of the current node
		if(cmp < 0){ //If key passed in is less than current node go left on the tree
			current.left = put(current.left, key);
		}
		else if(cmp > 0){ //if key passed in is greater than current node go right on the tree
			current.right = put(current.right, key);
		}
		else{ //if key passed in is equal to the current node, update it with the new value
			current.key = key;
			return current;
		}
		//Get the count from left of tree and right of tree and increment by one for the new node.
		current.size = Size(current.left) + Size(current.right) + 1; 
		return current; 
	}
	
	/* Methods to find and return the smallest key in the BST */
	public Key min(){
		if(isEmpty()){
			throw new NoSuchElementException("Called min() when BST is empty!");
		}
		return min(root).key; //return the key of the smallest Node.
	}
	public Node min(Node current){ //Finds smallest key in the BST
		if(current.left == null){ //If smallest then return smallest Node
			return current;
		}
		else{ //otherwise return next smallest node in the tree
			return min(current.left);
		}
	}
	/* Methods to find and return the largest key in the BST */
	public Key max(){ 
		if(isEmpty()){
			throw new NoSuchElementException("Called max() when BST is empty!");
		}
		return max(root).key;
	}
	public Node max(Node current){
		if(current.right == null){
			return current;
		}
		else {
			return max(current.right);
		}
	}
	
	/*METHODS TO DELETE NODES FROM A BST*/
	
	//Removes the smallest key and associated value from the BST
	public void deleteMin(){ 
		if(isEmpty()){
			throw new NoSuchElementException("Called deleteMin() when BST is empty!");
		}
		root = deleteMin(root);
	}
	private Node deleteMin(Node current){
		if(current.left == null){
			return current.right;
		}
		current.left = deleteMin(current.left);
		current.size = Size(current.left) + Size(current.right) + 1;
		return current;
	}
	//Removes the largest key and associate value from the BST
	public void deleteMax(){
		if(isEmpty()){
			throw new NoSuchElementException("Called deleteMin() when BST is empty!");
		}
		root = deleteMax(root);
	}
	private Node deleteMax(Node current){
		if(current.right == null){
			return current.left;
		}
		current.right = deleteMax(current.right);
		current.size = Size(current.left) + Size(current.right) + 1;
		return current;
	}
	//Removes the key and associated value from the BST if it exists
	public void delete(Key key){
		root = delete(root, key);
	}
	private Node delete(Node current, Key key){
		if(current == null){  //If node isn't found return null
			return null;
		}
		int cmp = key.compareTo(current.key); //compare key passed in with key of current node
		if(cmp < 0){ //if key smaller than current node go left
			current.left = delete(current.left, key);
		}
		else if(cmp > 0){ //if key larger than current node go right
			current.right = delete(current.right, key);
		}
		else{ //if key matches current node proceed with delete
			if(current.right == null){
				return current.left;
			}
			if(current.left == null){
				return current.right;
			}
			Node temp = current; //saves link to the node which will be deleted
			current = min(temp.right); //sets the node to be deleted to its successor t.right
			current.right = deleteMin(temp.right);
			current.left = temp.left;
		}
		current.size = Size(current.left) + Size(current.right)+ 1; //update size
		return current;
	}
	/*Method to keep track of size.*/
	public int Size(){
		return Size(root);
	}
	private int Size(Node current){
		if(current == null){ //if size is zero 
			return 0;
		}
		else {
			return current.size;
		}
	}
	public boolean isEmpty(){
		if( Size() == 0){
			System.out.println("BST IS EMPTY!");
			return true;
		}
		return false;
	}
	//Method to get the height of a BST
	public int getHeight(){
		int H = 0;
		return height(root, H);
	}
	public int height(Node root, int H){
		if(root == null){
			return H;
		}
		return Math.max(height(root.left, H+1), height(root.right, H+1));
	}
	/* METHODS TO PRINT THE NODE VALUES IN THE BST*/
	public void printInOrder(){
		printInOrder(root);
		System.out.println();
	}
	public void printInOrder(Node current){
		if(current == null){
			return;
		}
		printInOrder(current.left);
		System.out.print(current.key + " ");
		printInOrder(current.right);
		
	}
	public void printPreOrder(){
		printPreOrder(root);
		System.out.println();
	}
	public void printPreOrder(Node current){
		if(current == null){
			return;
		}
		System.out.println(current.key + " ");
		printPreOrder(current.left);
		printPreOrder(current.right);
	}
	public void printPostOrder(){
		printPostOrder(root);
		System.out.println();
	}
	public void printPostOrder(Node current){
		if(current == null){
			return;
		}
		printPostOrder(current.left);
		printPostOrder(current.right);
		System.out.println(current.key);
	}
}
