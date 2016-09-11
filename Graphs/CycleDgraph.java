package graph;

import java.util.LinkedList;

class Graph{
	int V;
	LinkedList adjList[] = null;
	
	
	public int getV() {
		return V;
	}


	public void setV(int v) {
		V = v;
	}


	public LinkedList[] getAdjList() {
		return adjList;
	}


	public void setAdjList(LinkedList[] adjList) {
		this.adjList = adjList;
	}

	public void addEdge(int u, int v){
		this.adjList[u].add(v);
	}

	public Graph(int V){
		this.V = V;
		adjList = new LinkedList[V];
		for(int i=0;i<V;i++)
			adjList[i] = new LinkedList();
	}
}



public class CycleDgraph {

	public static boolean isCyclicUtil(boolean[] visited, boolean[] recStack, Graph g, int n){
		
		if(visited[n] == false){
			
			LinkedList<Integer> aList = g.adjList[n];
			visited[n] = true;
			recStack[n] = true;
			
			for(int i=0; i<aList.size();i++){
				if(!visited[aList.get(i)] && isCyclicUtil(visited,recStack,g,aList.get(i))){
					return true;
				}
				else if(recStack[aList.get(i)])
					return true;
			}
			
		}
		recStack[n] = false;
		return false;
	}
	
	public static boolean isCyclic(Graph g){
		
		int V = g.getV();
		boolean visited[] = new boolean[V];
		boolean recStack[] =  new boolean[V];
		for(int i=0;i<V;i++)
			if(isCyclicUtil(visited, recStack,g,i))
				return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(7);
	    g.addEdge(0, 1);
	    g.addEdge(1, 2);
	    g.addEdge(2, 3);
	    g.addEdge(3, 4);
	    g.addEdge(3, 5);
	    g.addEdge(5, 6);
	    g.addEdge(6, 2);
	    
	    System.out.println(isCyclic(g));
	 
	}

}
