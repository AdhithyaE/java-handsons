package mobileproject;
import java.util.Comparator;
public class LaunchedDateComparator implements Comparator<Mobile>{
	public int compare(Mobile arg0, Mobile arg1) {
		
		return arg0.getLaunchedDate().compareTo(arg1.getLaunchedDate());
	}
}
