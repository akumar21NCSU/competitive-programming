package misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BikerHungarian {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		String[] parts = line.split(" ");
		
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int k = Integer.parseInt(parts[2]);
		
		int[][] nar = new int[n][2];
		int[][] mar = new int[m][2];
		
		for(int i=0;i<n;i++){
			line = br.readLine();
			parts = line.split(" ");
			nar[i][0] = Integer.parseInt(parts[0]);
			nar[i][1] = Integer.parseInt(parts[1]);
		}
		
		for(int i=0;i<m;i++){
			line = br.readLine();
			parts = line.split(" ");
			mar[i][0] = Integer.parseInt(parts[0]);
			mar[i][1] = Integer.parseInt(parts[1]);
		}
		int hung[][] = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				int xdist = nar[i][0] - mar[j][0];
				xdist = (xdist<0)? 0-xdist : xdist;
				
				int ydist = nar[i][1] - mar[j][1];
				ydist = (ydist<0)? 0-ydist : ydist;
				
				hung[i][j] = xdist*xdist+ydist*ydist;
			}
		}
		
		ArrayList<Integer> alist = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++){
			int min =Integer.MAX_VALUE;
			for(int j=0;j<m;j++)
				if(hung[i][j] < min)
					min = hung[i][j];
			
		}
		
		/*System.out.println("Printing");
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
				System.out.print(hung[i][j]+ " ");
			System.out.println();
		}*/
			
	}

}
