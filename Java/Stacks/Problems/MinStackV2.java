/*DESCRIPTION:  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
  NOTE: This version is done WITH the Java library.
*/
class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    Integer smallest;
    public MinStack(){
        smallest = Integer.MAX_VALUE;
    }
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int x = stack.pop();
        if(x == min.peek()){
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
