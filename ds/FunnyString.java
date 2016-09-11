package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FunnyString {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int t = Integer.parseInt(line);
		
		while(t-- > 0){
			String s = br.readLine();
			int n = s.length();
			
			int arr[] = new int[n];
			
			for(int i=1;i<n;i++){
				arr[i-1] = s.charAt(i) - s.charAt(i-1);
				if(arr[i-1] < 0 )
					arr[i-1] = 0 - arr[i-1];
			}
			
			/*for(int i=0;i<n;i++)
				System.out.print(arr[i]+ " ");*/
			
			int ceilIndex =(int) Math.ceil(n/2.0) -1;
			int floorIndex =(int) Math.floor(n/2.0) -1;
			//System.out.println("Index are "+ ceilIndex + "  "+ floorIndex);
			boolean funny = true;
			while(ceilIndex < n && floorIndex >=0){
				if(arr[ceilIndex] != arr[floorIndex]){
					funny = false;
					//System.out.println("n is "+n);
					//System.out.println("Index are "+ ceilIndex + "  "+ floorIndex);
					break;
				}
					ceilIndex++;
					floorIndex--;
			}
			if(funny)
				System.out.println("Funny");
			else
				System.out.println("Not Funny");
		}
		
	}

}
