
public class MajorLeagueBaseball {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int teamA = 2;
		int teamB = 3;
		
		int teama = 50;
		int teamb = 40;
		//change i and j and method call here to calculate for different situations.
		long startime = System.currentTimeMillis();
		System.out.println(" P("+teama+", " +teamb+ ") = "+dynaCalcul(teama, teamb));
		long endtime = System.currentTimeMillis();
		System.out.println(" This calculation takes "+ (double)(endtime-startime)/1000 +  " seconds.");
	}
	
	/**
	 * recursive way of calculation.
	 * @return P(i,j)
	 */
	public static double recurCalcul(int i, int j) {
		if( i== 0 && j > 0 ) {
			return 1;
		}
		else if(i > 0 && j == 0) {
			return 0;
		}
		else if(i > 0 && j > 0){
			return (recurCalcul(i-1,j)+ recurCalcul(i,j-1))/2;
		}
		return -1.0;
	}
	
	/**
	 * dynamic programming way of calculation.
	 * @return P(i,j)
	 */
	public static double dynaCalcul(int i, int j) {
		double[][] memory = new double[i+1][j+1];
		for(int k = 0; k < i+1; k++){
			for(int s = 0; s < j+1; s++){
				if(k == 0 && s == 0) {
					continue;
				}
				if( k == 0 && s > 0) {
					memory[k][s] = 1.0;
				}
				else if(k > 0 && s == 0) {
					memory[k][s] = 0.0;
				}
				else {
					memory[k][s] = (memory[k-1][s] + memory[k][s-1])/2;
				}
			}

		}
		return memory[i][j];
	}
	
}
