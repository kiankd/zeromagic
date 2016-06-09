package zeromagic.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import zeromagic.parsing.AbstractHTMLParser;

public class ParsedData extends HashMap<String, String>
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2974547242745332147L;

	public ParsedData(){}
	
	@Override
	public String put(String key, String value)
	{
		return super.put(AbstractHTMLParser.fixForSQL(key), value);
	}
	
	@Override
	public String toString()
	{
		String s = "[";
		for (String key : keySet())
		{
			s += key + ": " + get(key) + ", ";
		}
		s = s.substring(0, s.length()-2) + "]";
		return s;
	}
	
	public ArrayList<String> getColumns()
	{
		return new ArrayList<String>(keySet());
	}
	
//	public static void main(String[] args)
//	{
//		YahooParser yp = new YahooParser();
//		System.out.println(yp.parseForCurrentStockData("AAPL").getColumns());
//	}
}
