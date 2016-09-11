package bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FlipBits {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int t = Integer.parseInt(line.trim());
		
		while(t-- > 0){
			
			Long num = Long.parseLong(br.readLine().trim());
			
			num = num ^((1L<<32) -1);
			System.out.println(num);
		}
		
	}

}
