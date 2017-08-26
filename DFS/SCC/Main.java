package dfs.scc.cosaraju;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void reverseDFS(int here, int r, int visited[], List<List<Integer>>scc, List<Integer>adjList[]){

		visited[here] = 1;
		scc.get(r).add(here);
		List <Integer>thereList = adjList[here];

		for(int there : thereList){

			if(visited[there] == 0){
				reverseDFS(there, r, visited, scc, adjList);
			}

		}
	}

	public static void dfs(int here, int visited[], Stack<Integer>stack, List<Integer>adjList[]){

		visited[here] = 1;
		List <Integer>thereList = adjList[here];
		System.out.println("DFS");
		System.out.println(here);
		for(int there : thereList){
			if(visited[there] == 1){
				continue;
			}
			dfs(there,visited,stack,adjList);
		}
		stack.push(here);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		List<Integer>[]adjList = new ArrayList[10010];
		List<Integer>[]reverseAdjList = new ArrayList[10010];

		List<List<Integer>>scc = new ArrayList<List<Integer>>();
		int visited[] = new int[10010];

		for(int i = 1 ; i <= V ; i++){
			adjList[i] = new ArrayList<Integer>();
			reverseAdjList[i] = new ArrayList<Integer>();
		}

		for(int i = 1 ; i <= E ; i++){

			int start = sc.nextInt();
			int end = sc.nextInt();
			adjList[start].add(end);
			reverseAdjList[end].add(start);
		}


		//선작업 DFS 스택에 담음.
		Stack <Integer>stack = new Stack<Integer>();
		for(int i = 1 ; i <= V ; i++){
			if(visited[i] == 0){
				dfs(i,visited,stack,adjList);
			}
		}


		//후작업 역 DFS
		visited = new int[10010];

		int r = 0;
		while(!stack.isEmpty()){

			int here = stack.peek();
			stack.pop();
			if(visited[here] == 1){
				continue;
			}
			scc.add(new ArrayList<Integer>());
			++r;
			reverseDFS(here, r-1, visited, scc, reverseAdjList);

		}

		System.out.println(r);
		for(int i = 0 ; i < r ; i++){
			List <Integer>temp = scc.get(i);
			Collections.sort(temp);
		}

		scc.sort(new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				if(o1.get(0)< o2.get(0)){
					return -1;
				}else if(o1.get(0) > o2.get(0)){
					return 1;
				}
				return 0;
			}
		});

			for(List <Integer>list : scc){
				for(int i = 0 ; i < list.size() ; i++){
					System.out.print(list.get(i) + " ");
				}
				System.out.println("-1");
			}

	}

}
