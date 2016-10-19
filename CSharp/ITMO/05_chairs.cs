using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
namespace ITMO
{
    /*
        find (A + B)/2,  (A + C)/2, (B + C)/2
        value = (A + B + C) / 3
        result = value / 2;
    */
    class Program
    {
        static void Main(string[] args)
        {
            string text = File.ReadAllText("chairs.in");
            string[] nums = text.Split(' ');
            double A = double.Parse(nums[0]);
            double B = double.Parse(nums[1]);
            double C = double.Parse(nums[2]);
            double A2 = (A + B) / 2;
            double B2 = (A + C) / 2;
            double C2 = (B + C) / 2;
            double value = (A + B + C) / 3;
            double result = value / 2;
            //Console.WriteLine(result);
            System.IO.File.WriteAllText("chairs.out", result + "");
        }
    }
}
