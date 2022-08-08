package mock29;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;



public class SongMain {
	public static void main(String args[]) throws ParseException {
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
			
		System.out.println("Enter song 1 details:");
		String Song1=sc.nextLine();
		System.out.println("Enter song 2 details:");
		String Song2=sc.nextLine();
		String[] inp1=Song1.split(",");
		String[] inp2=Song2.split(",");
		Songs s_1=new Songs(inp1[0],inp1[1],sdf.parse(inp1[2]),Double.parseDouble(inp1[3]));
		Songs s_2=new Songs(inp2[0],inp2[1],sdf.parse(inp1[2]),Double.parseDouble(inp1[3]));
		System.out.println("");
	    
		System.out.println("Song 1"+"\n"+s_1.toString()+"\n");
		System.out.println("Song 2"+"\n"+s_2.toString()+"\n");
		if(s_1.equals(s_2))
			System.out.println("User 1 and User 2 are same");
		else
		    System.out.println("User 1 and User 2 are different");

	}
}
