package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main_Req5 {

	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Purchase");
		int noOfPurchase=sc.nextInt();
		List<User> itemList = User.prefill();
		List<Purchase> purchaseList=new ArrayList<>();

		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		for(int i=0;i<noOfPurchase;i++)
		{
			System.out.println("Enter purchase detail "+(i+1));
			String detail=sc.nextLine();
			if(detail.equals(""))
				detail=sc.nextLine();
			String[] arr = detail.split(",");
			Integer id=Integer.valueOf(arr[0]);
			Double price=0.0;
			String couponCode=arr[1];
			Date purchaseDate=sdf.parse(arr[2]);
			List<Order> orderList=new ArrayList<Order>();
			Purchase purchase=new Purchase(id, price, couponCode, purchaseDate, orderList);
			System.out.println("Enter the number of Orders");
			int noOfOrders=sc.nextInt();
			for(int j=0;j<noOfOrders;j++)
			{
				detail=sc.nextLine();
				if(detail.equals(""))
					detail=sc.nextLine();
				arr=detail.split(",");
				Integer quantity=Integer.valueOf(arr[0]);
				String itemName=arr[1];
				User item=null;

				for(User x:itemList)
				{
					if(x.getName().equals(itemName))
					item=x;	
				}
				Order order=new Order(quantity, item);
				orderList.add(order);
			}
			purchaseList.add(purchase);
		}
		//compute the price for all purchases
		Purchase.computePrice(purchaseList);
		System.out.format("%-5s %-10s %-12s %s\n","Id","Price","Coupon Code","Purchase Date");
		for(Purchase p:purchaseList)
		{
			System.out.format("%-5s %-10s %-12s %s\n",p.getId(),p.getPrice(),p.getCouponCode(),sdf.format(p.getPurchaseDate()));
		}
	}
}
