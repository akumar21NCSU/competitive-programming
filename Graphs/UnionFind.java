package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UnionFind {

	public static int find(int[] parent, int v){
		while(parent[v] != -1)
			v = parent[v];
		
		return v;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		String parts[] = line.split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		
		int edges[][] = new int[m][2];
		
		for(int i=0;i<m;i++){
			line = br.readLine();
			parts = line.split(" ");
			edges[i][0] = Integer.parseInt(parts[0]);
			edges[i][1] = Integer.parseInt(parts[1]);
			
		}
		int k = Integer.parseInt(br.readLine());
		int parent[] = new int[n];
		for(int i=0;i<n;i++)
			parent[i] = -1;
		
		for(int i=0;i<k;i++){
			int left = Integer.parseInt(br.readLine());
			parent[left] = -2;
		}
		
		int rank[] = new int[n];
		for(int i=0;i<n;i++)
			rank[i] = 0;
		
		for(int i=0;i<m;i++){
			if(parent[edges[i][0]] == -2 || parent[edges[i][1]] == -2){
				continue;
			}
			int p1 = find(parent,edges[i][0]);			
			int p2 = find(parent,edges[i][1]);	
			
			if(p1 == p2)
				continue;
			
			if(rank[p1] > rank[p2]){
				parent[p2] = p1;
				rank[p1] = rank[p1] +1;
			}else{
				parent[p1] = p2;
				rank[p2] = rank[p2] +1;
			}
			
		}
		int count=0;
		boolean visited[] = new boolean[n];
		
		for(int i=0;i<n;i++){
			if(parent[i] <-1)
				count++;
			else{
				int par =find(parent,i);
				if(!visited[par]){
					visited[par] = true;
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
