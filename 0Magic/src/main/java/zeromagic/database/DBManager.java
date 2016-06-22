package zeromagic.database;

import java.sql.Connection;

import zeromagic.datastructures.ParsedData;


public class DBManager 
{
	private static Connection MANAGER_CONNECTION;
	
	public DBManager(String pathToDb)
	{
		/*Sets up connection to specified db etc*/
	}
	
	public void updateDB(ParsedData data)
	{	
		for(DBColumn col: data.getColumns())
		{
			//stufff
			
			
		}
	}
}
