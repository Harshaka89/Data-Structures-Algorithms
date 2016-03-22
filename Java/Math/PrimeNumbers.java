/*This is the Sieve of Eratosthenes which is the most efficient way to calculate prime numbers*/
	public static void PrimeNumbers(int N){
		List<Boolean> list = new ArrayList<Boolean>();
		List<Integer> results = new ArrayList<Integer>();
		//Start by initially setting all values to true except for 0 and 1
		for(int i = 0; i <= N; i++){
			if(i == 0 || i == 1){
				list.add(false);
			}
			else{
				list.add(true);
			}
		}
		/*for each number set their multiples to false, only the prime numbers will remain true*/
		for(int i = 2; i*i <= N; i++){
			if(list.get(i) == true){ 
				for(int j = 2; i * j <= N; j++){
					list.set(i*j, false);
				}
			}
		}
		//creates list of results and print them
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) == true){
				results.add(i);
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
