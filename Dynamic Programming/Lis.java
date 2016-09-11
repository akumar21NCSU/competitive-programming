package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lis {
	
	public static int bSearch(int size[], int index, int key){
		
		int low = 0;
		int high = index;
		
		while(low<= high){
			int mid = (low+high)/2;
			if(size[mid] == key)
				return mid;
			if(size[mid] < key)
				low = mid+1;
			else
				high = mid-1;
		}
		return low;
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		int n = Integer.parseInt(line);
		int arr[] = new int[n];
		int dp[] = new int[n];
		int size[] = new int [n];
		for(int counter =0;counter<n;counter++){
			arr[counter]= Integer.parseInt(br.readLine());
			dp[counter] =1;
		}
		/*for(int i=1;i<n;i++){
			for(int j=i-1; j>=0; j--){
				if(arr[i] > arr[j]){
					if(dp[j] +1 > dp[i]){
						dp[i] = dp[j]+1;
					}
				}					
			}
		}
		int max=1;
		for(int i=0;i<n;i++){
			if(dp[i]>max)
				max=dp[i];
		}
		System.out.println(max);*/
		int index=0;
		size[index] = arr[0];
		for(int i=1;i<n;i++){
			int insertAt  = bSearch(size,index,arr[i]);
			if(insertAt > index)
				index = insertAt;
			size[insertAt] = arr[i];
		}
		System.out.println(index+1);
	}

}
