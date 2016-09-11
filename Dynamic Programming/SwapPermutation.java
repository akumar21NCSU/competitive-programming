package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SwapPermutation {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		
		String[] parts = line.split(" ");
		int n= Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		
		long MOD = 1000000007;
		//long dp[][] = new long[2501][2501];
		BigInteger dp[][] = new BigInteger[2501][2501];
		
		
		for(int i=0;i<=n;i++)
			dp[0][i] = new BigInteger(String.valueOf(1));
		
		for(int i=1;i<=k;i++){
			
			dp[i][0] = new BigInteger(String.valueOf(0));
			dp[i][1] = new BigInteger(String.valueOf(1));
			dp[i][2] = new BigInteger(String.valueOf(1));
			
			/*dp[i][0] =0;
			dp[i][1] = 1;
			dp[i][2] = 1;*/
		}
		//dp[0][0] = 0;
		dp[0][0] = new BigInteger(String.valueOf(0));
		
		long dp2[][] = new long[2501][2501];
		
		for(int i=0;i<=n;i++)
			dp2[0][i] = 1;
		
		for(int i=1;i<=k;i++){
			dp2[i][0] =0; dp2[i][1] = 1;dp2[i][2] = 2;
		}
		dp2[0][0] = 0;
		
		
		for(int i=1;i<=k;i++){
			for(int j=3;j<=n;j++){
				
				dp2[i][j] = ( dp2[i][j-1] + ((j-1)*(dp2[i-1][j-1]))%MOD)%MOD;
				//long minus =0;
				BigInteger minus=new BigInteger(String.valueOf(0));
				if (i-j >=0){
					minus = dp[i-j][j-1];
					//System.out.println("Minus is "+minus);
				}
				//dp[i][j] = ((dp[i][j-1] + dp[i-1][j]) - minus);
				dp[i][j] = (dp[i][j-1].add(dp[i-1][j]));
				dp[i][j] = dp[i][j].subtract(minus);
				/*int count=0;
				for(int l=0;i-l>=0;l++){
					if(count == j)
						break;
					dp[i][j] = (dp[i][j] + dp[i-l][j-1])%MOD;
					count++;
				}*/
			}
		}
		
		//print
		/*for(int i=0;i<=k;i++){
			for(int j=0;j<=n;j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}*/
		
		
		
		/*for(int i=1;i<=k;i++){
			for(int j=2;j<=n;j++){
				
			}
		}*/
		BigInteger m = new BigInteger(String.valueOf(MOD));
		System.out.println(dp[k][n].mod(m) + " "+ dp2[k][n]);
		//print
				/*for(int i=0;i<=k;i++){
					for(int j=0;j<=n;j++){
						System.out.print(dp2[i][j] + " ");
					}
					System.out.println();
				}*/
	}

}
