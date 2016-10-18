using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Collections;
using System.IO;

namespace ITMO
{
    class Program
    { 
        static void Main(string[] args) {
            string[] text = File.ReadAllText("prepare.in").Split('\n');
            string[] PList = text[1].Split(' ');
            string[] TList = text[2].Split(' ');
            int N = int.Parse(text[0]);
            int sum = 0;
            int[] P = new int[N];
            int[] T = new int[N];
            int[] P2 = new int[N];
            int[] T2 = new int[N];
            for (int i = 0; i < N; i++) {
                P[i] = int.Parse(PList[i]);
                T[i] = int.Parse(TList[i]);
                P2[i] = int.Parse(PList[i]);
                T2[i] = int.Parse(TList[i]);
            }
            Array.Sort(P2);
            Array.Sort(T2);
            int L = P2.Length;
            if (Array.IndexOf(P, P2[L - 1]) != Array.IndexOf(T, T2[L - 1])) {
                sum += P2[L - 1] + T2[L - 1];
            }
            else if (P2[L - 1] > T2[L - 1]) {
                sum += P2[L - 1] + T2[L - 2];
            }
            else {
                sum += T2[L - 1] + P2[L - 2];
            }
            //Console.WriteLine(sum);

            System.IO.File.WriteAllText("prepare.out", sum + "");

        }
    }
}
