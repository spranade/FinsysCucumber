package ejagruti.finsys.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import ejagruti.finsys.config.TestBase;
import ejagruti.finsys.library.DBconnection;

public class DBQueries extends TestBase {

protected static Connection conn;
protected static Statement stmt;
protected static Statement pstmt;
protected static ResultSetMetaData rsmd;
protected static ResultSet rset;
protected static String query = "";
protected static String SQL_QUERY_FROM_DB = "";
protected static int columnNumber;
protected static int rownumber;
protected static Properties prop;
protected static DBconnection connect; 


static {
	prop = new Properties();
	
	try {
	 //InputStream FI = FileUtility.retrieveFileOrClasspathResourceAsStream("config/DB.properties");
	 
	 FileInputStream FI = new FileInputStream(
	 System.getProperty("user.dir")+"/src/test/resources/DB.properties");
	 
	 
			 try {
			 prop.load(FI);
			 	
			}
			catch(IOException e)
			{
				System.out.println("Error while loading property file for database" + e.getLocalizedMessage());
				e.printStackTrace();
			}

		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error while fetching file for database" + e.getLocalizedMessage());
			e.printStackTrace();
		}


		connect = new DBconnection();
		conn = connect.setupDatabaseConnection(prop.getProperty("DB-URL"),
		prop.getProperty("DB-userName"), prop.getProperty("DB-password"));

		}



		public static String Execute_Query(String Query_From_Excel_Sheet) throws SQLException
		{
			String SQL_QUERY_FROM_DB = null;
			try 
			{
			pstmt = conn.createStatement();
			rset = pstmt.executeQuery(Query_From_Excel_Sheet);
			while(rset.next())
			SQL_QUERY_FROM_DB = rset.getString(1);
			}
			catch(Exception ex)
			{
				System.out.println("Error with SQL query"+ ex.getLocalizedMessage());
			}
			finally
			{
				pstmt.close();
			}
			return SQL_QUERY_FROM_DB;
		}




		public static String Execute_Query_loop(String Query_From_Excel_Sheet) throws SQLException
		{
			String SQL_QUERY_FROM_DB = null;
			try {
				pstmt = conn.createStatement();
				rset = pstmt.executeQuery(Query_From_Excel_Sheet);
				if (rset.next() == false) {
					System.out.println("no record found");
				} else {
					SQL_QUERY_FROM_DB = rset.getString(1);
				}
			}
						catch(Exception ex)
						{
							System.out.println("Error with SQL query"+ ex.getLocalizedMessage());
						}
						finally
						{
							pstmt.close();
						}
						return SQL_QUERY_FROM_DB;

			}



}