package mock21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;
public class Main {
	public String valuableUser(List<Purchase> purchaseList,String month) throws ParseException{
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String,Double> mp=new HashMap<String,Double>();
		for(Purchase p:purchaseList) {
			
			LocalDate date=LocalDate.parse(df.format(p.getPurchaseDate()));
			if(date.getMonth().toString().equalsIgnoreCase(month)) {
				//System.out.println(date.getMonth());
				User u=p.getUser();
				Double count=0d;
				Double ad=p.getPrice();
				count=mp.get(u.getName());
				if(count==null)
					count=0.0d;
				count+=ad;
				mp.put(u.getName(),count);
			}
		
		}
		Double l=0d;
		String res="";
		for(Entry<String,Double> e:mp.entrySet()) {
			if(e.getValue()>l) {
				l=e.getValue();
				res=e.getKey();
			}
		}
		return res;
	}
	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println("Enter the number of Purchase");
		int noOfPurchase=sc.nextInt();
		List<User> ulist=User.prefill();
		List<Purchase> purchaseList=new ArrayList<>();
		for(int i=0;i<noOfPurchase;i++)
		{
	
			String detail=sc.nextLine();
			if(detail.equals(""))
				detail=sc.nextLine();
			String[] arr = detail.split(",");
			Integer id=Integer.valueOf(arr[0]);
			Double price=Double.parseDouble(arr[1]);
			String couponCode=arr[2];
			Date purchaseDate=sdf.parse(arr[3]);
			List<Order> orderList=new ArrayList<Order>();
			
			
			for(User u:ulist) {
				if(u.getName().equalsIgnoreCase(arr[4].trim()))
				{
					Purchase purchase=new Purchase(id, price, couponCode, purchaseDate,u);
					purchaseList.add(purchase);
					//System.out.println(purchase.getUser().getName());
				}
			}
		}
		Main m=new Main();
		System.out.println("Enter the month:");
		String mon=sc.nextLine();
		System.out.println("The valuable user of the month "+mon+ " is "+m.valuableUser(purchaseList,mon));
	}
}
