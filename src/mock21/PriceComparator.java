package mock21;

import java.util.Comparator;

public class PriceComparator implements Comparator<Item>{
public int compare(Item arg1,Item arg2) {
	return arg1.getPrice().compareTo(arg2.getPrice());
}
}
