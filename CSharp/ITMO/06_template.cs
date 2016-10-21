using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
namespace ITMO
{
    class Program
    {
        public class POS {
            public int X, Y;
            public POS(int x, int y) {
                this.X = x;
                this.Y = y;
            }
        }
        static void Main(string[] args)
        {
            string text = File.ReadAllText("template.in");
            string[] lines = text.Split('\n');
            string[] dimension = lines[0].Split(' ');
            int M = int.Parse(dimension[1]);
            int N = int.Parse(dimension[0]);
            var map = new Dictionary<char, POS>();
            int x = M;
            for(int i = 1; i < M+1; i++) {
                for(int j = 0; j < N; j++) {
                    map.Add(lines[i][j], new POS(x, j+1));
                }
                x--;
            }
            var list = new List<string>();
            var list2 = new List<int>();
            bool flag = false;
            for(int i = M + 1; i < lines.Length; i++) {
                if(lines[i].Length != 0 && lines[i][0] == 13) {
                    if (i + 1 < lines.Length && lines[i+1].Length != 0 && char.IsLetter(lines[i + 1][0])) {
                        list.Add(lines[i + 1]);
                    }
                    continue;
                }
                //If true process calculations
                if(flag == true) {
                    int sum = 0;
                    var charList = new List<char>();
                    for (int j = i; lines[j][0] != 13; j++) {
                        
                        for (int k = 0; k < lines[j].Length; k++) {
                            if(lines[j][k] != 13) {
                                charList.Add(lines[j][k]);
                            }
                        }
                    }
                    
                    for (int l = 0; l < charList.Count-1; l++) {
                        POS pos1 = map[charList[l]];
                        POS pos2 = map[charList[l + 1]];
                        int val1 = Math.Abs(pos1.X - pos2.X);
                        int val2 = Math.Abs(pos1.Y - pos2.Y); ;
                        sum += Math.Max(val1, val2);
                    }
                    list2.Add(sum);
                    flag = false;
                }
                if (list[list.Count - 1].Equals(lines[i])) {
                    flag = true;
                    continue;
                }
                //Console.WriteLine(lines[i]);
            }
            string name = "";
            int score = -99999;
            if(list2[0] <= list2[1] && list2[0] <= list2[2]) {
                name = list[0];
                score = list2[0];
            }
            else if(list2[1] <= list2[0] && list2[1] <= list2[2]) {
                name = list[1];
                score = list2[1];
            }
            else {
                name = list[2];
                score = list2[2];
            }
            System.IO.File.WriteAllText("template.out", name + "\r\n" + score);
        }
    }
}
