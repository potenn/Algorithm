package dp.edit_distance;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String word1 = "sitting";
		String word2 = "kitten";
		int word1Len = word1.length();
		int word2Len = word2.length();

		int dp[][] = new int[word1Len+1][word2Len+1];

		//delete Cost
		for(int i = 0 ; i <= word1Len ; i++){
			dp[i][0] = i;
		}

		//insert Cost
		for(int i = 0 ; i <= word2Len ; i++){
			dp[0][i] = i;
		}

		for(int i = 0 ; i < word1Len ; i++){

			for(int j = 0 ; j < word2Len ; j++){

				if(word1.charAt(i) == word2.charAt(j)){

					dp[i+1][j+1] = dp[i][j];

				}else{

					int replace = dp[i][j] + 1;
					int insert = dp[i][j+1] + 1;
					int delete = dp[i+1][j]  + 1;

					int min = Math.min(replace, insert);
					min = Math.min(min,delete);
					dp[i+1][j+1] = min;

				}
			}
		}

		System.out.println("Minimum Cost "  + dp[word1Len][word2Len]);

	}

}
