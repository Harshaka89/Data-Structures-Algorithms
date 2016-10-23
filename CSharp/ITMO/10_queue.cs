using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Collections;
using System.IO;

namespace ITMO {
    class Program {
        public class MyQueue {
            public class Node {
                public int data;
                public Node next;
                public Node(int data) {
                    this.data = data;
                }
            }
            Node head; Node tail;

            public void enqueue(int val) {
                Node newNode = new Node(val);
                if (tail == null) {
                    newNode.next = head;
                    head = newNode;
                    tail = head;
                }
                else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
            public int dequeue() {
                int data = head.data;
                head = head.next;
                if (head == null) {
                    tail = null;
                }
                return data;
            }
        }
        static void Main(string[] args) {
            string[] text = File.ReadAllText("queue.in").Split('\n');
            int N = int.Parse(text[0]);
            StringBuilder result = new StringBuilder();
            MyQueue Q = new MyQueue();
            for (int i = 1; i < text.Length; i++) {
                string[] temp = text[i].Split(' ');
                if (temp[0].Length == 0) {
                    break;
                }
                if (temp[0][0] == '+') {
                    Q.enqueue(int.Parse(temp[1]));
                }
                else if (temp[0][0] == '-') {
                    result.Append("" + Q.dequeue() + "\r\n");
                }
            }
            System.IO.File.WriteAllText("queue.out", result.ToString() + "");
        }
    }
}
