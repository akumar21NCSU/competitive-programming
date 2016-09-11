package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Candy {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line);
		long []candies= new long[n];
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			line = br.readLine();
			arr[i]= Integer.parseInt(line);
			
		}
		candies[0]=1;
		for(int i=1;i<n;i++){
			if(arr[i] > arr[i-1])
				candies[i]= candies[i-1]+1;
			
			else {
				candies[i] = 1;
				for(int j=i;j>0;j--){
					
					if(arr[j-1] > arr[j]){
						if(candies[j-1] <= candies[j])
							candies[j-1] = candies[j-1]+1;
						else
							break;
					}else
						break;
				}
			}
		}
		long result=0;
		for(int i=0;i<n;i++)
			result+=candies[i];
		
		System.out.println(result);
		
	}

}
