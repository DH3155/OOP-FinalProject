package Abstracts;

import java.time.LocalDate;

import Assets.Room.UsedRoom;

public abstract class Customer{
	public String CID;
	public String Name;
	public String NIK;
	
	//	Date of birth date
	public LocalDate dob;
	
	//	Check in date
	public LocalDate ci;

	// Check out date
	public LocalDate co;
	
	// 0 = check out
	// 1 = check in
	public String Room;
	public String RNum;
	public int TotalCharge;
	
	public Customer(String CID, String Name, LocalDate dob, LocalDate ci, LocalDate co, String NIK, String room, String RNum, int TotalCharge){
		this.CID = CID;
		this.Name = Name;
		// Date of birth
		this.dob = dob;

		// Check in
		this.ci = ci;

		// Check out
		this.co = co;

		this.NIK = NIK;
		this.Room = room;
		this.RNum = RNum;
		this.TotalCharge = TotalCharge;
	}
	
}
