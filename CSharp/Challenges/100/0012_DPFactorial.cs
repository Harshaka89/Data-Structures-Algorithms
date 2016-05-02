/* DESCRIPTION:  Given an integer N, print the factorial of the N(mod 10^9 + 7).
*/

using System; 
using System.Numerics;
class MyClass {
    static void Main(string[] args) {
    	int T = int.Parse(Console.ReadLine());
    	int M = 1000000007;
    	long sum = 1;
    	int count = 1;
    	while(T-- > 0){
	        int N = int.Parse(Console.ReadLine());
	        while(count <= N){
	        	sum = (sum*count) % M;
	        	count++;
	        }
	        Console.WriteLine(sum);
    	}
    }
}
