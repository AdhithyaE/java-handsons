package mock30;

import java.util.Scanner;

public class Main {
	static Boolean validateContactNumber(String contactNumber) 
	{
		if(contactNumber.matches("[+]+(91)+[1-9]{1}+[0-9]{9}"))
			  return true;
		else
			return false;
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the contact number to be validated:");
		    String num=sc.nextLine();
		 if(validateContactNumber(num))
			 System.out.println("Contact number is valid");
		 else
			 System.out.println("Contact number is invalid");
	}
}
