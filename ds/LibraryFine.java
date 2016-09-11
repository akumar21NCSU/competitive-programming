package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LibraryFine {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		String[] parts = line.split(" ");
		int actDay = Integer.parseInt(parts[0]);
		int actMon = Integer.parseInt(parts[1]);
		int actYear = Integer.parseInt(parts[2]);
		
		line = br.readLine();
		parts = line.split(" ");
		int estDay = Integer.parseInt(parts[0]);
		int estMon = Integer.parseInt(parts[1]);
		int estYear = Integer.parseInt(parts[2]);
		
		if(actYear > estYear)
			System.out.println(10000);
		else if(actMon > estMon && (actYear == estYear)){
			System.out.println(500*(actMon - estMon));
		}
		else if(actDay > estDay && (actMon == estMon) && (actYear == estYear) ){
			System.out.println(15*(actDay - estDay));
		}
		else
			System.out.println(0);
		
	}

}
