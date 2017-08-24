package dfs.cutvertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int counter = 0;

	/*
	 * discovered[i]는 정점 i가 발견된 순서
	 * isCutVertex[i]는 정점 i가 절단점인지아닌지판단
	 *
	 *
	 * 정점 A가 루트이면 자식수가 2개일때 단절점.
	 *
	 * 정점 A가 루트가 아니라면 A의 자식노드들이 A를 안거치고 A이전 방문노드 도달 못하면
	 * 단절점
	 *
	 */

	//TestCase
//	7 7
//	1 4
//	4 5
//	5 1
//	1 6
//	6 7
//	2 7
//	7 3

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		int adjMatrix[][] = new int[10010][10010];

		for(int i = 0 ; i < E ; i++){

			int start = sc.nextInt();
			int end = sc.nextInt();
//
			adjMatrix[start][end] = 1;
			adjMatrix[end][start] = 1;

		}

		int discovered[] = new int[10010];
		for(int i = 1 ; i <= V ; i++){
			discovered[i] = -1;
		}
		boolean isCutVertex[]= new boolean[10010];

		for(int i = 1 ; i <= V ; i++){
			if(discovered[i] == -1){
				findCutVertex(adjMatrix, i, true, discovered, isCutVertex,V);
			}
		}

		int cnt=0;
		for(int i = 1 ; i<= V; i++){
			if(isCutVertex[i]){
				cnt++;
			}
		}
		System.out.println(cnt);
		for(int i =1 ; i<= V; i++){
			if(isCutVertex[i])
				System.out.printf("%d ", i);
		}




	}


	public static  int findCutVertex(int matrix[][], int here, boolean isRoot, int discovered[], boolean isCutVertex[], int V){

		//발견된 순서 기록
		discovered[here] = ++counter;
		//here 정점의 방문순서 기록
		int ret = discovered[here];

		//루트인경우 절단점 판단을 위해 자손서브트리개수세야함.
		int children = 0;

		for(int i = 1 ; i <= V ; i++){

			if(matrix[here][i] == 1){

				int there = i;

				if(discovered[there] == -1){

					children++;
					int subTree = findCutVertex(matrix, there, false, discovered, isCutVertex, V);
					if(!isRoot && subTree >= discovered[here]){
						isCutVertex[here] = true;
					}
					ret = Math.min(ret,subTree);

				}else{
					ret = Math.min(ret, discovered[there]);
				}
			}

		}

		//루트인 경우 절단점 판정은 서브트리의개수로한다.
		if(isRoot){
			isCutVertex[here] = (children>=2 ? true : false);
		}

		return ret;
	}


}
