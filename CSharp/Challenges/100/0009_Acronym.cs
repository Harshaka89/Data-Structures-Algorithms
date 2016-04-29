using System; 
using System.Numerics;
using System.Collections.Generic;
class MyClass {
    static void Main(string[] args) {
        var set = new SortedSet<String>();
        int K = int.Parse(Console.ReadLine());
        for(int i = 0; i < K; i++){
        	set.Add(Console.ReadLine());
        }
        int N = int.Parse(Console.ReadLine());
        string[] words = Console.ReadLine().Split(' ');
        string output = "";
        for(int i = 0; i < N; i++){
        	if(set.Contains(words[i])){
        		continue;
        	}
        	output += words[i][0] + ".";
        }
        output = output.ToUpper();
    	for(int i = 0; i < output.Length-1; i++){
    		Console.Write(output[i]);
    	}
    }
}
