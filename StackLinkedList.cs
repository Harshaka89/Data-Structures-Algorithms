using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructures
{
    class LinkedListStack
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
        public Node top;
        public int size;
        public LinkedListStack()
        {
            size = 0;
        }

        public void push(Object data)
        {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            size++;
        }

        public Object pop()
        {
            if (isEmpty())
            {
                return null;
            }
            Object deletedNode = top.data;
            top = top.next;
            size--;
            return deletedNode;
        }
        public Object peek()
        {
            if (isEmpty())
            {
                return null;
            }
            return top.data;
        }
        public Boolean isEmpty()
        {
            if (size == 0)
            {
                Console.WriteLine("List is empty!");
                return true;
            }
            return false;
        }
        public int Size()
        {
            return size;
        }
        public void printStack()
        {
            if (isEmpty())
            {
                return;
            }
            Node current = top;
            while (current != null)
            {
                Console.Write("{0} ", current.data);
                current = current.next;
            }
            Console.WriteLine();
        }
    }
}
