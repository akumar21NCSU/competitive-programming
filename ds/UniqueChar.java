class UniqueChar{

	public static boolean hasUnique(String str){
		char carr[] = str.toCharArray();
		int a=0,b=0,c=0,d=0,e=0;

		for(char x: carr){
			int val = (int)x;
			if(0< val && val<=30){
				if ( (a & (1<<val)) > 0)
					return false;
				a = a | (1<<val);
			}else if(31<val && val<=60){
				val = val -30;
				if ( (b & (1<<val)) > 0)
					return false;
				b = b | (1<<val);
			}else if(61<val && val<= 90){
				val = val - 60;
				if ( (c & (1<<val)) > 0)
					return false;
				c = c | (1<<val);
			}else if(91<val && val<= 120){
				val = val -90;
				if ( (d & (1<<val)) > 0)
					return false;
				d = d | (1<<val);
			}else if(121<val && val<= 150){
				val = val -120;
				if ( (e & (1<<val)) > 0)
					return false;
				e = e | (1<<val);
			}

		}
		return true;
	}

	public static void main(String ...args)throws Exception{

		System.out.println(hasUnique("ab12!lo"));		
		
	}

}
