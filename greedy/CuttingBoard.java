package greedy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CuttingBoard {

	public static void reverse(long []ar){
		
		int n= ar.length;
		
		for(int i=0;i<n/2;i++){
			long temp = ar[i];
			ar[i] = ar[n-1-i];
			ar[n-1-i] =temp;
		}
			
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int t = Integer.parseInt(line);
		
		while(t-- > 0){
			line = br.readLine();
			String parts[] = line.split(" ");
			int n = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			
			line = br.readLine();
			parts = line.split(" ");
			Long yar[] = new Long[parts.length];
			
			for(int i=0;i<yar.length;i++)
				yar[i] = Long.parseLong(parts[i]);
			
			
			line = br.readLine();
			parts = line.split(" ");
			Long xar[] = new Long[parts.length];
			
			for(int i=0;i<xar.length;i++)
				xar[i] = Long.parseLong(parts[i]);
			
			Arrays.sort(xar,Collections.reverseOrder());
			//reverse(xar);
			Arrays.sort(yar,Collections.reverseOrder());
			//reverse(yar);
			
			//System.out.println("xar "+xar.length +" yar "+ yar.length);
			
			long hseg=1;
			long vseg=1;
			
			int xptr=0;
			int yptr=0;
			
			long sum=0;
			
			int MOD = 1000000007;
			
			while(xptr <xar.length && yptr <yar.length){
				
								
				if(xar[xptr] > yar[yptr]){
					sum= (sum+ (long)((long)hseg* (long)xar[xptr])%MOD)%MOD;
					vseg++;
					xptr++;
				}else{
					sum= (sum + (long)((long)vseg* (long)yar[yptr]))%MOD;
					hseg++;
					yptr++;
				}
				
			}
			//System.out.println("interim"+sum);
			if(xptr < xar.length){
				for(int i=xptr;i<xar.length;i++)
					sum= (sum+ (long)((long)hseg* (long)xar[i])%MOD)%MOD;
				
			}
			if(yptr < yar.length){
				for(int i=yptr;i<yar.length;i++)
					sum= (sum+ (long)((long)vseg* (long)yar[i]))%MOD;
			}
			
			System.out.println(sum);
		}
		
	}
	
	
	

}
