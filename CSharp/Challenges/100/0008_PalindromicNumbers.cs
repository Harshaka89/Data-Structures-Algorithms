/* DESCRIPTION:  Given A and B, count the numbers N such that A ≤ N ≤ B and N is a palindrome.
    Examples: 
      Palindromes: 121, 11 , 11411 
      Not Palindromes: 122, 10
    Input: 
      First line contains T, the number of testcases. Each testcase consists of two integers A and B in one line.
    Output: 
      For each testcase, print the required answer in one line.
    Constraints: 
      1 ≤ T ≤ 10 
      0 ≤ A ≤ B ≤ 105
    Sample Input
     2
      10 13
      20 30
    Sample Output
     1
     1
*/
using System; 
using System.Numerics;
class MyClass {
    static void Main(string[] args) {
        int T = int.Parse(Console.ReadLine());
        while(T-- >  0){
        	String[] S = Console.ReadLine().Split();
        	int num1 = int.Parse(S[0]);
        	int num2 = int.Parse(S[1]);
        	int count = 0;
        	for(int i = num1; i <= num2; i++){
        		bool flag = false;
        		string temp = i.ToString();
        		int N = temp.Length;
        		for(int j = 0; j <= N/2; j++){
        			if(temp[j] != temp[temp.Length - j - 1]){
        				flag = false;
        				break;
        			}
        			else{
        				flag = true;
        			}
        		}
        		if(flag == true){
        			count++;
        			flag = false;
        		}
        	}
        	Console.WriteLine(count);
        }
    }
}
