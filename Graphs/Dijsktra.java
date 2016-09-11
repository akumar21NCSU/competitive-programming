package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dijsktra {
	
	public static int minIndex(int[] sptAr,int n, boolean[] included){
		
		int result=-1;
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++){
			if(included[i] == false && sptAr[i]< min){
				min = sptAr[i];
				result = i;
			}
		}
		return result;
	}

	public static void dijkstra(int[][]graph, int s, int n, int[] sptAr){
		
		boolean[] included = new boolean[n];
			
		while(true){
			int index = minIndex(sptAr,n,included);
			if(index == -1)
				break;
			
			included[index] = true;
			// update sptAr with adjacent vertices
			for(int i=0;i<n;i++){
				if(graph[index][i] != -1)
					if(sptAr[index] + graph[index][i] < sptAr[i])
						sptAr[i] = sptAr[index] + graph[index][i];
			}
		}		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int t = Integer.parseInt(line);
		
		while(t-- > 0){
			line = br.readLine();
			String[] parts = line.split(" ");
			int n = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			
			int graph[][] = new int[n][n];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					graph[i][j] = -1;
			
			for(int i=0;i<m;i++){
				line=br.readLine().trim();
				parts=line.split(" ");
				int x = Integer.parseInt(parts[0])-1;
				int y = Integer.parseInt(parts[1])-1;
				int r = Integer.parseInt(parts[2]);
				
				if(graph[x][y] == -1 || graph[x][y] > r){
					graph[x][y] = graph[y][x] = r;
				}
			}
			
			int s = Integer.parseInt(br.readLine().trim());
			int sptAr[] =  new int[n];
			for(int i=0;i<n;i++)
				sptAr[i] = Integer.MAX_VALUE;
			
			sptAr[s-1] = 0;
			
			dijkstra(graph,s,n,sptAr);
			
			for(int i=0;i<n;i++){
				if(sptAr[i] == Integer.MAX_VALUE)
					sptAr[i] = -1;
			}
			
			// print result
			for(int i=0;i<n;i++){
				if(i != s-1)
					System.out.print(sptAr[i]+" ");
			}
			
		}
		
	}

}
