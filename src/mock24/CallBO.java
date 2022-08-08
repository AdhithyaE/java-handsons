package mock24;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CallBO {
	public static List<Call> findCall(List<Call> callList,Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		List<Call> clist=new ArrayList<Call>();
		for(Call c:callList) {
			if(sdf.format(c.getDate()).equals(sdf.format(date)))
			{
				clist.add(c);
			}
		}
		return clist;
	}
	public static List<Call> findCall(List<Call> callList,String contactName)
	{
		List<Call> clist=new ArrayList<Call>();
		for(Call c:callList) {
			//System.out.println("=========");
			if(c.getContactName().equalsIgnoreCase(contactName))
			{
				clist.add(c);
				//System.out.println("=========");
			}
		}
		return clist;
	}
	public static void main(String args[]) throws ParseException {
		Scanner sc=new Scanner(System.in);
		List<Call> call_list=new ArrayList<Call>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat du=new SimpleDateFormat("HH:mm:ss");
		System.out.println("Enter the number of calls:");
		Integer n=Integer.parseInt(sc.nextLine());
		//System.out.println("");
		for(int i=0;i<n;i++) {
			String[] inp=sc.nextLine().split(",");
			Contact con=new Contact();
			for(Contact c:Contact.prefill())
			{
				if(c.getName().equalsIgnoreCase(inp[5]))
					con=c;
			
					
			}
			call_list.add(new Call(inp[5],inp[0],inp[1],du.parse(inp[3]),sdf.parse(inp[4]),
					con,Double.parseDouble(inp[2])));
			
		}
		
		System.out.println("Enter a search type: \r\n"
				+ "1.By a name \r\n"
				+ "2.By a call date");
		List<Call> result=new ArrayList<Call>();
		Integer co=Integer.parseInt(sc.nextLine());
		switch(co) {
		case 1:System.out.println("Enter the name:");
		       String nam=sc.nextLine();
		       result=findCall(call_list,nam);
		       break;
		case 2:System.out.println("Enter the call date:");
	            Date d=sdf.parse(sc.nextLine());
	       result=findCall(call_list,d);
		}
		if(!result.isEmpty()) {
			System.out.format("%-13s %-15s %-10s %-10s %-10s %-15s %s\n",
					"Name","Mobile Number","Type", "Call Type","Cost" ,"Duration","Date");
			for(Call c:result) {
				System.out.format("%-13s %-15s %-10s %-10s %-10s %-15s %s\n",
						c.getContact().getName(),c.getContact().getMobileNumber(),
						c.getType(),c.getCallType(),c.getCost() ,du.format(c.getDuration()),sdf.format(c.getDate()));
			}
		}
	}
}
