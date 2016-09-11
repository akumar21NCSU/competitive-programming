package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HexaGrid {
	
	public static boolean solveR(int arr[][], int tIndex, int vIndex){
		
		System.out.println("Called for t "+tIndex +" and v "+vIndex);
		if(tIndex<0 && vIndex <0)
			return true;
		
		boolean result=false;
				
		if(tIndex == vIndex){			
			
			if(arr[0][tIndex] == arr[1][vIndex]){
				result = result || solveR(arr,tIndex-1,vIndex-1);
			}else{
				if(arr[0][tIndex] == 1)
					result = result || solveR(arr,tIndex-1,vIndex);
				else
					result = result || solveR(arr,tIndex,vIndex-1);				
			}							
		}
		else{			
			if(tIndex > vIndex){
				// two options
				if(arr[0][tIndex] == 1)
					result = result || solveR(arr,tIndex-1,vIndex);
				else{
					if(tIndex >0 && arr[0][tIndex-1] == 0)
						result = result || solveR(arr,tIndex-2,vIndex);
					if(vIndex >= 0 && arr[1][vIndex] == 0)
						result = result || solveR(arr,tIndex-1,vIndex-1);
				}				
								
			}else{
				//System.out.println("In here with vIndex as "+vIndex);
				if(arr[1][vIndex] ==1)
					result = result || solveR(arr,tIndex,vIndex-1);
				else{
					if(vIndex >0 && arr[1][vIndex-1] == 0)
						result = result || solveR(arr,tIndex,vIndex-2);
					/*if(tIndex >= 0 && arr[0][tIndex] == 0)
						result = result || solveR(arr,tIndex-1,vIndex-1);*/
				}
			}
		}		
		return result;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		
		int t = Integer.parseInt(line);
		while(t-- >0){
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[2][n];
			
			line = br.readLine();
			for(int i=0;i<n;i++)
				arr[0][i] = Integer.parseInt(String.valueOf(line.charAt(i)));
			
			line = br.readLine();
			for(int i=0;i<n;i++)
				arr[1][i] = Integer.parseInt(String.valueOf(line.charAt(i)));
			
			boolean result = solveR(arr,n-1,n-1);
			System.out.println((result)?"YES":"NO");
			
		}		
	}

}
