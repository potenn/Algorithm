package dp.coin_problem;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int typeCoin = sc.nextInt();
		int money = sc.nextInt();

		int coins[] = new int[typeCoin];
		for(int i = 0 ; i < typeCoin ; i++){
			coins[i] = sc.nextInt();
		}
		sc.close();

		/*
		 * -1로초기화하는게 제일 중요함.
		 * 값이 없으면 -1을 반환해야하므로.
		 *
		 *
		 *
		 */
		int dp[] = new int[money+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		for(int i = 0 ; i < coins.length; i++){

			int coinValue = coins[i];

			for(int m = 1; m <= money ;m++){

				if(m >=coinValue && dp[m-coinValue] != -1){

					if(dp[m] == -1){
						dp[m] = dp[m-coinValue] + 1;
					}else{
						dp[m] = Math.min(dp[m-coinValue] + 1, dp[m]);
					}

				}
			}
		}

		System.out.println("Table : ");
		for(int i = 0 ; i <= money ; i++){
			System.out.print(dp[i] + " ");
		}

		System.out.println();
		System.out.print("Answer : " + dp[money]);

	}

}
