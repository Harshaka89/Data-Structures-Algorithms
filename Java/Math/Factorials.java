/*Description:  Write a program that calculates the factorials for a given number N.  EX: 5*4*3*2*1 = 120  */

//Inefficient Recursive solution
public static int Factorials(int N){
		if(N == 1){
			return 1;
		}
		return N * Factorials(N-1);
}

//More efficient Recursive Solution using an accumulator
public static int Factorials(int accumulator, int N){ //Accumulator is set to 1 initially
		if(N == 1){
			return accumulator;
		}
		return Factorials(accumulator * N, N-1);
}

//Iterative approach, same idea as the recursive accumulator approach
public static int Factorials(int N){
		int accumulator = 1;
		for(int i = 1; i <= N; i++){
			accumulator *= i;
		}
		return accumulator;
}
