package zeromagic.database;

public class DatabaseConstants 
{
	public enum InteractionEnum
	{
		UPDATE, 
		SET,
		SELECT, 
		FROM
	}
	
	public enum DatabaseTableEnum 
	{
		ARTICLES,
		STOCKS_DATA,
		SHORTSELLERS,
		PROMOTERS,
		FORMULA
	}
	
	public enum DatabaseColumnEnum
	{
		URL,
		TYPE,
		SYMBOL,
		MARKETCAPN,
		SHORTRATIO,
		OCFN,
		PROXIMITY,
		SHORTPUBLIC,
		PROMOTERSPUBLIC,
		FIFTYWEEKHIGH,
		DAYMA
	}

}
