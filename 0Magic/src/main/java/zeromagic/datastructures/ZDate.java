package zeromagic.datastructures;

public class ZDate 
{
	public String m, d, y;
	
	/**
	 * Simple date class. Note that we are assuming that January starts at int 0! December = 11!
	 */
	public ZDate(int month, int day, int year)
	{
		m = Integer.toString(month);
		d = Integer.toString(day);
		y = Integer.toString(year);
		
		if (m.length() == 1)
			m = "0"+m;
		
		if (d.length() == 1)
			d = "0"+d;
	}
}
