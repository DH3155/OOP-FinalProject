package Abstracts;
// Facility Abstract
public abstract class Facility {
	protected String name;
	protected int price;
	protected int quantity;
	
	public Facility(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
}
