package ejagruti.finsys.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil
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
	
	
	
	public static void setExcelFile(String Path, String Sheet_For_Query) throws Exception 
	{
	
		try
		{
			File src = new File(Path);
			FileInputStream ExcelFile = new FileInputStream(src);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(Sheet_For_Query);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File unable to load"+ e.getLocalizedMessage());
			e.printStackTrace();
		}
	
	}
	
	public static String SearchQuery_From_Excel(String TestCase_ID, String Query)
	{
		int i = 0;
		Row row = ExcelWSheet.getRow(i);
		breakloop:
		for(int j=0 ; j < row.getLastCellNum() ; j++)
		{
			try {
				Cell cell1 = row.getCell(j);
				cell1.setCellType(Cell.CELL_TYPE_STRING);
				if(cell1.getStringCellValue().equals("Test_Case_No"))
				{
					columnIndexForTestCase = cell1.getColumnIndex();
					rowIndexForTestCase = cell1.getRowIndex();
					break breakloop;
				}
			}
			catch(Exception e)
			{
				
			}
		}			
		
		int k = columnIndexForTestCase;
		
		testIDloop:
		for(int r=1; r <= ExcelWSheet.getLastRowNum() ; r++)
		{
			try {
				Row rowTestCaseID = ExcelWSheet.getRow(r);
				Cell cellTestCaseID = rowTestCaseID.getCell(k);
				cellTestCaseID.setCellType(Cell.CELL_TYPE_STRING);
				if (cellTestCaseID.getStringCellValue().equals(TestCase_ID))
				{
					columnIndexForTestCaseID = cellTestCaseID.getColumnIndex();
					rowIndexForTestCaseID = cellTestCaseID.getRowIndex();
					break testIDloop;
				}
			
			}
			catch(Exception ex)
			{
			}
		}
		
		int m = 0;
		Row rowOfQuery = ExcelWSheet.getRow(m);
		Queryloop :
		
		for(int j=0; j < rowOfQuery.getLastCellNum() ; j++)
		{
			try {
				Cell cell1 = rowOfQuery.getCell(j);
				cell1.setCellType(Cell.CELL_TYPE_STRING);
				if( cell1.getStringCellValue().equals(Query))
				columnIndexForQuery = cell1.getColumnIndex();
				rowIndexForQuery = cell1.getRowIndex();
				break Queryloop;
			}
			catch(Exception ex)
			{
			}
		}
		
		Row rowofSQLQuery  = ExcelWSheet.getRow(rowIndexForTestCaseID);
		DataFormatter formatter = new DataFormatter();
		Cell cell_query = rowofSQLQuery.getCell(columnIndexForQuery);
		return SQL_QUERY = formatter.formatCellValue(cell_query);
		
	}
	
}


