using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructures
{
    class Bitwise
    {
        //Adds two integers and returns the sum without using +,-,/,*
        public static int add(int x, int y)
        {
            while (y != 0)
            {
                int carry = x & y;
                x = x ^ y;
                y = carry << 1;
            }
            return x;
        }
        //Subtraction code is the same as addition except you add a "~" when declaring carry
        public static int subtraction(int x, int y)
        {
            while (y != 0) 
            {
                int carry = ~x & y;
                x = x ^ y;
                y = carry << 1;
            }
            return x;
        }
        //Packs multiple numbers into a single number;
        public static int arrayPacking(int[] a) {
            int M = 0;
            for(int i = 0; i < a.Length; i++){
                M |= a[i] << (8 * i);
            }
            return M;
        }
        // Kills/Switches off the Kth bit
        public static int killKthBit(int n, int k)
        {
          return (n & ~(1 << (k - 1)));;
        }
    }
}
