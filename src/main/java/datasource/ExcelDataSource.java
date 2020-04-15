package datasource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

/*
Author: Sumit Kumar
This public class provides function that perform dataload via various sources like excel , jdbc etc and return recordset, it contains overloaded
methods to accommodate multiple datasource
*/

//Below function takes a excel path , sheet name and returns a record set.Leverage Fillo API 
public class ExcelDataSource {
	public Recordset readexcelasquery(String excelfilepath, String sheetname) 
	{
		System.out.println("**********************INSIDE FUNCTION - readexcelasquery *******************");	
		System.out.println("Excel file path is : "+excelfilepath);
		System.out.println("Excel Sheet name is : "+sheetname);
		Fillo fillo=new Fillo();
		Connection connection = null;
		try {
			connection = fillo.getConnection(excelfilepath);
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strQuery="Select * from "+ sheetname;
		Recordset recordset = null;
		try {
			recordset = connection.executeQuery(strQuery);
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		connection.close();
		return recordset;
	}

//Below function takes a excel path , sheet name and returns a record set.Leverage Fillo POI
	public XSSFSheet readexcelasrow(String excelfilepath, String sheetname) 
	{
		System.out.println("**********************INSIDE FUNCTION - readexcelasrow *******************");
		System.out.println("Excel file path is : "+excelfilepath);
		System.out.println("Excel Sheet name is : "+sheetname);
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File(excelfilepath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//XSSFSheet  sheet = wb.getSheetAt(0);
		XSSFSheet  sheet = wb.getSheet(sheetname);
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheet;
	}

//Below function takes a excel path , sheet index and returns a record set. Leverage POI
	public XSSFSheet readexcelasrow(String excelfilepath, int sheetindex) 
	{
		System.out.println("**********************INSIDE FUNCTION - readexcelasrow *******************");
		System.out.println("Excel file path is : "+excelfilepath);
		System.out.println("Excel Sheet index is : "+sheetindex);
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File(excelfilepath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet  sheet = wb.getSheetAt(sheetindex);
		//XSSFSheet  sheet = wb.getSheet(sheetname);
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheet;
	}
}
