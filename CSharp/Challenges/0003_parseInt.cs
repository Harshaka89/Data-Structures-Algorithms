/*Description:  Implement the equivalent of Java's Integer.parseInt or C#'s int.Parse() */

public class Solution {
        public static int parseInt(String num)
        {
            int sum = 0;
         
            foreach(char c in num){
                int digit = c - '0';
                sum = (sum * 10) + digit;
            }
            return sum;
        }
        public static void Main(String[] args)
        {
            int num = parseInt("566");
            Console.WriteLine(num);
            num += 115;
            Console.WriteLine(num);
            
        }
}
