/*
 * This is an implementation of a queue data structure using arrays
 * A queue is FIFO.  
 */
 
 import java.util.NoSuchElementException;
 
public class MyQueue<T> {
	private T[] queue;
	private int first, last, size;
	
	@SuppressWarnings("unchecked")
	public MyQueue(){ //Must cast the array since there are no generic arrays
		queue =(T[]) new Object[2];
		first = 0;
		last= 0;
		size = 0;
	}
	
	public void enqueue(T data){
		if(size + 1 == queue.length){ //Resizes the array if needed
			resize(2*queue.length);
		}
		queue[last++] = data; //Adds data to the array then increments
		if(last == queue.length){ //wraps around to use unused spaces at beginning of array
			last = 0;
		}
		size++;
		
	}
	public T dequeue(){
		if(isEmpty() == true){
			throw new NoSuchElementException("Queue is empty!");
		}
		T dataToRemove = queue[first];
		queue[first] = null;
		size--;
		first++;
		if(first == queue.length) { //Wraps around if needed
			first = 0;
		}
		if(size > 0 && size == queue.length/4){ //If needed resize array to make it smaller
			resize(queue.length/2);
		}
		return dataToRemove;
	}
	public T peek(){ //Returns the item least recently added to the queue
		if(isEmpty() == true){
			throw new NoSuchElementException("Queue is empty!");
		}
		return queue[first];
	}
	public boolean isEmpty(){ //will return true if no items in queue
		return size == 0; 
	}
	public int size(){ //Will return the count of items in the queue
		return size;
	}
	public void resize(int newLength){ //Resizes the array as needed
		@SuppressWarnings({ "unchecked"})
		T[] temp = (T[]) new Object[newLength];
		
		for(int i = 0; i < queue.length; i++) {
			temp[i] = queue[i];
		}
		queue = temp;
		first = 0;
		last = size;
	}
}
