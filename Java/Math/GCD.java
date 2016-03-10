public class GCD {
	public static long gcd(long A, long B){
		if(B == 0){ //If B== 0 then GCD is found so return A
			return A;
		}
		long R = A % B; //Calculate the remainder of A/B
		return gcd(B, R); //Return B to divide it by the remainder
	}
	public static void main(String[] args){
		System.out.println(gcd(3918848, 1653264));
	}
}
