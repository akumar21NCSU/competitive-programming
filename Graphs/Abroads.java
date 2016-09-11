package codechef.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;

public class Abroads {

	public static int find(int[] parent, int v){
		
		while(parent[v] != -1)
			v = parent[v];
		
		return v;
	}
	
	private static ArrayList<BigInteger> result = new ArrayList<BigInteger>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		String parts[] = line.split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int q = Integer.parseInt(parts[2]);
		String query[] = new String[q+1];
		boolean bad[] = new boolean[m];
		line = br.readLine();
		parts =  line.split(" ");
		LinkedList ar[] = new LinkedList[n+1];
		for(int i=1;i<=n;i++){
			LinkedList<Integer> newlist = new LinkedList<Integer>();
			newlist.push(Integer.parseInt(parts[i-1]));
			ar[i] = newlist;
		}
		int parent[] = new int[n+1];
		int rank[] = new int[n+1];
		int d[][] = new int[m][2];
		
		for(int i=0;i<=n;i++){
			parent[i] = -1;
			rank[i] = 0;
		}
		for(int i=0;i<m;i++){
			line = br.readLine();
			parts = line.split(" ");
			int u = Integer.parseInt(parts[0]) ;
			int v = Integer.parseInt(parts[1]) ;
			d[i][0]= u;
			d[i][1] =v;
			
		}
		
		for(int i=1;i<=q;i++){
			line = br.readLine();
			query[i]= line;
			parts = line.split(" ");
			if(parts.length == 3){
				int a = Integer.parseInt(parts[1]) ;
				int p = Integer.parseInt(parts[2]);
				ar[a].push(p);
			}else{
				int rem = Integer.parseInt(parts[1]) -1;
				bad[rem] = true;
			}
		}
		
		BigInteger count[] = new BigInteger[n+1];
		for(int i=0;i<=n;i++)
			count[i] = new BigInteger(String.valueOf("0"));
		
		findUnion(parent,rank,d,bad,n,m);
		//findMax(parent,ar,n);
		for(int i=q;i>=1;i--){
			for(int j=0;j<=n;j++)
				count[j] = new BigInteger(String.valueOf("0"));
			findMax(count,parent,ar,n);
			line = query[i];
			parts = line.split(" ");
			if(parts.length == 3){
				int a = Integer.parseInt(parts[1]);
				ar[a].pop();
			}else{
				int roadno = Integer.parseInt(parts[1]) -1 ;
				int u = d[roadno][0];
				int v = d[roadno][1];
				int pu = find(parent,u);
				int pv = find(parent,v);
				
				if(pu == pv){					
					continue;
				}
					
				
				if(rank[pu] > rank[pv]){
					parent[v] = u;
					rank[pu]++;
					
				}
				else{
					parent[u] = v;
					rank[pv]++;
				}				
			}
			
		}
		for(int i=result.size()-1;i>=0;i--)
			System.out.println(result.get(i));
		
	}
	public static void findUnion(int[] parent, int[] rank, int [][]d, boolean [] bad, int n, int m){
		
		for(int i=0;i<m;i++){
			if(bad[i])
				continue;
			int u = d[i][0];
			int v = d[i][1];
			int pu = find(parent,u);
			int pv = find(parent,v);
			
			if(pu == pv)
				continue;
			
			if(rank[pu] > rank[pv]){
				
					parent[v] = u;
				rank[pu]++;
				
			}
			else{
				
					parent[u] =v;
				rank[pv]++;
			}
			
		}
	}
	public static void findMax(BigInteger count[], int[] parent, LinkedList[] ar, int n){
		
		
		
		
		
		for(int i=1;i<=n;i++){
			if(parent[i] == -1){
				//System.out.println("Adding "+ar[i]+" to  "+ count[i]);
				BigInteger newbig = new BigInteger(String.valueOf((Integer)ar[i].peekFirst()));
				//System.out.println("Adding "+newbig +"to  " +count[i] );
				count[i] = count[i].add(newbig) ;
				
			}
			else {
				//System.out.println("Adding "+ar[i]+" to count of "+count[parent[i]]);
				int par = find(parent, i);
				BigInteger newbig = new BigInteger(String.valueOf((Integer)ar[i].peekFirst()));
				//System.out.println("Adding "+newbig +"to  " +count[i] );
				count[par] = count[par].add(newbig);
				
			}
		}
		
		/*for(int i=1;i<=n;i++)
			System.out.print(parent[i]+ " ");
		System.out.println();*/
		
		BigInteger max = new BigInteger(String.valueOf("0"));
		for(int i=1;i<=n;i++)
			if(count[i].compareTo(max) > -1)
				max = count[i];
		
		result.add(max);
		/*for(int i=0;i<=n;i++)
			System.out.print(parent[i]+ " ");
		System.out.println();*/
	}
	
}
