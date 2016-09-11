import java.io.*;

public class Partition {

	public int part(int sum, int large){
		
		if(large <2)
			return 0;
		
		int res =0;
		if( sum ==  large)
			res=1;
		
		return res + part(sum,large-1) + part(sum-large,java.lang.Math.min(sum-large, large));
		
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		n = Integer.parseInt(input);
		
		long a[][]= new long[n+1][n+1] ;
		
		for(int i=0;i<=n;i++)
			for(int j=0;j<=n;j++)
				a[i][j]=0;
		
		
		for(int i=2;i<=n;i++)
			for(int j=i;j<=n;j++){
				
				if(i==j){
					a[i][j] = a[i][j] +1;					
				}		
				long num1 = (a[i-1][j])%1000000007;
				long num2 = (a[Math.min(i,j-i)][j-i])%1000000007;
				
				a[i][j]= (a[i][j] + num1 + num2)%1000000007;
				
			}
		
		/*for(int i=1;i<=n;i++){
			
			for(int j=1;j<=n;j++)
				System.out.print(a[i][j] + "  ");
			System.out.println();
		}*/
		
		System.out.println(a[n][n]);
	}

}
