package bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxXOR {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int l = Integer.parseInt(line);
		int r = Integer.parseInt(br.readLine());
		
		
		int n = l^r;
		
			for(int i=0;i<12;i++){
				int p = (int)Math.pow(2, i);
				
				if(n < p){
					System.out.println((int)Math.pow(2, i) - 1);
					break;
				}
			}
		
	}

}
