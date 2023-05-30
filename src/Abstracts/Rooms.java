package Abstracts;
import Assets.CustomerStuff.CustomerIdentification;
import interfaces.FacilityActions;

// Room Abstract Class
public abstract class Rooms implements FacilityActions{
	protected String RID;
	protected int Rnum;
	protected int duration;
	protected CustomerIdentification Customer;
	
	public Rooms(String RID, int Rnum, int duration, CustomerIdentification Customer) {
		this.RID = RID;
		this.Rnum = Rnum;
		this.duration = duration;
		this.Customer = Customer;
	}
	
	public abstract double GetPrice();
	
	
}
