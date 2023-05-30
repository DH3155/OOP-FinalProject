package Abstracts;
// Abstract for menu item
public class MenuItems {
	protected String name;
	protected int type;
	// 0 for drinks
	// 1 for foods
	protected double price;

	public MenuItems(String name, int type, double price){
		this.name = name;
		this.type = type;
		this. price = price;
	}
}
