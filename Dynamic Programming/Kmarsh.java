package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kmarsh {

	public static void horizontal(int[][] input, int [][] hor, int ver[][], int m, int n) {
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(input[i][j] == 1){
					hor[i][j] = hor[i][j-1] +1;
					ver[i][j] = ver[i-1][j] +1;
				}else{
					hor[i][j] =0;
					ver[i][j]= 0;
				}
			}
		}
		
	}
	
	public static int solve (int [][] input, int[][] hor, int[][] ver, int m, int n){
		
		int maxP =-1;
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				int max=-1;
				if(input[i][j] == 1){
					if(hor[i][j] == 1 || ver[i][j] == 1)
						continue;
					
					int verValue = ver[i][j]; //4
					int horValue =  hor[i][j]; // 5
					
					for(int k =1;k< verValue;k++){
						
						int newhorValue = hor[i-k][j];
						if(newhorValue == 1)
							continue;
						int minHor = (horValue < newhorValue)? horValue:newhorValue;
						
						for(int l= j-minHor+1;l<j; l++){
							int tempVer = ver[i][l];
							if(tempVer >= (k+1)){
								// found a rectangle
								//System.out.println("Found a rect at i = "+ i+" and j = "+j);
								max = 2*(k + (j-l));
								//System.out.println(" Perimeter - "+max);
								if(max> maxP)
									maxP = max;
								break;
							}
						}
						
						
						
					}
				}
			}
		}
		return maxP;
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String parts[] = line.split(" ");
		int m = Integer.parseInt(parts[0]);
		int n = Integer.parseInt(parts[1]);
		
		int input[][] = new int[m+1][n+1];
		int hor[][] = new int[m+1][n+1];
		int ver[][] = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++){
			input[i][0] = 0;
			hor[i][0]=0;
		}
		for(int j=0;j<=n;j++){
			input[0][j] = 0;
			ver[0][j]=0;
		}
		for(int i=1;i<=m;i++){
			line = br.readLine();
			for(int j=1;j<=n;j++){
				if(line.charAt(j-1) == '.')
					input[i][j] = 1;
				else
					input[i][j] = 0;
			}
		}
		
		horizontal(input,hor,ver,m,n);
		
		int perimeter = solve(input,hor,ver,m,n);
		if(perimeter != -1)
			System.out.println(perimeter);
		else
			System.out.println("impossible");
		/*System.out.println();
		displaArray(input, m, n);
		System.out.println();
		displaArray(hor, m, n);
		System.out.println();
		displaArray(ver, m, n);*/
		
	}

	public static void displaArray(int a[][],int m,int n){
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++)
				System.out.print(a[i][j]+ " ");
			System.out.println();
		}
	}
	
}
