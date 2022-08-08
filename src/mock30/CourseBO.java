package mock30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseBO {
	public List<Course> findCourse(List<Course> courseList,List<String> nameList){
		List<Course> matched_courses=new ArrayList<Course>();
		for(Course c:courseList) {
			for(String s:nameList) {
				if(c.getName().equals(s))
					matched_courses.add(c);
					     
			}
		}
		return matched_courses;
	}
	public List<Course> findCourse(List<Course> courseList,String category){
		List<Course> matched_courses=new ArrayList<Course>();
		for(Course c:courseList) {
		
				if(c.getCategory().equals(category))
					matched_courses.add(c);
					     
			
		}
		return matched_courses;
	}
	
}
