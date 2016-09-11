package mak;

public class BitMask {

	
	public static void main(String[] args) {
		int n=3;
		int iter = (int)Math.pow(2, 3)-1;
		//System.out.println("iter is "+iter);
		
		for(int i=0;i<=iter;i++){
			for(int j=0;j<n;j++){
				if((i & (1<<j)) != 0){
					System.out.println(i+" has "+(j+1));
				}
			}
		}
	}

}
