package mock21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Req4 {
	public static void main(String[] args) {
		ItemO ibo=new ItemO();
		Item def=new Item();
		Scanner sc=new Scanner(System.in);
		List<Item> item_list=new ArrayList<Item>();
		//List<Item> result=new ArrayList<Item>();
		System.out.println("Enter the number of items:");
		Integer no=Integer.parseInt(sc.nextLine());
		for(int i=0;i<no;i++) {
			String inp=sc.nextLine();
			Item item=new Item();
			item=def.createItem(inp);
			item_list.add(item);

		}
		System.out.println("Enter a type to sort: \r\n"
				+ "1.Sort by Name \r\n"
				+ "2.Sort by Price");
		Integer co=Integer.parseInt(sc.nextLine());
       switch(co) {
       case 1:Collections.sort(item_list);break;
       case 2:Collections.sort(item_list,new PriceComparator());break;
       default:System.out.println("Invalid Choice");
        
       }
       if(!item_list.isEmpty()) {
			System.out.format("%-20s %-5s %s\n","Name","Price","Type");
			for(Item ii:item_list) {
				System.out.format("%-20s %.01f %s\n",ii.getName(),ii.getPrice(),ii.getType());
			}
		}
			}
}
