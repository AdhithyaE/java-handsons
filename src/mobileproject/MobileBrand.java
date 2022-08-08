package mobileproject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;


public class MobileBrand {
	private ArrayList<Mobile> mobileList;
	private String name;
	public ArrayList<Mobile> getMobileList() {
		return mobileList;
	}
	public void setMobileList(ArrayList<Mobile> mobileList) {
		this.mobileList = mobileList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MobileBrand() {
		super();
	}
	public MobileBrand(ArrayList<Mobile> mobileList, String name) {
		super();
		this.mobileList = mobileList;
		this.name = name;
	}
	
	public MobileBrand(String name) {
		super();
		this.name = name;
		this.mobileList=new ArrayList<Mobile>();
	}
	public static Mobile createMobile(String detail) throws ParseException{
		 StringTokenizer st=new StringTokenizer(detail,","); 
		 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		  String ref1=st.nextToken();
		  String model1=st.nextToken();
		  
		  Double dsize1=Double.parseDouble(st.nextToken());
		  Double price1=Double.parseDouble(st.nextToken());
		  Date ldate1=sdf.parse(st.nextToken());
		  Mobile m1=new Mobile(ref1,model1,dsize1,price1,ldate1);
		  return m1;
		
	}
	public void addMobileToMobileBrand(Mobile mobile) {
		this.mobileList.add(mobile);
	}
	public Boolean removeMobileFromMobileBrand(String referenceId) {
		if(this.mobileList!=null) {
		for(Mobile m:this.mobileList)
		{if(m.referenceId.equals(referenceId))
			   {this.mobileList.remove(m);
			   return true;
			   }
		
		}}
		return false;
	}
	public void displayMobiles(){
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		if(this.mobileList.isEmpty())
			System.out.println("No Moiles to show");
		else
		    {System.out.println("Mobiles in "+this.name);
		    System.out.format("%-15s%-20s%-15s%-15s%-15s\n", "ReferenceId","ModelName","DisplaySize","Price","LaunchedDate"); 
		    for(Mobile m:this.mobileList) {
		    	System.out.format("%-15s%-20s%-15s%-15s%-15s\n",m.getReferenceId(),m.getModelName(),m.getDisplaySize().toString(),m.getPrice().toString(),sdf.format(m.getLaunchedDate())); 

		    }
		    }	
			
	}
	public static void main(String args[]) throws ParseException{
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the name of Mobile Brand:");
		  String uname=sc.nextLine();
		  MobileBrand mb=new MobileBrand(uname);
		  int flag=1;
		 do { System.out.println("1.Add Mobile\n"
		  		+ "2.Delete Mobile\n"
		  		+ "3.Display Mobiles\n"
		  		+ "4.Exit\n"
		  		+ "Enter your choice:");
		 int c=Integer.parseInt(sc.nextLine());
		 
		 switch(c) {
		 case 1:String details=sc.nextLine();
			 Mobile mob=new Mobile();
		       mob=mb.createMobile(details);
		        mb.addMobileToMobileBrand(mob);;
		        break;
		 case 2:System.out.println("Enter the reference id of the mobile to be deleted:");
			   String mb_name=sc.nextLine();
		        if(mb.removeMobileFromMobileBrand(mb_name))
		        	System.out.println("Mobile successfully deleted");
		        else
		        	System.out.println("Mobile not found in the MobileBrand");
		        break;
		 case 3:mb.displayMobiles();
		        break;
		 case 4:flag=0;
		 }
		 }while(flag==1);
	
	}
}
