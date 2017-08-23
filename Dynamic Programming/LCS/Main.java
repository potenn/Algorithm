package dp.longest_common_subsequence;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 *
		 * ACAYKP
		   CAPCAK
		 */
		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();

		sc.close();

		int len1 = str1.length();
		int len2 = str2.length();

		int dp[][] = new int[len1+1][len2+1];

		/*
		 * dp[i][j]의 정의
		 * 문자열 A의 처음부터 i길이 문자열 B의 처음부터 j길이 까지 겹치는(공통) 최대 문자열 길이.
		 *
		 */

		for(int i = 1 ; i <= len1 ; i++){

			for(int j = 1; j <= len2 ; j++){

				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[len1][len2]);
	}
}
