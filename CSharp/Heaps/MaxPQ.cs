using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructures {
    class MaxPQ<T> where T: IComparable<T> {
        private T[] pq;
        private int N;
        //Constructor
        public MaxPQ() {
            pq = new T[101];
            N = 0;
        }
        //Return MAX Value
        public T Max() {
            if (IsEmpty()) {
                throw new InvalidOperationException("Priority Queue Empty");
            }
            return pq[1];
        }
        //Insert Value into Heap
        public void Enqueue(T val) {
            if (N >= pq.Length + 1) {
                resize(2 * pq.Length);
            }
            pq[++N] = val;
            swim(N);
        }
        //Remove Max value from heap
        public T Dequeue() {
            if (IsEmpty()) {
                throw new InvalidOperationException("Priority Queue Empty");
            }
            T max = pq[1];
            Swap(1, N--);
            sink(1);
            if ((N > 0) && (N == (pq.Length - 1) / 4)) {
                resize(pq.Length / 2);
            }
            return max;
        }
        //Swim and Sink Helper Methods
        private void swim(int k) {
            while (k > 1 && Less(k / 2, k)) {
                Swap(k, k/2);
                k = k / 2;
            }
        }
        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && Less(j, j + 1)) {
                    j++;
                }
                if (!Less(k, j)) {
                    break;
                }
                Swap(k, j);
                k = j;
            }
        }
        //Less and Swap helper methods
        private bool Less(int i, int j) {
            int cmp = pq[i].CompareTo(pq[j]);
            if (cmp < 0) {
                return true;
            }
            return false;
        }
        private void Swap(int i, int j) {
            T temp = pq[i];
            pq[i] = pq[j];
            pq[j] = temp;
        }
        //Utility Methods
        public bool IsEmpty() {
            return N == 0;
        }
        public int Count() {
            return N;
        }
        public void resize(int newLength) {
            T[] temp = new T[newLength];
            for (int i = 1; i <= N; i++) {
                temp[i] = pq[i];
            }
            pq = temp;
        }
    }
}
