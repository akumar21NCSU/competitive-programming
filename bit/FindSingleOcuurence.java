package bit;

public class FindSingleOcuurence {

	public static void main(String[] args) {
		int n= 10;
		int ar[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};

		int ones=0;
		int twos=0;
		int common_bit_mask=0;
		
		for(int i=0;i<ar.length;i++){
			
			twos = twos | (ones&ar[i]);
			ones = ones ^ (ar[i]);
			
			common_bit_mask = ~(ones&twos);
			
			ones = ones& common_bit_mask;
			twos = twos & common_bit_mask;
			
		}
		System.out.println(ones);
		//System.out.println((1<<32) -1);
		System.out.println((2147483648L^((1<<31) -1))+2147483648L);
	}

}
