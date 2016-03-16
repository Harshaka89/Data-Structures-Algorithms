/* DESCRIPTION:  Given a non-negative number represented as an array of digits, plus one to the number. The digits
    are stored such that the most significant digit is at the head of the list.
*/
import java.math.BigInteger;
public class Solution {
    public int[] plusOne(int[] digits) {
        String num = "";
        for(int i = 0; i < digits.length; i++){
            num += digits[i];
        }
        BigInteger A = new BigInteger(num);
        A = A.add(BigInteger.ONE);
        num = "" + A;
        if(num.length() > digits.length){
            digits = new int[num.length()];
        }
        for(int i = 0; i < digits.length; i++){
            Character temp = num.charAt(i);
            digits[i] = temp.getNumericValue(temp);
        }
        return digits;
    }
}
