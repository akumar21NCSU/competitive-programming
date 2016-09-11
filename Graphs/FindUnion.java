package graph;

import java.io.*;
import java.util.*;

public class FindUnion {

	public static void main(String[] args) throws Exception{
		int n,m,k,id;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().trim().split(" ");
		
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		int parent[] = new int[n];
		
		for(int i=0;i<n;i++)
			parent[i]= i;
		
		int rel[] = new int[m*2];
		
		for(int i=0;i<m;i++){
			
			String[] line = br.readLine().split(" ");
			int num1 = Integer.parseInt(line[0]);
			int num2 = Integer.parseInt(line[1]);
			rel[i*2] = num1;
			rel[i*2 +1] =num2;
			
		}
		
		k = Integer.parseInt(br.readLine());
		
		for(int i=0;i<k;i++){
			id = Integer.parseInt(br.readLine());
			parent[id] = -1;
		}
			
		for(int i=0;i<m;i++){
			
			
			int num1 = rel[i*2];	//5-6-7
			int num2 = rel[i*2+1];	//1-2-3
			
			int p1 = parent[num1];	//5
			int p2 = parent[num2];	//1
			
			if(p1 <0 || p2 <0)
				continue;
			
			if(p1 < p2){
				//parent[num2] = p1;
				for(int j=0;j<n;j++)
					if(parent[j]== p2)
						parent[j]=p1;
			}
			else if(p2<p1){
			//	parent[num1] = p2;
				
				for(int j=0;j<n;j++)
					if(parent[j]== p1)
						parent[j]=p2;
			}
		}
		
		boolean visited[] = new boolean[n];
		for(int i=0;i<n;i++)
			visited[i]=false;
		
		int result=0;
		for(int i=0;i<n;i++){
			if(parent[i] == -1)
				result++;
			else{
				if(visited[parent[i]]==false){
					result++;
					visited[parent[i]] = true;
				}
					
			}
			
		}
		System.out.println(result);
	}

}
