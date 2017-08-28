class Solution{


	/*
	Formula

	dp[i][j] = i transanction, j day Maximum Profit
	
	max 
	(dp[i][j-1], profit[j] - profit[m](m=0...j-1) + dp[i-1][j])
	

	*/

	public int maxProfit(int[] prices) {


		if(prices == null || prices.length == 0){
			return 0;
		}

		int len = prices.length;
		int k = 2;

		int dp[][] = new int[k+1][len];


		for(int i = 1 ; i <= k ; i++){

			int maxVal = -prices[0];

			for(int j = 1 ; j < len ; j++){

				dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxVal);
				maxVal = Math.max(dp[i-1][j] + prices[j], maxVal);

			}

		}

		return dp[k][j-1];
	}

}