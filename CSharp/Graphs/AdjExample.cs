using System; 
using System.Numerics;
using System.Collections.Generic;
class MyClass {
    static void Main(string[] args) {
        string[] temp = Console.ReadLine().Split(' ');
        int N = int.Parse(temp[0]);
        int M = int.Parse(temp[1]);
        List<int>[] graph = new List<int>[N];
        for(int i = 0; i < N; i++){
            graph[i] = new List<int>();
        }
        for(int i = 0; i < M; i++){
            string[] line = Console.ReadLine().Split(' ');
            int A = int.Parse(line[0]);
            int B = int.Parse(line[1]);
            graph[A].Add(B);
            graph[B].Add(A);
        }
        
        int Q = int.Parse(Console.ReadLine());
        for(int i = 0; i < Q; i++){
            string[] line = Console.ReadLine().Split(' ');
            int A = int.Parse(line[0]);
            int B = int.Parse(line[1]);
            if(graph[A].IndexOf(B) != -1){
                Console.WriteLine("YES");
            }
            else{
                Console.WriteLine("NO");
            }
        }
    }
}
