package zeromagic.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBCreator 
{
	private static Connection CONNECTION;
	
	public DBCreator()
		{
			try
			{
				Class.forName("org.sqlite.JDBC");
				CONNECTION = DriverManager.getConnection("jdbc:sqlite:zeromagic.db");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	/**57 enums, one for each column in the Yahoo Current table.
	 * NOTE: On yahoo finance there are 58 fields, since there are two fields 
	 * for Trailing Annual Dividend Yield. ParsedData class only considers one of them**/
	
		
	public void createTables()
		{
			String YCurrCreate = "CREATE TABLE yahoocurrent(";
		
			for(YahooColumnsCurrent y : YahooColumnsCurrent.values())
			{
				YCurrCreate += y.toString() + " varchar(50),";
			}
		
			YCurrCreate = YCurrCreate.substring(0, YCurrCreate.length()-1);
			YCurrCreate += ")";
		
			try
			{
				CONNECTION.createStatement().execute(YCurrCreate);
				CONNECTION.close();
			}
			catch(Exception e){System.out.println(e);}
		}
	
	public static void main(String[] args)
		{
			DBCreator dbc = new DBCreator();
			dbc.createTables();
		}
	
	private static enum YahooColumnsCurrent
		{
			_5_Year_Average_Dividend_Yield4, 
			_Total_Cash_Per_Share_, 
			_SP500_52Week_Change3, 
			_Short_Ratio_, 
			_Float, 
			_Trailing_Annual_Dividend_Yield3, 
			_50Day_Moving_Average3, 
			_52Week_Change3, 
			_ExDividend_Date4, 
			_Gross_Profit_, 
			_Operating_Cash_Flow_, 
			_PriceSales_, 
			_Qtrly_Revenue_Growth_, 
			_Qtrly_Earnings_Growth_, 
			_Forward_Annual_Dividend_Yield4, 
			_Most_Recent_Quarter_, 
			_Last_Split_Date3, 
			_Beta, _Current_Ratio_, 
			_Dividend_Date3, 
			_52Week_Low_, 
			_Shares_Outstanding5, 
			_Revenue_, 
			_Total_Debt_, 
			_Profit_Margin_, 
			_Operating_Margin_, 
			_Levered_Free_Cash_Flow_, 
			_PEG_Ratio_, 
			_percent_Held_by_Insiders1, 
			_Trailing_PE_, 
			_200Day_Moving_Average3, 
			_Short_percent_of_Float_, 
			_Shares_Short__prior_month_3, 
			_Last_Split_Factor_, 
			_Return_on_Equity_, 
			_EBITDA_, 
			_Total_DebtEquity_, 
			_PriceBook_, 
			_Forward_PE_, 
			_Revenue_Per_Share_, 
			_Avg_Vol__10_day_3, 
			_Enterprise_ValueRevenue_, 
			_Diluted_EPS_, 
			_Total_Cash_, 
			_Forward_Annual_Dividend_Rate4, 
			_Enterprise_Value_, 
			_Market_Cap_, 
			_52Week_High_, 
			_percent_Held_by_Institutions1, 
			_Avg_Vol__3_month_3, 
			_Return_on_Assets_, 
			_Shares_Short_, 
			_Net_Income_Avl_to_Common_, 
			_Payout_Ratio4, 
			_Book_Value_Per_Share_, 
			_Enterprise_ValueEBITDA_, 
			_Fiscal_Year_Ends;
		}
	
	public static enum YahooColumnsHistoric
		{
			/**PUT HISTORIC COLUMNS!**/
		}
}
