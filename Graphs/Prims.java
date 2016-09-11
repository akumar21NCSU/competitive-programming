package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prims {

	public static int findMin(int key[], boolean inMst[], int V){
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i=0;i<V;i++){
			if(inMst[i] == false && key[i] < min){
				min = key[i];
				index = i;				
			}			
		}
		
		return index;
	}
	
	public static void updateKeys(int[][] graph, boolean inMst[], int key[],int current,int V){
		
			
	}
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		String[] parts = line.split(" ");
		
		int n= Integer.parseInt(parts[0]);
		long m = Long.parseLong(parts[1]);
		
		int graph[][] = new int[n][n];		
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				graph[i][j]= -1;
		
		
		int key[] = new int[n];
		int parent[] =  new int[n];
		boolean inMst[] = new boolean[n];
		
		for(int i=0;i<n;i++){
			key[i]=Integer.MAX_VALUE;
			inMst[i] = false;
		}
		
		for(int i=0;i<m;i++){
				line = br.readLine();
				parts = line.split(" ");
				int x = Integer.parseInt(parts[0]) -1;
				int y = Integer.parseInt(parts[1]) -1;
				int r = Integer.parseInt(parts[2]);
			
				if(graph[x][y] == -1){					
					graph[x][y] = graph[y][x] = r;
				}else{
					if(graph[x][y] > r){
						graph[x][y] = graph[y][x] = r;
					}
				}
				
		}
				
		int s = Integer.parseInt(br.readLine()) -1;
		key[s] =0;
		parent[s] = 0;
		int count =0;
		long result=0;
		while(count != n){		
			
			int current = findMin(key,inMst,n);	
			/*System.out.println("Current is "+current+" and total is "+count);
			if(count == 999){
				for(int i=0;i<n;i++)
					System.out.print(inMst[i]+ " ");
			}*/
			if(current == -1)
				break;
			inMst[current]= true;
			for(int i=0;i<n;i++){
				if(current != i){
					if(graph[current][i] != -1 && inMst[i]==false && key[i] > graph[current][i] ){
						key[i] = graph[current][i];
						parent[i] = current;
					}
				}			
			}	
			count++;
		}
					
		for(int i=0;i<n;i++){
			result += key[i];
		}
			
		System.out.println(result);
	}
	
	
}
