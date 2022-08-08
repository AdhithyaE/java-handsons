package mobileproject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Mobile implements Comparable<Mobile>{
	String referenceId;
	String modelName;
   Double displaySize;
  Double price;
 Date launchedDate;
public String getReferenceId() {
	return referenceId;
}
public void setReferenceId(String referenceId) {
	this.referenceId = referenceId;
}
public String getModelName() {
	return modelName;
}
public void setModelName(String modelName) {
	this.modelName = modelName;
}
public Double getDisplaySize() {
	return displaySize;
}
public void setDisplaySize(Double displaySize) {
	this.displaySize = displaySize;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Date getLaunchedDate() {
	return launchedDate;
}
public void setLaunchedDate(Date launchedDate) {
	this.launchedDate = launchedDate;
}
public Mobile(String referenceId, String modelName, Double displaySize, Double price, Date launchedDate) {
	super();
	this.referenceId = referenceId;
	this.modelName = modelName;
	this.displaySize = displaySize;
	this.price = price;
	this.launchedDate = launchedDate;
}
public Mobile() {
	super();
}
@Override
public String toString() {
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	String str1="ReferenceId:  "+this.referenceId+"\n"+
	"ModelName: "+ this.modelName+"\n"+
	"DisplaySize: "+this.displaySize.toString()+"\n"+
	"Price: "+this.price.toString()+"\n"+
	"LaunchedDate: "+sdf.format(this.launchedDate);
return str1;
} 
public boolean equals(Mobile m) {
	if(this.toString().equals(m.toString()))
		 return true;
	else
		 return false;
}
public int compareTo(Mobile arg0) {
	
	return this.getPrice().compareTo(arg0.getPrice());
}
public static Map<Date,Integer> yearWiseCount(ArrayList<Mobile> mobileList) throws ParseException{
	Map<Date,Integer> ywc=new TreeMap<Date,Integer>();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
	for(Mobile tp: mobileList) {
		String dat=sdf.format(tp.getLaunchedDate());
		Date d=new Date();
		d=sdf.parse(dat);
		Integer count=0;
		count=ywc.get(d);
		if(count==null)
			count=0;
		count++;
		ywc.put(d, count);
	}
	return ywc;
}
}
public class Mobilereq1 {
	public static void main(String args[]) throws ParseException{
		  Scanner sc=new Scanner(System.in);
		  SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		  System.out.println("Enter mobile 1 detail: ");
		  String input1=sc.nextLine();
		  System.out.println("Enter mobile 2 detail:");
		  String input2=sc.nextLine();
		  StringTokenizer st=new StringTokenizer(input1,","); 
		  String ref1=st.nextToken();
		  String model1=st.nextToken();
		  
		  Double dsize1=Double.parseDouble(st.nextToken());
		  Double price1=Double.parseDouble(st.nextToken());
		  Date ldate1=sdf.parse(st.nextToken());
		  Mobile m1=new Mobile(ref1,model1,dsize1,price1,ldate1);
		  System.out.println("Mobile 1:");
          System.out.println(m1.toString());
		  st=new StringTokenizer(input2,","); 
		  String ref2=st.nextToken();
		  String model2=st.nextToken();
		  
		  Double dsize2=Double.parseDouble(st.nextToken());
		  Double price2=Double.parseDouble(st.nextToken());
		  Date ldate2=sdf.parse(st.nextToken());
		  
		  Mobile m2=new Mobile(ref2,model2,dsize2,price2,ldate2);
		  System.out.println("Mobile 2:");
          System.out.println(m2.toString());
		  System.out.print(m1.equals(m2)?"Mobile 1 is same as Mobile 2":"Mobile 1 and Mobile 2 are different");
	}
}
