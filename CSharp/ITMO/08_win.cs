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
        static void Main(string[] args) {
            string[] text = File.ReadAllText("win.in").Split('\n');
            int N = int.Parse(text[0]);
            string[] nums = text[1].Split(' ');
            int[] values = new int[N];
            for (int i = 0; i < nums.Length; i++) {
                values[i] = int.Parse(nums[i]);
            }
            Array.Sort(values);
            int seconds = 300 * 60;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (values[i] <= seconds) {
                    seconds -= values[i];
                    count++;
                }
                else {
                    break;
                }
            }
            System.IO.File.WriteAllText("win.out", count + "");
        }
    }
}
