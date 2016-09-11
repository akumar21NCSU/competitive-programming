package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ACMTeam {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		String parts[]= line.split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		
		String[] input = new String[n];
		int store[] = new int[m+1];
		store[0] = 0;
		
		for(int i=0;i<n;i++)
			input[i] = br.readLine();
		
		
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				int count = 0;
				for(int k=0;k<m;k++){
					if(input[i].charAt(k) == '1' || input[j].charAt(k) == '1')
						count++;
				}
				store[count] += 1;
			}
		}
		int i=0;
		for( i=m;i>=0;i--){
			if(store[i] > 0){
				System.out.println(i);
				System.out.println(store[i]);
				break;
			}
		}
		if(i == 0){
			System.out.println(0);
			System.out.println((n*n-1)/2);
		}
			
	}

}
