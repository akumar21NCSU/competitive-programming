package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Bfs {

	public static void updateAdj(HashSet<Integer> adjList[], int src, int dest){
		
		HashSet<Integer> srcList = adjList[src];
		srcList.add(dest);
		
		HashSet<Integer> destList = adjList[dest];
		destList.add(src);
	}
	
	public static void solveBfs(HashSet<Integer> adjList[],int [] output,LinkedList<Integer> queue,boolean visited[],int n, int s){
		
		queue.add(s);
				
		while(!queue.isEmpty()){
			int current = queue.remove();
			visited[current] = true;
			HashSet<Integer> llist = adjList[current];
			for(Integer i: llist){
				if(visited[i] != true){
					queue.add(i);
				}
				if(output[i]<0)
					output[i] = output[current] + 6;
			}
		}
		StringBuffer sb = new StringBuffer("");
		
		for(int i=0;i<n;i++){
			if(i!=s){
				sb.append(output[i]+" ");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		int t = Integer.parseInt(line);
		//ArrayList<LinkedList<Integer>> adjList = new ArrayList<LinkedList<Integer>>();
		
		
		
		
		while(t-- > 0){
			line = br.readLine();
			String parts[] = line.split(" ");
			int n = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			
			HashSet<Integer> adjList[]= new HashSet[n];
			LinkedList<Integer> queue = new LinkedList<Integer>();
			int output[] = new int[n];
			boolean visited[] = new boolean[n];
			
			for(int i=0;i<n;i++){
				HashSet<Integer> list = new HashSet<Integer>();
				adjList[i] = list;		
				output[i] =  -1;
				visited[i]=false;
			}
			
			for(int i=0;i<m;i++){
				line = br.readLine();
				parts = line.split(" ");
				int x = Integer.parseInt(parts[0])-1;
				int y = Integer.parseInt(parts[1])-1;				
				updateAdj(adjList,x,y);
			}
			int s = Integer.parseInt(br.readLine())-1;
			output[s] = 0;
			//System.out.println("S is "+s);
			//System.out.println("Origin adjlist size = "+adjList[s]);
			solveBfs(adjList,output,queue,visited,n,s);
		}
		
	}

}
