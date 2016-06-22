package zeromagic.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

import zeromagic.database.DBColumn;
import zeromagic.parsing.AbstractHTMLParser;

public class ParsedData extends HashMap<DBColumn, String>
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2974547242745332147L;

	public ParsedData(){}
	
	public String put(String key, String value)
	{
		return super.put(DBColumn.get(key), value);
	}
	
	@Override
	public String toString()
	{
		String s = "[";
		for (DBColumn key : keySet())
		{
			s += key.toString() + ": " + get(key) + ", ";
		}
		s = s.substring(0, s.length()-2) + "]";
		return s;
	}
	
	public ArrayList<DBColumn> getColumns()
	{
		return new ArrayList<DBColumn>(keySet());
	}
}		
	
//	public static void main(String[] args)
//	{
//		YahooParser yp = new YahooParser();
//		System.out.println(yp.parseForCurrentStockData("AAPL").getColumns());
//	}

