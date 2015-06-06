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
        //Method delete() takes an int argument k and deletes the kth element in a linked list if it exists
        public void delete(int k)
        {
            if (isEmpty()) //Checks if list is empty
            {
                Console.WriteLine("List is empty!");
                return;
            }
            int count = 1; //If not empty start count at 1
            Node current = head; //Set pointer to the head node in the list
            if (k < 1 || k > size) //Checks if k is a valid node number in the list
            {
                Console.WriteLine("Item {0} not found", k);
                return;
            }
            if (k == 1) //If k is the head delete head
            {
                head = current.next;
                size--;
                return;
            }
            //Traverse through the list and find the element before the one we want to delete
            while (current.next.next != null && count + 1 < k)
            {
                current = current.next;
                count++;
            }
            current.next = current.next.next; //Delete element k
            size--; //decrement size

        }
        /*  Method find() takes a linked list and a key as its argument and returns true if some node in the
            list has the key as its data field, false otherwise. 
         */
        public bool find(MyLinkedList list, Object key)
        {
            if (isEmpty()) //Checks if list is empty
            {
                Console.WriteLine("List is empty!");
                return false;
            }
            Node current = list.head; //Set pointer to first node in the list
            if (current.data.Equals(key)) //Check if data in first node equals the key
            {
                return true;
            }
            while (current != null && current.data.Equals(key) == false) //Loop through list until data is found
            {
                current = current.next;
            }
            if (current == null) //If data isn't found return false
            {
                return false;
            }
            return true; //If data was found, current wont be null and so we return true
        }
        
        /*  Function reverse() takes the first node in a list as an argument and reverses the list returning the 
         *  first Node in the result.
         */
        public Node reverse(Node first)
        {
            Node prev = null; 
            Node current = first;
            Node next;
            while (current != null)
            {
                next = current.next; //Points to the element next to current element
                current.next = prev; 
                prev = current;
                current = next;
            }
            head = prev; //Set lists head node to point to the new first node in the reversed list
            first = head; //Set first to point to first element of the reversed list
            return first;
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
