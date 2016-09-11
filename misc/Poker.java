package misc;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Poker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cards[] = new String[5];
        for(int cards_i=0; cards_i < 5; cards_i++){
            cards[cards_i] = in.next();
        }
        
        if(cards[0].charAt(1) == cards[1].charAt(1) && 
        		cards[0].charAt(1) == cards[2].charAt(1) &&
        				cards[0].charAt(1) == cards[3].charAt(1) &&
        						cards[0].charAt(1) == cards[4].charAt(1) ){
        	
        	String r1 = (String.valueOf(cards[0].charAt(0)));
        	String r2 = (String.valueOf(cards[1].charAt(0)));
        	String r3 = (String.valueOf(cards[2].charAt(0)));
        	String r4 = (String.valueOf(cards[3].charAt(0)));
        	String r5 = (String.valueOf(cards[4].charAt(0)));
        	
        	int n1,n2,n3,n4,n5;
        	
        	if(r1.equals("T"))
        		n1= 10;
        	else if(r1.equals("J"))
        		n1 = 11;
        	else if(r1.equals("Q"))
        		n1 = 12;
        	else if(r1.equals("K"))
        		n1 = 13;
        	else if(r1.equals("A"))
        		n1 = 0;
        	else
        		n1 = Integer.parseInt(r1);
        	
        	if(r2.equals("T"))
        		n2= 10;
        	else if(r2.equals("J"))
        		n2 = 11;
        	else if(r2.equals("Q"))
        		n2 = 12;
        	else if(r2.equals("K"))
        		n2 = 13;
        	else if(r2.equals("A"))
        		n2 = 0;
        	else
        		n2 = Integer.parseInt(r2);
        	
        	if(r3.equals("T"))
        		n3= 10;
        	else if(r3.equals("J"))
        		n3 = 11;
        	else if(r3.equals("Q"))
        		n3 = 12;
        	else if(r3.equals("K"))
        		n3 = 13;
        	else if(r3.equals("A"))
        		n3 = 0;
        	else
        		n3 = Integer.parseInt(r3);
        	
        	
        	if(r4.equals("T"))
        		n4= 10;
        	else if(r4.equals("J"))
        		n4 = 11;
        	else if(r4.equals("Q"))
        		n4 = 12;
        	else if(r4.equals("K"))
        		n4 = 13;
        	else if(r4.equals("A"))
        		n4 = 0;
        	else
        		n4 = Integer.parseInt(r4);
        	
        	if(r5.equals("T"))
        		n5= 10;
        	else if(r5.equals("J"))
        		n5 = 11;
        	else if(r5.equals("Q"))
        		n5 = 12;
        	else if(r5.equals("K"))
        		n5 = 13;
        	else if(r5.equals("A"))
        		n5 = 0;
        	else
        		n5 = Integer.parseInt(r5);
        	
        	if(n1!= 0 && n2 != 0 && n3 !=0 && n4 !=0 && n5!= 0){
        		
        	}else{
        		
        	}
        	
        	
        }else{
        	System.out.println("NO");
        }
        	
    }
}
