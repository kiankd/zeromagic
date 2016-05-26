package zeromagic.parsing;

import java.io.IOException;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class AbstractHTMLParser 
{
	protected Document webpage;
	protected HashMap<String, String> data;
	
	protected void parseWebpage(String url)
	{
		try {
			webpage = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
