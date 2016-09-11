class Heap{

	private int[] harr;
	private int capacity;
	private int tail;

	public Heap(int n){
		harr = new int[n];
		capacity = n;
		tail=-1;
	}

	public  int parent(int i){	
		return (i-1)/2;
	}

	public  int getLeft(int i){
		return (2*i)+1;
	}
	public  int getRight(int i){
		return (2*i)+2;
	}

	public int getMini(){
		return harr[0];
	}
	
	public int min(int l,int r){

		if(harr[l]<harr[r])
			return l;
		return r;
	}

	public void downheap(int index){

		while(index<tail){
	
			int lindex = 2*index +1;
			if(lindex > tail)
				break;

			int rindex = 2*index +2;
			if(rindex > tail){
				// compare with lchild
				if(harr[index] > harr[lindex]){
					swap(index,lindex);
				}
				break;
			}else{
				// find min of two child and then compare
				int cindex = min(lindex,rindex);
				swap(index,cindex);
				index =cindex;
			}

		}		
	}

	public int extractMin(){

		if(tail <0){
			System.out.println("Empty heap");
			return -1;
		}
			
		int min = getMini();
	
		swap(0,tail);
		harr[tail] = 0;
		tail = tail-1;
		if(tail > 0)
			downheap(0);		
		return min;
	}

	public void swap(int a,int b){
		int temp = harr[a];
		harr[a] =harr[b];
		harr[b] = temp;
	}

	public void upheap(int index){
	
		while(index!= 0 && harr[parent(index)] > harr[index]){
			swap(parent(index),index);
			index = parent(index);
		}

	}

	public void insert(int newVal){
		harr[++tail] =newVal;
		if(tail >0)
			upheap(tail);
	}
	
	public static void buildHeap(int[] arr){

	}
	
	public static void main(String []args)throws Exception{
	
		/*Heap h = new Heap(7);
		h.insert(100);
		h.insert(30);
		h.insert(10);
		h.insert(45);
		h.insert(15);
		h.insert(40);
		h.insert(50);
		for(int i=0;i<7;i++)
			System.out.print(h.harr[i]+" ");
		System.out.println();
		System.out.println("Min is "+h.extractMin());
		System.out.println("Min is "+h.extractMin());
		System.out.println("Min is "+h.extractMin());
		System.out.println("Min is "+h.extractMin());
		System.out.println("Min is "+h.extractMin());
		System.out.println("Min is "+h.extractMin());
		System.out.println("Min is "+h.extractMin());
		System.out.println("Min is "+h.extractMin());
		for(int i=0;i<7;i++)
			System.out.print(h.harr[i]+" ");*/

		int arr[] = {12, 11, 13, 5, 6, 7};
		buildHeap(arr);

	}
}
