package mock21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemO {
	public List<Item> findItem(List<Item> itemList, String type){
		List<Item> res=new ArrayList<Item>();
		for(Item i:itemList) {
			if(i.getType().trim().equalsIgnoreCase(type.trim()))
				res.add(i);
		}
		return res;
	}
	public List<Item> findItem(List<Item> itemList, Double price){
		List<Item> res=new ArrayList<Item>();
		for(Item i:itemList) {
			if(i.getPrice().equals(price))
				       res.add(i);
		}
		return res;
	}
	public static void main(String[] args) {
		ItemO ibo=new ItemO();
		Scanner sc=new Scanner(System.in);
		List<Item> item_list=new ArrayList<Item>();
		List<Item> result=new ArrayList<Item>();
		System.out.println("Enter the number of items:");
		Integer no=Integer.parseInt(sc.nextLine());
		for(int i=0;i<no;i++) {
			String inp=sc.nextLine();
			String[] i1=inp.split(",");
			Item item=new Item(i1[0],Double.parseDouble(i1[1]),i1[2]);
			item_list.add(item);
		}
		System.out.println("Enter a search type: \r\n"
				+ "1.By Type \r\n"
				+ "2.By Price");
		Integer co=Integer.parseInt(sc.nextLine());
		switch(co) {
		case 1:System.out.println("Enter the Type:");
		       String type=sc.nextLine();
			     result=ibo.findItem(item_list,type);
			     break;
		case 2:System.out.println("Enter the Price:");
	        Double p=Double.parseDouble(sc.nextLine());
		     result=ibo.findItem(item_list,p);
		     break;
		  default:System.out.println("Invalid Choice");
}
		if(!result.isEmpty()) {
			System.out.format("%-20s %-5s %s\n","Name","Price","Type");
			for(Item ii:result) {
				System.out.format("%-20s %.01f %s\n",ii.getName(),ii.getPrice(),ii.getType());
			}
		}
		else {
			System.out.format("No such item is present");
		}
		}}
