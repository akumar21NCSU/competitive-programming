package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class IndianJob {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		int t = Integer.parseInt(line);
		while(t-- >0){
			line = br.readLine();
			String parts[] = line.split(" ");
			int n = Integer.parseInt(parts[0]);
			int g = Integer.parseInt(parts[1]);
			int arr[] = new int[n];
			line = br.readLine();
			parts = line.split(" ");
			long sum=0;
			for(int i=0;i<n;i++){
				arr[i] = Integer.parseInt(parts[i]);
				sum = sum+arr[i];
				if(arr[i] > g){
					sum=-1;
					break;
				}
			}
			if(sum == -1){
				System.out.println("NO");
				continue;
			}
			if(sum > 2*g){
				System.out.println("NO");
				continue;
			}
			
			int dp[][] = new int[g+1][n+1];
			for(int i=0;i<=g;i++)
				dp[i][0] = 0;
			
			for(int j=0;j<=n;j++)
				dp[0][j]= 1;
			
				for(int i=1;i<=g;i++){
					for(int j=1;j<=n;j++ ){
						if(arr[j-1] <= i){
							dp[i][j] = dp[i][j-1] | dp[i-arr[j-1]][j-1];
						}
						else
							dp[i][j] = dp[i][j-1];
						
					}
				}
			
			/*for(int i=0;i<=g;i++){
				for(int j=0;j<=n;j++)
					System.out.print(dp[i][j]+ " ");
				System.out.println();
			}*/
				int found=0;
				for(int i=g;i>0;i--){
					if(dp[i][n] > 0){
						found=i;
						break;
					}
				}
				if(sum - found <= g)
					System.out.println("YES");
				else
					System.out.println("NO");
				
			/*long low = sum -g;
			long high = g;
			if(low > high)
				System.out.println("NO");
			else{
			int dp[][] = new int[g+1][n+1];
			for(int i=0;i<=g;i++)
				dp[i][0] = 0;
			
			for(int j=0;j<=n;j++)
				dp[0][j]= 1;
			
				for(int i=1;i<=g;i++){
					for(int j=1;j<=n;j++ ){
						if(arr[j-1] <= i){
							dp[i][j] = dp[i-1][j] | dp[i-arr[j-1]][j-1];
						}
						else
							dp[i][j] = dp[i][j-1];
						
					}
				}
				boolean result = false;
				for(int i= new Long(low).intValue();i<=g;i++){
					if(dp[i][n] > 0){
						result = true;
						break;
					}
				}
				if(result)
					System.out.println("YES");
				else
					System.out.println("NO");
			}*/
		}
	}

}
