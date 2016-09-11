package bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Manipulative {

	public static boolean isOk(int ar[]){
		
		Arrays.sort(ar);
		
		int count=0;
		int limit = ar.length/2;
		
		for(int i=0;i<ar.length;i++){
			if(i == 0 || ar[i] != ar[i-1])
				count=1;
			else
				count++;
			
			if(count> limit)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		int n = Integer.parseInt(line.trim());
		int ar[] = new int[n];
		line = br.readLine().trim();
		String parts[] = line.split(" ");
		
		for(int i=0;i<n;i++)
			ar[i] = Integer.parseInt(parts[i]);
		
		for(int k=31;k>=0;k--){
			int temp[] = new int[n];
			
			for(int i=0;i< n;i++)
				temp[i] = ar[i]>>k;
			
			boolean result = isOk(temp);
			if(result){
				System.out.println(k);
				return;
			}
				
			
		}
		System.out.println(-1);
	}

}
