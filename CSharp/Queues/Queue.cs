using System;
namespace MyQueue {
    class Queue<T> {
        public class Node{
            public T data;
            public Node next;
            public Node(T data){
                this.data = data;
            }
        }
        Node head {get; set;}
        Node tail {get; set;}
        int size {get; set;}

        /* Methods to add */
        public void Enqueue(T data){
            Node newNode = new Node(data);
            if(tail == null){
                head = newNode; 
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        /* Methods to delete */
        public T Dequeue(){
            if(IsEmpty()){
                throw new Exception("Queue is empty!");
            }
            T data = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            }
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
