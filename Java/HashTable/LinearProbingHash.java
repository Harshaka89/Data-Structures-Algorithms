/*  DESCRIPTION: Implementation of a HashTable that uses LinearProbing to avoid collisions.
*/
import java.util.LinkedList;
import java.util.Queue;


public class HashTableLinearProbe<Key, Value> {
	private static final int INIT_CAPACITY = 4;
	private int N; //Number of key-value pairs in hashtable
	private int M; //Size of linear probing table
	private Key[] keys; //The keys
	private Value[] vals; //The values
	
	/*Constructors*/
	public HashTableLinearProbe(){
		this(INIT_CAPACITY);
	}
	public HashTableLinearProbe(int M){
		this.M = M; 
		int N = 0;
		keys = (Key[])new Object[M];
		vals = (Value[]) new Object[M];
	}
	/* Hash Function returns value between 0 and M-1 */
	private int hash(Key key){
		return(key.hashCode() & 0x7fffffff) % M;
	}
	/*Insert item into the hashtable*/
	public void put(Key key, Value val){
		if(N + 1 == M){
			resize(2*M);
		}
		int i; //Declared outside for loop to update key and val at end
		for(i = hash(key); keys[i] != null; i = (i+1) % M){ 
			/*if(keys[i].equals(key)){ //This code will make it a HashSet
				vals[i] = val;
				return;
			}*/ 
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	/*Search for and return associated value of given key in the hashtable*/
	public Value get(Key key){
		for(int i = hash(key); keys[i] != null; i = (i + 1) % M){
			if(keys[i].equals(key)){ //If key found return associated value
				return vals[i];
			}
		}
		return null; //If not found return null
	}
	/*Checks if Key is in the hashtable returns true if it is, otherwise false*/
	public boolean contains(Key key){
		return get(key) != null;
	}
	/*Delete method will remove the key and associated value from the hashtable*/
	public void delete(Key key){
		if(!contains(key)){
			return;
		}
		int i = hash(key);
		while(!key.equals(keys[i])){
			i = (i + 1) % M;
		}
		keys[i] = null; //Delete key and value
		vals[i] = null;
		
		// Now we must rehash all the keys in the same cluster
		i = (i + 1) % M;
		while(keys[i] != null){
			Key keyToRehash = keys[i];
			Value valToRehash = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--; //Decrement count for each
			put(keyToRehash, valToRehash);
			i = (i + 1) % M;
		}
		N--; //Decrease count for key value pair deleted
		if(N > 0 && N <= M/8){
			resize(M/2);
		}
	}
	
	/*Resize will resize the array as needed*/
	public void resize(int newSize){
		HashTableLinearProbe<Key, Value> temp = new HashTableLinearProbe<Key, Value>(newSize);
		for(int i = 0; i < M; i++){
			if(keys[i] != null){
				temp.put(keys[i], vals[i]); //Copy values to larger hashtable
			}
		}
		keys = temp.keys; //point to new keys array
		vals = temp.vals; //point to new vals array
		M = temp.M; //update size of hashtable
	}
	public Iterable<Key> keys(){
		Queue<Key> queue = new LinkedList<Key>();
		for(int i = 0; i < M; i++){
			if(keys[i] != null){
				queue.add(keys[i]);
			}
		}
		return queue;
	}
	
	public static void main(String[] args){
		HashTableLinearProbe<String, Integer> hash = new HashTableLinearProbe<String,Integer>();
		hash.put("one", 1);
		hash.put("two", 2);
		hash.put("three", 3);
		hash.put("four", 4);
		hash.put("five", 5);
		hash.put("six", 6);
		
		for(String x : hash.keys()){
			System.out.println(x + ": " + hash.get(x));
		}
		hash.delete("four");
		System.out.println("\n\n");
		for(String x : hash.keys()){
			System.out.println(x + ": " + hash.get(x));
		}
	}
}
