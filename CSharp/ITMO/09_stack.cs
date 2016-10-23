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
        public class MyStack {
            public class Node {
                public int data;
                public Node next;
                public Node(int data) {
                    this.data = data;
                }
            }
            Node head;

            public void push(int val) {
                Node newNode = new Node(val);
                newNode.next = head;
                head = newNode;
            }
            public int pop() {
                int data = head.data;
                head = head.next;
                return data;
            }
        }
        static void Main(string[] args) {
            string[] text = File.ReadAllText("stack.in").Split('\n');
            int N = int.Parse(text[0]);
            StringBuilder result = new StringBuilder();
            MyStack stack = new MyStack();
            for (int i = 1; i < text.Length; i++) {
                string[] temp = text[i].Split(' ');
                if (temp[0].Length == 0) {
                    break;
                }
                if (temp[0][0] == '+') {
                    stack.push(int.Parse(temp[1]));
                }
                else if (temp[0][0] == '-') {
                    result.Append("" + stack.pop() + "\r\n");
                }
            }
            System.IO.File.WriteAllText("stack.out", result.ToString() + "");
        }
    }
}
