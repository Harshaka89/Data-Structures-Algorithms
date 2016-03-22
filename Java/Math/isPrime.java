/*Method to calculate if a number is prime*/

public static boolean isPrime(int N){
		if(N == 2){ //2 is the only even prime number
			return true;
		}
		else if(N < 2){ //A prime number must be greater than 1
			return false;
		}
		else if(N % 2 == 0){ //If a number is divisible by 2 (and isn't equal to 2) it isn't prime.
			return false;
		}
		for(int i = 3; i*i <= N; i+=2){ //We only need to check up to the square root of N
			if(N % i == 0){
				return false;
			}
		}
		return true;
}
