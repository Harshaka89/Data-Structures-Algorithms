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
        public static int minCoins(int[] coins, int N, int V) {
            int[] table = new int[V + 1];
            table[0] = 0; //If V is 0 this will be base case
            for (int i = 1; i <= V; i++) { //Initially sets all values in the table to MaxValue
                table[i] = int.MaxValue;
            }
            for (int i = 1; i <= V; i++) {
                for (int j = 0; j < N; j++) {
                    if (coins[j] <= i) {
                        int temp = table[i - coins[j]];
                        if (temp != int.MaxValue && temp + 1 < table[i]) {
                            table[i] = temp + 1;
                        }
                    }
                }
            }
            foreach (int x in table) {
                Console.Write(x + " ");
            }
            Console.WriteLine();
            return table[V];
        }
        static void Main(string[] args) {
            int[] coins = { 9, 6, 5, 1 };
            int V = 11;
            int N = coins.Length;
            Console.WriteLine("ANSWER: " + minCoins(coins, N, V));
        }
    }  
}
