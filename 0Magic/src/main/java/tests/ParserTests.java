package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import zeromagic.parsing.SeekingAlphaParser;

public class ParserTests
{
	private String testUrl = "http://www.cs.mcgill.ca/kkenyo1";
	
	@Test
	public void parserDocumentEqualityTest()
	{
		SeekingAlphaParser p1 = new SeekingAlphaParser();
		p1.setDocument(testUrl);
		
		SeekingAlphaParser p2 = new SeekingAlphaParser(testUrl);
		
		assertEquals(p1.docToString(), p2.docToString());
	}
	
	@Test
	public void sanityCheckTest()
	{
		assertTrue(true);
		assertEquals(false, false);
	}
}
