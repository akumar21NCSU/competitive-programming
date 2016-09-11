package bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sansa {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine().trim();
		int t = Integer.parseInt(line);
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine().trim());
			String parts[] = br.readLine().trim().split(" ");
			int ar[] = new int[n];
			for(int i=0;i<n;i++)
				ar[i] = Integer.parseInt(parts[i]);
			
			if(n%2 == 0)
				System.out.println(0);
			else{
				int result=0;
				for(int i=0;i<ar.length;i=i+2)
					result = result^ar[i];
				System.out.println(result);
			}
				
			
		}
		
	}

}
