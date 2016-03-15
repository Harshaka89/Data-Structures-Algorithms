class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> A = new Stack<Integer>();
    Stack<Integer> B = new Stack<Integer>();
    
    public void push(int x) {
        A.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(B.isEmpty()){
            while(!A.isEmpty()){
                B.push(A.pop());
            }
        }
        B.pop();
    }

    // Get the front element.
    public int peek() {
        if(B.isEmpty()){
            while(!A.isEmpty()){
                B.push(A.pop());
            }
        }
        return B.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(A.isEmpty() && B.isEmpty()){
            return true;
        }
        return false;
    }
}
