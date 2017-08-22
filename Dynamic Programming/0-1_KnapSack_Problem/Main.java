package knapsack_dp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int weight[] = {0,3,4,5};
		int values[] = {0,6,3,5};
		int size = 12;

		int max = maxProfit(weight, values, size);
		System.out.println("MAX" + max);

	}

	public static int maxProfit(int weight[], int values[], int size){

		// n = 3
		int n = values.length - 1;

		int dp[][] = new int[n+1][size+1];


		for(int i = 1 ; i <= n ; i++){

			int wt = weight[i];

			for(int bagSize = 1 ; bagSize <= size ; bagSize++){

				if(bagSize >= wt){
          //compare include current Item to not included currentItem
					dp[i][bagSize] = Math.max(dp[i-1][bagSize], dp[i-1][bagSize-weight[i]] + values[i]);
				}
				else{
					dp[i][bagSize] = dp[i-1][bagSize];
				}
			}
		}

		for(int i = 0 ; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[n][size];
	}
}
