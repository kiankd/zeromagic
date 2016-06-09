package zeromagic.parsing;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
	private static String YAHOO_TABLE_HEADER_CLASS = ".yfnc_tablehead1";
	private static String YAHOO_TABLE_DATA_CLASS = ".yfnc_tabledata1";
	private static int PAGE_TABLE_NEXT = 66;
	
	public YahooParser() { super(); }
	public YahooParser(String url) { super(url); }
	
	private Elements tableHeads, tableData;
	private void setTableData()
	{
		tableHeads = webpage.select(YAHOO_TABLE_HEADER_CLASS);
		tableData = webpage.select(YAHOO_TABLE_DATA_CLASS);
	}
	
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
		setTableData();
		
		assert tableHeads.size() == tableData.size();
		
		ParsedData parsedData = new ParsedData();
		
		for (int i=0; i<tableHeads.size(); i++)
		{
			parsedData.put(tableHeads.get(i).text(), tableData.get(i).text());
		}
		
		return parsedData;
	}
	
	/*
	 * @TODO: Need to have it get all data over a time sequence if the time sequence is greater than
	 * 66 days, which means we have to go to another page. This simply means increment y=0 in endOfUrl 
	 * by 66 to y=66, and then y=132 etc.
	 */
	public ArrayList<ParsedData> parseForHistoricalStockData(String stockName, ZDate start, ZDate end)
	{
		ArrayList<ParsedData> data = new ArrayList<ParsedData>();
		
		String endOfUrl = "&a=" + start.m + 
						  "&b=" + start.d + 
						  "&c=" + start.y +
						  "&d=" + end.m +
						  "&e=" + end.d +
						  "&f=" + end.y + 
						  "&g=d&z=66&y=0"; // change g=w for weekly, g=m for monthly
		int yValueInUrl = 0;
		int daysBetween = start.daysBetween(end);
		System.out.println("Getting stock data over a "+daysBetween+"-day period.");
		
		while (data.size() < daysBetween)
		{
			if (data.size() != 0)
			{
				endOfUrl = endOfUrl.replace("y="+yValueInUrl, "y=" + (yValueInUrl + PAGE_TABLE_NEXT));
				yValueInUrl += PAGE_TABLE_NEXT;
			}
			
			setDocument(YAHOO_HISTORICAL_STOCK_START + stockName + endOfUrl);
			setTableData();
			
			// Make a header list
			ArrayList<String> headers = new ArrayList<String>();
			for (int i = 0; i < tableHeads.size(); i++) 
			{
				headers.add(tableHeads.get(i).text());
			}
			
			// Clean table data if there is a row with only 2 columns
			Elements newTableData = new Elements();
			for (int i=0; i < tableData.size(); i++)
			{
				if (tableData.get(i).text().contains("Dividend"))
				{
					newTableData.remove(i-1);
				}
				else
				{
					newTableData.add(tableData.get(i));
				}
			}
			tableData = newTableData;
			
			// Extract values from table data
			ParsedData currentItem = new ParsedData();
			for (int i=0; i < tableData.size(); i++)
			{
				if (i != 0 && i % headers.size() == 0) 
				{
					data.add(currentItem);
					if (data.size() >= daysBetween)
					{
						return data;
					}
					currentItem = new ParsedData();
				}
				currentItem.put(headers.get(i % headers.size()), tableData.get(i).text());
			}
		}
		
		for (ParsedData p : data)
			System.out.println(p);
		
		return data;
	}
	
	public static void main(String[] args) 
	{
		ZDate start = new ZDate(1, 20, 2016);
		ZDate end = new ZDate(5, 5, 2016);
		
		YahooParser p = new YahooParser();
		p.parseForHistoricalStockData("AAPL", start, end);
	}
}
