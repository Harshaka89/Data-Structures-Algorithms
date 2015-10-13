/* Implementation of a MinHeap Priority Queue in Java
*/
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPQ<Key> implements Iterable<Key> {
	private Key[] pq;
	private int N;
	private Comparator<Key> comparator;
	
/***************************************************************************
*  Constructors
***************************************************************************/	
	public MinPQ(int capacity) {
		pq = (Key[]) new Object[capacity + 1];
		N = 0;
	}
	public MinPQ(){ 
		this(1);
	}
	public MinPQ(int capacity, Comparator<Key> comparator){
		this.comparator = comparator;
		pq = (Key[]) new Object[capacity + 1];
		N = 0;
	}
	public MinPQ(Comparator<Key> comparator){
		this(1, comparator);
	}
	
/***************************************************************************
*  Return MIN Value
***************************************************************************/
	public Key min(){
		if(isEmpty()){
			throw new NoSuchElementException("Priority Queue Underflow!");
		}
		return pq[1];
	}

/***************************************************************************
*  Insert Value Into Heap
***************************************************************************/	
	public void insert(Key x){
		if(N == pq.length + 1){
			resize(2*pq.length);
		}
		pq[++N] = x;
		swim(N);
	}
/***************************************************************************
*  Delete MIN value in Heap
***************************************************************************/
	public Key delMin(){
		if(isEmpty()){
			throw new NoSuchElementException("Priority Queue Underflow!");
		}
		exch(1, N);
		Key min = pq[N--];
		sink(1);
		pq[N+1] = null;
		if((N > 0) && (N ==(pq.length -1)/4)){
			resize(pq.length/2);
		}
		return min;
	}
/***************************************************************************
*  Helper Methods Swim and Sink
***************************************************************************/
	private void swim(int k){
		while(k > 1 && greater(k/2, k)){
			exch(k, k/2);
			k = k/2;
		}
	}
	private void sink(int k){
		while(2*k <= N){
			int j = 2*k;
			if(j < N && greater(j, j+1)){
				j++;
			}
			if(!greater(k,j)){
				break;
			}
			exch(k, j);
			k = j;
		}
	}
	
/***************************************************************************
*  Helper Methods Swim and Sink
***************************************************************************/
	private boolean greater(int i, int j){
		if(comparator == null){
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
		}
		else{
			return comparator.compare(pq[i], pq[j]) > 0;
		}
	}
	private void exch(int i, int j){
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
/***************************************************************************
*  Iterator Method
***************************************************************************/
	public Iterator<Key> iterator(){
		return new HeapIterator();
	}
	private class HeapIterator implements Iterator<Key>{
		private MinPQ<Key> copy;
		public HeapIterator(){
			if(comparator == null){
				copy = new MinPQ<Key>(size());
			}
			else{
				copy = new MinPQ<Key>(size(), comparator);
			}
			for(int i = 1; i <= N; i++){
				copy.insert(pq[i]);
			}
		}
		public boolean hasNext(){
			return !copy.isEmpty();
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
		public Key next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			return copy.delMin();
		}
	}
/***************************************************************************
*  Utility Methods
***************************************************************************/	
	public boolean isEmpty(){
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void resize(int newLength){
		Key[] temp = (Key[]) new Object[newLength];
		for(int i = 1; i <= N; i++){
			temp[i] = pq[i];
		}
		pq = temp;
	}
/***************************************************************************
*  Main Method For Testing
***************************************************************************/
	public static void main(String[] args){
		MinPQ<Integer> pq = new MinPQ<Integer>(8);
		pq.insert(88);
		pq.insert(15);
		pq.insert(4);
		pq.insert(8);
		pq.insert(2);
		
		System.out.println(pq.min());
		pq.delMin();
		System.out.println(pq.min());
	}
}
