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
//		Scanner sc = new Scanner(System.in);

		String str1 = "ACAYKP";

		//if you want to test other text..
		//sc.next();
		String str2 = "CAPCAK";

		//if you want to test other text..
		//sc.next();
//		sc.close();

		int len1 = str1.length();
		int len2 = str2.length();

		int dp[][] = new int[len1+1][len2+1];
		int sol[][] = new int[len1+1][len2+1];
		/*
		 * dp[i][j]의 정의
		 * 문자열 A의 처음부터 i길이 문자열 B의 처음부터 j길이 까지 겹치는(공통) 최대 문자열 길이.
		 *
		 */

		int top = 1;
		int left = 2;
		int diagonal = 3;


		for(int i = 1 ; i <= len1 ; i++){

			for(int j = 1; j <= len2 ; j++){

				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
					sol[i][j] = diagonal;
				}else{

					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

					//top
					if(dp[i][j] == dp[i-1][j]){
						sol[i][j] = top;
					}
					//left
					else{
						sol[i][j] = left;
					}
				}
			}
		}
		System.out.println(dp[len1][len2]);

		System.out.println("Sol Table");
		for(int i = 1 ; i <= len1 ; i++){

			for(int j = 1; j <= len2 ; j++){
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}

		int ALen = len1;
		int BLen = len2;


		StringBuilder builder = new StringBuilder();

		while(ALen != 0 && BLen != 0){

			if(sol[ALen][BLen] == 3){
				ALen--;
				BLen--;
				builder.insert(0, str1.charAt(ALen));
			}else if(sol[ALen][BLen] == 2){
				BLen--;
			}else if(sol[ALen][BLen] == 1){
				ALen--;
			}
		}

		System.out.println(builder.toString());

	}
}
