public class Solution {
    public int RomanToInt(string s) {
        var map = new Dictionary<string, int>();
            map["M"] = 1000; map["CM"] = 900; map["D"] = 500; map["CD"] = 400; map["C"] = 100; map["XC"] = 90;
            map["L"] = 50; map["XL"] = 40; map["X"] = 10; map["IX"] = 9; map["V"] = 5; map["IV"] = 4;
            map["I"] = 1;
            int result = 0;
            bool flag = false;
            for (int i = s.Length - 1; i >= 0; i--)
            {
                if (flag == true)
                {
                    flag = false;
                    continue;
                }
                string temp = "";
                if (i - 1 >= 0)
                {
                    temp = "" + s[i - 1] + s[i];
                }
               
                if ((i - 1) >= 0 && map.ContainsKey(temp))
                {
                    result += map[temp];
                    flag = true;
                    continue;
                }
                result += map[s[i] + ""];
            }
            return result;
    }
}
