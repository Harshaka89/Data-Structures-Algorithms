using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BinarySearchTree {
    class BST<T> where T: IComparable<T>{
        Node root { set; get; }

        public class Node {
            public T key;
            public Node left;
            public Node right;
            public int size;
            public Node(T key, int size) {
                this.key = key;
                this.size = 1;
            }
        }

        //put method to add key to the BST
        public void put(T key) {
            root = put(root, key);
        }
        public Node put(Node current, T key) {
            if (current == null) {
                return new Node(key, 1);
            }
            int cmp = key.CompareTo(current.key);
            if (cmp < 0) {
                current.left = put(current.left, key);
            }
            else if (cmp > 0) {
                current.right = put(current.right, key);
            }
            else {
                current.key = key;
            }
            current.size = Size(current.left) + Size(current.right) + 1;
            return current;
        }
        //delete method to delete a key from BST
        public void Delete(T key) {
            root = Delete(root, key);
        }
        public Node Delete(Node current, T key) {
            if (current == null) {
                return current;
            }
            int cmp = key.CompareTo(current.key);
            if (cmp < 0) {
                current.left = Delete(current.left, key);
            }
            else if (cmp > 0) {
                current.right = Delete(current.right, key);
            }
            else {
                if (current.left == null) {
                    return current.right;
                }
                if (current.right == null) {
                    return current.left;
                }
                Node temp = current;
                current = min(temp.right);
                current.right = DeleteMin(temp.right);
                current.left = temp.left;
            }
            current.size = Size(current.left) + Size(current.right) + 1;
            return current;
        }


        //Method to search for and return item in bst
        public T get(T key) {
            return get(root, key);
        }
        public T get(Node current, T key) {
            if (current == null) {
                throw new System.Exception("Element Not Found in BST!");
            }
            int cmp = key.CompareTo(current.key);
            if (cmp < 0) {
                return get(current.left, key);
            }
            else if (cmp > 0) {
                return get(current.right, key);
            }
            else {
                return current.key;
            }
        }
        //Returns true if element found, false otherwise
        public bool Contains(T key) {
            return Contains(root, key);
        }
        public bool Contains(Node current, T key) {
            if (current == null) {
                return false;
            }
            int cmp = key.CompareTo(current.key);
            if (cmp < 0) {
                return Contains(current.left, key);
            }
            else if (cmp > 0) {
                return Contains(current.right, key);
            }
            else {
                return true;
            }
        }

        //Methods to find minimum and maximum elements in BST
        public T min() {
            if (IsEmpty()) {
                throw new Exception("BST IS EMPTY!");
            }
            return min(root).key;
        }
        public Node min(Node current) {
            if (current.left == null) {
                return current;
            }
            return min(current.left);
        }

        public T max() {
            if (IsEmpty()) {
                throw new Exception("BST IS EMPTY");
            }
            return max(root).key;
        }
        public Node max(Node current) {
            if (current.right == null) {
                return current;
            }
            return max(current.right);
        }
        //Methods to delete minimum and maximum elements in BST
        public void DeleteMin() {
            if (IsEmpty()) {
                throw new Exception("BST IS EMPTY!");
            }
            root = DeleteMin(root);
        }
        public Node DeleteMin(Node current) {
            if (current.left == null) {
                return current.right;
            }
            current.left = DeleteMin(current.left);
            current.size = Size(current.left) + Size(current.right) + 1;
            return current;
        }
        public void DeleteMax() {
            if (IsEmpty()) {
                throw new Exception("BST IS EMPTY!");
            }
            root = DeleteMax(root);
        }
        public Node DeleteMax(Node current) {
            if (current.right == null) {
                return current.left;
            }
            current.right = DeleteMax(current.right);
            current.size = Size(current.left) + Size(current.right) + 1;
            return current;
        }

        //Print nodes of BST in order
        public void InOrder() {
            Node current = root;
            InOrder(current);
            Console.WriteLine();
        }
        public void InOrder(Node current) {
            if (current == null) {
                return;
            }
            InOrder(current.left);
            Console.Write(current.key + " ");
            InOrder(current.right);
        }
        //Track the size of the BST
        public int Size() {
            return Size(root);
        }
        public int Size(Node current) {
            if (current == null) {
                return 0;
            }
            else {
                return current.size;
            }
        }

        public bool IsEmpty() {
            if (Size() == 0) {
                return true;
            }
            return false;
        }
    }
}
