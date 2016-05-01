/*Description: This program prints all the permutations of a given string.
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        static void permutations(string S) {
            permutations("", S);
        }
        static void permutations(string perm, string S) {
            int N = S.Length;
            if (N == 0) {
                Console.WriteLine(perm);
            }
            for (int i = 0; i < N; i++) {
                permutations(perm + S[i], S.Substring(0, i) + S.Substring(i+1, N - (i+1)));
            }
        }
        static void Main(string[] args) {
            string test = "123";
            permutations(test);
        }
    }
}
