class SumofArrays{

	public static int[] sum(int []a, int[]b){
		
		if(a.length==0)
			return b;

		if(b.length == 0)
			return a;

		int c[] = new int[(a.length>b.length)?a.length+1:b.length+1];	

		int carry=0;
		int aindex=a.length-1;
		int bindex=b.length-1;		

		for(int i=c.length-1;i>=0;i--){
			int num1=0;
			int num2=0;
			if(aindex>=0)
				num1= a[aindex--];

			if(bindex>=0)
				num2 = b[bindex--];

			int temp = num1+num2+carry;
			if(temp>=10){
				carry = 1;
				temp = temp-10;
			}else{
				carry=0;
			}
			c[i] = temp;		

		}
		return c;
	}

	public static void main(String ... args){

		int[] a={9,9,9};
		int[] b={9,9,9};

		int c[] = sum(a,b);
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]+" ");

	}

}
