package mock21;

import java.util.Scanner;

public class Req1 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter user 1 detail");
	String inp1=sc.nextLine();
	System.out.println("Enter user 2 detail");
	String inp2=sc.nextLine();
	String[] u1=inp1.split(",");
	User user1=new User(u1[0],u1[1],u1[2],u1[3]);
	String[] u2=inp2.split(",");
	User user2=new User(u2[0],u2[1],u2[2],u2[3]);
	System.out.println("User 1\n"+user1.toString());
	System.out.println("User 2\n"+user2.toString());
	if(user1.equals(user2))
	          System.out.println("User 1 is same as User 2");
	else
	        System.out.println("User 1 and User 2 are different");
}
}
