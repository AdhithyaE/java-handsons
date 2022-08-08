package mobileproject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import java.util.ArrayList;
class MobileBO{
	public ArrayList<Mobile> findMobile(ArrayList<Mobile> mobileList,String modelName){
		ArrayList<Mobile> mbr=new ArrayList<Mobile>();
		for(Mobile m:mobileList) {
			if(m.getModelName().equals(modelName))
			{
				mbr.add(m);
			}
		}
		return mbr;
	}
	public ArrayList<Mobile> findMobile(ArrayList<Mobile> mobileList,Double displaySize){
		ArrayList<Mobile> mbr=new ArrayList<Mobile>();
		for(Mobile m:mobileList) {
			if(m.getDisplaySize().equals(displaySize))
			{
				mbr.add(m);
			}
		}
		return mbr;
	}
}
public class MObile_Req4 {
	public static void main(String args[]) throws ParseException{
		  Scanner sc=new Scanner(System.in);
		  MobileBrand mb=new MobileBrand();
		  MobileBO mbo=new MobileBO();
		  System.out.println("Enter the number of mobiles:");
		  Integer n=Integer.parseInt(sc.nextLine());
		  ArrayList<Mobile> mb_list=new ArrayList<Mobile>();
		  ArrayList<Mobile> result=new ArrayList<Mobile>();
		  for(int i=0;i<n;i++) {
			  String dt=sc.nextLine();
			  mb_list.add(mb.createMobile(dt));
			 		  }
		  System.out.println("Enter a search type: \r\n"
		  		+ "1.By Model Name \r\n"
		  		+ "2.By Display Size ");
		  Integer op=Integer.parseInt(sc.nextLine());
		  switch(op) {
		  case 1:System.out.println("Enter the Model Name:");
		         String mod=sc.nextLine();
		         result=mbo.findMobile(mb_list, mod);
		         break;
		  case 2:System.out.println("Enter the Display Size:");
		         Double ds=Double.parseDouble(sc.nextLine());
		         result=mbo.findMobile(mb_list,ds);
		         break;
		
	}
	if(!result.isEmpty()) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		System.out.format("%-15s %-15s %-12s %-8s %s\n","Reference Id","Model Name","Display Size", "Price","Launched Date");
		  for(Mobile temp:result) {
			  System.out.format("%-15s %-15s %-12s %-8s %s\n",temp.getReferenceId(),temp.getModelName(),temp.getDisplaySize().toString(),temp.getPrice().toString(),sdf.format(temp.getLaunchedDate()));  
		  }}
	else
		System.out.format("No mobiles in this model");
	}
	public int compare(Mobile arg0, Mobile arg1) {

		return arg0.getPrice().compareTo(arg1.getPrice());
	}
}


//#SM 45 JJ6-001,Galaxy J6,5.6,13990,02-01-2017 
//#SM 46 JJ6-002,Galaxy J6,5.7,13900,17-02-2018 
//#SM 47 PRO-003,J3 pro,5,7490,19-06-2017 
//#SM 48 DUO-004,J7 Duo,5.6,17000,23-09-2016 
//#SM 49 PRO-005,J7 Pro,5.5,16900,15-12-2017 
//#SM 50 ONN-006,On5,5,6990,29-07-2017 
//#SM 51 NXT-007,J7 Nxt,5.5,9490,30-03-2018