package mock30;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;


public class Req4course {
	public static void main(String args[]) {
		  Scanner sc=new Scanner(System.in);
		  List<Course> courselist=new ArrayList<Course>();
		  Map<String,Integer> result=new TreeMap<String,Integer>();
			Course t=new Course();
			System.out.println("Enter the number of courses:");
			int no=Integer.parseInt(sc.nextLine());
			for(int i=0;i<no;i++) {
			String course=sc.nextLine();
			String[] inp=course.split(",");
			Course courses=new Course(inp[0],inp[1],Double.parseDouble(inp[2]));
			courselist.add(courses);
			
			}
			result=Course.coursePerCategory(courselist);
			if(!result.isEmpty()) {
				 System.out.format("%-15s %-15s \n","Name","Category");
				for(Entry<String,Integer> e:result.entrySet()) {
					System.out.format("%-15s %-15s \n",e.getKey(),e.getValue().toString());
				}}
		    else
		    	 System.out.format("No course is present");
	}
}
