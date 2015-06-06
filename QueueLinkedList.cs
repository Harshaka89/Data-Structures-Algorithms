using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructures
{
    class LinkedListQueue
    {
        public class Node
        {
            public Node next;
            public Object data;
            public Node(Object data)
            {
                this.data = data;
            }
        }
        Node first,last;
        int size;
        public LinkedListQueue()
        {
            size = 0;
        }

        public void enqueue(Object data)
        {
            Node oldLast = last;
            last = new Node(data);
            last.next = null;
            if (size == 0)
            {
                first = last;
            }
            else
            {
                oldLast.next = last;
            }
            size++;
        }

        public Object dequeue()
        {
            Object deletedData = first.data;
            first = first.next;
            if(size == 0)
            {
                last = null;
            }
            size--;
            return deletedData;
        }
        public void printQueue()
        {
            Node current = first;
            while (current != null)
            {
                Console.Write("{0} ", current.data);
                current = current.next;
            }
            Console.WriteLine();
        }
        public Object peek()
        {
            return first.data;
        }
        public bool isEmpty()
        {
            if (size == 0)
            {
                Console.WriteLine("Queue is empty!");
                return true;
            }
            return false;
        }
        public int Size()
        {
            return size;
        }
    }
}
