package dfs;

import java.util.LinkedList;

public class DetectCycle {

	public static void insertEdge(int adj[][],int src,int dest){
		
		adj[src][dest]=1;
		
	}
	
	
	public static boolean checkCycle(int adj[][],int v){
		
		boolean visited[] = new boolean[v];
		for(int i=0;i<v;i++)
			visited[i]= false;
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		l.push(0);
		visited[0]= true;
		System.out.print(" "+ "0 -> ");
		
		while(!l.isEmpty()){
			int top = l.peek();
			int i=0;
			for(i=0;i<v;i++){
				if(adj[top][i] == 1){
					if(!l.contains(i)){
						visited[i] = true;
						adj[top][i] = 0;
						l.push(i);
						System.out.print(i+ "  ");
						break;
					}
					else
						return true;
				}
					
			}
			if(i == v)
				l.poll();
			
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v=4;
		int adj[][] = new int[v][v];
		
		for(int i=0;i<v;i++)
			for(int j=0;j<v;j++)
				adj[i][j]= 0;
		
		insertEdge(adj,0,1);
		insertEdge(adj,0,2);
		insertEdge(adj,1,2);
		insertEdge(adj,2,0);
		insertEdge(adj,2,3);
		//insertEdge(adj,3,3);
		
		System.out.println("The graph has cycle -"+String.valueOf(checkCycle(adj,v)));
		
	}

}
