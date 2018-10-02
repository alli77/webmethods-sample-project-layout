package KogunExcel.apachePOI.utils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-01-03 11:02:45 GMT
// -----( ON-HOST: WM8DEV5.skyrr.local

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import org.apache.poi.ss.examples.ToCSV;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.*;
import org.apache.poi.openxml4j.exceptions.*;
// --- <<IS-END-IMPORTS>> ---

public final class read

	implements FilenameFilter

{
	// ---( internal utility methods )---

	final static read _instance = new read();

	static read _newInstance() { return new read(); }

	static read _cast(Object o) { return (read)o; }

	// ---( server methods )---




	public static final void XLSXtoCSV (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(XLSXtoCSV)>> ---
		// @sigtype java 3.5
		// [i] field:0:required Source
		// [i] field:0:required Destination
		// [i] field:0:required Separation
		// [i] field:0:required Format
		// [o] field:0:required stringTest
		// [o] field:0:required CSVstringTest
		/*
		 * 	PIPELINE IN
		 */
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	Source = IDataUtil.getString( pipelineCursor, "Source" );
			String	Destination = IDataUtil.getString( pipelineCursor, "Destination" );
			String	Separation = IDataUtil.getString( pipelineCursor, "Separation" );
			String	Format = IDataUtil.getString( pipelineCursor, "Format" );
		pipelineCursor.destroy();
		
		int formattingConvention = 0;
		
		if(Format == null)
		{
			formattingConvention = 0;
		}
		else
		{
			formattingConvention = Integer.parseInt(Format);
		}
		
		if(Separation == null)
		{
			Separation = ";";
		}
			
		
		ToCSV converter = null;
		try
		{
			converter = new ToCSV();
			if(Source != null && Destination != null) 
			{
				converter.convertExcelToCSV(Source, Destination, Separation, formattingConvention);
			}
		}
		catch(Exception ex) 
		{
		    System.out.println("Caught an: " + ex.getClass().getName());
		    System.out.println("Message: " + ex.getMessage());
		    System.out.println("Stacktrace follows:.....");
		    ex.printStackTrace(System.out);
		}
		
		
		/*
		 *	PIPELINE OUT
		 */
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "stringTest", "stringTest" );
		IDataUtil.put( pipelineCursor_1, "CSVstringTest", "CSVstringTest" );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void XLSXtoCSV_backup (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(XLSXtoCSV_backup)>> ---
		// @sigtype java 3.5
		// [i] field:0:required Source
		// [i] field:0:required Destination
		// [i] field:0:required Separation
		// [i] field:0:required Format
		// [o] field:0:required stringTest
		// [o] field:0:required CSVstringTest
		/*
		 * 	PIPELINE IN
		 */
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	Source = IDataUtil.getString( pipelineCursor, "Source" );
			String	Destination = IDataUtil.getString( pipelineCursor, "Destination" );
			String	Separation = IDataUtil.getString( pipelineCursor, "Separation" );
			String	Format = IDataUtil.getString( pipelineCursor, "Format" );
		pipelineCursor.destroy();
		
		//BarryWhite
		int formattingConvention = 0;
		
		if(Format == null)
		{
			formattingConvention = 0;
		}
		else
		{
			formattingConvention = Integer.parseInt(Format);
		}
		
		if(Separation == null)
		{
			Separation = ";";
		}
		
		
		ToCSV converter = null;
		try
		{
			converter = new ToCSV();
			if(Source != null && Destination != null) 
			{
				converter.convertExcelToCSV(Source, Destination, Separation, formattingConvention);
			}
		}
		catch(Exception ex) 
		{
		    System.out.println("Caught an: " + ex.getClass().getName());
		    System.out.println("Message: " + ex.getMessage());
		    System.out.println("Stacktrace follows:.....");
		    ex.printStackTrace(System.out);
		}
		
		
		/*
		 *	PIPELINE OUT
		 */
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "stringTest", "stringTest" );
		IDataUtil.put( pipelineCursor_1, "CSVstringTest", "CSVstringTest" );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void XLSXtoDocument (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(XLSXtoDocument)>> ---
		// @sigtype java 3.5
		// [i] field:0:required PathToExcelFile
		// [i] field:0:required Sheet
		// [i] field:0:required SkipStartEmptyRows
		// [i] field:0:required NumberOfCells
		// [o] recref:1:required ExcelSheets KogunExcel.rec:ExcelSheet
		IDataCursor pipelineCursor = pipeline.getCursor();
		String file_name = IDataUtil.getString(pipelineCursor,"PathToExcelFile");
		String sheet_name = IDataUtil.getString(pipelineCursor,"Sheet");
		String s = IDataUtil.getString(pipelineCursor,"SkipStartEmptyRows");
		String numberOfCells = IDataUtil.getString(pipelineCursor,"NumberOfCells");
		boolean SkipStartEmptyRows = s!=null && s.equals("true");
		IData sheets[] = null;
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(new FileInputStream(file_name)));
			int sheet_count = wb.getNumberOfSheets();
			sheets = new IData[sheet_count];
		        //Loop over all sheets
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
					IDataUtil.put(cursor,"ExcelFile",file_name);
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
	public static class ToCSV {
	
	    private Workbook workbook = null;
	    private ArrayList<ArrayList> csvData = null;
	    private int maxRowWidth = 0;
	    private int formattingConvention = 0;
	    private DataFormatter formatter = null;
	    private FormulaEvaluator evaluator = null;
	    private String separator = null;
	
	    private static final String CSV_FILE_EXTENSION = ".csv";
	    private static final String DEFAULT_SEPARATOR = ",";
	
	    public static final int EXCEL_STYLE_ESCAPING = 0;
	
	    public static final int UNIX_STYLE_ESCAPING = 1;
	
	    public void convertExcelToCSV(String strSource, String strDestination) throws FileNotFoundException, IOException, IllegalArgumentException, InvalidFormatException 
	    {
	        this.convertExcelToCSV(strSource, strDestination,
	                ToCSV.DEFAULT_SEPARATOR, ToCSV.EXCEL_STYLE_ESCAPING);
	    }
		
		public void convertExcelToCSV(String strSource, String strDestination, String separator) throws FileNotFoundException, IOException, IllegalArgumentException, InvalidFormatException 
		{
			this.convertExcelToCSV(strSource, strDestination,
			separator, ToCSV.EXCEL_STYLE_ESCAPING);
		}
		
		public void convertExcelToCSV(String strSource, String strDestination, String separator, int formattingConvention) throws FileNotFoundException, IOException, IllegalArgumentException, InvalidFormatException 
		{
		    File source = new File(strSource);
		    File destination = new File(strDestination);
		    File[] filesList = null;
		    String destinationFilename = null;
		
		    if(!source.exists()) {
		        throw new IllegalArgumentException("The source for the Excel file(s) cannot be found.");
		    }
		
		    if(!destination.exists()) {
		        throw new IllegalArgumentException("The folder/directory for the converted CSV file(s) does not exist.");
		    }
		    if(!destination.isDirectory()) {
		        throw new IllegalArgumentException("The destination for the CSV file(s) is not a directory/folder.");
		    }
		
		    if(formattingConvention != ToCSV.EXCEL_STYLE_ESCAPING && formattingConvention != ToCSV.UNIX_STYLE_ESCAPING) 
			{
		        throw new IllegalArgumentException("The value passed to the formattingConvention parameter is out of range.");
		    }
		
		    this.separator = separator;
		    this.formattingConvention = formattingConvention;
		
		    if(source.isDirectory()) 
			{
		        filesList = source.listFiles(new ExcelFileNameFilter());
		    }
		    else 
			{
		        filesList = new File[]{source};
		    }
		
		    for(File excelFile : filesList) 
			{
		        this.openWorkbook(excelFile);
		        this.convertToCSV();
		        destinationFilename = excelFile.getName();
		        destinationFilename = destinationFilename.substring(
		                0, destinationFilename.lastIndexOf(".")) +
		                ToCSV.CSV_FILE_EXTENSION;
		        this.saveCSVFile(new File(destination, destinationFilename));
		    }
		}
		
		private void openWorkbook(File file) throws FileNotFoundException, IOException, InvalidFormatException 
		{
		    FileInputStream fis = null;
		    try 
			{
		        System.out.println("Opening workbook [" + file.getName() + "]");
		        fis = new FileInputStream(file);
		        this.workbook = WorkbookFactory.create(fis);
		        this.evaluator = this.workbook.getCreationHelper().createFormulaEvaluator();
		        this.formatter = new DataFormatter(true);
		    }
		    finally 
			{
		        if(fis != null) 
				{
		            fis.close();
		        }
		    }
		}
		
		private void convertToCSV() 
		{
		    Sheet sheet = null;
		    Row row = null;
		    int lastRowNum = 0;
		    this.csvData = new ArrayList<ArrayList>();
		
		    System.out.println("Converting files contents to CSV format.");
		
		    int numSheets = this.workbook.getNumberOfSheets();
		
		    for(int i = 0; i < numSheets; i++) 
		    {
		
		        sheet = this.workbook.getSheetAt(i);
		        if(sheet.getPhysicalNumberOfRows() > 0) 
		        {
		
		            lastRowNum = sheet.getLastRowNum();
		            for(int j = 0; j <= lastRowNum; j++) 
		            {
		                row = sheet.getRow(j);
		                this.rowToCSV(row);
		            }
		        }
		    }
		}
		
		private void saveCSVFile(File file) throws FileNotFoundException, IOException 
		{
		    FileWriter fw = null;
		    BufferedWriter bw = null;
		    ArrayList<String> line = null;
		    StringBuffer buffer = null;
		    String csvLineElement = null;
		    try {
		
		        System.out.println("Saving the CSV file [" + file.getName() + "]");
		        fw = new FileWriter(file);
		        bw = new BufferedWriter(fw);
		
		        for(int i = 0; i < this.csvData.size(); i++) 
				{
		            buffer = new StringBuffer();
		
		            line = this.csvData.get(i);
		            for(int j = 0; j < this.maxRowWidth; j++) 
					{
		                if(line.size() > j) {
		                    csvLineElement = line.get(j);
		                    if(csvLineElement != null) 
							{
		                        buffer.append(this.escapeEmbeddedCharacters(
		                                csvLineElement));
		                    }
		                }
		                if(j < (this.maxRowWidth - 1)) 
						{
		                    buffer.append(this.separator);
		                }
		            }
		
		            bw.write(buffer.toString().trim());
		
		            if(i < (this.csvData.size() - 1)) {
		                bw.newLine();
		            }
		        }
		    }
		    finally {
		        if(bw != null) 
				{
		            bw.flush();
		            bw.close();
		        }
		    }
		}
		
		private void rowToCSV(Row row) 
		{
		    Cell cell = null;
		    int lastCellNum = 0;
		    ArrayList<String> csvLine = new ArrayList<String>();
		
		    if(row != null) {
		
		        lastCellNum = row.getLastCellNum();
		        for(int i = 0; i <= lastCellNum; i++) 
				{
		            cell = row.getCell(i);
		            if(cell == null) {
		                csvLine.add("");
		            }
		            else {
		                if(cell.getCellType() != Cell.CELL_TYPE_FORMULA) 
						{
		                    csvLine.add(this.formatter.formatCellValue(cell));
		                }
		                else 
						{
		                    csvLine.add(this.formatter.formatCellValue(cell, this.evaluator));
		                }
		            }
		        }
		        if(lastCellNum > this.maxRowWidth) {
		            this.maxRowWidth = lastCellNum;
		        }
		    }
		    this.csvData.add(csvLine);
		}
		
		
		private String escapeEmbeddedCharacters(String field) 
		{
		    StringBuffer buffer = null;
		
		    if(this.formattingConvention == ToCSV.EXCEL_STYLE_ESCAPING) 
			{
		
		        if(field.contains("\"")) 
				{
		            buffer = new StringBuffer(field.replaceAll("\"", "\\\"\\\""));
		            buffer.insert(0, "\"");
		            buffer.append("\"");
		        }
		        else 
				{
		            buffer = new StringBuffer(field);
		            if((buffer.indexOf(this.separator)) > -1 ||
		                     (buffer.indexOf("\n")) > -1) 
					{
		                buffer.insert(0, "\"");
		                buffer.append("\"");
		            }
		        }
		        return(buffer.toString().trim());
		    }
		    else 
			{
		        if(field.contains(this.separator)) 
				{
		            field = field.replaceAll(this.separator, ("\\\\" + this.separator));
		        }
		        if(field.contains("\n")) {
		            field = field.replaceAll("\n", "\\\\\n");
		        }
		        return(field);
		    }
		}
		
	
	
		
	}
	
	/**
	 * An instance of this class can be used to control the files returned
	 * be a call to the listFiles() method when made on an instance of the
	 * File class and that object refers to a folder/directory
	 */
	public static class ExcelFileNameFilter implements FilenameFilter {
		public boolean accept(File file, String name)
		{
			return(name.endsWith(".xls") || name.endsWith(".xlsx"));
		}
	}
	
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

