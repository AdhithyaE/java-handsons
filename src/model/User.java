package model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private Double price;
	private String type;
	public User() {}

	public User(String name, Double price, String type) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static List<User> prefill(){
		List<User> list = new ArrayList<>();
		list.add(new User("Paneer Fried Rice",Double.parseDouble("150"),"Veg"));
		list.add(new User("Chicken Fried Rice",Double.parseDouble("210"),"NonVeg"));
		list.add(new User("Bucket Chicken",Double.parseDouble("479"),"Veg"));
		list.add(new User("Ghee Roast",Double.parseDouble("75"),"Veg"));
		list.add(new User("Masal Roast",Double.parseDouble("65"),"Veg"));
		list.add(new User("Grill",Double.parseDouble("250"),"NonVeg"));
		list.add(new User("Tomato Soup",Double.parseDouble("100"),"Veg"));
		list.add(new User("Prawn Fry",Double.parseDouble("185"),"NonVeg"));
		list.add(new User("Mushroom Briyani",Double.parseDouble("140"),"Veg"));
		list.add(new User("Baby Corn Chilli",Double.parseDouble("80"),"Veg"));
		list.add(new User("Barbeque Chicken",Double.parseDouble("400"),"NonVeg"));
		list.add(new User("Veg Extravaganza",Double.parseDouble("99"),"Veg"));
		list.add(new User("Margherita",Double.parseDouble("399"),"Veg"));
		list.add(new User("Tandoori Chicken",Double.parseDouble("500"),"NonVeg"));
		list.add(new User("Mutton Balls",Double.parseDouble("90"),"NonVeg"));
		return list;
	}
}


