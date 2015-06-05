using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructures
{
    class MyLinkedList
    {
        public class Node
        {
            public Object data;
            public Node next;
            public Node(Object data) //Initialize data with data passed to constructor
            {
                this.data = data;
            }
        }

        Node head, tail; //Declare head and tail nodes
        int size;
        public MyLinkedList() //Constructor that initializes size
        {
            size = 0;
        }

        /*
         *  Linked List Problems  
         */

        //Adds an item to the head of the list
        public void addToHead(Object data)
        {
            Node newNode = new Node(data);
            newNode.next = head; //Links node next to the newNode to current head
            head = newNode; //Links head to the newNode which adds it to the list
            if (tail == null)
            {
                tail = newNode;
            }

            size++;
        }

        //Adds an item to the end of the list
        public void addToTail(Object data)
        {
            Node newNode = new Node(data);
            if (tail == null) //If the list is empty set head and tail to the new node
            {
                head = newNode;
                tail = newNode;
            }
            else //If the list is not empty
            {
                tail.next = newNode; //set link to the newNode
                tail = newNode; //set tail to the newNode
            }
            size++; //increment size
        }

        //Deletes the first node in the list
        public void removeHead()
        {
            if (isEmpty())
            {
                Console.WriteLine("List is empty!");
                return;
            }
            head = head.next; //Deletes the current head
            size--; //decrements size
            if (size == 0)
            {
                tail = null; //If list is empty set tail to null
            }
        }
        //Deletes the last node in the list
        public void removeTail()
        {
            if (isEmpty())
            {
                Console.WriteLine("List is empty!");
                return;
            }
            Node current = head;
            while (current.next.next != null)
            {
                current = current.next; //traverse through list
            }
            current.next = current.next.next; //deletes element next to current
            size--;
        }

        //Checks if the list is empty
        public bool isEmpty()
        {
            if (size == 0)
            {
                return true;
            }
            return false;
        }
        //Returns the number of nodes in the list
        public int Size()
        {
            return size;
        }
        //Prints all nodes on the list
        public void printList()
        {
            if (isEmpty())
            {
                Console.WriteLine("List is empty!");
                return;
            }

            Node current = head;
            while (current != null)
            {
                Console.Write("{0} ", current.data);
                current = current.next;
            }
            Console.WriteLine();
        }
    }
}
