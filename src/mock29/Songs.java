package mock29;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
public class Songs  implements Comparable <Songs>{
	private String title;
	private String genre;
	private Date duration;
	private Double rating;
	List<Artist> artistList;
	Album album;
	public Songs(String title, String genre, Date duration, Double rating, List<Artist> artistList, Album album) {
		super();
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
		this.artistList = artistList;
		this.album = album;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public int compareTo(Songs s) {
		return this.getDuration().compareTo(s.getDuration());
	}
	public Songs(String title, String genre, Date duration, Double rating, List<Artist> artistList) {
		super();
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
		this.artistList = artistList;
	}
	public List<Artist> getArtistList() {
		return artistList;
	}
	public void setArtistList(List<Artist> artistList) {
		this.artistList = artistList;
	}
	public Songs() {
		super();
	}
	public Songs(String title, String genre, Date duration, Double rating) {
		super();
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	public Double getRating(){
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
	public  Songs createSong(String line) throws ParseException {
		StringTokenizer st=new StringTokenizer(line,",");
		ArrayList<Artist> at=new ArrayList<Artist>();
		String arg1=st.nextToken();
		String arg2=st.nextToken();
		String arg3=st.nextToken();
		String arg4=st.nextToken();
		String[] arg5=st.nextToken().split("-");
		List<Artist> tar=Artist.prefill();
       for(String ss:arg5) {
    	   for(Artist aa:tar) {
    		   if(ss.equals(aa.getName())) {
    			   {at.add(aa);
    			   //System.out.println(aa.getName());
    			   }
    		   }
    	   }
       }
       Songs song=new Songs(arg1,arg2,sdf.parse(arg3),Double.parseDouble(arg4),at);
   	for(Artist ast:song.getArtistList()) {
   		//System.out.println(ast.getName());
   		ast.getSongList().add(song);
   		
   	}
   		return song;
       }
       
       public  Songs createSong1(String line) throws ParseException {
   		StringTokenizer st=new StringTokenizer(line,",");
   		ArrayList<Artist> at=new ArrayList<Artist>();
   		String arg1=st.nextToken();
   		String arg2=st.nextToken();
   		String arg3=st.nextToken();
   		String arg4=st.nextToken();
   		String arg5=st.nextToken();
   		String[] arg6=st.nextToken().split("-");
   		List<Artist> tar=Artist.prefill();
   		List<Album> alb=Album.prefill();
          for(String ss:arg6) {
       	   for(Artist aa:tar) {
       		   if(ss.equals(aa.getName())) {
       			   {at.add(aa);
       			   //System.out.println(aa.getName());
       			   }
       		   }
       	   }
          }
          Album album=new Album();
          for(Album ab:alb) {
      		   if(arg5.equals(ab.getName())) {
      			   {
      			   album=ab;
      			   }
      		   }
      	   }
	Songs song=new Songs(arg1,arg2,sdf.parse(arg3),Double.parseDouble(arg4),at,album);
	for(Artist ast:song.getArtistList()) {
		//System.out.println(ast.getName());
		ast.getSongList().add(song);
		
	}
		return song;	
		
	}
	
	@Override
		public String toString() {
		String str="title= " + this.getTitle()+ "\ngenre= " + this.getGenre() + "\nduration= " + sdf.format(this.getDuration())
				+ "\nrating= " +this.getRating();
		return str;
	}
	public boolean equals(Songs s) {
		if(this.toString().equals(s.toString()))
			return true;
	return false;
	}
		}
