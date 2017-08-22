package dp_LIS;

/*
 * Longest Increasing Subsequence
 */
/*
Arr = {10,9,2,5,3,7,101,18};
index =0 1 2 3 4 5 6 7

initialization
dp[index]    1 1 1 1 1 1 1 1
index       0 1 2 3 4 5 6 7


Cri = 1;
dp[index]    1 1 1 1 1 1 1 1
index       0 1 2 3 4 5 6 7

Cri = 2;
dp[index]    1 1 1 1 1 1 1 1
index       0 1 2 3 4 5 6 7
Cri = 3;
dp[index]    1 1 1 2 1 1 1 1
index       0 1 2 3 4 5 6 7

Cri = 4;
dp[index]    1 1 1 2 2 1 1 1
index       0 1 2 3 4 5 6 7

Cri = 5;
dp[index]    1 1 1 2 2 3 1 1
index       0 1 2 3 4 5 6 7

Cri = 6;
dp[index]    1 1 1 2 2 3 4 1
index       0 1 2 3 4 5 6 7

Cri = 7;
dp[index]    1 1 1 2 2 3 4 4
index       0 1 2 3 4 5 6 7

*/
public class Main {


	public static int LIS(int arr[]){

		int n = arr.length;

		int dp[] = new int[n];
		for(int i = 0 ; i < n ; i++){
			dp[i] = 1;
		}

		for(int criterionLen = 1 ; criterionLen < n ; criterionLen++){

			for(int j = 0 ; j < criterionLen ; j++){

				if(arr[j] < arr[criterionLen]){

					if(dp[criterionLen] < dp[j] + 1){
						dp[criterionLen] = dp[j] + 1;
					}

				}
			}
		}
		return dp[n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};

		int answer = LIS(arr);
		System.out.println("Answer : " + answer);

	}

}
