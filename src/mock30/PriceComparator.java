package mock30;

import java.util.Comparator;

public class PriceComparator implements Comparator<Course>{
public int compare(Course c1,Course c2) {
	return c1.getPrice().compareTo(c2.getPrice());
}
}
