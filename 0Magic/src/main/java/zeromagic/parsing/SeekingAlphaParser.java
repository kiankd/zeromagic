package zeromagic.parsing;

public class SeekingAlphaParser extends AbstractHTMLParser
{
	public SeekingAlphaParser()
	{
		super();
	}
	
	public static void main(String[] args)
	{
		SeekingAlphaParser alpha = new SeekingAlphaParser();
		alpha.setDocument("http://www.cs.mcgill.ca/~mnemit");
		System.out.println(alpha.docToString());
	}
}
