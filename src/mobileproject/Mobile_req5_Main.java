package mobileproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mobile_req5_Main {
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
		  System.out.println("Enter a type to sort: \r\n"
		  		+ "1.Sort by price \r\n"
		  		+ "2.Sort by launched date");
		  Integer op=Integer.parseInt(sc.nextLine());
	
	switch(op)
	{
	case 1:		
		Collections.sort(mb_list);
		break;
	case 2:
		Collections.sort(mb_list, new LaunchedDateComparator());
		break;
	}
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	System.out.format("%-15s %-15s %-12s %-8s %s\n","Reference Id","Model Name","Display Size", "Price","Launched Date");
	  for(Mobile temp:mb_list) {
		  System.out.format("%-15s %-15s %-12s %-8s %s\n",temp.getReferenceId(),temp.getModelName(),temp.getDisplaySize().toString(),temp.getPrice().toString(),sdf.format(temp.getLaunchedDate()));  
	}
}}
