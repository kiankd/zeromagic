package structures;

import java.util.HashMap;
import zeromagic.database.DatabaseConstants.DatabaseColumnEnum;

public class Data 
{
	private HashMap<DatabaseColumnEnum,String> map;
	
	public Data()
	{
		map = new HashMap<DatabaseColumnEnum,String>();
	}
	
	public void put(DatabaseColumnEnum dbCol ,String val)
	{
		map.put(dbCol, val);
	}
}
