package misc;

import java.io.*;

public class FourStrings {

	public int matchCount(String a, String b){
		
		int ar[][] = new int[a.length()][b.length()];
		
		for(int i=0;i<a.length();i++){
			for(int j=0;j<b.length();j++){
				if(b.charAt(j) == a.charAt(i))
					ar[i][j] = 1;
			}
		}
		int count=0;
		for(int i=0;i<a.length();i++){
			for(int j=0;j<b.length();j++){
					
			}
		}
		return 0;
	}
	
	public int shortestLength(String a, String b, String c, String d){
		
		int count=0;
		int c1 = matchCount(a,b);
		int c2 = matchCount(a,c);
		int c3 = matchCount(a,d);
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		String [] parts = line.split(" ");
		new FourStrings().shortestLength(parts[0], parts[1], parts[2], parts[3]);
	}

}
