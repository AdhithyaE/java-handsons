package mock30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Req6 {
	public static void main(String args[]) {
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the number of user scores:");
			int no=Integer.parseInt(sc.nextLine());
		 List<UserScore> usl=new ArrayList<UserScore>();
		 for(int i=0;i<no;i++) {
			 String[] us=sc.nextLine().split(",");
			 Course cc=new Course();
			 User uu=new User();
			 for(User u:User.prefill()) {
				 if(u.getName().equalsIgnoreCase(us[1].trim()))
					   uu=u;
					 
			 }
			 for(Course c:Course.prefill()) {
				 if(c.getName().equalsIgnoreCase(us[2].trim()))
					   cc=c;
			 }
			 usl.add(new UserScore(Double.parseDouble(us[0]),uu,cc));
		 }
		
		 for(UserScore uS:usl) {
			 for(Course c:Course.prefill()) {
				 if(uS.getCourse().equals(c))
					 c.getUserScoreList().add(uS);
				 Collections.sort(c.userScoreList);
			 }
		 }
		 
		 System.out.format("%-15s %s\n","Course","Top performer");
		 Map<String,Double> mp=new TreeMap<String,Double>();
			for(UserScore u:usl) {
				String arg1=u.getCourse().getName();
				Double d=0d;
				d=mp.get(arg1);
				if(d==null)
					d=0d;
				if(u.getCompletion_Percentage()>d)
					  d=u.getCompletion_Percentage();
				mp.put(arg1,d);
			}
		 for(Entry<String,Double> e:mp.entrySet()) {
			 UserScore sco=new UserScore();
			 for(UserScore u:usl)
			 {
				 if(u.getCompletion_Percentage().equals(e.getValue()))
					 sco=u;
					 
			 }
			 System.out.format("%-15s %s\n",e.getKey(),sco.getUser().getName()); 
		 }
		 
		 }
	
}
