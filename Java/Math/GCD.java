public class GCD {
	public static long gcd(long A, long B){
		if(B == 0){
			return A;
		}
		long R = A % B;
		return gcd(B, R);
	}
	public static void main(String[] args){
		System.out.println(gcd(3918848, 1653264));
	}
}
