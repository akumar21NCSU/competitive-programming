package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class CoinOnTable {
	
	public static long INF = 99999999999L;
	
	public static long min(long a,long b,long c, long d){
		
		long min =a;
		min = (min<b)?min:b;
		min = (min<c)?min:c;
		min = (min<d)?min:d;
		
		return min;
	}

	
	
	public static long mul(char[][] board, int n,int m, int xpos, int ypos, int k) {
		
		long dp[][] = new long[n+2][m+2];
		long time[][] = new long[n+2][m+2];
		
		for(int i=0;i<n+2;i++)
			for(int j=0;j<m+2;j++)
				dp[i][j] = time[i][j]=INF;
		
		dp[xpos][ypos]=0;
		time[xpos][ypos] =0;
		
		for(int counter =0;counter < k; counter++){
			for(int i=1;i<=n;i++){
				for(int j=1;j<=m;j++){
					if(i == xpos && j == ypos)
						continue;
					
					long lvalue = dp[i][j-1];
					if(lvalue < dp[i][j] && time[i][j-1] < k){
						dp[i][j] = lvalue;
						time[i][j] = time[i][j-1]+1;
						if(board[i][j] != 'L')
							dp[i][j] = dp[i][j]+1;
					}
					
					long rvalue = dp[i][j+1];
					if(rvalue < dp[i][j] && time[i][j+1] < k){
						dp[i][j] = rvalue;
						time[i][j] = time[i][j+1]+1;
						if(board[i][j] != 'R')
							dp[i][j] = dp[i][j]+1;
					}
					
					
					long tvalue = dp[i-1][j];
					if(tvalue < dp[i][j] && time[i-1][j] < k){
						dp[i][j] = tvalue;
						time[i][j] = time[i-1][j]+1;
						if(board[i][j] != 'U')
							dp[i][j] = dp[i][j]+1;
					}
					
					long bvalue = dp[i+1][j];
					if(bvalue < dp[i][j] && time[i+1][j] < k){
						dp[i][j] = bvalue;
						time[i][j] = time[i+1][j]+1;
						if(board[i][j] != 'D')
							dp[i][j] = dp[i][j]+1;
					}
					
				}
				
			}
			/*for(int ii=0;ii<n+2;ii++){
				
				for(int jj=0;jj<m+2;jj++)
					System.out.print(dp[ii][jj]+" ");
				
				System.out.println();
			}*/
		}
		
		/*for(int i=0;i<n+2;i++){
			
			for(int j=0;j<m+2;j++)
				System.out.print(dp[i][j]+" ");
			
			System.out.println();
		}*/
		
		return (dp[1][1] < INF)?dp[1][1]:-1;	// check for k
		//return dp[1][1];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		String [] parts = line.split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int k = Integer.parseInt(parts[2]);
		
		char[][] board = new char[n+1][m+1];
		int xpos=0;
		int ypos=0;
		
		for(int i=0;i<n;i++){
			line = br.readLine();
			for(int j=0;j<m;j++){
				board[i+1][j+1] = line.charAt(j);
				if(board[i+1][j+1] == '*'){
					xpos=i+1;
					ypos=j+1;
				}
			}
		}
		/*if(xpos+ypos > k)
			System.out.println("-1");*/
		//else{
			//long result = solveR(board,n,m,xpos,ypos,k);		
		
		//long result = solve(board,n,m,xpos,ypos,k);
		
		long result = mul(board,n,m,xpos,ypos,k);
			System.out.println(result);
		//}
	}

}
