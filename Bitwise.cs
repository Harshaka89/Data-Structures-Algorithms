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
    }
}
