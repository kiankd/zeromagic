package zeromagic.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateDB 
{
//	public static enum YahooColumn
//	{
//		_Market_Cap_, 
//		_Enterprise_Value_, 
//		_Trailing_PE_, 
//		_Forward_PE_, 
//		_PEG_Ratio_, 
//		_PriceSales_, 
//		_PriceBook_, 
//		_Enterprise_ValueRevenue_, 
//		_Enterprise_ValueEBITDA_, 
//		_Fiscal_Year_Ends, 
//		_Most_Recent_Quarter_, 
//		_Profit_Margin_, 
//		_Operating_Margin_, 
//		_Return_on_Assets_, 
//		_Return_on_Equity_, 
//		_Revenue_, 
//		_Revenue_Per_Share_, 
//		_Qtrly_Revenue_Growth_, 
//		_Gross_Profit_, 
//		_EBITDA_, 
//		_Net_Income_Avl_to_Common_, 
//		_Diluted_EPS_, 
//		_Qtrly_Earnings_Growth_, 
//		_Total_Cash_, 
//		_Total_Cash_Per_Share_, 
//		_Total_Debt_, 
//		_Total_DebtEquity_, 
//		_Current_Ratio_, 
//		_Book_Value_Per_Share_, 
//		_Operating_Cash_Flow_, 
//		_Levered_Free_Cash_Flow_, 
//		_Beta, 
//		_Week_Change, 
//		_SP_Week_Change, 
//		_Week_High_, 
//		_Week_Low_, 
//		_Day_Moving_Average,
//		_Avg_Vol_,
//		_Shares_Outstanding, 
//		_Float, 
//		_percent_Held_by_Insiders, 
//		_percent_Held_by_Institutions, 
//		_Shares_Short_, 
//		_Short_Ratio_, _Short_percent_of_Float_, _Shares_Short_, _Forward_Annual_Dividend_Rate, _Forward_Annual_Dividend_Yield, _Trailing_Annual_Dividend_Yield, _Trailing_Annual_Dividend_Yield, __Year_Average_Dividend_Yield, _Payout_Ratio, _Dividend_Date, _ExDividend_Date, _Last_Split_Factor_, _Last_Split_Date;
//	}
	
	public static void create()
	{
		/**First create the yahoo table**/
		
		Connection c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:zeromagic.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	}
}
