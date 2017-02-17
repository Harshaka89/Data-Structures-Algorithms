using System;
namespace MyStack {
    class Stack<T> {
        public class Node{
            public T data;
            public Node next;
            public Node(T data){
                this.data = data;
            }
        }
        Node head {get; set;}
        int size {get; set;}

        /* Methods to add */
        public void Push(T data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            size++;
        }

        /* Methods to delete */
        public T Pop(){
            if(IsEmpty()){
                throw new Exception("Stack is empty!");
            }
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }

        /* Utility Methods */
        public bool IsEmpty(){
            return size == 0;
        }
        public void print(){
            if(IsEmpty()){
                return;
            }
            Node current = head;
            while(current != null){
                Console.WriteLine(current.data);
                current = current.next;
            }
        }
    }
}
