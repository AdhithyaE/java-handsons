package model;

public class Order {
	private Integer quantity;
	private User item;
	public Order() {}
	public Order(Integer quantity, User item) {
		super();
		this.quantity = quantity;
		this.item = item;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public User getItem() {
		return item;
	}
	public void setItem(User item) {
		this.item = item;
	}
	
}
