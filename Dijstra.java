
public class Dijstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 다익스트라 알고리즘
		 * 한 정점에서 모든 정점간의 최단경로를 구하는 알고리즘
		 * 시간 복잡도 O(n^2)
		 *
		 */

		//Map에서 Integer.MAX_VALUE가 있는 부분은 길이 없다는 뜻.
		int [][]map = {

				{Integer.MAX_VALUE,10,30,15,Integer.MAX_VALUE,Integer.MAX_VALUE},
				{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,20,Integer.MAX_VALUE},
				{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,5},
				{Integer.MAX_VALUE,Integer.MAX_VALUE,5,Integer.MAX_VALUE,Integer.MAX_VALUE,20},
				{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,20},
				{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,20,Integer.MAX_VALUE,20}

		};

		int xLen = map.length;

		//distance[노드번호]는 현재에서 노드번호까지 연결된 거리를 의미.
		int []distance = new int[xLen];
		boolean []visited = new boolean[xLen];



		for(int i = 0 ; i < xLen ; i++){
			distance[i] = Integer.MAX_VALUE;
		}

		//한 정점선택 0을 선택.
		int startPoint = 0;

		//start Point가 0부터 시작한다고 가정.
		//즉 distance[i]는 0부터 i까지의 거리를 의미함.
		dijstra(xLen, distance, map, visited, startPoint);

		for(int i = 0 ; i < xLen ; i++){
			System.out.println("노드번호 " + i + "번 " + distance[i] + " ");
		}

	}

	public static void dijstra(int xLen, int distance[], int map[][], boolean visited[], int startPoint){

		/* 0. 기존에 distance배열은 모두 Integer.MAX_VALUE로 되있고.
		 * 1. 최초시작 distance배열[startPoint] = 0으로 만듬.
		 *
		 */

		//최초시작 distance = 0
		distance[startPoint] = 0;

		int minValue = Integer.MAX_VALUE;
		int minPoint = -1;

		for(int i = 0 ; i < xLen ; i++){

			minValue = Integer.MAX_VALUE;

			for(int j = 0 ; j < xLen ; j++){

				// 방문을 하지않았고, 최소값보다 더 큰 최소값이 나타났을 때
				if(visited[j] == false && minValue > distance[j]){
					minValue = distance[j];
					minPoint = j;
				}
			}

			visited[minPoint] = true;


			for(int k = 0 ; k < xLen ; k++){
				//경로가 존재하고 && 현재 start 정점부터 k점까지 거리보다 더 작은 최소값이 나왔을때
				 if(map[minPoint][k] != Integer.MAX_VALUE && distance[k] > distance[minPoint] + map[minPoint][k]){
					 distance[k] = distance[minPoint] + map[minPoint][k];
				 }
			}
		}
	}
}
