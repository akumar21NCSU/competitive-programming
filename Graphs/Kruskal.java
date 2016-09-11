package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Kruskal {
	
	static class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int weight;
		public int getSrc() {
			return src;
		}
		public void setSrc(int src) {
			this.src = src;
		}
		public int getDest() {
			return dest;
		}
		public void setDest(int dest) {
			this.dest = dest;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public Edge(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			if(weight > o.weight)
				return 1;
			else if (weight < o.weight)
				return -1;
			else{
				if((src+dest+weight) > (o.src+o.dest+o.weight)){
					return 1;
				} else if((src+dest+weight) < (o.src+o.dest+o.weight)){
					return -1;
				}else {
					return 0;
				}
			}
				
		}
		
		
	}
	public static int find(int[] parent,int v){
		
		
		while(parent[v] != -1)
			v= parent[v];
		
		//System.out.println("Returing "+v);
		return v;
		
	}
	
	public static void kruskal(Edge[] edges,int n){
		
		int parent[] = new int[n+1];
		int rank[] = new int[n+1];
		
		for(int i=0;i<=n;i++){
			parent[i] = -1;
			rank[i] = 0;
		}
		
		//ArrayList<Edge> mst = new ArrayList<Edge>();
		
		int index=0;
		int result=0;
		
		for(int count=0; count<n-1;){
			
			boolean inserted = addEdge(parent,edges,rank,index,n);
			if(inserted){
				count++;
				result += edges[index].weight;
			}
			index++;
		}
		System.out.println(result);
	}
	public static boolean addEdge(int[] parent,Edge[] edges,int []rank,int index,int n){
		
		Edge current = edges[index];
		int num1 = current.getSrc();
		int num2 = current.getDest();
		
		int p1 = find(parent,num1);
		int p2 = find(parent,num2);
		
		if(p1 == p2)
			return false;
		
		else{
			if(rank[p1] > rank[p2]){
				parent[p2] = p1;
				rank[p2]++;
			}else{
				parent[p1] = p2;
				rank[p1]++;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		String parts[] = line.split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		
		Edge edges[] = new Edge[m];
		
		for(int i=0;i<m;i++){
			line = br.readLine();
			parts = line.split(" ");
			int src = Integer.parseInt(parts[0]);
			int dest = Integer.parseInt(parts[1]);
			int weight = Integer.parseInt(parts[2]);
			Edge edge = new Edge(src,dest,weight);
			edges[i] = edge;
		}
		int s = Integer.parseInt(br.readLine());
		
		Arrays.sort(edges);
		
		kruskal(edges,n);
		/*System.out.println("Printing edges");
		
		for(int i=0;i<m;i++)
			System.out.println(edges[i].getSrc() + " "+ edges[i].getDest());*/
		
	}

}
