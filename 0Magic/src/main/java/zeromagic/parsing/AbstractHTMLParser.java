package zeromagic.parsing;

import java.io.IOException;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class AbstractHTMLParser 
{
	public AbstractHTMLParser()
	{
	}
	
	protected Document webpage;
	
	protected void setDocument(String url)
	{
		try {
			webpage = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String docToString()
	{
		return webpage.toString();
	}
}
