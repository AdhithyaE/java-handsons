package mock29;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Req6song {
	public static void main(String args[]) throws ParseException {
		Scanner sc=new Scanner(System.in);
		SongBO sbo=new SongBO();
		List<Songs> slist=new ArrayList<Songs>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		SimpleDateFormat ms=new SimpleDateFormat("mm:ss");
		System.out.println("Enter the number of songs:");
		int no=Integer.parseInt(sc.nextLine());
		for(int i=0;i<no;i++) {
			slist.add(new Songs().createSong1(sc.nextLine()));
			//System.out.println(no);
		}
		System.out.println("Enter a search type:\r\n"
				+ "1.By Released year and Genre \r\n"
				+ "2.By Artist and Genre");
		
	         int co=Integer.parseInt(sc.nextLine());
	List<Songs>  result=new ArrayList<Songs>();
	switch(co) {
	case 1:System.out.println("Enter the Released year and Genre:");
	        Date date=new Date();
	        date=sdf.parse(sc.nextLine());
	        String genre=sc.nextLine();
	        result=sbo.findSong(slist,date, genre);
	        break;
	case 2:System.out.println("Enter the artist name and Genre:");
             String name=sc.nextLine();
            String genr=sc.nextLine();
           result=sbo.findSong(slist,name, genr);
             break;
	default:System.out.println("Invalid Choice");
	}
	if(!result.isEmpty()) {
	System.out.format("%-15s %-15s %-12s %s\n", "Title", "Genre", "Rating", "Album");
	for(Songs r:result) {
		System.out.format("%-15s %-15s %-12s %s\n",r.getTitle(),r.getGenre(),r.getRating().toString(),r.getAlbum().getName());
	}
}}}
