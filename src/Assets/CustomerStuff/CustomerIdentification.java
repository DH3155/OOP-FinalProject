package Assets.CustomerStuff;
import java.time.LocalDate;

import Abstracts.Customer;

public class CustomerIdentification extends Customer{
	public CustomerIdentification(String CID, String Name,LocalDate dob, LocalDate ci, LocalDate co, int status, String ID, String Room){
		super(CID, Name, dob, ci, co, status, ID, Room);
	}
}
