package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SquareSeq {
	
	public static void displayDp(int dp[][],int n){
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(dp[i][j]);
			System.out.println();
		}
	}
	public static int mod = 100000007;
	
	public static int  work(char ss[],int k,int n) {
		int ans[][] = new int [10][10];
		int n1 = k, n2 = n - k - 1;
		for(int i=1; i<=n1; ++i)
			ans[i][0] = ans[i-1][0] + (ss[i-1] == ss[k] ? 1 : 0);
		for(int i=1; i<=n1; ++i)
			for(int j=1; j<=n2; ++j) {
				ans[i][j] = (ans[i][j-1] + ans[i-1][j])%mod;
				if(ss[i-1] != ss[k+j])
					ans[i][j] = (ans[i][j] - ans[i-1][j-1] + mod)%mod;
			}
		System.out.println("For i= "+k);
		System.out.println("Returning = "+ans[n1][n2]);
		displayDp(ans, n);
		return ans[n1][n2];
	}

	public static long solveDP(String s){
		long result =0L;
		int length = s.length();
		long dp[][][] = new long[length][length][length/2];
		
		// base array
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				if(s.charAt(i) == s.charAt(j)){
					dp[i][j][0]= 1;
					result = (result+1)%1000000007;
				}
			}
		}
		
		for(int k=1;k<length/2;k++){			
			for(int i=0+k;i<length;i++){
				for(int j=i+1;j<length;j++){
					if(s.charAt(i) == s.charAt(j)){
						//check1
						if(j-i < k+1)
							continue;
						
						
					}
				}
			}
		}
		
		//displayDp(dp,0,length);
		
		return result;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		
		int t = Integer.parseInt(line);
		while(t-- >0){
			
			String s = br.readLine();
			long result=0;
			for(int i=1;i<s.length();i++)
			     result += work(s.toCharArray(),i,s.length());
			
			System.out.println(result);
		}
	}

}
