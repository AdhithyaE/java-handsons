package mock29;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class SongReq5 {
public	static Artist bestSinger(String gender,List<Artist> artistList) {
	Map<Artist,Integer> artM=new TreeMap<Artist,Integer>();
	   Integer c=0;
	   Integer max=0;
	   Artist rs=new Artist();
		for(Artist aa:artistList) {
			if(aa.getGender().equals(gender)&&aa.getRole().equals("Singer"))
			{c=artM.get(aa);
			if(c==null)
				c=0;
			c++;	
			artM.put(aa,c);
		}}
		for(Entry<Artist,Integer> e:artM.entrySet()) {
			if(e.getValue()>max)
			{
				rs=e.getKey();
				max=e.getValue();
			}
				
		}
		return rs;
	}
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
		//Collections.sort(slist,new RatingComparator());
		Collections.sort(slist,Collections.reverseOrder(new RatingComparator()));
		System.out.println("Enter the gender of singer:");
		String art_gen=sc.nextLine();
		String art_name="";
		int f=0;
	    List<Artist> inpl=new ArrayList<Artist>();
	    for(Songs ss:slist) {
	    	if(ss.getRating()>4.5)
	    	{for(Artist aa:ss.getArtistList()) {
	    		inpl.add(aa);
	    	//System.out.println(aa.getName());
	    	}}
	    }
		
		switch(art_gen) {
		case "Male" :
				System.out.println("The best Male singer is "+bestSinger(art_gen,inpl).getName());
				break;
		case "Female" :
			System.out.println("The best Female singer is "+bestSinger(art_gen,inpl).getName());	
			}
		              
		
}}
