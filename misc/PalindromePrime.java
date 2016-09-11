package misc;

import java.io.*;

public class PalindromePrime {

	public boolean isPalin(int num){
		
		String num1 = String.valueOf(num);
		boolean result= true;
		for(int i=0;i<num1.length();i++)
			if(num1.charAt(i) != num1.charAt(num1.length()-1 -i)){
				result = false;
				break;
			}
		
		return result;
	}
	
	public int count(int L, int R){
		
		boolean primeAr[] = new boolean[1001];
		//primeAr[2] = true;
		
		primeAr[1] = false;
		
		for(int i=1;i<1001;i++)
			primeAr[i] = true;
		
		int j=2;
		for(int i=2;i<1001/2;i++){
			if(primeAr[i] == true){
				j=2;
				while(i*j < 1001){
					primeAr[i*(j)]= false;
					j++;
				}
			}
		}
		
		int count=0;
		for(int i=L;i<= R;i++){
			if(primeAr[i] == true && isPalin(i))
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		String parts[] = line.split(" ");
		int l = Integer.parseInt(parts[0]);
		int r = Integer.parseInt(parts[1]);
		System.out.println(new PalindromePrime().count(l,r));
		
	}

}
