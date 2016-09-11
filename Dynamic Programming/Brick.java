package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Brick {

	public static long max(long a, long b,long c){
		return (a>b)?((a>c)?a:c):((b>c)?b:c);
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int t = Integer.parseInt(line);
		
		while(t-- >0 ) {
			line = br.readLine();
			int n= Integer.parseInt(line);
			line = br.readLine();
			String[] parts = line.split(" ");
			long brick[] = new long[n];
			long max[] = new long[n+3];
			long min[] = new long[n+3];
			
			for(int i=0;i<n+3;i++){
				max[i]=0;
				min[i]=0;
			}
			for(int i=0;i<n;i++)
				brick[i] = Integer.parseInt(parts[i]);
			
			
			long sum=0;
			if(n<=3)
				for(int i=0;i<n;i++)
					sum+=brick[i];
			else{
				max[n-1] = brick[n-1];
				max[n-2] = brick[n-1]+brick[n-2];
				max[n-3]= brick[n-1]+brick[n-2]+brick[n-3];
				
				for(int i=n-4;i>=0;i--){
				//	System.out.println("For brick with number- "+brick[i]);
					long a = brick[i] + min[i+1];
					long b = brick[i]+ brick[i+1] + min[i+2];
					long c = brick[i]+ brick[i+1]+ brick[i+2]+ min[i+3];

					long greatest=0;
					if(a>b){						
						if(a>c){
							greatest = a;
							min[i]= max[i+1];
						}else{
							greatest=c;
							min[i]= max[i+3];
						}
					}else{
						if(b>c){
							greatest = b;
							min[i]= max[i+2];
						}else{
							greatest =c;
							min[i]= max[i+3];
						}
					}
					
					max[i] = greatest;
					
				}
				sum = max[0];
			}
			/*for(int i=0;i<n;i++)
				System.out.print(max[i]+" ");*/
			System.out.println(sum);
		}
		
	}

}
