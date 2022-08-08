package mock29;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
	String name;
	Date releasedYear;
	List<Songs> songList;
	
	public Album() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getReleasedYear() {
		return releasedYear;
	}
	public void setReleasedYear(Date releasedYear) {
		this.releasedYear = releasedYear;
	}
	public List<Songs> getSongList() {
		return songList;
	}
	public void setSongList(List<Songs> songList) {
		this.songList = songList;
	}
	public Album(String name, Date releasedYear, List<Songs> songList) {
		super();
		this.name = name;
		this.releasedYear = releasedYear;
		this.songList = songList;
	}
	public static List<Album> prefill() throws ParseException{ 

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy"); 
		List<Album> list = new ArrayList<Album>(); 
		list.add(new Album("Illuminate",sdf.parse("2014"),new ArrayList<Songs>())); 
		list.add(new Album("Divide",sdf.parse("2015"),new ArrayList<Songs>())); 
		list.add(new Album("Evolve",sdf.parse("2014"),new ArrayList<Songs>())); 
		list.add(new Album("Collage",sdf.parse("2012"),new ArrayList<Songs>())); 
		list.add(new Album("Memories",sdf.parse("2014"),new ArrayList<Songs>())); 
		list.add(new Album("Listen",sdf.parse("2016"),new ArrayList<Songs>())); 
		list.add(new Album("Meteora",sdf.parse("2017"),new ArrayList<Songs>())); 
		list.add(new Album("Faded",sdf.parse("2014"),new ArrayList<Songs>())); 
		list.add(new Album("Despacito",sdf.parse("2018"),new ArrayList<Songs>())); 
		list.add(new Album("Cheap thrills",sdf.parse("2015"),new ArrayList<Songs>())); 
		list.add(new Album("Night Visions",sdf.parse("2012"),new ArrayList<Songs>())); 
		return list; 

		} 
	
}
