import java.io.*;

class Stairway{
	
	
	public static int smallest(int a, int b){
		return (a<b)?a:b;
	}

	public static int func(int[][] arr,int barr[][], int index, int k, int n,int p){
		if(index == n-1){
			arr[1][index]=arr[0][index];
			return arr[0][index];
		}
		if(index> n-1)
			return 999999;
	
		
		if(arr[1][index] !=0)
			return arr[1][index];

		int val = arr[0][index];
		int s=999999;
		int min = s;
		for(int i=1;i<=k;i++){
			s = smallest(func(arr,barr,index+i,k,n,p),func(barr,arr,index+i,k,n,p)+p);
			if(s<min)
				min = s;
		}
		arr[1][index] = val+min;
		//if(index == 0)
			//System.out.println(mem[index]+" " +(val+min));
		return val+min;
	}

	public static void main(String ...args)throws Exception{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- >0){
			String[] parts = br.readLine().split(" ");
			int n=Integer.parseInt(parts[0]);
			int k=Integer.parseInt(parts[1]);
			int p=Integer.parseInt(parts[2]);

			parts = br.readLine().split(" ");
			int a[][]= new int[2][n];

			for(int i=0;i<n;i++){
				a[0][i] = Integer.parseInt(parts[i]);
				a[1][i] = 0;
			}

			int b[][]= new int[2][n];		
			parts = br.readLine().split(" ");

			for(int i=0;i<n;i++){
				b[0][i] = Integer.parseInt(parts[i]);
				b[1][i] = 0;
			}

			int c[][];
			if(b[0][0] <a[0][0]){
				c = b;
				b=a;
				a=c;
			}
			
		
			int result= func(a,b,0,k,n,p);
			System.out.println(result);

		}
		/*for(int i=0;i<n;i++)
			System.out.print(a[1][i]+" ");

		System.out.println();
		for(int i=0;i<n;i++)
			System.out.print(b[1][i]+" ");*/

	}

}
