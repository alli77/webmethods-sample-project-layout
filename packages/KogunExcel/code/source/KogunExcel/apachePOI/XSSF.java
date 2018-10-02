package KogunExcel.apachePOI;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-11-14 13:06:26 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// --- <<IS-END-IMPORTS>> ---

public final class XSSF

{
	// ---( internal utility methods )---

	final static XSSF _instance = new XSSF();

	static XSSF _newInstance() { return new XSSF(); }

	static XSSF _cast(Object o) { return (XSSF)o; }

	// ---( server methods )---




	public static final void addCellToRow (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addCellToRow)>> ---
		// @sigtype java 3.5
		// [i] field:0:required FullFileName
		// [i] field:0:required SheetName
		// [i] field:0:required RowNumber
		// [i] field:0:required CellData
		// [o] field:0:required Status
		/*
		 * Pipeline In
		 */
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	FullFileName = IDataUtil.getString( pipelineCursor, "FullFileName" );
			String	SheetName = IDataUtil.getString( pipelineCursor, "SheetName" );
			String	RowNumber = IDataUtil.getString( pipelineCursor, "RowNumber" );
			String	CellData = IDataUtil.getString( pipelineCursor, "CellData" );
		pipelineCursor.destroy();
		
		/*
		 * Code
		 */
		
		String Status;
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(new FileInputStream(FullFileName)));
			Sheet sheet = wb.getSheet(SheetName);
			int foo = Integer.parseInt(RowNumber);
			Row row = sheet.getRow(foo);
			short cellShort = row.getLastCellNum();
			int cellInt = cellShort;
			
			if(CellData == null)
			{ 
				Cell cell;
				if(cellInt == 0)
					cell = row.createCell(cellInt+1); 
				else
					cell = row.createCell(cellInt);
				cell.setCellValue("");
			}
			else
			{	
				
				Cell cell;
				if(cellInt < 0)
					cell = row.createCell(cellInt+1); 
				else
					cell = row.createCell(cellInt);
				cell.setCellValue(CellData);
			}
			
			FileOutputStream fileOut = new FileOutputStream(FullFileName);
			wb.write(fileOut);
			fileOut.close();
			
			Status = "Suceeded In Adding A Cell To The Row";
			
		}
		catch(Exception e)
		{
			Status = "Failed In Adding A Cell To The Row";
			//throw new ServiceException(e);
		}
		/*
		 * Pipeline Out
		 */
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "Status", Status );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void addRowToSheet (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addRowToSheet)>> ---
		// @sigtype java 3.5
		// [i] field:0:required FullFileName
		// [i] field:0:required SheetName
		// [o] field:0:required Status
		// [o] field:0:required RowNumber
		/*
		 *  Pipeline In
		 */
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	FullFileName = IDataUtil.getString( pipelineCursor, "FullFileName" );
			String	SheetName = IDataUtil.getString( pipelineCursor, "SheetName" );
		pipelineCursor.destroy();
		/*
		 *  Code
		 */
		
		String Status, RowNumber;
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(new FileInputStream(FullFileName)));
			Sheet sheet = wb.getSheet(SheetName);
			int fjoldi = sheet.getLastRowNum();
			int fjoldi1 = fjoldi+1;
			Row row = sheet.createRow(fjoldi+1);
			RowNumber = Integer.toString(fjoldi1);
			
			FileOutputStream fileOut = new FileOutputStream(FullFileName);
			wb.write(fileOut);
			fileOut.close();
			
			Status = "Suceeded In Adding A Row To The Sheet";
		}
		catch(Exception e)
		{
			Status = "Failed In Adding A Row To The Sheet";
			throw new ServiceException(e);
		}
		
		/* 
		 *  Pipeline Out
		 */
		
		IDataCursor pipelineCursor_2 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_2, "Status", Status );
		IDataUtil.put( pipelineCursor_2, "RowNumber", RowNumber );
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void addSheet (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addSheet)>> ---
		// @sigtype java 3.5
		// [i] field:0:required FullFileName
		// [i] field:0:required NewSheetName
		// [o] field:0:required Status
		/*
		 * Pipeline In
		 */
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	FullFileName = IDataUtil.getString( pipelineCursor, "FullFileName" );
			String	NewSheetName = IDataUtil.getString( pipelineCursor, "NewSheetName" );
		pipelineCursor.destroy();
		
		/*
		 * Code
		 */
		String Status;
		try
		{
			XSSFWorkbook  wb = new XSSFWorkbook (new BufferedInputStream(new FileInputStream(FullFileName)));
			int sheet_count = wb.getNumberOfSheets();
			Sheet sheet = wb.createSheet(NewSheetName);
			
			FileOutputStream fileOut = new FileOutputStream(FullFileName);
			wb.write(fileOut);
			fileOut.close();
			
			Status = "Succeeded In Adding A Sheet";
		}
		catch(Exception e)
		{
			Status = "Failed In Adding A Sheet";
			throw new ServiceException(e);
		}
		
		/*
		 * Pipeline Out
		 */
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "Status", Status );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void addSpecificCell (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addSpecificCell)>> ---
		// @sigtype java 3.5
		// [i] field:0:required FullFileName
		// [i] field:0:required SheetName
		// [i] field:0:required RowNumber
		// [i] field:0:required CellIndex
		// [i] field:0:required CellData
		// [i] field:0:required FontType {"Arial","Calibri","Calibri Light","SimSun","Times New Roman"}
		// [i] field:0:required FontSize
		// [o] field:0:required Status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	FullFileName = IDataUtil.getString( pipelineCursor, "FullFileName" );
			String	SheetName = IDataUtil.getString( pipelineCursor, "SheetName" );
			String	RowNumber = IDataUtil.getString( pipelineCursor, "RowNumber" );
			String	CellIndex = IDataUtil.getString( pipelineCursor, "CellIndex" );
			String	CellData = IDataUtil.getString( pipelineCursor, "CellData" );
			
			String FontType = IDataUtil.getString( pipelineCursor, "FontType" );
			String FontSize = IDataUtil.getString( pipelineCursor, "FontSize" );
		pipelineCursor.destroy();
		
		/*
		 * Code
		 */
		String Status;
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(new FileInputStream(FullFileName)));
			Sheet sheet = wb.getSheet(SheetName);
			//cast row number
			int foo = Integer.parseInt(RowNumber);
			Row row = sheet.getRow(foo);
			//cast cell number
			int bar = Integer.parseInt(CellIndex);
			
			if(CellData == null)
			{
				Cell cell = row.createCell(bar); 
				cell.setCellValue("");
			}
			else
			{	
				Cell cell = row.createCell(bar); 
				cell.setCellValue(CellData);		
				CellStyle style = CreateStyle(wb, FontType, FontSize);
				cell.setCellStyle(style);
			}
			
			FileOutputStream fileOut = new FileOutputStream(FullFileName);
			wb.write(fileOut);
			fileOut.close();
			
			Status = "Suceeded In Adding A Cell To The Row";
			
			
		}
		catch(Exception e)
		{
			Status = "Failed In Adding A Cell To The Row";
			//throw new ServiceException(e);
		}
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "Status", Status );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void addSpecificRow (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addSpecificRow)>> ---
		// @sigtype java 3.5
		// [i] field:0:required FullFileName
		// [i] field:0:required SheetName
		// [i] field:0:required RowNumber
		// [o] field:0:required Status
		/*
		 *  Pipeline In
		 */
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	FullFileName = IDataUtil.getString( pipelineCursor, "FullFileName" );
			String	SheetName = IDataUtil.getString( pipelineCursor, "SheetName" );
			String  RowNumber = IDataUtil.getString( pipelineCursor, "RowNumber" );
		pipelineCursor.destroy();
		/*
		 *  Code
		 */
		
		String Status;
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(new FileInputStream(FullFileName)));
			Sheet sheet = wb.getSheet(SheetName);
			int foo = Integer.parseInt(RowNumber);
			Row row = sheet.createRow(foo);
			
			FileOutputStream fileOut = new FileOutputStream(FullFileName);
			wb.write(fileOut);
			fileOut.close();
		
			Status = "Suceeded In Adding A Row To The Sheet";
		}
		catch(Exception e)
		{
			Status = "Failed In Adding A Row To The Sheet";
			throw new ServiceException(e);
		}
		
		/* 
		 *  Pipeline Out
		 */
		IDataCursor pipelineCursor_2 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_2, "Status", Status );
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void adjustAllColumnsWidth (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(adjustAllColumnsWidth)>> ---
		// @sigtype java 3.5
		// [i] field:0:required FullFileName
		// [i] field:0:required SheetName
		// [o] field:0:required Status
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	FullFileName = IDataUtil.getString( pipelineCursor, "FullFileName" );
			String	NewSheetName = IDataUtil.getString( pipelineCursor, "SheetName" );
		pipelineCursor.destroy();
		
		String Status = "";
		
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(new FileInputStream(FullFileName)));
			Sheet sheet = wb.getSheet(NewSheetName);
			
			int rowEnd = sheet.getLastRowNum();
			Row row = sheet.getRow(rowEnd);
			
			int lastColumn = row.getLastCellNum();
			
			for(int i=0; i<10; i++) {
				sheet.autoSizeColumn(i);
			}
			
			FileOutputStream fileOut = new FileOutputStream(FullFileName);
			wb.write(fileOut);
			fileOut.close();
			
			Status = "Columns width adjusted";
		}
		catch(Exception e)
		{
			Status = "Column width adjustment failed";
			throw new ServiceException(e);
		}
		
		IDataCursor pipelineCursor_2 = pipeline.getCursor();
			IDataUtil.put( pipelineCursor_2, "Status", Status );
		pipelineCursor.destroy();			
		// --- <<IS-END>> ---

                
	}



	public static final void countDataInColumn (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(countDataInColumn)>> ---
		// @sigtype java 3.5
		// [i] field:0:required ExcelFileName
		// [i] field:0:required ExcelFileLocation
		// [i] field:0:required SheetName
		// [i] field:0:required ColumnIndex
		// [o] field:0:required FullFileName
		// [o] field:0:required Counter
		// [o] field:0:required Status
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	ExcelFileName = IDataUtil.getString( pipelineCursor, "ExcelFileName" );
			String	ExcelFileLocation = IDataUtil.getString( pipelineCursor, "ExcelFileLocation" );
			String	SheetName = IDataUtil.getString( pipelineCursor, "SheetName" );
			String	ColumnIndex = IDataUtil.getString( pipelineCursor, "ColumnIndex" );
		pipelineCursor.destroy();
		
		String Status = "";
		
		//Create FillFileName from file location and filename: C:\cleanup\ + lol.xlsx = C:\cleanup\lol.xlsx
		String FullFileName = ConcatFileLocationAndFileName(ExcelFileLocation, ExcelFileName);
		
		//If CellData is found, it is placed in this ArrayList.
		ArrayList<CellData>data = new ArrayList<CellData>();
		
		//		int counter = 0;
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(new FileInputStream(FullFileName)));
			data = GetAllDataInColumnIndex(wb, SheetName, Integer.parseInt(ColumnIndex)); 
		}
		catch(Exception e)
		{
			throw new ServiceException(e);
		}
		
		int counter = data.size();
				
		String Counter = Integer.toString(counter);
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "FullFileName", FullFileName);
		IDataUtil.put( pipelineCursor_1, "Counter", Counter);
		IDataUtil.put( pipelineCursor_1, "Status", Status);
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void createXLSX (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createXLSX)>> ---
		// @sigtype java 3.5
		// [i] field:0:required ExcelFileName
		// [i] field:0:required ExcelFileLocation
		// [i] field:0:optional FirstSheetName
		// [o] field:0:required Status
		// [o] field:0:required FullFileLocation
		/*
		 *  Pipeline In
		 */
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	ExcelFileName = IDataUtil.getString( pipelineCursor, "ExcelFileName" );
			String	ExcelFileLocation = IDataUtil.getString( pipelineCursor, "ExcelFileLocation" );
			String	FirstSheetName = IDataUtil.getString( pipelineCursor, "FirstSheetName" );
		pipelineCursor.destroy();
		
		/* 
		 *  Code 
		 */
		ExcelFileName = ExcelFileName.toLowerCase();
		int indexOfName = ExcelFileName.indexOf(".xlsx");
		//this should cover all mistakes that could be made regarding the file name
		if(indexOfName == -1) 
		{
			//see if user accidentally entered xls instead of xlsx
			indexOfName = ExcelFileName.indexOf(".xls");
			if(indexOfName == -1)
			{
				int length = ExcelFileName.length();
				if(length == 0)
				{
					ExcelFileName = "NewExcelFile.xlsx";
				}
				else
				{
					ExcelFileName = ExcelFileName+".xlsx";
				}	
			}
			else //we found .xls
			{
				ExcelFileName = ExcelFileName.substring(0, indexOfName);
				ExcelFileName = ExcelFileName+".xlsx";
			}
		}
		//finally create a string with name and location
		String FullFileName = ExcelFileLocation+ExcelFileName;
		String Status = "";
		
		if(FirstSheetName.length() == 0)
		{
			FirstSheetName="new_sheet";
		}
		
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook();
			//CreationHelper ch = wb.getCreationHelper();
			Sheet sheet = wb.createSheet(FirstSheetName);
			FileOutputStream fileOut = new FileOutputStream(FullFileName);
			wb.write(fileOut);
			fileOut.close();
			Status = "Succeeded In Creating File";
		}
		catch(Exception e)
		{
			Status = "Failed In Creating File";
			throw new ServiceException(e);
		}
		
		
		
		/*
		 *  Pipeline Out
		 */
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "Status", Status );
		IDataUtil.put( pipelineCursor_1, "FullFileLocation", FullFileName );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void findCellData (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(findCellData)>> ---
		// @sigtype java 3.5
		// [i] field:0:required ExcelFileName
		// [i] field:0:required ExcelFileLocation
		// [i] field:0:optional SheetName
		// [i] field:0:required CellData
		// [o] field:0:required FullFileName
		// [o] field:0:required Status
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	ExcelFileName = IDataUtil.getString( pipelineCursor, "ExcelFileName" );
			String	ExcelFileLocation = IDataUtil.getString( pipelineCursor, "ExcelFileLocation" );
			String	SheetName = IDataUtil.getString( pipelineCursor, "SheetName" );
			String	CellData = IDataUtil.getString( pipelineCursor, "CellData" );
		pipelineCursor.destroy();
		
		//Create FillFileName from file location and filename: C:\cleanup\ + lol.xlsx = C:\cleanup\lol.xlsx
		String FullFileName = ConcatFileLocationAndFileName(ExcelFileLocation, ExcelFileName);
		
		//If CellData is found, it is placed in this ArrayList.
		ArrayList<CellData>data = new ArrayList<CellData>();
		
		String Status = "\"" + CellData + "\"" + " was not found in " + ExcelFileName;
		if(SheetName != null && SheetName != "")
			Status += " - inside sheet " + SheetName;
		
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(new FileInputStream(FullFileName)));
			data = FindDataInFile(wb, SheetName, CellData);	
		}
		catch(Exception e)
		{
			throw new ServiceException(e);
		}
		
		IData[] DataList = new IData[data.size()];		
		for(int i=0;i<data.size();i++)
			DataList[i] = AddCellDataToIData(data.get(i));	
		
		if(data.size() > 0)
			Status = "\"" + CellData + "\"" + " was found in " + ExcelFileName;
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "FullFileName", FullFileName);
		IDataUtil.put( pipelineCursor_1, "Data", DataList);
		IDataUtil.put( pipelineCursor_1, "Status", Status);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getAllDataInColumnIndex (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getAllDataInColumnIndex)>> ---
		// @sigtype java 3.5
		// [i] field:0:required ExcelFileName
		// [i] field:0:required ExcelFileLocation
		// [i] field:0:required SheetName
		// [i] field:0:required ColumnIndex
		// [o] field:0:required FullFileName
		// [o] field:0:required Status
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	ExcelFileName = IDataUtil.getString( pipelineCursor, "ExcelFileName" );
			String	ExcelFileLocation = IDataUtil.getString( pipelineCursor, "ExcelFileLocation" );
			String	SheetName = IDataUtil.getString( pipelineCursor, "SheetName" );
			String	ColumnIndex = IDataUtil.getString( pipelineCursor, "ColumnIndex" );
		pipelineCursor.destroy();
		
		String Status = "";
		
		//Create FillFileName from file location and filename: C:\cleanup\ + lol.xlsx = C:\cleanup\lol.xlsx
		String FullFileName = ConcatFileLocationAndFileName(ExcelFileLocation, ExcelFileName);
		
		//If CellData is found, it is placed in this ArrayList.
		ArrayList<CellData>data = new ArrayList<CellData>();
		 
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(new FileInputStream(FullFileName)));
			data = GetAllDataInColumnIndex(wb, SheetName, Integer.parseInt(ColumnIndex)); 
		} 
		catch(Exception e)
		{
			throw new ServiceException(e);
		}
		
		IData[] DataList = new IData[data.size()];		
		for(int i=0;i<data.size();i++)
			DataList[i] = AddCellDataToIData(data.get(i));	
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "FullFileName", FullFileName);
		IDataUtil.put( pipelineCursor_1, "Data", DataList);
		IDataUtil.put( pipelineCursor_1, "Status", Status);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	static IData AddCellDataToIData(CellData cData) {
		IData   iData = IDataFactory.create();
		IDataCursor pipelineCursor_2 = iData.getCursor();
		IDataUtil.put( pipelineCursor_2, "RowNumber", Integer.toString(cData.getRowNumber()));		
		IDataUtil.put( pipelineCursor_2, "ColumnIndex", Integer.toString(cData.getColumnNumber()));
		IDataUtil.put( pipelineCursor_2, "SheetName", cData.getSheetName());
		IDataUtil.put( pipelineCursor_2, "CellData", cData.getCellData());
		
		pipelineCursor_2.destroy();
		return iData;
	}
		
	static public CellStyle CreateStyle(XSSFWorkbook wb, String fontType, String fontSize) {
		if(fontType == "" || fontType == null)
			fontType = "Calibri";
		
		if(fontSize == "" || fontSize == null)
			fontSize = "11";
		
		CellStyle style;
		
		Font font = wb.createFont();
		font.setFontName(fontType);
	
		int size = Integer.parseInt(fontSize);
		font.setFontHeightInPoints((short)size);
		
		style = wb.createCellStyle(); 
		style.setFont(font);
		
		return style;
	}
	
	static public String ConcatFileLocationAndFileName(String fileLocation, String fileName) {
		if(fileLocation.endsWith("\\"))
			return fileLocation + fileName;
		else
			return fileLocation + "\\" + fileName;
	}
	
	static ArrayList<CellData> GetAllDataInColumnIndex(XSSFWorkbook wb, String sheetName, int columnIndex) {
		ArrayList<CellData>data = new ArrayList<CellData>();		
		Sheet sheet;
		if(sheetName == "" || sheetName == null)
			sheet = wb.getSheetAt(0);
		else
			sheet = wb.getSheet(sheetName);
	
		int rowNum = 1;
		for (Row row : sheet) {
			Cell c = row.getCell(columnIndex);
			if(c != null) {
				String cellDataString = GetDataInCell(c);
				if(cellDataString != "") {
					CellData dCell = new CellData(rowNum, columnIndex, sheetName, cellDataString);
					data.add(dCell);						
				}
			}
			++rowNum;
		}
	    return data;
	}
		
	static String GetDataInCell(Cell cell) {
		switch(cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				return cell.getRichStringCellValue().getString();
			case Cell.CELL_TYPE_NUMERIC:
				double num = cell.getNumericCellValue();
				if(num%1 != 0)
					return String.valueOf(num);			
				int intNum = (int)num;
				return String.valueOf(intNum);
			//TODO
			//case Cell.CELL_TYPE_BOOLEAN:
			//case Cell.CELL_TYPE_FORMULA:
		}
		return "";
	}
	
	static public ArrayList<CellData> FindDataInFile(XSSFWorkbook wb, String sheetName, String cellData) {
		ArrayList<CellData>data = new ArrayList<CellData>();
	
		if(sheetName == null || sheetName == "") {
			ArrayList<ArrayList<CellData>>temp = new ArrayList<ArrayList<CellData>>();
			for(int i=0; i<wb.getNumberOfSheets(); i++)
				 temp.add(FindInFile(wb, wb.getSheetAt(i), cellData));
			for(ArrayList<CellData> ar : temp) {
				for(CellData d : ar) {
					data.add(d);
				}
			}
		}
		else
			data = FindInFile(wb, wb.getSheet(sheetName), cellData);
		return data;
	}
	
	static ArrayList<CellData> FindInFile(XSSFWorkbook wb, Sheet sheet, String cellData) {
		ArrayList<CellData>data = new ArrayList<CellData>();
		CellData cData;
		for(Row row : sheet) {
			for(Cell cell : row) {
				switch(cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					if(cell.getRichStringCellValue().getString().equals(cellData)) {
						cData = new CellData(row.getRowNum(), cell.getColumnIndex(), sheet.getSheetName(), cell.getRichStringCellValue().getString());
						data.add(cData);
					}
					break;
				case Cell.CELL_TYPE_NUMERIC:
					double num = cell.getNumericCellValue();
					String strNum = String.valueOf(num);
					
					if(strNum.equals(cellData)) {
						cData = new CellData(row.getRowNum(), cell.getColumnIndex(), sheet.getSheetName(), strNum);
						data.add(cData);
					}
					else {
						int intNum = (int)num;
						strNum = String.valueOf(intNum);
						if(strNum.equals(cellData)) {
							cData = new CellData(row.getRowNum(), cell.getColumnIndex(), sheet.getSheetName(), strNum);
							data.add(cData);
						}
					}
		
					break;
				//TODO
				//case Cell.CELL_TYPE_BOOLEAN:
				//case Cell.CELL_TYPE_FORMULA:
				} 
			}
		}
		return data;
	}
	
	static class CellData {
		private int rowNumber;
		private int columnNumber;
		private String sheetName;
		private String cellData;
		
		public CellData() {
			rowNumber = 0;
			columnNumber = 0;
			sheetName = "";
			cellData = "";
		}
		
		public CellData(int row, int col, String sh) {
			rowNumber = row;
			columnNumber = col;
			sheetName = sh;
			cellData = "";
		}
		
		public CellData(int row, int col, String sh, String d) {
			rowNumber = row;
			columnNumber = col;
			sheetName = sh;
			cellData = d;			
		}
		
		public void cellFound(int row, int col, String sh) {
			rowNumber = row;
			columnNumber = col;
			sheetName = sh;
		}
		
		public void setRowNumber(int row) {
			rowNumber = row;
		}
		
		public void setColumnNumber(int col) {
			columnNumber = col;
		}
		
		public void setSheetName(String sh) {
			sheetName = sh;
		}
		
		public void setCellData(String d) {
			cellData = d;
		}
		
		public int getRowNumber() {
			return rowNumber;
		}
		
		public int getColumnNumber() {
			return columnNumber;
		}
		
		public String getSheetName() {
			return sheetName;
		}
		
		public String getCellData() {
			return cellData;
		}
	};
		
	// --- <<IS-END-SHARED>> ---
}

