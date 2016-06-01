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
	
}
