package mobileproject;

import java.text.ParseException;
import java.util.Scanner;

class Main{
	static Boolean validateReferenceId(String referenceId){
		if(referenceId.matches("(#)+[A-Z]{2,3}+[\s]+([0-9]{2}+[\s])*+[A-Z]{2,6}+[-]+[0-9]{2,6}"))
		{
			return true;
		}
		else 
			return false;
	}
}
public class Mobile_req3 {
	public static void main(String args[]) throws ParseException{
		  Scanner sc=new Scanner(System.in);
		  Main m=new Main();
		  System.out.println("Enter the reference Id to be validated:");
		  String ref=sc.nextLine();
		 // System.out.println(m.validateReferenceId("#BA CX-20"));
		  if(m.validateReferenceId(ref))
		              System.out.println("Reference Id is valid");
		  else
			  System.out.println("Reference Id is invalid");
	}
}
