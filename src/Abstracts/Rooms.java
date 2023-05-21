package Abstracts;
import interfaces.FacilityActions;

// Room Abstract Class
abstract class Rooms implements FacilityActions{
	protected String RID;
	protected int Rnum;
	protected int type;
	protected int days;
	
	public Rooms(String RID, int Rnum, int type, int days) {
		this.RID = RID;
		this.Rnum = Rnum;
		this.type = type;
		this.days = days;
	}
	
	public abstract double GetPrice();
}
