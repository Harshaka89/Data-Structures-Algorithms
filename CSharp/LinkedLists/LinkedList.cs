using System;
namespace MyLinkedList {
    class LinkedList<T> {
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
        public void AddHead(T data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            if(tail == null){
                tail = newNode;
            }
            size++;
        }
        public void AddTail(T data){
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
        public T RemoveHead(){
            if(IsEmpty()){
                throw new Exception("List is empty!");
            }
            T data = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            }
            size--;
            return data;
        }
        public T RemoveTail(){
            if(IsEmpty()){
                throw new Exception("List is empty!");
            }
            if(size == 1){
                return RemoveHead();
            }
            Node current = head;
            while(current.next.next != null){
                current = current.next;
            }
            T data = current.next.data;
            current.next = current.next.next;
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
