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
            string text = File.ReadAllText("aplusbb.in");
            string[] nums = text.Split(' ');
            long A = long.Parse(nums[0]);
            long B = long.Parse(nums[1]);
            B *= B;
            long result = A + B;
            System.IO.File.WriteAllText("aplusbb.out", result + "");

        }
    }
}
