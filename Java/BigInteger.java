import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BigInteger A = new BigInteger(input.nextLine());
        BigInteger B = new BigInteger(input.nextLine());
        System.out.println(A.add(B));
        System.out.println(A.multiply(B));
    }
}
