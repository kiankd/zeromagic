package zeromagic.parsing;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class AbstractHTMLParser 
{
	protected Document webpage;
	
	// --------------- Constructors --------------- //
	public AbstractHTMLParser() {}
	
	/**
	 * Initializes the parser and then connects the parser object to the url.
	 * @param url String that we use to connect to a website.
	 */
	public AbstractHTMLParser(String url)
	{
		setDocument(url);
	}
	
	// --------------- Setters --------------- //
	/**
	 * Connects to the URL of the webpage string passed to it, and sets that Document as a private variable.
	 * @param url String that we use to connect to a website.
	 */
	public void setDocument(String url)
	{
		System.out.println("Connecting to website: "+url);
		
		try {
			webpage = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// --------------- Getters --------------- //
	public String docToString()
	{
		return webpage.toString();
	}
	
	// --------------- String Fixing --------- //
	public static String fixForSQL(String arg)
	{
		String temp = "_" + arg.replaceAll("[!/@#,$^&*+:=`]", "").replace(" ", "_").replace("%", "percent").replace("-", "");
		
		int stop = 0;
		//This condition retains the text in parentheses for Avg Vol and Shares Short (prior month) to avoid duplication
		if(!(temp.contains("Avg_Vol") || (temp.contains("prior_month"))))
		{
			for(int i = 0; i < temp.length(); i++)
			{
				if (temp.charAt(i) == '(')
				{
					stop = i;
					break;
				}
			}
			if(stop !=0)
			{
				temp = temp.substring(0, stop);
			}
		}
		else
		{
			temp = temp.replace('(', '_').replace(')', '_');
		}
		return temp;
	}
}
