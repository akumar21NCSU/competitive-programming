package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LCS {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		String [] parts = line.split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		
		int arrA[] = new int [n];
		int arrB[] = new int[m];
		
		line = br.readLine();
		parts = line.split(" ");
		for(int i=0;i<n;i++)
			arrA[i] = Integer.parseInt(parts[i]);
		
		line = br.readLine();
		parts = line.split(" ");
		for(int i=0;i<m;i++)
			arrB[i] = Integer.parseInt(parts[i]);
		
		
		int dp[][] = new int[n+1][m+1];
		int max=0;
		int maxIndexi=0;
		int maxIndexj=0;
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				dp[i][j]=0;
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(arrA[i-1] == arrB[j-1]){
					dp[i][j] = dp[i-1][j-1] +1;
					if(dp[i][j] > max){
						max = dp[i][j];
						maxIndexi = i;
						maxIndexj=j;
					}
				}
				else
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
			}
		}
		//System.out.println("Max index are "+maxIndexi+","+maxIndexj);
		int counter=1;
		
				
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(arrB[maxIndexj-1]);
		
		/*for(int i=maxIndexi-1;i<0 ;i--)
			for(int j=maxIndexj-1;j<0;j--)
				if(dp[i][j] == max-counter && dp[i][j-1]!= max-counter && dp[i-1][j]!= max-counter){
					System.out.print(arrB[j-1]+" ");
					result.add(arrB[j-1]);
					counter++;
					break;
				}*/
		
		
		int ii = maxIndexi-1;
		int jj = maxIndexj-1;
		
		while(counter != max){
						
				for(int k=jj;k>0;k--){
					if(dp[ii][k] == max-counter && arrA[ii-1]== arrB[k-1]){
						result.add(arrB[k-1]);
						counter++;
						jj =k-1;
						break;
					}
				}
				ii--;
		}
		for(int i=result.size()-1;i>0;i--)
			System.out.print(result.get(i)+" ");
		
		System.out.print(result.get(0));
		//System.out.print(arrB[maxIndexj-1]);
		//StringBuffer sb = new StringBuffer("");
		/*ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(arrB[maxIndexj-1]);
		
		//sb.append(arrB[maxIndexj-1]);
		
			for(int i= maxIndexi -1; i>0; i--){
				for(int j=1;j<= maxIndexj -counter;j++){
					if(dp[i][j] == max-counter){
						result.add(arrB[j-1]);
						counter++;
					}
				}
			}
			
			for(int i=result.size()-1;i>0;i--)
				System.out.print(result.get(i)+" ");
			
			System.out.print(result.get(0));*/
		/*for(int j=1; j<= maxIndexj;j++){
			if(dp[maxIndexi][j] > counter){
				sb.append(arrB[j-2]+" ");
				counter++;
			}
		}*/
		
		//sb.append(arrB[maxIndexj-1]);
		//System.out.println(sb.reverse().toString());
		/*for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}*/
		//	System.out.println("Max is "+max+" and index are "+maxIndexi+","+maxIndexj);
	}

}
