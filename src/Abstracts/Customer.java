package Abstracts;

import java.time.LocalDate;

import Assets.Room.UsedRoom;

public abstract class Customer{
	protected String CID;
	protected String Name;
	protected String NIK;
	
	//	Date of birth date
	protected LocalDate dob;
	
	//	Check in date
	protected LocalDate ci;

	// Check out date
	protected LocalDate co;
	
	// 0 = check out
	// 1 = check in
	protected int status;
	protected UsedRoom Room;
	protected double TotalCharge;
	
	public Customer(String CID, String Name, LocalDate dob, LocalDate ci, LocalDate co, int status, String NIK, String room){
		this.CID = CID;
		this.Name = Name;
		// Date of birth
		this.dob = dob;

		// Check in
		this.ci = ci;

		// Check out
		this.co = co;

		this.NIK = NIK;
		this.status = status;
	}
	
	
}
