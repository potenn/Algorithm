package dp.coin_problem2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		3 10
//		1
//		2
//		5
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int money = sc.nextInt();

		int coins[] = new int[n+1];
		int dp[] = new int[money + 1];
		dp[0] =1;
		for(int i = 0 ; i < n ; i++){
			coins[i] = sc.nextInt();
		}
		sc.close();

		for(int i = 0 ; i < n ; i++){
			int coinValue = coins[i];
			for(int m = 1 ; m <= money ; m++){

				if(m >= coinValue){
					dp[m] = dp[m-coinValue] + dp[m];
				}
			}
		}
		System.out.println(dp[money]);
	}
}
