package KogunExcel.apachePOI.utils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-10-12 11:37:53 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.dom4j.*;
// --- <<IS-END-IMPORTS>> ---

public final class base

{
	// ---( internal utility methods )---

	final static base _instance = new base();

	static base _newInstance() { return new base(); }

	static base _cast(Object o) { return (base)o; }

	// ---( server methods )---




	public static final void ReadXLS (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ReadXLS)>> ---
		// @sigtype java 3.5
		try {
		     
		    FileInputStream file = new FileInputStream(new File("E:\\webmethods8\\IntegrationServer\\packages\\KogunExcel\\test\\test.xls"));
		     
		    //Get the workbook instance for XLS file 
		    HSSFWorkbook workbook = new HSSFWorkbook(file);
		 
		    //Get first sheet from the workbook
		    HSSFSheet sheet = workbook.getSheetAt(0);
		     
		    //Iterate through each rows from first sheet
		    Iterator<Row> rowIterator = sheet.iterator();
		    while(rowIterator.hasNext()) {
		        Row row = rowIterator.next();
		         
		        //For each row, iterate through each columns
		        Iterator<Cell> cellIterator = row.cellIterator();
		        while(cellIterator.hasNext()) {
		             
		            Cell cell = cellIterator.next();
		             
		            switch(cell.getCellType()) {
		                case Cell.CELL_TYPE_BOOLEAN:
		                    System.out.print(cell.getBooleanCellValue() + "\t\t");
		                    break;
		                case Cell.CELL_TYPE_NUMERIC:
		                    System.out.print(cell.getNumericCellValue() + "\t\t");
		                    break;
		                case Cell.CELL_TYPE_STRING:
		                    System.out.print(cell.getStringCellValue() + "\t\t");
		                    break;
		            }
		        }
		        System.out.println("");
		    }
		    file.close();
		    FileOutputStream out = 
		        new FileOutputStream(new File("E:\\webmethods8\\IntegrationServer\\packages\\KogunExcel\\test\\test2.xls"));
		    workbook.write(out);
		    out.close();
		     
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
			
		// --- <<IS-END>> ---

                
	}



	public static final void ReadXLSX (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ReadXLSX)>> ---
		// @sigtype java 3.5
		// [i] field:0:required FileName
		// [i] field:0:required FileDest
		try 
		{
			FileInputStream file = new FileInputStream(new File("E:\\webmethods8\\IntegrationServer\\packages\\KogunExcel\\test\\test.xlsx"));
		
			//Get the workbook instance for XLS file 
			XSSFWorkbook workbook = new XSSFWorkbook (file);
			 
			//Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			 
			//Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) 
			{
			    Row row = rowIterator.next();
			 
				//Get iterator to all cells of current row
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
			         
			        switch(cell.getCellType()) 
			        {
			            case Cell.CELL_TYPE_BOOLEAN:
			                System.out.print(cell.getBooleanCellValue() + "\t\t");
			                break;
			            case Cell.CELL_TYPE_NUMERIC:
			                System.out.print(cell.getNumericCellValue() + "\t\t");
			                break;
			            case Cell.CELL_TYPE_STRING:
			                System.out.print(cell.getStringCellValue() + "\t\t");
			                break;
			        }
				}
				System.out.println(" ");
			}
			   file.close();
			FileOutputStream out = 
			new FileOutputStream(new File("E:\\webmethods8\\IntegrationServer\\packages\\KogunExcel\\test\\test.xlsx"));
			workbook.write(out);
			out.close();	
			}
			catch (FileNotFoundException e) {
			    e.printStackTrace();
			} catch (IOException e) {
			    e.printStackTrace();
			}
		// --- <<IS-END>> ---

                
	}
}

