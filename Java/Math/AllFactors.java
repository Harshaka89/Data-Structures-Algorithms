/* Description:  Write a program to return all the factors of a given number N in a list
*/

/*Not as efficient*/
public static ArrayList<Integer> allFactors(int N){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for(int i = 2; i <= N/2; i++){
			if(N % i == 0){
				list.add(i);
			}
		}
		list.add(N);
		return list;
}
