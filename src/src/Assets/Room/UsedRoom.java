package Assets.Room;

public class UsedRoom{
	public String RID;
	public int Rnum;
	public int type;
	public int duration;
	public String CID;
public UsedRoom(String RID, int Rnum, int type, int duration, String CID) {
		this.RID = RID;
		this.Rnum = Rnum;
		this.duration = duration;
		this.type = type;
		this.CID = CID;
	}

	public Integer GetPrice() {
		if(type == 1) {
			return 2000000 * duration;			
		}else if(type == 2) {
			return 4000000 * duration;
		}
		return 6000000*duration;
	}
}
