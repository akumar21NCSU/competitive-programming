package hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class IntervalSelection implements Comparable<IntervalSelection>{

	private int start;
	private int end;
	
	
	
	public int getStart() {
		return start;
	}



	public void setStart(int start) {
		this.start = start;
	}



	public int getEnd() {
		return end;
	}



	public void setEnd(int end) {
		this.end = end;
	}



	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		int t = Integer.parseInt(line);
		
		
		
		while(t-- > 0){
			
			line = br.readLine();
			int n = Integer.parseInt(line);
			//long arr[][] = new long[n][2];
			IntervalSelection arr[] = new IntervalSelection[n];
			for(int i=0;i<n;i++){
				line = br.readLine();
				String[] parts = line.split(" ");
				IntervalSelection obj = new IntervalSelection();
				obj.setStart(Integer.parseInt(parts[0]));
				obj.setEnd(Integer.parseInt(parts[1]));
				arr[i] = obj;
				//arr[i][0] = Long.parseLong(parts[0]);
				//arr[i][1] = Long.parseLong(parts[1]);
			}
			java.util.Arrays.sort(arr);
			
			boolean included[] = new boolean[n];
			for(int i=0;i<n;i++)
				included[i] = true;
			
			int result=0;
			for(int i=0;i<n;i++){
				if(included[i] == false)
					continue;
				
				result++;
				int coll=0;
				int start = arr[i].getStart();
				int end = arr[i].getEnd();
				for(int j=i+1;j<n;j++){
					if(included[j] == true)
						if(start >= arr[j].getStart() || arr[j].getStart() <= end){
							coll++;
							if(coll > 1)
								included[j] = false;
						}
					
				}
			}
			System.out.println(result);
			
			/*for(int i=0;i<n;i++)
				System.out.println(arr[i].getStart() +"  " + arr[i].getEnd());
			
			for(int i=0;i<n;i++)
				System.out.println(included[i]);*/
		}
		
	}



	@Override
	public int compareTo(IntervalSelection o) {
		if(this.getEnd() > o.getEnd())
			return 1;
		else if(this.getEnd() < o.getEnd())
			return -1;
		else {
			return o.getStart() - this.getStart();
		}
	}

}
