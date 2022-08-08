package mobileproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;
public class Mobile_Req6 {
	public static void main(String args[]) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		  Scanner sc=new Scanner(System.in);
		  MobileBrand mb=new MobileBrand();
		  Mobile tmp=new Mobile();
		  System.out.println("Enter the number of mobiles:");
		  Integer n=Integer.parseInt(sc.nextLine());
		  ArrayList<Mobile> mb_list=new ArrayList<Mobile>();
		  
		  for(int i=0;i<n;i++) {
			  String dt=sc.nextLine();
			  mb_list.add(mb.createMobile(dt));
		   		  }
		  Map<Date,Integer> ywc=new TreeMap<Date,Integer>();
		  ywc=tmp.yearWiseCount(mb_list);
		  System.out.format("%-15s %s\n","Year","No. of Mobiles");
		  for(Entry<Date,Integer> t1:ywc.entrySet()) {
		  {System.out.format("%-15s %s\n",sdf.format(t1.getKey()),t1.getValue());}
		  }
		  }
}
