package dfs;
import java.util.*;

public class DetectCycleUndirected {
	
	public static boolean[] visited = new boolean[7];
	public static ArrayList<LinkedList<Integer>> adjList =  new ArrayList<LinkedList<Integer>>();
	
	public static void addEdge(int edge1, int edge2){
		
		LinkedList<Integer> list1 = adjList.get(edge1);
		list1.add(edge2);
		
		LinkedList<Integer> list2 = adjList.get(edge2);
		list2.add(edge1);
	}
	
	public static boolean isCyclic(int curVertex,int parent){
		
		LinkedList<Integer> llist = adjList.get(curVertex);
		visited[curVertex] = true;
		for(int i=0;i<llist.size();i++){
			boolean result=false;
			if(i==0)
				continue;
			if(visited[llist.get(i)] == false)
				result= isCyclic(llist.get(i),curVertex);
			else
				if(llist.get(i) != parent){
					return true;
				}
			if(result)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		// n is number of vertex starting with v=1
		int n=6;
		
		
		
		for(int i=0;i<=n;i++){
			LinkedList<Integer> l = new LinkedList<Integer>();
			l.add(i);
			adjList.add(l);
		}
		
		
		addEdge(1,2);
		addEdge(1,3);
		addEdge(3,4);
		addEdge(3,6);
		addEdge(4,5);
		//addEdge(5,3);
		
		for(int i=0;i<=n;i++){
			
			LinkedList<Integer> ll = adjList.get(i);
			for(int j=0;j<ll.size();j++)
				System.out.print(ll.get(j)+" -> ");
			
			System.out.println();
		}
		
		System.out.println(isCyclic(1,-1));
		
	}

}
