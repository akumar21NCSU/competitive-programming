package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StockMax {
	
		
	public static long findMaxRec(int[] prices,int n,int index,int stocks,long cp){
		
		if(index==n)
			return 0;
		
		// case 1 - buy one share
		long a = findMaxRec(prices,n,index+1,stocks+1,cp+prices[index]);
		
		// case 2 - sell all share			
		long b = prices[index]*stocks - cp + findMaxRec(prices,n,index+1,0,0) ;
						
		return (a>b)?a:b;
		
	}
	

	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int t = Integer.parseInt(line);
		
		while(t-- > 0){
			
			int n =  Integer.parseInt(br.readLine());
			line = br.readLine();
			String []parts = line.split(" ");
			long prices[] = new long[n];
			for(int i=0;i<n;i++)
				prices[i] = Long.parseLong(parts[i]);
			
			//System.out.println(findMaxRec(prices,n,0,0,0));
			
			long arr[] = new long[n];
			arr[0]=0;
			for(int i=1;i<n;i++)
				arr[i] = arr[i-1]+ prices[i-1];
			
			
			long max=0;
			int topIndex=n-1;
			//int nextTopIndex=0;
			for(int i=n-2;i>=0;i--){
				if(prices[i] <= prices[topIndex])
					continue;
				
				long sales = arr[topIndex] - arr[i+1];
				long diff = topIndex - (i+1);
				long gain = diff*prices[topIndex];
				long profit = gain -sales;
				max=max+profit;
				topIndex = i;
			}
			
			if(topIndex != 0){
				long sales = arr[topIndex] - arr[0];
				long diff = topIndex;
				long gain = diff*prices[topIndex];
				long profit = gain -sales;
				max=max+profit;
			}
			
			/*for(int i=1;i<n;i++){
				long max_now=0;
				for(int j=i;j<n;j++){
					long sales = i*prices[j];
					long cp = arr[j]- arr[j-i];
					if(cp >= sales)
						max_now = max_now+0;
					else
						max_now= max_now+ (sales-cp);
				}
				if(max_now > max)
					max=max_now;
			}*/
			
			/*for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}*/
			/*long max=0;
			for(int i=1;i<n;i++)
				if(arr[i][n-1] > max)
					max = arr[i][n-1];*/
			
			System.out.println(max);
		}
	}

}
