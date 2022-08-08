package mock29;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Songreq4 {
	public static void main(String args[]) throws ParseException {
		Scanner sc=new Scanner(System.in);
		
		List<Songs> slist=new ArrayList<Songs>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat ms=new SimpleDateFormat("mm:ss");
		System.out.println("Enter the number of songs:");
		int no=Integer.parseInt(sc.nextLine());
		for(int i=0;i<no;i++) {
			slist.add(new Songs().createSong(sc.nextLine()));
			//System.out.println(no);
		}
		List<Songs> res=new ArrayList<Songs>();
		System.out.println("Enter the name of the artist:");
		String art_name=sc.nextLine();
		
		for(Songs ss:slist) {
			for(Artist aa:ss.getArtistList()) {
				if(art_name.equals(aa.getName())) {
					res.add(ss);
				}
			}
		}
		//Collections.sort(res,new RatingComparator());
		Collections.sort(res,Collections.reverseOrder(new RatingComparator()));
		//System.out.println(res);
		for(Songs ss:res) {
			System.out.println("The best song of "+art_name+" "+ss.getTitle());
			break;
		}
		}
}
