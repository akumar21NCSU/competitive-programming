package bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LonelyInteger {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int n = Integer.parseInt(line);
		int ar[] = new int[n];
		
		line = br.readLine();
		String[] parts = line.split(" ");
		int result=0;
		
		for(int i=0;i<n;i++){
			ar[i] = Integer.parseInt(parts[i]);
			result = result^ar[i];
		}
		System.out.println(result);
		
	}

}
