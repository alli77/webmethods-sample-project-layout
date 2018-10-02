package KogunExcel;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2013-12-16 10:32:04 GMT
// -----( ON-HOST: WM8DEV5.skyrr.local

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// --- <<IS-END-IMPORTS>> ---

public final class inputStream

{
	// ---( internal utility methods )---

	final static inputStream _instance = new inputStream();

	static inputStream _newInstance() { return new inputStream(); }

	static inputStream _cast(Object o) { return (inputStream)o; }

	// ---( server methods )---




	public static final void inputStreamToDocument (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(inputStreamToDocument)>> ---
		// @sigtype java 3.5
		// [i] object:0:required InStream
		// [i] field:0:required Sheet
		// [i] field:0:required SkipStartEmptyRows
		// [i] field:0:required NumberOfCells
		// [o] recref:1:required ExcelSheets KogunExcel.rec:ExcelSheet
		IDataCursor pipelineCursor = pipeline.getCursor();
		String sheet_name = IDataUtil.getString(pipelineCursor,"Sheet");
		String s = IDataUtil.getString(pipelineCursor,"SkipStartEmptyRows");
		String numberOfCells = IDataUtil.getString(pipelineCursor,"NumberOfCells");
		boolean SkipStartEmptyRows = s!=null && s.equals("true");
		IData sheets[] = null;
		try
		{
			InputStream	InStream = (InputStream)IDataUtil.get( pipelineCursor, "InStream" );
			XSSFWorkbook wb = new XSSFWorkbook(InStream);
		
			int sheet_count = wb.getNumberOfSheets();
			
			sheets = new IData[sheet_count];
			for (int i=0;i<sheet_count;i++)
			{
				String name = wb.getSheetName(i);
		                //Check if we only want one specific sheet by name
				if (sheet_name!=null && name!=null && !sheet_name.equalsIgnoreCase(name+"$"))
				{
					continue;					
				}
				XSSFSheet sheet = wb.getSheetAt(i);
				if (sheet!=null)
				{
					sheets[i] = IDataFactory.create();
					IDataCursor cursor = sheets[i].getCursor();
					IDataUtil.put(cursor,"ExcelFile",InStream);
					IData isheet = IDataFactory.create();
					IDataUtil.put(cursor,"ExcelSheet",isheet);
					IDataCursor sheet_cursor = isheet.getCursor();
					int row_count = sheet.getPhysicalNumberOfRows();
		                        List rows = new ArrayList(row_count);
		                        //Loop over all rows in sheet
		                        boolean empty_row = true;
					for (int j=0;j<row_count;j++)
					{
						IData irow = IDataFactory.create();
						cursor = irow.getCursor();
						XSSFRow row = sheet.getRow(j);
		                                boolean has_value = false;
						if (row!=null)
						{
							int cell_count;
							if(numberOfCells != null)
							{
								cell_count = Integer.parseInt(numberOfCells);;
							}
							else
							{
								cell_count = row.getPhysicalNumberOfCells();
							}
		                                        //Loop over all cells
							for (int k=0;k<cell_count;k++)
							{
								String value = "";
								XSSFCell cell = row.getCell((short)k);
								if (cell!=null)
								{
									value = getCellString(cell);
								}
		                        if (!value.equals(""))
		                        {
		                           empty_row = false;
		                        }
								IDataUtil.put(cursor,"ExcelColumn_"+(k+1),value);
							}
						}
		                    //Should we skip this row?
		                    if (SkipStartEmptyRows && empty_row)
		                    {
		                       continue;
		                    }
		                    rows.add(irow);
					}
		        IDataUtil.put(sheet_cursor,"ExcelRow",rows.toArray(new IData[0]));
				}
			}
		}
		catch (Exception e)
		{
			throw new ServiceException(e);
		}
		IDataUtil.put(pipelineCursor,"ExcelSheets",sheets);
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static String getCellString(XSSFCell cell) throws Exception
	{
	String value = "";
	int type = cell.getCellType();
	switch (type) 
	{
	  case XSSFCell.CELL_TYPE_STRING:
		value = cell.getStringCellValue();
		break;
	  case XSSFCell.CELL_TYPE_NUMERIC:
		double icl = cell.getNumericCellValue();
		if (isCellDateFormatted(cell))
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(getJavaDate(icl,false));
			String pattern = "d.M.yyyy";
			int year = cal.get(Calendar.YEAR);
			if (year<1900) // Year is before 1900, must be time only value
			{
				pattern = "HH:mm:ss";
			} 
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			value = df.format(cal.getTime());
		}
		else
		{
			value = Double.toString(icl);
		}
		break;
	} // END SWITCH
	return value;
	}
	
	private static boolean isCellDateFormatted(XSSFCell cell) 
	{
	boolean bDate = false;
	
	double d = cell.getNumericCellValue();
	if ( isValidExcelDate(d) ) {
	  XSSFCellStyle style = cell.getCellStyle();
	  int i = style.getDataFormat();
	  switch(i) {
	// Internal Date Formats as described on page 427 in Microsoft Excel Dev's Kit...
	    case 0x0e:
	    case 0x0f:
	    case 0x10:
	    case 0x11:
	    case 0x12:
	    case 0x13:
	    case 0x14:
	    case 0x15:
	    case 0x16:
	    case 0x2d:
	    case 0x2e:
	    case 0x2f:
	     bDate = true;
	    break;
	
	    default:
	     bDate = false;
	    break;
	  }
	}
	return bDate;
	  }
	
	private static Date getJavaDate(double date, boolean use1904windowing) {
	if (isValidExcelDate(date)) {
	    int startYear = 1900;
	    int dayAdjust = -1; // Excel thinks 2/29/1900 is a valid date, which it isn't
	    int wholeDays = (int)Math.floor(date);
	    if (use1904windowing) {
	        startYear = 1904;
	        dayAdjust = 1; // 1904 date windowing uses 1/2/1904 as the first day
	    }
	    else if (wholeDays < 61) {
	        // Date is prior to 3/1/1900, so adjust because Excel thinks 2/29/1900 exists
	        // If Excel date == 2/29/1900, will become 3/1/1900 in Java representation
	        dayAdjust = 0;
	    }
	    GregorianCalendar calendar = new GregorianCalendar(startYear,0, wholeDays + dayAdjust);
	    int millisecondsInDay = (int)((date - Math.floor(date)) * ((24 * 60 * 60 * 1000) + 0.5));
	    calendar.set(GregorianCalendar.MILLISECOND, millisecondsInDay);
	    return calendar.getTime();
	}
	else {
	    return null;
	}
	}
	
	private static boolean isValidExcelDate(double value)
	{
	return (value > -Double.MIN_VALUE);
	}
	// --- <<IS-END-SHARED>> ---
}

