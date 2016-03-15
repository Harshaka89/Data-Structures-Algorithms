/*DESCRIPTION:  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
  NOTE: This version is done without the Java library.
*/
class MinStack {
    public class Node{
        int data;
        Node next;
        Node(int x){
            this.data = x;
        }
    }
    Node head; Node minHead;
    int size, minSize;
    public MinStack(){
        size = 0;
        minSize = 0;
    }
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
        if(minSize == 0 || x <= minHead.data){
            newNode = new Node(x);
            newNode.next = minHead;
            minHead = newNode;
            minSize++;
        }
    }

    public void pop() {
        if(size != 0){
            if(head.data == minHead.data){
                minHead = minHead.next;
                minSize--;
            }
            head = head.next;
            size--;
        }
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return minHead.data;
    }
}
