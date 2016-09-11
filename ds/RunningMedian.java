import java.util.*;
class RunningMedian{

	public static int maxS = 0;
	public static int minS =0;


	public static void insertMax(int num,PriorityQueue<Integer> minHeap, PriorityQueue<Integer>  maxHeap){
		if(maxS <= minS){
				maxHeap.offer(num);
				maxS += 1;
		}

		else{
			int oldroot = maxHeap.poll();
			maxHeap.add(num);
			minHeap.add(oldroot);
			minS +=1;
		}

		
	}

	public static void insertMin(int num,PriorityQueue<Integer>  minHeap, PriorityQueue<Integer>  maxHeap){

		if(minS <= maxS){
				minHeap.add(num);
				minS +=1;
		}

		else{
			int oldroot = minHeap.poll();
			minHeap.add(num);
			maxHeap.add(oldroot);
			maxS +=1;
		}


	}

	public static void insert(int num,PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){

		if(minS > maxS){
			maxHeap.add(num);
			maxS+=1;
		}else{
			minHeap.add(num);
			minS+=1;	
		}
	}

	public static int findMedian(PriorityQueue<Integer>  minHeap, PriorityQueue<Integer>  maxHeap){
		if(minS == maxS)
			return (int)(maxHeap.peek()+minHeap.peek())/2;

		if(minS > maxS)
			return minHeap.peek();

		return maxHeap.peek();
	}


	public static void main(String ...args){
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(100,Collections.reverseOrder());
		/*PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(100,new Comparator(){
					public int compare(Object a, Object b){
						return (Integer)b-(Integer)a;
					}
						
				});*/


		int input[] = {5,15,1,3,4,8,7,9,10,6,11,14};
		
		if(input.length == 1){
			System.out.println(input[0]);
			return;
		}
		else{
			
			if(input[0]  > input[1]){
				minHeap.add(input[0]);
				maxHeap.add(input[1]);
				minS=1;
				maxS=1;
			}else{
				minHeap.add(input[1]);
				maxHeap.add(input[0]);
				minS=1;
				maxS=1;
			}
		}	

		for(int i=2;i<input.length;i++){
			int num = input[i];
			//System.out.println("Maxs  = "+maxHeap.peek());
			//System.out.println("mins = "+minS+" maxs = "+maxHeap.size());
			if( num < maxHeap.peek())
				 insertMax(num,minHeap,maxHeap);
			else if( num > minHeap.peek())
				 insertMin(num,minHeap,maxHeap);

			else{
				insert(num,minHeap,maxHeap);		
				
			}	

			int median = findMedian(minHeap,maxHeap);
			System.out.println("For iteration "+i+" median = "+median);
		}	


	}

}
