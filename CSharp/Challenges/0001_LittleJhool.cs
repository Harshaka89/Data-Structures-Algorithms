/*DESCRIPTION: If the Binary Number String has 6 consecutive 1's or 0's print "Sorry, sorry!" otherwise print "Good luck!"  */
using System; 
using System.Numerics;
class MyClass {
    static void Main(string[] args) {
        string binary = Console.ReadLine();
        string zero = "000000";
        string one = "111111";
        if(binary.Contains(zero) || binary.Contains(one)){
        	Console.WriteLine("Sorry, sorry!");
        	return;
        }
        Console.WriteLine("Good luck!");
    }
}
