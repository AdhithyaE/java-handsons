package mock24;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Req1_Main {
public static void main(String args[]) throws ParseException {
	Scanner sc=new Scanner(System.in);
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	System.out.println("Enter contact 1 detail:");
	String inp1=sc.nextLine();
	System.out.println("Enter contact 2 detail:");
	String inp2=sc.nextLine();
	String[] cont1=inp1.split(",");
	String[] cont2=inp2.split(",");
	Contact contact1=new Contact(cont1[0],cont1[1],cont1[2],sdf.parse(cont1[3]));
	Contact contact2=new Contact(cont2[0],cont2[1],cont2[2],sdf.parse(cont2[3]));
	System.out.println("Contact 1\n"+contact1.toString());
	System.out.println("Contact 2\n"+contact2.toString());
	if(contact1.equals(contact2))
	      System.out.println("Contact 1 is same as Contact 2");
	else
	      System.out.println("Contact 1 and Contact 2 are different");
	
			
}

}
