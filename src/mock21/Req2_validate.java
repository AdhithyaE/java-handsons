package mock21;

import java.util.Scanner;

public class Req2_validate {
	static Boolean validateEmail(String email) {
		if(email.matches("[a-z]{1}+[a-z0-9_.]{1,}+[@]{1}+[a-z]{1,}+[.]{1}+[a-z]{2,6}"))
			return true;
		return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the email to be validated:");
       String email=sc.nextLine();
       if(validateEmail(email))
	          System.out.println("Email is valid");
	else
	        System.out.println("Email is invalid");
}
}