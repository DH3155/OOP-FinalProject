package Abstracts;

import interfaces.Menu;

// Abstract for menu item
public abstract class MenuItems implements Menu{
	protected String name;
	// 0 for drinks
	// 1 for foods
	protected int price;
	protected int quantity;

	public MenuItems(String name, int price, int quantity){
		this.name = name;
		this. price = price;
		this.quantity = quantity;
	}
	
	public int GetPrice() {
		return this.price * this.quantity;
	}
}
