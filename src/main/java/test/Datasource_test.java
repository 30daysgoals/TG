package test;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import datasource.ExcelDataSource;

public class Datasource_test {
	/*
	Test class to test functions of ExcelDataSource class.  
	*/

	public static void main(String[] args) throws FilloException, Exception {
		// TODO Auto-generated method stub
		

		ExcelDataSource exobj=new ExcelDataSource();
//*************************************************** TEST EXCEL AS ROW , ITERATE OVER EACH CELL*********************************
		Recordset rs=exobj.readexcelasquery("./resources_test/excel_files/test.xlsx", "test");
		System.out.println("========================TEST EXCEL AS QUERY - START=========================");  
		while(rs.next()){
			System.out.println(rs.getField("TestCaseId"));
			}
		System.out.println("========================TEST EXCEL AS QUERY - END==========================="); 
		
		
//*************************************************** TEST EXCEL AS ROW , ITERATE OVER EACH CELL*********************************
		XSSFSheet sheet=exobj.readexcelasrow("./resources_test/excel_files/test.xlsx", "test");
		System.out.println("========================TEST EXCEL AS ROW - START==========================="); 
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum(); 
	    for (int i = 0; i < rowCount+1; i++) {
	    	System.out.println("--------------------------------------------------------------------------"); 
	        Row row = sheet.getRow(i);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	        	if(row.getCell(j)!=null)
	        	{
	            switch(row.getCell(j).getCellType())  
	            {  
	            case NUMERIC:   //field that represents numeric cell type  
	            //getting the value of the cell as a number  
	            System.out.println(row.getCell(j).getNumericCellValue()+ "\t\t");   
	            break;  
	            case STRING:    //field that represents string cell type  
	            //getting the value of the cell as a string  
	            System.out.println(row.getCell(j).getStringCellValue()+ "\t\t");  
	            break;
	            case BLANK:    //field that represents string cell type  
		            //getting the value of the cell as a string  
		            System.out.println(row.getCell(j).getStringCellValue()+ "\t\t");  
		            break;
				default:
					break;
	            }  
	        	}
	        	}
	        }
	    System.out.println("========================TEST EXCEL AS ROW - START==========================");
//************************************************ TEST EXCEL AS ROW , ITERATE OVER EACH CELL - END*********************************
	    } 
	}

