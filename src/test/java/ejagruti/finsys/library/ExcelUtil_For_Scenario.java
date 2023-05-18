package ejagruti.finsys.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil_For_Scenario
{
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static int columnIndexForTestCase;
	private static int rowIndexForTestCase;
	private static int columnIndexForTestCaseID;
	private static int rowIndexForTestCaseID;
	private static int columnIndexForQuery;
	private static int rowIndexForQuery;
	private static String SQL_QUERY;
		
	
	
	
	public static void setExcelFile(String Path, String Sheet_For_Scenario) throws IOException {

		try {
		File src = new File(Path);
		FileInputStream ExcelFile = new FileInputStream(src);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(Sheet_For_Scenario);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File unable to load"+ e.getLocalizedMessage());
		}
	}
}