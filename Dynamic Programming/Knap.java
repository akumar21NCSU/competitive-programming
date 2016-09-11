package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Knap {
	
	//public static int maxResult=0;
	
	public static int solveR(int arr[], int k,int n, int index,int sum,int max){
		
		if(index == n)
			return 0;
		
		if(sum > k)
			return 0;
				
		//System.out.println("Calling for sum -"+sum +" and next value -" + arr[index]);
		max = solveR(arr,k,n,index,sum+arr[index],max);
		
		if(sum > max)
			max= sum;
		
		int value = solveR(arr,k,n,index+1,sum,max);
		if(value> max)
			max = value;
		
		return max;
	}

	public static int dSol(int arr[],int k,int n){
		
		int darr[][] = new int[k+1][n+1];
		
		for(int i=0;i<=k;i++)
			darr[i][0]=0;
		
		for(int j=0;j<=n;j++)
			darr[0][j]=0;
		
		int index =0;
		for(int i=1;i<=k;i++){
			
			for(int j=1;j<=n;j++){
				
				if(i < arr[j-1]){
					darr[i][j]= darr[i][j-1];
				}
				else if(i == arr[j-1]){					
						darr[i][j] = 1;	
						if( i > index)
							index =i;
				}else{
					int a = darr[i - arr[j-1]][j];
					int b = darr[i][j-1];
					
					darr[i][j] = (a>b)?a:b;
					if(darr[i][j] == 1 && i > index)
						index =i;
				}
			}			
		}		
		return index;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int t = Integer.parseInt(line);
		
		while(t-- > 0){
		
			line = br.readLine();
			String parts[] = line.split(" ");
			int n = Integer.parseInt(parts[0]);
			int k = Integer.parseInt(parts[1]);
			
			int arr[] = new int[n];
			
			line = br.readLine();
			parts = line.split(" ");
			
			for(int i=0;i<n;i++)
				arr[i]= Integer.parseInt(parts[i]);
			
			//int result = solveR(arr,k,n,0,0,0);
			int result = dSol(arr,k,n);
			System.out.println(result);
			
		}
	}

}
