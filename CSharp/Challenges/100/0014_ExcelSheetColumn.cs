/* DESCRIPTION: Given a column title as appear in an Excel sheet, return its corresponding column number.
*/
public class Solution {
    public int TitleToNumber(string s) {
        var map = new Dictionary<char, int>();
        char c = 'A';
        for(int i = 1; i <= 26; i++){
            map[c] = i;
            c++;
        }
        double power = 0;
        double result = 0;
        for(int i = s.Length-1; i >= 0; i--){
            result += Math.Pow(26, power) * map[s[i]];
            power++;
        }
        return (int)result;
    }
}
