package hacker;
import java.io.*;

public class CoinChange {
	
	public static long countSol(int sum, int[]coins,int n){
		
		long arr[][] = new long[sum+1][n+1];
		
		for(int i=0;i<=sum;i++){
			
			for(int j=0;j<=n;j++){				
				if(i==0){
					arr[i][j]= 1;
					continue;
				}
				if(j==0){
					arr[i][j] = 0;
				}else{
					if(i < coins[j-1]){
						arr[i][j]=arr[i][j-1];
					}else{
						//System.out.println("Computing for i= "+i+" and j= "+j);
						arr[i][j]= arr[i][j-1] + arr[i- coins[j-1]][j];
					}
						
				}
				
			}
			
		}
		/*for(int i=0;i<=sum;i++){
			
			for(int j=0;j<= n;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}*/
		return arr[sum][n];	
	}

	/*public static int countSol(int sum, int[]coins,int n,int index){
		if(index == n)
			return 0;
		
		if(sum == coins[index]){
			return 1;
		}
		
		if(sum < 0)
			return 0; 
		
		int count =0;
		count = countSol(sum,coins,n,index+1) + countSol(sum-coins[index],coins,n,index);
		
		return count;
	}*/
	
	public static void main(String[] args) throws Exception{
		int n,m;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String parts[] = line.split(" ");
		n=Integer.parseInt(parts[0]);
		m=Integer.parseInt(parts[1]);
		int [] coins= new int[m];
		line = br.readLine();
		parts = line.split(" ");
		for(int i=0;i<m;i++)
			coins[i] = Integer.parseInt(parts[i]);
		System.out.println(countSol(n,coins,m));
	}

}
