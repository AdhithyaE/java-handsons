package mock29;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Music_Aggregator {
	public static void main(String args[]) throws ParseException {
		Scanner sc=new Scanner(System.in);
		List<Songs> slist=new ArrayList<Songs>();
		SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
		System.out.println("Enter the number of songs:");
		int no=Integer.parseInt(sc.nextLine());
		for(int i=0;i<no;i++) {
			slist.add(new Songs().createSong(sc.nextLine()));
			
		}
		System.out.println("Enter a type to sort:  \r\n"
				+ "1.Sort by Duration  \r\n"
				+ "2.Sort by Rating  ");
		int c=Integer.parseInt(sc.nextLine());
		switch(c) {
		case 1:Collections.sort(slist);
		       break;
		case 2:Collections.sort(slist,new RatingComparator());
		}
		System.out.format("%-20s %-10s %-12s %-12s\n","Title","Genre","Duration","Rating"); 
		for(Songs t:slist) {
			
			System.out.format("%-20s %-10s %-12s %-12s\n",t.getTitle(),t.getGenre(),sdf.format(t.getDuration()),t.getRating().toString()); 
		}
}}
