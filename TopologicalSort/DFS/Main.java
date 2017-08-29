package topologicalSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
7 8
1 2
1 3
1 4
2 5
5 7
3 5
3 6
6 2

Cycle exists TestCase
7 9
1 2
1 3
1 4
2 5
5 7
3 5
3 6
6 2
7 2

 */

public class Main {

	static int cycle = 0;

	public static void dfs(List<List<Integer>> adjList, int here, int visited[] , int finished[], Stack<Integer> stack){
		
		visited[here] = 1;
		List <Integer>list = adjList.get(here);
		for(int there : list){
			
			if(visited[there] == 0){
				visited[there] = 1;
				dfs(adjList,there, visited,finished, stack);
			}
			//방문중인 노드인데, 아직 끝나지않은 정점을 보면? 역방향이존재. 싸이클 존재. 
			else if(finished[there] == 0){
				cycle = 1;
				return;
			}
		}
		//완전히 끝남.
		finished[here] = 1;
		stack.push(here);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scan = new Scanner(System.in);
	    int Nv = scan.nextInt();
	    int Ne = scan.nextInt();
	    List <List<Integer>> adList = new ArrayList<List<Integer>>(Nv+1);
	    int visited[] = new int[Nv+1];
	    int finished[] = new int[Nv+1];
	    Stack <Integer> stack = new Stack<Integer>();
	    
	    
	    for(int i = 0; i < Nv+1; i++){ // 인접 리스트 속의 리스트 초기화
	    	adList.add(new ArrayList<Integer>());
	    }
	    
	    for(int i = 0; i < Ne; i++){
	    	 
	    	int t1 = scan.nextInt();
	    	int t2 = scan.nextInt();
	            
	    	adList.get(t1).add(t2);
	    	
	    }
	    
	    for(int i = 1 ; i <= Nv ; i++){
	    	if(visited[i] == 0){
	    		System.out.println("Main");
	    		dfs(adList, i, visited, finished, stack);
	    	}
	    }
	    
	    if(cycle != 1){
		    while(!stack.isEmpty()){
		    	
		    	int num = stack.pop();
		    	System.out.print(num + " ");
		    	
		    }	    	
	    }else{
	    	System.out.println("Cycle Exists");
	    }

	    

	}

}
