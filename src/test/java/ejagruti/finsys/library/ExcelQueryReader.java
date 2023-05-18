package ejagruti.finsys.library;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import ejagruti.finsys.config.TestBase;

public class ExcelQueryReader extends TestBase  {
public static String Query_From_Excel;
	public static String Search_Query(String TestCase_ID, String Column_Header_For_Query) throws SQLException,IOException
	{
		try
		{
	
			try 
			{
			
				ExcelUtil_For_Scenario.setExcelFile(System.getProperty("user.dir")+prop.getProperty("Test_Parameter_Data_Sheet_Path"),"Sheet1");
				
				//String Test_Sheet_Name = ExcelUtil_For_Scenario.getCelldata(TestCase_ID);
				
				ExcelUtil.setExcelFile(System.getProperty("user.dir")+prop.getProperty("Test_Parameter_Data_Sheet_Path"),"Sheet1");
				
				//return ExcelUtil.SearchQuery_From_Excel(TestCase_ID, Column_Header_For_Query);
				
			}
		
			catch(FileNotFoundException e)
			{
				System.out.println("Unable to find TestData sheet and sheet number"+ e.getLocalizedMessage());
				e.printStackTrace();
			}
			
			Query_From_Excel = ExcelUtil.SearchQuery_From_Excel(TestCase_ID, Column_Header_For_Query);
			
			System.out.println("Query_From_Excel --> "+Query_From_Excel);
		}
		catch(Exception ex)
		{
			System.out.println("Error fetching SQL Query from Excel Sheet"+ex.getLocalizedMessage());
		}
		
		return Query_From_Excel;
	}
	
}