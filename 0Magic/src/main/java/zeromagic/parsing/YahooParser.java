package zeromagic.parsing;

import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import zeromagic.parsing.AbstractHTMLParser;
import zeromagic.datastructures.ParsedData;

public class YahooParser extends AbstractHTMLParser 
{
	private static String YAHOO_STOCK_URL = "https://finance.yahoo.com/q/ks?s=";
	private static String YAHOO_TABLE_HEADER_CLASS = ".yfnc_tablehead1";
	private static String YAHOO_TABLE_DATA_CLASS = ".yfnc_tabledata1";
	
	public YahooParser() { super(); }	
	public YahooParser(String url) { super(url); }
	
	/**
	 * This method parses the Yahoo finance stock table for the given stock name
	 * and then returns a ParsedData object mapping the names of the stock info
	 * columns to the values they correspond to.
	 * @param stockName UPPERCASE name of a stock.
	 * @return ParsedData mapping.
	 */
	public ParsedData parseForStockData(String stockName)
	{
		setDocument(YAHOO_STOCK_URL + stockName);
		Elements tableHeads = webpage.select(YAHOO_TABLE_HEADER_CLASS);
		Elements tableData = webpage.select(YAHOO_TABLE_DATA_CLASS);
		
		assert tableHeads.size() == tableData.size();
		
		ParsedData parsedData = new ParsedData();
		
		for (int i=0; i<tableHeads.size(); i++)
		{
			parsedData.put(tableHeads.get(i).text(), tableData.get(i).text());
		}
		
		return parsedData;
	}
	
	public void testParseForStockData(String stockName, Boolean verbose)
	{
		setDocument(YAHOO_STOCK_URL + stockName);
		Elements tableHeads = webpage.select(".yfnc_tablehead1");
		Elements tableData = webpage.select(".yfnc_tabledata1");

		if (verbose)
		{
			System.out.println(tableHeads);
			System.out.println(tableData);
			System.out.println(tableHeads.size() == tableData.size());
			System.out.println(tableHeads.size());
			System.out.println(tableData.size());
		}
			
		assert tableHeads.size() == tableData.size();
		
		ParsedData myData = new ParsedData();
		
		for (int i=0; i<tableHeads.size(); i++)
		{
			myData.put(tableHeads.get(i).text(), tableData.get(i).text());
		}
		
		if (verbose)
		{
			for (String key : myData.keySet())
			{
				System.out.print(key+" ---> ");
				System.out.println(myData.get(key));
			}
		}
		
		System.out.println("This table is "+tableHeads.size()+" by "+tableData.size());
	}
	
	/**
	 * Gets the correctly ordered list of column names from Yahoo finance based on example stock (GOOGL).
	 * @return ArrayList of column names (i.e., Market cap, 4-month high etc.)
	 */
	public static ArrayList<String> getColumnNames()
	{
		YahooParser parser = new YahooParser(YAHOO_STOCK_URL + "GOOGL");
		Elements tableHeads = parser.webpage.select(YAHOO_TABLE_HEADER_CLASS);
		ArrayList<String> columnNames = new ArrayList<String>();
		for (Element e : tableHeads) {
			columnNames.add(e.text());
		}
		return columnNames;
	}
	
	public static void main(String[] args) 
	{
		YahooParser parser = new YahooParser();
		parser.testParseForStockData("AIG", false);
		System.out.println(getColumnNames());
	}
}
