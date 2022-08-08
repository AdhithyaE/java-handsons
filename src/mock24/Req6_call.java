package mock24;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Req6_call {
	public static void main(String args[]) throws ParseException {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of calls:");
		Integer np=Integer.parseInt(sc.nextLine());
		List<Call> call_list=new ArrayList<Call>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat du=new SimpleDateFormat("HH:mm:ss");
		System.out.println("");
		for(int i=0;i<np;i++) {
			
			String[] inp=sc.nextLine().split(",");
			
			Contact con=new Contact();
			for(Contact c:Contact.prefill())
			{
				if(c.getName().equalsIgnoreCase(inp[5].trim()))
					con=c;
			}
	
			call_list.add(new Call(inp[5],inp[0],inp[1],du.parse(inp[3]),sdf.parse(inp[4]),
					con,Double.parseDouble(inp[2])));
			//System.out.println(con.getName());
		}
		
		CallLog cl=new CallLog(call_list);
		Contact res=new Contact();
		res=cl.getFavouriteContact();
		System.out.println("The favourite contact is "+res.getName());
}
}
