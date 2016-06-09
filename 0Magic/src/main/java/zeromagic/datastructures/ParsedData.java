package zeromagic.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import zeromagic.parsing.AbstractHTMLParser;
import zeromagic.parsing.YahooParser;

public class ParsedData extends HashMap<String, String>
{	
	public ParsedData(){}
	
	@Override
	public String put(String key, String value)
	{
		return super.put(AbstractHTMLParser.fixForSQL(key), value);
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
