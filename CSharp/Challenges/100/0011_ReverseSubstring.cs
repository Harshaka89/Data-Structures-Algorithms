/* DESCRIPTION: Given a string S, and two number N, M arrange the characters of string in between the indexes 
N and M (both inclusive) in descending order.  (Indexing starts from 0).
Input Format:  First Line contains T- Number of Test Cases
Next T Lines contains a string (S) and two numbers(N, M) separated by Spaces.
Output Format: Print the modified string for each test case in new line.
*/
using System; 
using System.Numerics;
using System.Text;
using System.Collections.Generic;
class MyClass {
    static void Main(string[] args) {
        int T = int.Parse(Console.ReadLine());
        while(T-- > 0){
        	string[] line = Console.ReadLine().Split(' ');
        	string word = line[0];
        	int N = int.Parse(line[1]);
        	int M = int.Parse(line[2]);
        	var selection = new List<char>();
        	string sub = word.Substring(N, M+1-N);
        	for(int i = 0; i < sub.Length; i++){
        		selection.Add(sub[i]);
        	}
        	selection.Sort();
        	selection.Reverse();
        	StringBuilder temp = new StringBuilder("");
        	for(int i = 0; i < selection.Count; i++){
        		temp.Append(selection[i]);
        	}
        	StringBuilder output = new StringBuilder(word.Substring(0, N));
        	output.Append(temp);
        	for(int i = output.Length; i < word.Length; i++){
        		output.Append(word[i]);
        	}
        	Console.WriteLine(output.ToString());
        }
    }
}
