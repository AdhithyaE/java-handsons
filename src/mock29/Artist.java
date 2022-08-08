package mock29;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Artist implements Comparable <Artist> {
	String name;
	String role;
	String gender;
	Date dob;
	List<Songs> songList;
	public int compareTo(Artist a) {
		return this.getName().compareTo(a.getName());
	}
	
	public Artist() {
		super();
	}
	public Artist(String name, String role, String gender, Date dob, List<Songs> songList) {
		super();
		this.name = name;
		this.role = role;
		this.gender = gender;
		this.dob = dob;
		this.songList = songList;
		
		 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Songs> getSongList() {
		return songList;
	}
	public void setSongList(List<Songs> songList) {
		this.songList = songList;
	}
	
	public static List<Artist> prefill() throws ParseException{


			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
			List<Artist> list = new ArrayList<Artist>(); 
			list.add(new Artist("Ed Sheeran","Singer","Male",sdf.parse("17-02-1991"),new ArrayList<Songs>())); 
			list.add(new Artist("Steve Mac","Musician","Male",sdf.parse("15-01-1972"),new ArrayList<Songs>())); 
			list.add(new Artist("Burruss","Singer","Female",sdf.parse("17-05-1976"),new ArrayList<Songs>())); 
			list.add(new Artist("Beyonce","Singer","Female",sdf.parse("04-09-1981"),new ArrayList<Songs>())); 
			list.add(new Artist("Zoey","Musician","Female",sdf.parse("10-10-1994"),new ArrayList<Songs>())); 
			list.add(new Artist("Shawn Mendes","Singer","Male",sdf.parse("08-10-1998"),new ArrayList<Songs>())); 
			list.add(new Artist("Frankie Dunne","Musician","Male",sdf.parse("10-09-1978"),new ArrayList<Songs>())); 
			list.add(new Artist("Luis Fonsi","Singer","Male",sdf.parse("15-04-1978"),new ArrayList<Songs>())); 
			list.add(new Artist("Daddy Yankee","Singer","Male",sdf.parse("03-02-1977"),new ArrayList<Songs>())); 
			list.add(new Artist("Zuleyka","Dancer","Female",sdf.parse("03-10-1987"),new ArrayList<Songs>())); 
			list.add(new Artist("Dan Reynolds","Singer","Male",sdf.parse("14-07-1987"),new ArrayList<Songs>())); 
			list.add(new Artist("Wayne Sermon","Musician","Male",sdf.parse("15-06-1984"),new ArrayList<Songs>())); 
			list.add(new Artist("Andrew","Musician","Male",sdf.parse("03-02-1978"),new ArrayList<Songs>())); 
			list.add(new Artist("Chris Martin","Singer","Male",sdf.parse("02-03-1977"),new ArrayList<Songs>())); 
			list.add(new Artist("Alan Walker","Lyricist","Male",sdf.parse("24-08-1997"),new ArrayList<Songs>())); 
			list.add(new Artist("Jesper","Musician","Male",sdf.parse("16-09-1988"),new ArrayList<Songs>())); 
			list.add(new Artist("Rob","Singer","Male",sdf.parse("20-01-1979"),new ArrayList<Songs>())); 
			list.add(new Artist("Joe","Musician","Male",sdf.parse("15-03-1977"),new ArrayList<Songs>())); 
			list.add(new Artist("Sia","Musician","Female",sdf.parse("18-12-1975"),new ArrayList<Songs>())); 
			list.add(new Artist("Maddie","Dancer","Female",sdf.parse("30-09-2002"),new ArrayList<Songs>())); 
			list.add(new Artist("David Guetta","Lyricist","Male",sdf.parse("07-11-1967"),new ArrayList<Songs>())); 
			list.add(new Artist("Sam Martin","Musician","Male",sdf.parse("07-02-1983"),new ArrayList<Songs>())); 

			return list; 

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
		
		System.out.println("Enter the date for special collection");
		Date d=sdf.parse(sc.nextLine());
		Artist a=new Artist();
		List<Songs> sng=new ArrayList<Songs>();
		List<Artist> listof_artists=Artist.prefill();
	
			
		SimpleDateFormat db=new SimpleDateFormat("dd-MM");
		List<String> arl=new ArrayList<String>();
		for(Artist art:listof_artists) {
			//System.out.println(art.getSongList());
			if(db.format(d).equals(db.format(art.getDob()))) {
				arl.add(art.getName());
			}
		}
		for(Songs ss:slist) {
			for(Artist at:ss.getArtistList()) {
				for(String rr:arl) {
					if(rr.equals(at.getName()))
						sng.add(ss);
				}
			}
		}
	
		if(!sng.isEmpty()) {
			System.out.format("%-20s %-20s %s\n","Title","Genre","Rating");
			for(Songs ss:sng) {
				System.out.format("%-20s %-20s %s\n",ss.getTitle(),ss.getGenre(),ss.getRating().toString());
			}
		}
		
	}
}

