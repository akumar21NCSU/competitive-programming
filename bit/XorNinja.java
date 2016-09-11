package bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XorNinja {

	public static long power(int n){
		
		long result=1;
		for(int i=0;i<n;i++)
			result = (result*2)%1000000007;
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine().trim();
		int t = Integer.parseInt(line);
		
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine().trim());
			String [] parts = br.readLine().trim().split(" ");
			int ar[] = new int[n];
			for(int i=0;i<n;i++)
				ar[i] = Integer.parseInt(parts[i]);
			
			long result=0;
			
			for(int i=0;i<n;i++)
				result = (result| ar[i])%1000000007;
			
			long pow = power(n-1);
			
			result = (result*pow)%1000000007;
			System.out.println(result);
		}
		
	}

}
