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
            string text = File.ReadAllText("aplusb.in");
            string[] nums = text.Split(' ');
            int result = int.Parse(nums[0]) + int.Parse(nums[1]);
            Console.WriteLine(result);
            System.IO.File.WriteAllText("aplusb.out", result + "");

        }
    }
}
