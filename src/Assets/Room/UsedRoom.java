package Assets.Room;

import Abstracts.Rooms;
import Assets.CustomerStuff.CustomerIdentification;

public class UsedRoom extends Rooms{
	int type;
public UsedRoom(String RID, int Rnum, int type, int duration, CustomerIdentification CID) {
		super(RID, Rnum, duration, CID);
		this.type = type;
	}

	@Override
	public double GetPrice() {
		return 2000000 * duration;
	}
}
