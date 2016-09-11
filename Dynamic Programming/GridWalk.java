package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class GridWalk {

	/*public static long func(int m, int xi, int di){
		
		if(xi<=0 || xi>di )
			return 0;
		
		if(m == 0)
			return 1;
		
		long sum = func(m-1, xi+1,di)%1000000007 + func(m-1,xi-1,di)%1000000007;
		//System.out.println("Sum is "+sum);
		return sum;
		
	}*/
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int t = Integer.parseInt(line);
		
		
		// combination
		long ncr[][] = new long[301][301];
		
		for(int i=0;i<301;i++){
			
			ncr[i][0] = ncr[i][i] = 1;
			for(int j=1;j<i;j++){				
				ncr[i][j] = (ncr[i-1][j-1] + ncr[i-1][j])%1000000007;
			}
		}
		
		
		while(t-- > 0){
			line = br.readLine();
			String parts[] = line.split(" ");
			int n = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			
			line = br.readLine();
			parts = line.split(" ");
			int xiArray[] = new int[n];
			for(int i=0;i<n;i++)
				xiArray[i]=Integer.parseInt(parts[i]);
			
			line = br.readLine();
			parts = line.split(" ");
			int diArray[] = new int[n];
			for(int i=0;i<n;i++)
				diArray[i]=Integer.parseInt(parts[i]);

			long result =0;
			long [][] noOfWays = new long[m+1][n]; // contains seperate values of each dimension
			
			
			for(int k=0;k<n;k++){
				int di = diArray[k];
				
				long arr[][] = new long[m+1][di+2];
	
				for(int i=1;i<=di;i++)
					arr[0][i] =1;
				
				for(int i=0;i<=m;i++)
					arr[i][0] = arr[i][di+1]=0;
				
				for(int i=1;i<=m;i++){				
					for(int j=1;j<=di;j++){
						arr[i][j] = (arr[i-1][j-1]%1000000007 + arr[i-1][j+1]%1000000007)%1000000007;
						//farray[i][j] = (farray[i][j]+arr[i][j])%1000000007;
					}
				}
			
				//result = (result+arr[m][xiArray[k]])%1000000007;
				
				for(int i=0;i<=m;i++){
					noOfWays[i][k] = arr[i][xiArray[k]];
				}
				
			}
			long resultArray[][] = new long[m+1][n];
			
			for(int i=0;i<n;i++){
				
				for(int j=0;j<=m;j++){
					if(i==0){
						resultArray[j][0]= noOfWays[j][0];
						continue;
					}
					result=0;
					for(int k=0;k<=j;k++){
						long temp = (resultArray[k][i-1]* noOfWays[j-k][i])%1000000007;
						temp = (temp * ncr[j][j-k])%1000000007;
						result = (result + temp)%1000000007;
					}
					resultArray[j][i] = result;
				}
				
			}
			
			/*for(int i=0;i<=m;i++){
				for(int j=0;j< n;j++)
					System.out.print(farray[i][j] + " ");
				System.out.println();
			}*/
			/*for(int i=0;i<m;i++){				
				result = (result*result)%1000000007;
			}*/
						
			System.out.println(resultArray[m][n-1]);
			
		}
	}

}
