package mock29;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SongBO {
	public List<Songs> findSong(List<Songs> songList,String name,String genre){
		List<Songs>  result=new ArrayList<Songs>();
		for(Songs ss:songList) {
			if(ss.getGenre().equals(genre)) {
				for(Artist aa:ss.getArtistList()) {
					if(aa.getName().equals(name)) {
						result.add(ss);
					}
				}
			}
		}
		return result;
	}
	public List<Songs> findSong(List<Songs> songList,Date releasedYear,String genre){
		SimpleDateFormat sm=new SimpleDateFormat("yyyy");
		List<Songs>  result=new ArrayList<Songs>();
		for(Songs ss:songList) {
			if(ss.getGenre().equals(genre)) {
				if(sm.format(ss.getAlbum().getReleasedYear()).equals(sm.format(releasedYear))) {
					result.add(ss);
				}
					
			}
		}
		return result;
	}
}
