package mock29;

import java.util.Comparator;

public class RatingComparator implements Comparator<Songs> {
	public int compare(Songs s1,Songs s2) {
		return s1.getRating().compareTo(s2.getRating());
	}
}
