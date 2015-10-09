/*
 * DESCRIPTION:  This is an implementation of a Separate Chaining Hash Table where each slot in
 *  the array is a linked list, so that it handles collisions.
 * */
import java.util.*;
public class HashTableChain<Key, Value> {

  /***Linked List for hashing that accepts two generic arguments***/
	private class HashList<Key, Value> { //LinkedList for chaining
		private class Node{
			Key key; Value val;
			Node next;
			public Node(Key key, Value val){
				this.key = key;
				this.val = val;
			}
		}
		private Node head;
		public Value get(Key key){
			Node current = head;
			while(current != null){
				if(key.equals(current.key)){
					return current.val; //If key matches return value
				}
				current = current.next;
			}
			return null; //If key not found return null
		}
		public boolean contains(Key key){
			return get(key) != null;
		}
		public void put(Key key, Value val){
			Node newNode = new Node(key, val);
			newNode.next = head;
			head = newNode;
		}
		//Removes the key and associate value from the hashtable
		public void delete(Key key){
			head = delete(head, key);
		}
		public Node delete(Node current, Key key){
			if(current == null){ //Base case, if nothing found return null
				return null;
			}
			if(key.equals(current.key)){
				N--;
				return current.next; //If value found return next value to delete it
			}
			current.next = delete(current.next, key); //otherwise recursively call next value and try again
			return current;
		}
		//Returns all keys in linked list as an iterable
		public Iterable<Key> keys(){
			Node current = head;
			Queue<Key> queue = new LinkedList<Key>();
			while(current != null){
				queue.add(current.key);
				current = current.next;
			}
			return queue;
		}
	}
	
	/***Hash Table Member Variables***/
	private int M; int N ; 
	private static final int INIT_CAPACITY = 4;
	private HashList<Key, Value>[] chain;
	/*Hash Table Constructors*/
	public HashTableChain(){
		this(INIT_CAPACITY);
	}
	public HashTableChain(int M){
		this.M = M;
		int N = 0;
		chain = (HashList<Key, Value>[]) new HashList[M]; //Cast needed, Java prohibits generic arrays
		for(int i = 0; i < M; i++){
			chain[i] = new HashList(); //Initialize Array of objects
		}
	}
	/*The Hash Method*/
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	/*Get method will return value associated with key if it exists, null if it doesnt*/
	public Value get(Key key){
		int i = hash(key);
		return chain[i].get(key);
	}
	/*Checks if Key is in the hashtable returns true if it is, otherwise false*/
	public boolean contains(Key key){
		return get(key) != null;
	}
	/*Put method will insert a key value pair into the hash table*/
	public void put(Key key, Value val){
		if(N+1 == M){
			resize(2*M);
		}
		int i = hash(key);
		chain[i].put(key, val);
		N++;
	}
	/*Delete method will remove key and associated value from hashtable*/
	public void delete(Key key){
		int i = hash(key);
		if(chain[i].contains(key)){
			N--;
		}
		chain[i].delete(key);
		
		if(M > INIT_CAPACITY && N <= 2*M){
			resize(M/2);
		}
	}
	/*Resize will resize the array as needed*/
	private void resize(int newLength){
		HashTableChain<Key, Value> temp = new HashTableChain<Key, Value>(newLength);
		for(int i = 0; i < M; i++){
			for(Key key: chain[i].keys()){
				temp.put(key, chain[i].get(key));
			}
		}
		this.M = temp.M; //Update size of hashtable
		this.N = temp.N; //Update count of Key Value pairs
		this.chain = temp.chain; //Point to new chain
	}
	public Iterable<Key> keys(){
		Queue<Key> queue = new LinkedList<Key>();
		for(int i = 0; i < M; i++){
			for(Key key: chain[i].keys()){
				queue.add(key);
			}
		}
		return queue;
	}
	/*Methods to get size and test if empty*/
	public int Size(){
		return N;
	}
	public boolean isEmpty(){
		return Size() == 0;
	}
	
	
	/***Main method for testing***/
	public static void main(String[] args){
		HashTableChain<String, Integer> hash = new HashTableChain<String, Integer>();
		hash.put("one", 1);
		hash.put("two", 2);
		hash.put("three", 3);
		hash.put("four", 4);
		hash.put("five", 5);
		hash.put("six", 6);
		
		for(String x : hash.keys()){
			System.out.println(x + ": " + hash.get(x));
		}
		System.out.println("\n\n");
		hash.delete("three");
		for(String x : hash.keys()){
			System.out.println(x + ": " + hash.get(x));
		}
		System.out.println(hash.contains("three"));
	}
}
