/*  DESCRIPTION:  This converts an integer to its binary equivalent.
    NOTE: It works by looping through and dividing the integer by 2 until it reaches zero.
    At each step of the way you take the MOD of the int and append it to the beginning of a binary
    string.  The loop exits early so after loop we must append the final binary digit to the string.
*/
public class Test {
	public static void main(String[] args){
		int num = 4;
		String binary = "";
		while(num/2 != 0){ //Loop until num/2 is 0
			binary = num%2 + binary; //Take remainder and create binary string
			num = num/2; 
		}
		binary = num%2 + binary; //Loop exits before final update so append last binary digit
		System.out.println(binary); 
	}
}
