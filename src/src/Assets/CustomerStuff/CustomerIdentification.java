package Assets.CustomerStuff;
import java.time.LocalDate;

import Abstracts.Customer;

public class CustomerIdentification extends Customer{
	public CustomerIdentification(String CID, String Name,LocalDate dob, LocalDate ci, LocalDate co, String ID, String Room, String RNum, int TotalCharge){
		super(CID, Name, dob, ci, co, ID, Room, RNum, TotalCharge);
	}
	
	@Override
	public boolean equals(Object o) {
		CustomerIdentification CI = (CustomerIdentification) o;
		if(this.CID.equals(CI.CID) && this.Name.equals(CI.Name) && this.NIK.equals(CI.NIK)) {
			return true;
		}
		return false;
	}
}
