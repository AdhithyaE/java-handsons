package mock30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User{
	String name;
	String emailId;
	String contactNumber;
	List<UserScore> userScoreList;
	
	public List<UserScore> getUserScoreList() {
		return userScoreList;
	}
	public void setUserScoreList(List<UserScore> userScoreList) {
		this.userScoreList = userScoreList;
	}
	public User(String name, String emailId, String contactNumber, List<UserScore> userScoreList) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.userScoreList = userScoreList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public User() {
		super();
	}
	
	public User(String name) {
		super();
		this.name = name;
	}
	public User(String name, String emailId, String contactNumber) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		String userdet="Name:"+this.getName()+" \r\n"+"Email Id:"+this.getEmailId()+" \r\n"+ "Contact Number:"+this.getContactNumber();
	return userdet;
	}
	public boolean equals(User o) {
		if(this.toString().equals(o.toString()))
			return true;
		else
			return false;
	}
	public static List<User> prefill(){ 
        List<User> list = new ArrayList<>(); 
        list.add(new User("Harry","harry@gmail.com","9874585258",new ArrayList<UserScore>())); 
        list.add(new User("Oliver","oliver@gmail.com","9515951263",new ArrayList<UserScore>())); 
        list.add(new User("Danny","danny@gmail.com","8745874585",new ArrayList<UserScore>())); 
        list.add(new User("Matt","matt@gmail.com","9636925686",new ArrayList<UserScore>())); 
        list.add(new User("James","james@gmail.com","8454585263",new ArrayList<UserScore>())); 
        list.add(new User("Rob","rob@gmail.com","8475216953",new ArrayList<UserScore>())); 
        list.add(new User("Brandon","brandon@gmail.com","8457548965",new ArrayList<UserScore>())); 
        list.add(new User("Winn","winn@gmail.com","9231252136",new ArrayList<UserScore>())); 
        list.add(new User("Barry","barry@gmail.com","9568956235",new ArrayList<UserScore>())); 
        list.add(new User("Joe","joe@gmail.com","8525623568",new ArrayList<UserScore>())); 
        list.add(new User("John","john@gmail.com","8454575412",new ArrayList<UserScore>())); 
        list.add(new User("Slade","slade@gmail.com","9584758652",new ArrayList<UserScore>())); 
        return list; 

    } 
	
	
}
public class Learning_Platform {
public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	
		
	System.out.println("Enter user 1 details:");
	String user1=sc.nextLine();
	System.out.println("Enter user 2 details:");
	String user2=sc.nextLine();
	String[] inp1=user1.split(",");
	String[] inp2=user2.split(",");
	User user_1=new User(inp1[0],inp1[1],inp1[2]);
	User user_2=new User(inp2[0],inp2[1],inp2[2]);
	System.out.println("");
    
	System.out.println("User 1"+"\n"+user_1.toString()+"\n");
	System.out.println("User 2"+"\n"+user_2.toString()+"\n");
	if(user_1.equals(user_2))
		System.out.println("User 1 and User 2 are same");
	else
	    System.out.println("User 1 and User 2 are different");

}
}
