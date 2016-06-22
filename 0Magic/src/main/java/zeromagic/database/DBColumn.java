package zeromagic.database;

import java.util.HashMap;

public class DBColumn
{
	private static HashMap<String,DBColumn> ColumnNames = new HashMap<String, DBColumn>();
	private String tableName;
	
	//outsiders do not touch this constructor
	private DBColumn(String name)
	{
		//do attribute setting here
	}
	
	//public getter of unique DBColumns
	public static DBColumn get(String originalColumnName)
	{
		String fixedName = fixForSQL(originalColumnName);
		if(ColumnNames.containsKey(fixedName))
		{
			return ColumnNames.get(fixedName);
		}
		ColumnNames.put(fixedName, new DBColumn(fixedName));
		return ColumnNames.get(fixedName);
	}
	
	public String getTableName()
	{
		return tableName;
	}
	
	private static String fixForSQL(String arg)
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
