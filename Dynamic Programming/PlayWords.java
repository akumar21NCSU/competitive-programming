package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayWords {
	
	public static long palLength(String s1, int len){
		
		
		long dp[][] = new long[len][len];
		for(int i= len-1; i>=0;i--){
			dp[i][i] = 1;
			for(int j= i+1; j< len; j++){
				if(s1.charAt(i) == s1.charAt(j)){
					dp[i][j] = 2+ dp[i+1][j-1];
				}else
					dp[i][j] = (dp[i][j-1] > dp[i+1][j])?dp[i][j-1]:dp[i+1][j];
			}
		}
		return dp[0][len-1];
	}
	

	public static long solve(String s, int index, long result){
		
		String s1 = s.substring(0,index);
		String s2 = s.substring(index, s.length());
		
		long len1 = palLength(s1,s1.length());
		long len2 = palLength(s2,s2.length());
		//System.out.println("Lens are "+len1 +","+len2);
		if(len1* len2 > result)
			result = len1*len2;
		
		return result;
		
	}
	public static long solveEff(String s, int len){
		
		long dp[][] = new long[len][len];
		for(int i= len-1; i>=0;i--){
			dp[i][i] = 1;
			for(int j= i+1; j< len; j++){
				if(s.charAt(i) == s.charAt(j)){
					dp[i][j] = 2+ dp[i+1][j-1];
				}else
					dp[i][j] = (dp[i][j-1] > dp[i+1][j])?dp[i][j-1]:dp[i+1][j];
			}
		}
		long result =1;
		for(int i=1;i<len-1;i++){
			long len1 = dp[0][i];
			long len2 = dp[i+1][len-1];
			if(len1*len2 > result)
				result = len1*len2;
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String s = br.readLine();
		long result=0;
		
		/*for(int i=1;i<s.length();i++)
			result = solve(s,i,result);*/
		
		result = solveEff(s,s.length());
		System.out.println(result);		
		
	}

}
