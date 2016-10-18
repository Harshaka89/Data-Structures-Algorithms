using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ITMO
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = File.ReadAllText("team.in").Split('\n');
            string[] Row1 = text[1].Split(' ');
            string[] Row2 = text[2].Split(' ');
            string[] Row3 = text[2].Split(' ');
            int[,] table = new int[3,3];
            bool[,] truth = new bool[3,3];
            for(int i = 0; i < Row1.Length; i++){
                for(int j = 0; j < Row1.Length; j++){
                    if(i == 0){
                        table[i,j] = int.Parse(Row1[j]);
                        truth[i,j] = false;
                    }
                    else if(i == 1){
                        table[i,j] = int.Parse(Row2[j]);
                        truth[i,j] = false;
                    }
                    else if(i == 2){
                        table[i,j] = int.Parse(Row3[j]);
                        truth[i,j] = false;
                    }
                }
            }

            Console.WriteLine(table[2,2]);

            System.IO.File.WriteAllText("team.out", "");
        }
    }
}
