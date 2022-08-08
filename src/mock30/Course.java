package mock30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Course implements Comparable<Course>{
	String name;
	String category;
	Double price;
	List<UserScore> userScoreList;
	
	public int compareTo(Course c) {
		Integer l1=this.getUserScoreList().size();
		Integer l2=c.getUserScoreList().size();
		return l1.compareTo(l2);
	}
	
	public List<UserScore> getUserScoreList() {
		return userScoreList;
	}

	public void setUserScoreList(List<UserScore> userScoreList) {
		this.userScoreList = userScoreList;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Course() {
		super();
	}
	public Course(String name, String category, Double price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Course(String name, String category, Double price, List<UserScore> userScoreList) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.userScoreList = userScoreList;
	}
	public static Map<String,Integer> coursePerCategory(List<Course> courseList){
		Map<String,Integer> result=new TreeMap<String,Integer>();
		for(Course c:courseList) {
			Integer count=0;
			count=result.get(c.getCategory());
			if(count==null)
				count=0;
			count++;
			result.put(c.getCategory(), count);
		}
		return result;
	}
	
	public static List<Course> prefill(){ 

        List<Course> list = new ArrayList<>(); 
        list.add(new Course("ANGULAR","Web Development",Double.parseDouble("9360"),new ArrayList<UserScore>())); 
        list.add(new Course("Web Developer","Web Development",Double.parseDouble("9600"),new ArrayList<UserScore>())); 
        list.add(new Course("JavaScript","Web Development",Double.parseDouble("9699"),new ArrayList<UserScore>())); 
        list.add(new Course("HTML CSS","Web Development",Double.parseDouble("9000"),new ArrayList<UserScore>())); 
        list.add(new Course("MEAN Stack","Web Development",Double.parseDouble("9599"),new ArrayList<UserScore>())); 
        list.add(new Course("C","Programming",Double.parseDouble("5000"),new ArrayList<UserScore>())); 
        list.add(new Course("Java","Programming",Double.parseDouble("4999"),new ArrayList<UserScore>())); 
        list.add(new Course("Python","Programming",Double.parseDouble("5299"),new ArrayList<UserScore>())); 
        list.add(new Course("C Sharp","Programming",Double.parseDouble("4900"),new ArrayList<UserScore>())); 
        list.add(new Course("AWS Developer","IT Software",Double.parseDouble("10000"),new ArrayList<UserScore>())); 
        list.add(new Course("Ethical Hacking","IT Software",Double.parseDouble("9300"),new ArrayList<UserScore>())); 
        list.add(new Course("PhotoShop CS","Design",Double.parseDouble("9299"),new ArrayList<UserScore>())); 
        list.add(new Course("TShirt Design","Design",Double.parseDouble("8999"),new ArrayList<UserScore>())); 
        list.add(new Course("3D Modelling","Design",Double.parseDouble("11999"),new ArrayList<UserScore>())); 
        list.add(new Course("Music Theory","Music",Double.parseDouble("9499"),new ArrayList<UserScore>())); 
        list.add(new Course("Learn Guitar","Music",Double.parseDouble("9999"),new ArrayList<UserScore>())); 
        list.add(new Course("Become a Singer","Music",Double.parseDouble("7500"),new ArrayList<UserScore>())); 
        return list; 

    } 
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		List<Course> courselist=new ArrayList<Course>();
		List<Course> result=new ArrayList<Course>();
		CourseBO cbo=new CourseBO();
		System.out.println("Enter the number of courses:");
		int no=Integer.parseInt(sc.nextLine());
		for(int i=0;i<no;i++) {
		String course=sc.nextLine();
		String[] inp=course.split(",");
		Course courses=new Course(inp[0],inp[1],Double.parseDouble(inp[2]));
		courselist.add(courses);
		}
		
		System.out.println("Enter a search type: \r\n"
				+ "1.By Category \r\n"
				+ "2.By List of Names");
		int co=Integer.parseInt(sc.nextLine());
		switch(co) {
		case 1:
		          System.out.println("Enter the Category:");
		          String cat=sc.nextLine();
		        result=cbo.findCourse(courselist,cat);
		        break;
		case 2:System.out.println("Enter the Names:");
		        List<String> namel=new ArrayList<String>();
		       String[] temp= sc.nextLine().split(",");
		       for(int i=0;i<temp.length;i++)
		        		{namel.add(temp[i]);}
		        result=cbo.findCourse(courselist,namel);
		        break;
		 default:System.out.format("Invalid choice");}
		      
		if(!result.isEmpty()) {
			 System.out.format("%-15s %-15s %s\n","Name","Category","Price");
			for(Course cc:result) {
				System.out.format("%-15s %-15s %s\n",cc.getName(),cc.getCategory(),cc.getPrice().toString());
			}}
	    else
	    	 System.out.format("No such course is present");
		}
	
	}

