package hacker;

import java.io.*;
import java.util.*;

public class Kadane {

	public static int int_min = -999999;
	
	public static int contig(int[] arr, int n){
		
		int max_so_far = int_min;
		int max=int_min;
		
		for(int i=0;i<n;i++){
			max_so_far = max_so_far + arr[i];
			if(arr[i] > max_so_far){
				max_so_far = arr[i];
			}
			if(max_so_far > max){
				max = max_so_far;
			}
		}
		return max;
	}
	public static int nonContig(int[] arr,int n){
		
		int max_so_far = int_min;
		int max_pos = 0;
		int posCounter=0;
		
		for(int i=0;i<n;i++){
			if(arr[i] >=0 ){
				posCounter++;
				max_pos = max_pos+arr[i];
			}
			else{
				if(arr[i] > max_so_far)
					max_so_far = arr[i];
			}	
						
		}
		if(posCounter ==0)
			return max_so_far;
		else
			return max_pos;
	}
	
	public static void main(String[] args) throws Exception{

		int t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		t = Integer.parseInt(line);
		
		while(t-- >0){
			int n = Integer.parseInt(br.readLine());
			String []nums = br.readLine().split(" ");
			int arr[] = new int[n];
			for(int i=0;i<nums.length;i++){
				arr[i] = Integer.parseInt(nums[i]);
			}
			System.out.println(contig(arr,n)+" "+nonContig(arr,n));
			
		}
		
		
	}

}
