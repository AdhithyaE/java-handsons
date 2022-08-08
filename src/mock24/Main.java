package mock24;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
	static Boolean validateMobileNumber(String mobileNumber) {
		if(mobileNumber.matches("[+]+(91)+[1-9]{1}+[0-9]{9}"))
			 return true;
		return false;
	}
	public static void main(String args[]) throws ParseException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Mobile number to be validated:");
		String inp1=sc.nextLine();
		if(validateMobileNumber(inp1))
		      System.out.println("Mobile number is valid");
		else
		      System.out.println("Mobile number is invalid");
		

}
}