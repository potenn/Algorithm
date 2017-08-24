package dp.continue_problem;

import java.util.Scanner;

public class Main_Grape_Problem {

//	https://www.acmicpc.net/problem/2156
	/*
	 *
Hyoju went to the wine tasting.
I went there, and there was a glass of wine on the table in a row containing various wines.
 Hyoju tries to have a wine tasting, which has two rules:

1. If you choose a wine glass, you must drink all of the wine that is in the cup,
and you should put it back in its original position after drinking it.
2. You can not drink 3 cups in a row.
Hyosu is wondering which wine cup to choose to taste as much wine as possible.
When n number of wine glasses numbered from 1 to n are placed on the table in order and the amount of wine in each wine glass is given,
Write it down.
For example,
if you have 6 glasses of wine and each of the glasses contains 6, 10, 13, 9, 8, and 1 of the wine in turn, select the first, second, fourth, fifth glass of wine If you have a total wine 33 can drink up to.
	 *
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maximumJuice();
	}

	public static void maximumJuice(){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int juice[] = new int[n+1];
		for(int i = 1 ; i <= n ; i++){
			juice[i] = sc.nextInt();
		}
		sc.close();

		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = juice[1];
		dp[2] = juice[1] + juice[2];

		for(int i = 3 ; i <= n ; i++){

			dp[i] = Math.max(dp[i-2] + juice[i], dp[i-3] + juice[i] + juice[i-1]);
			dp[i] = Math.max(dp[i], dp[i-1]);

		}
		System.out.println(dp[n]);

	}

}
