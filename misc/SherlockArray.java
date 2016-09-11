package misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SherlockArray {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		int t = Integer.parseInt(line);
		while(t-- > 0){
		
		int n = Integer.parseInt(br.readLine());
		line = br.readLine();
		String parts[] = line.split(" ");
		int ar[] = new int[n];
		long lSum[] = new long[n];
		long sum =0;
		
		for(int i=0;i<n;i++){
			ar[i] = Integer.parseInt(parts[i]);
			sum += ar[i];
			lSum[i] = sum;
		}
		
		long rSum =0;
		boolean accept=false;
		
		for(int i=n-1;i>=0;i--){
			if((lSum[i] - ar[i]) == rSum){
				accept = true;
				//System.out.println("For i = "+i);
				break;
			}
			rSum = rSum + ar[i];
		}
		if(accept)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		}
	}

}
