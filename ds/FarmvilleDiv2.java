package top;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FarmvilleDiv2{
    class Inner implements Comparable{
    	int time;
        public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
		int cost; 
        public Inner(int time,int cost){
        	this.time = time;
        	this.cost = cost;
        }
		@Override
		public int compareTo(Object o) {
			if(this.getCost() < ((Inner)o).getCost())
				return -1;
			else if(this.getCost() > ((Inner)o).getCost())
				return 1;
			
			return 0;
		}
    }
    public int minTime(int[]time, int[]cost, int budget){
    	
    	ArrayList<Inner> list = new ArrayList<Inner>();
    	
    	for(int i=0; i<time.length;i++){
    		list.add(new Inner(time[i],cost[i]));
    	}
       list.sort(null);
       int i=0; 
       int n = time.length;
       while(budget >= list.get(i).getCost() && i<n){
    	   
    	   if(list.get(i).getTime() !=0 ){
    		   list.get(i).setTime( list.get(i).getTime() - 1);
    		   budget = budget - list.get(i).getCost();
    	   }else{
    		   i++;
    	   }
    	   
       }
       int result=0;
       for(int j=0;j<n;j++)
    	   result += list.get(j).getTime();
       /*for(int i=0;i<time.length;i++)
    	   System.out.println(list.get(i).getTime());
       */
       return result;
    }
    public static void main(String ...args)throws Exception{
    	
    	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//String line = br.readLine();
		int time[] = {100,100,100,100,100,100,100,100,100,100};
		int cost[] = {2,4,6,8,10,1,3,5,7,9};
		int budget = 5000;
		System.out.println(new FarmvilleDiv2().minTime(time, cost, budget));
		
    }
    
}