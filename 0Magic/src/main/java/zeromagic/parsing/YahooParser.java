package zeromagic.parsing;

import java.sql.Date;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import zeromagic.parsing.AbstractHTMLParser;
import zeromagic.datastructures.ParsedData;
import zeromagic.datastructures.ZDate;

@SuppressWarnings("unused")
public class YahooParser extends AbstractHTMLParser 
{
	private static String YAHOO_STOCK_URL = "https://finance.yahoo.com/q/ks?s=";
	private static String YAHOO_HISTORICAL_STOCK_START = "https://finance.yahoo.com/q/hp?s=";
	private static String YAHOO_HISTORICAL_STOCK_END = "+Historical+Prices";
	// maybe change historical to variation of below to exact time span:
	// https://finance.yahoo.com/q/hp?s=STOCK_NAME&a=00&b=19&c=2004&d=05&e=7&f=2016&g=m&z=66&y=0
	// problem is that it only shows stock values, not the other info
	
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
	public ParsedData parseForCurrentStockData(String stockName)
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
	
	public ParsedData parseForHistoricalStockData(String stockName, ZDate start, ZDate end)
	{
		String endOfUrl = "&a=" + start.m + 
						  "&b=" + start.d + 
						  "&c=" + start.y +
						  "&d=" + end.m +
						  "&e=" + end.d +
						  "&f=" + end.y + 
						  "&g=d&z=66&y=0"; // change g=w for weekly, g=m for monthly
		
		
		
		
		return null;
	}
}
