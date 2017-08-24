package dp.palindrome;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * use this sample testcase
		 *
		 *
		 *
		 *
		 */

//		7 (lenth of palindrome string
//		1 2 1 3 1 2 1 (string)
//		4 (num of question)
//		1 3 (start = 1 end = 3)
//		2 5 (start = 2 end= 5)
//		3 3 (start = 3 end = 3)
//		5 7 (start = 5 end = 7)

//		7
//		1 2 1 3 1 2 1
//		4
//		1 3
//		2 5
//		3 3
//		5 7


		solBaekjoonProblem();
	}

	public static void solBaekjoonProblem(){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n+1];
		for(int i = 1 ; i <= n ; i++){
			arr[i] = sc.nextInt();
		}
		int dp[][] = new int[n+1][n+1];
		for(int i = 0 ; i <= n ; i++){
			for(int j = 0 ; j <= n ; j++){
				dp[i][j] = -1;
			}
		}

		int numOfQuestion = sc.nextInt();
		int question[][] = new int[numOfQuestion][2];
		for(int i = 0 ; i < numOfQuestion ; i++){
			question[i][0] = sc.nextInt();
			question[i][1] = sc.nextInt();
		}


		for(int i = 0 ; i < numOfQuestion ; i++){
			int answer = palindromeCheck(dp, question[i][0], question[i][1],arr);
			System.out.println(answer);
		}


	}

	public static int palindromeCheck(int dp[][],int start, int end, int arr[]){

		if(start >= end){
			return 1;
		}
		if(dp[start][end]!= -1){
			return dp[start][end];
		}

		if(arr[start] == arr[end]){

			start++;
			end--;
			dp[start][end] = palindromeCheck(dp, start, end, arr);

		}else{
			dp[start][end] = 0;
		}
		return dp[start][end];
	}


}
