/*DESCRIPTION: https://www.hackerrank.com/challenges/bear-and-workbook */
using System;
using System.Collections.Generic;
using System.IO;
class Solution {
    static void Main(String[] args) {
        string[] temp = Console.ReadLine().Split();
        int chapters = int.Parse(temp[0]);
        int ppp = int.Parse(temp[1]);
        temp = Console.ReadLine().Split();
        int page = 0; int special = 0;
        for(int i = 0; i < chapters; i++){
            page++;
            int num = int.Parse(temp[i]);
            for(int j = 1; j <= num; j++){
                if(j == page){
                    special++;
                }
                if(j % ppp == 0 && j < num){
                    page++;
                }
            }
        }
        Console.WriteLine(special);
    }
}
