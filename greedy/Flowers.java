package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Flowers {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		String parts[] = line.split(" ");
		int n = Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		
		line = br.readLine();
		parts = line.split(" ");
		int c[] = new int[n];
		
		for(int i=0;i<n;i++)
			c[i] = Integer.parseInt(parts[i]);
		
		Arrays.sort(c);
		
		int result=0;
		if(k>= n){
			for(int i=0;i<n;i++)
				result+= c[i];
		}else{
			
			for(int i=0;i<n;i++){
				result = result + ((int)(i/k)+1)*c[n-1-i];
				
			}
			
			/*for(int i=0;i<k;i++){
				result += c[n-1-i];
			}*/
		}
		System.out.println(result);
		
	}

}
