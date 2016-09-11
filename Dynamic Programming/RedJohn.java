package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RedJohn {

	public static int solveForP(boolean [] primeSieve,int m) {
		
		int count=0;
		for(int i=2;i<=m;i++)
			if(primeSieve[i] == true)
				count++;
		
		return count;
		
	}
	
	public static int solveForM(int n){
		
		if(n<0)
			return 0;
		
		if(n==0)
			return 1;
		
		return solveForM(n-4) + solveForM(n-1);
		
		
	}
	
	public static void main(String[] args) throws Exception{
		int t,n,m,p;
		
		boolean primeSieve [] = new boolean[10000000];
		for(int i=0;i<10000000;i++)
			primeSieve[i] = true;
		
		for(int i=2;i<5000000;i++){
			if(primeSieve[i] == false)
				continue;
			for(int j=i*2;j< 10000000;j=j+i){
				primeSieve[j] = false;
			}
		}
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		t = Integer.parseInt(line);
		
		while(t-- > 0){
			
			n = Integer.parseInt(br.readLine());
			m = solveForM(n);
			//System.out.println("M is "+m);
			p = solveForP(primeSieve,m);
			System.out.println(p);
		}
		
	}

}
