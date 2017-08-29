package bfs.cycle.topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


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
	
	public static List<Integer> bfs(List<List<Integer>> adjList, int indegree[], int Nv, int result[]){
		
		/*
		 * 1. 먼저 indegree 연산을 해준다.
		 * 2. indegree가 0 인것들을큐에넣어준다.
		 * 3. 큐에서 빼내면서 해당 here노드에 연결된 노드들의 indegree를 감소시키면서 0이면 result배열에 넣는다.큐에넣는다.
		 * 
		 */
		List<Integer>list = new ArrayList<Integer>();
		Queue<Integer>queue = new LinkedList<Integer>();
		
		
	    for(int i = 1; i <= Nv ; i++){
	    	
	    	if(indegree[i] == 0){
	    		list.add(i);
	    		queue.offer(i);
	    	}
	    	
	    }
		while(!queue.isEmpty()){
			
			int here = queue.poll();
			List <Integer>thereList = adjList.get(here);
			for(int there : thereList){
				
				--indegree[there];
				if(indegree[there] == 0){
					queue.offer(there);
					list.add(there);
				}
			}
		}
		//개수가 일치해야함
	    if(list.size() != Nv){
	    	cycle=1;
	    	return new ArrayList<Integer>();
	    }
		
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
	    int Nv = scan.nextInt();
	    int Ne = scan.nextInt();
	    List <List<Integer>> adList = new ArrayList<List<Integer>>(Nv+1);
	    int indegrees[] = new int[Nv+1];
	    int result[] = new int[Nv+1];
	    
	    
	    for(int i = 0; i <= Nv; i++){ // 인접 리스트 속의 리스트 초기화
	    	adList.add(new ArrayList<Integer>());
	    }
	    
	    for(int i = 0; i < Ne; i++){
	    	 
	    	int t1 = scan.nextInt();
	    	int t2 = scan.nextInt();
	        indegrees[t2]++;
	    	adList.get(t1).add(t2);
	    	
	    }
	    scan.close();
	   
	   List <Integer> list = bfs(adList, indegrees, Nv, result);
	   
	   if(list.size() != 0){
		   for(int i = 0 ; i < Nv ; i++){
			   
			   System.out.print(list.get(i) + " ");
			   
		   }   
	   }else{
		   System.out.println("Cycle Exists");
	   }
	}

}
