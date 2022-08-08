package mock30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class req5 {
	public static void main(String args[]) {
		  Scanner sc=new Scanner(System.in);
		  List<Course> courselist=new ArrayList<Course>();
		  List<UserScore> uscore=new ArrayList<UserScore>();
		  System.out.println("Enter the number of courses:");
			int no=Integer.parseInt(sc.nextLine());
			for(int i=0;i<no;i++) {

			System.out.println("Enter course "+(i+1)+" detail");
			String c1=sc.nextLine();
			String[] inp=c1.split(",");
			Course course=new Course();
			
			
			for(Course c:Course.prefill()) {
				if(c.getName().equalsIgnoreCase(inp[0]))
					  course=c;
						}
			System.out.println("Enter number of user scores:");
			int un=Integer.parseInt(sc.nextLine());
			for(int k=0;k<un;k++)
			{
				UserScore us=new UserScore();
				User user=new User();
				String use=sc.nextLine();
				
				String[] useC=use.split(",");
			
				for(User u:User.prefill()) {
					if(u.getName().equalsIgnoreCase(useC[1]))
						  user=u;
							           }
				
				course.getUserScoreList().add(new UserScore(Double.parseDouble(useC[0]),user,course));
			}
			courselist.add(course);
			}
			System.out.println("Enter a type to sort: \r\n"
					+ "1.Sort by No.of Users \r\n"
					+ "2.Sort by Price");
			Integer co=Integer.parseInt(sc.nextLine());
			switch(co) {
			case 1: Collections.sort(courselist);break;
			case 2:Collections.sort(courselist,new PriceComparator());
			}
			System.out.format("%-15s %-15s %-8s %s\n","Name","Category","Price","No.of Users");
			for(Course c:courselist) {
				System.out.format("%-15s %-15s %.1f  %s\n",c.getName(),c.getCategory(),
					c.getPrice(),c.getUserScoreList().size());
			}
			}		
	}
/*3 
Enter course 1 detail 
Java,Programming,4999 
Enter number of user scores: 
2 
95.2,Harry 
94.3,Oliver 
Enter course 2 detail 
Python,Programming,5299 
Enter number of user scores: 
1 
96.5,Harry 
Enter course 3 detail 
C Sharp,Programming,4900 
Enter number of user scores: 
3 
78.6,Matt 
60.2,James 
60.2,James 
Enter a type to sort: 
1.Sort by No.of Users 
2.Sort by Price */