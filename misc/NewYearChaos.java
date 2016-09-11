package misc;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NewYearChaos {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n];
            for(int q_i=0; q_i < n; q_i++){
                q[q_i] = in.nextInt();
            }
            // your code goes here
             int count[] = new int[n+1];
            int posCount = 0;
            int i=0;
            for(i=1;i<=n;i++){
                count[q[i-1]] = q[i-1] - i;
                if(count[q[i-1]] >2)
                    break;
                
            }
            if(i <= n)
                System.out.println("Too chaotic");
            else{
                for(i=1;i<=n;i++){
                    if(count[i]== 0)
                        continue;
                    if(count[i] < 0){
                        int k = 0- count[i];
                        posCount += k;
                        for(int j=1;j<=k;j++){
                        	if(count[i+j]> 0)
                        		count[i+j]= count[i+j]-1;
                        	else
                        		posCount++;
                        }
                    }
                }  
                for( i=1;i<=n;i++)
                	System.out.print(count[i]+" ");
                System.out.println();
                System.out.println(posCount);
            }
        
        }
    }
}
