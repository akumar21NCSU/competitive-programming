package bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Counter {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		
		int t = Integer.parseInt(line);
		while(t-- > 0){
			
			BigInteger n = new BigInteger(br.readLine());			
			BigInteger barr[] = new BigInteger[65];			
			BigInteger start = new BigInteger(String.valueOf(2));
			BigInteger end = new BigInteger(String.valueOf(1));
			
			for(int i=0;i<65;i++){
				barr[i] = start.pow(i);
			}
			int result=0;
			while(!(n.compareTo(end) == 0)){
				//System.out.println("N = "+n);
				for(int i=0;i<65;i++){
					if(n.compareTo(barr[i]) == 0){
						n = n.subtract(n.divide(start));
						result++;
						break;
					}
					else if( n.compareTo(barr[i]) == -1){
						BigInteger temp = barr[i-1];
						n = n.subtract(temp);
						result++;
						break;
					}
				}				
			}
			
			if(result % 2 == 0)
				System.out.println("Richard");
			else
				System.out.println("Louise");
		}
	}

}
