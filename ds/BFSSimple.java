package Queue;

public class BFSSimple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int petrol[] = new int[4];
		petrol[0] = -2;
		petrol[1]=1;
		petrol[2]=4;
		petrol[3]= -1;
		
		int i=0;
		for( i=0;i<n;i++){
			
			int start = i;
			int end = (start+1)%n;
			
			int value = petrol[i];
			
			int j=(i+1)%n;
			while(start!= end && value >=0){
				
				value += petrol[j];
				
				if(value >=0)
					end = (end+1)%n;
				j=(j+1)%n;
			}
			if(start == end){
				System.out.println(start);
				break;
			}
			
		}
		if(i==n+1)
			System.out.println("-1");
		

	}

}
