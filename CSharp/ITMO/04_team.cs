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
            string[] text = File.ReadAllText("team.in").Split('\n');
            string[] Row1 = text[0].Split(' ');
            string[] Row2 = text[1].Split(' ');
            string[] Row3 = text[2].Split(' ');
            int[,] table = new int[3, 3];
            bool[,] truth = new bool[3, 3];
            var list = new List<int>();
            for (int i = 0; i < Row1.Length; i++) {
                for (int j = 0; j < Row1.Length; j++) {
                    if (i == 0) {
                        table[i, j] = int.Parse(Row1[j]);
                        truth[i, j] = false;
                    }
                    else if (i == 1) {
                        table[i, j] = int.Parse(Row2[j]);
                        truth[i, j] = false;
                    }
                    else if (i == 2) {
                        table[i, j] = int.Parse(Row3[j]);
                        truth[i, j] = false;
                    }
                }
            }
            //find max
            int index1 = -1, index2 = -1;
            int max = int.MinValue;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (table[i,j] > max && !truth[i,j]) {
                        max = table[i, j];
                        index1 = i; index2 = j;
                    }
                }
            }
            list.Add(max);
            mark(truth, index1, index2);
            //print(truth);
            //find second max
            index1 = -1; index2 = -1;
            max = int.MinValue;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (table[i, j] > max && !truth[i, j]) {
                        max = table[i, j];
                        index1 = i; index2 = j;
                    }
                }
            }
            list.Add(max);
            mark(truth, index1, index2);
            //print(truth);
            //find third max
            index1 = -1; index2 = -1;
            max = int.MinValue;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (table[i, j] > max && !truth[i, j]) {
                        max = table[i, j];
                        index1 = i; index2 = j;
                    }
                }
            }
            list.Add(max);
            mark(truth, index1, index2);
            //print(truth);
            for (int i = 0; i < list.Count; i++) {
                //Console.Write(list[i] + " ");
            }
            //Console.WriteLine();
            double result = Math.Sqrt((double)(list[0] * list[0]) + (double)(list[1] * list[1]) + (double)(list[2] * list[2]));
            //Console.WriteLine(result);
            System.IO.File.WriteAllText("team.out", result.ToString());
        }
        public static void mark(bool[,] truth, int M, int N) {
            int i = M; int j = N;
            //go up
            if (M - 1 >= 0) {
                while (i >= 0) {
                    truth[i,j] = true;
                    i--;
                }
                i = M;
            }
            //go right
            if (N + 1 < truth.GetLength(1)) {
                while (j < truth.GetLength(1)) {
                    truth[i,j] = true;
                    j++;
                }
                j = N;
            }
            //go left
            if (N - 1 >= 0) {
                while (j >= 0) {
                    truth[i,j] = true;
                    j--;
                }
                j = N;
            }
            //go down
            if (M + 1 < truth.GetLength(0)) {
                while (i < truth.GetLength(0)) {
                    truth[i,j] = true;
                    i++;
                }
                i = M;
            }
        }
        public static void print(bool[,] truth) {
            for (int i = 0; i < truth.GetLength(0); i++) {
                for (int j = 0; j < truth.GetLength(1); j++) {
                    Console.Write(truth[i,j] + " ");
                }
                Console.WriteLine();
            }
            Console.WriteLine();
        }
    }
}
