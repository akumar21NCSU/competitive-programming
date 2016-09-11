class Heap{
	int harr[];
	int tail;
	int capacity;

	public Heap(int arr[], int t, int c){
		this.harr= arr;
		this.tail = t;
		this.capacity=c;
	}

	public void buildHeap( int len){
		for(int i= (len-2)/2;i>=0;i--){
			heapify(i);
		}
	}

	public int getMin(){
		return harr[0];

	}
	public void heapify(int i){

		int lindex = 2*i+1;
		int rindex=2*i+2;
		int smallest=i;

		if(lindex<= this.tail && harr[lindex]<harr[smallest])
			smallest=lindex;

		if(rindex<= this.tail && harr[rindex]<harr[smallest])
			smallest=rindex;

		if(smallest!= i){
			int temp= harr[i];
			harr[i]=harr[smallest];
			harr[smallest]=temp;
			heapify(smallest);
		}
		

	}

}

class Klargest{

	public static void main(String ... args){
		
		int a[]= {1,23,12,9,30,2,50};
		int k=4;		
		int heap[] = new int[k];
		for(int i=0;i<k;i++)
			heap[i] =a[i];

		Heap h = new Heap(heap,k-1,k);
		h.buildHeap(k);	

		for(int i=k;i<a.length;i++){
			if(a[i] > h.getMin()){
				h.harr[0]=a[i];
				h.heapify(0);
			}			
		}	
		// print the heap

		for(int i=0;i<k;i++)
			System.out.print(h.harr[i]+" ");

	}

}
