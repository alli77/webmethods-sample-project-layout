package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-10-21 15:37:00 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class calendar

{
	// ---( internal utility methods )---

	final static calendar _instance = new calendar();

	static calendar _newInstance() { return new calendar(); }

	static calendar _cast(Object o) { return (calendar)o; }

	// ---( server methods )---




	public static final void Add (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(Add)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Calendar
		// [i] field:0:required Field {"Ear","Year","Month","WeekOfYear","WeekOfMonth","DayOfMonth","DayOfYear","DayOfWeek","Hour","Minute","Second","Millisecond"}
		// [i] field:0:required Amount
		/**************************************************************************
		 * Copy this to the Web Methods Java Add Flow
		 *
		 * java.util.Calendar add method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Calendar   (java.util.Calendar)
		 *         Field      (String)
		 *         Amount     (String - Integer)
		 *
		 * Revision History
		 * 111003 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 111003 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		// Extract Parameters
		java.util.Calendar cal = ExtractCalendar(idc, true);
		Integer amount = ExtractInteger(idc, AMOUNT, true);
		int field = ExtractField(idc, true);
		
		cal.add(field, amount.intValue());
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java Add Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void Get (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(Get)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:optional Calendar
		// [i] field:0:required Field {"Ear","Year","Month","WeekOfYear","WeekOfMonth","Date","DayOfMonth","DayOfYear","DayOfWeek","DayOfWeekInMonth","Hour","HourOfDay","Minute","Second","Millisecond"}
		// [o] field:0:optional Value
		/**************************************************************************
		 * Copy this to the Web Methods Java Get Flow
		 *
		 * java.util.Calendar get method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Calendar   (java.util.Calendar)
		 *         Field      (String)
		 *
		 * Output: Value      (String - Integer)
		 *
		 * Revision History
		 * 111003 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 111003 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		// Extract Parameters
		java.util.Calendar cal = ExtractCalendar(idc, false);
		int field = ExtractField(idc, false);
		
		if(cal != null && field >= 0)
		  IDataUtil.put(idc, VALUE, Integer.toString(cal.get(field)));
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java Get Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void GetField (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(GetField)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required Field {"Ear","Year","Month","WeekOfYear","WeekOfMonth","Date","DayOfMonth","DayOfYear","DayOfWeek","DayOfWeekInMonth","Hour","HourOfDay","Minute","Second","Millisecond"}
		// [o] field:0:optional Value
		/**************************************************************************
		 * Copy this to the Web Methods Java GetField Flow
		 *
		 * Get java.util.Calendar Fields Constants
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Field      (String)
		 *
		 * Output: Value      (String - Integer)
		 *
		 * Revision History
		 * 111004 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 111004 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		// Extract Parameters
		int field = ExtractField(idc, false);
		
		IDataUtil.put(idc, VALUE, Integer.toString(field));
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java GetField Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void GetInstance (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(GetInstance)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required Calendar
		/**************************************************************************
		 * Copy this to the Web Methods Java GetInstance Flow
		 *
		 * java.util.Calendar getInstance static method
		 *
		 * ToDo: Support Locale and TimeZone. Support Date as Input through setTime
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  ClassType  (String - Optional)
		 *
		 * Output: Calendar   (java.util.Calendar)
		 *
		 * Revision History
		 * 111003 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 111003 GOS Finished
		 *
		 */
		
		// Constants
		final String VarNameClassType = "ClassType";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		String ClassType = IDataUtil.getString(idc, VarNameClassType);
		
		if(ClassType != null && ClassType.equalsIgnoreCase("GregorianCalendar"))
		{
		  IDataUtil.put(idc, CALENDAR, java.util.GregorianCalendar.getInstance());
		}
		else
		{
		  IDataUtil.put(idc, CALENDAR, java.util.Calendar.getInstance());
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java GetInstance Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void GetTime (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(GetTime)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:optional Calendar
		// [o] object:0:optional Date
		/**************************************************************************
		 * Copy this to the Web Methods Java GetTime Flow
		 *
		 * java.util.Calendar getTime method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Calendar   (java.util.Calendar)
		 *
		 * Output: Date       (java.util.Date)
		 *
		 * Revision History
		 * 111003 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 111003 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		// Extract Parameters
		java.util.Calendar cal = ExtractCalendar(idc, false);
		
		if(cal != null)
		  IDataUtil.put(idc, DATE, cal.getTime());
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java GetTime Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void SetTime (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(SetTime)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Calendar
		// [i] object:0:required Date
		/**************************************************************************
		 * Copy this to the Web Methods Java SetTime Flow
		 *
		 * java.util.Calendar setTime method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Calendar   (java.util.Calendar)
		 *         Date       (java.util.Date)
		 *
		 * Revision History
		 * 111003 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 111003 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Calendar cal = ExtractCalendar(idc, true);
		Object obj = IDataUtil.get(idc, DATE);
		
		if(obj == null)
		  throw new ServiceException("The Date parameter is undefined");
		if(!(obj instanceof java.util.Date))
		  throw new ServiceException("The Date parameter is not an instance of Date");
		
		java.util.Date date = (java.util.Date)obj;
		
		cal.setTime(date);
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java SetTime Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	/**************************************************************************
	 * Copy this to the Web Methods Calendar Java Flow Shared Source
	 *
	 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
	 *
	 * Revision History
	 * 111003 GOS (geirmundur@skyrr.is) Created
	 *
	 * Unit test
	 * 111003 GOS Finished
	 *
	 */
	
	public static final String CALENDAR = "Calendar";
	public static final String AMOUNT = "Amount";
	public static final String FIELD = "Field";
	public static final String VALUE = "Value";
	public static final String DATE = "Date";
	
	public static final int ParseField(String Field, boolean ThrowException)
	        throws ServiceException
	{
	  if(Field == null)
	  {
	    if(ThrowException)
	      throw new ServiceException("The Field Parameter is undefined");
	    else
	      return -1;
	  }
	
	  if(Field.equalsIgnoreCase("ERA"))
	    return java.util.Calendar.ERA;
	  if(Field.equalsIgnoreCase("YEAR"))
	    return java.util.Calendar.YEAR;
	  if(Field.equalsIgnoreCase("MONTH"))
	    return java.util.Calendar.MONTH;
	  if(Field.equalsIgnoreCase("WEEK_OF_YEAR"))
	    return java.util.Calendar.WEEK_OF_YEAR;
	  if(Field.equalsIgnoreCase("WEEKOFYEAR"))
	    return java.util.Calendar.WEEK_OF_YEAR;
	  if(Field.equalsIgnoreCase("WEEK_OF_MONTH"))
	    return java.util.Calendar.WEEK_OF_MONTH;
	  if(Field.equalsIgnoreCase("WEEKOFMONTH"))
	    return java.util.Calendar.WEEK_OF_MONTH;
	  if(Field.equalsIgnoreCase("DATE"))
	    return java.util.Calendar.DATE;
	  if(Field.equalsIgnoreCase("DAY_OF_MONTH"))
	    return java.util.Calendar.DAY_OF_MONTH;
	  if(Field.equalsIgnoreCase("DAYOFMONTH"))
	    return java.util.Calendar.DAY_OF_MONTH;
	  if(Field.equalsIgnoreCase("DAY_OF_YEAR"))
	    return java.util.Calendar.DAY_OF_YEAR;
	  if(Field.equalsIgnoreCase("DAYOFYEAR"))
	    return java.util.Calendar.DAY_OF_YEAR;
	  if(Field.equalsIgnoreCase("DAY_OF_WEEK"))
	    return java.util.Calendar.DAY_OF_WEEK;
	  if(Field.equalsIgnoreCase("DAYOFWEEK"))
	    return java.util.Calendar.DAY_OF_WEEK;
	  if(Field.equalsIgnoreCase("DAY_OF_WEEK_IN_MONTH"))
	    return java.util.Calendar.DAY_OF_WEEK_IN_MONTH;
	  if(Field.equalsIgnoreCase("DAYOFWEEKINMONTH"))
	    return java.util.Calendar.DAY_OF_WEEK_IN_MONTH;
	  if(Field.equalsIgnoreCase("AM_PM"))
	    return java.util.Calendar.AM_PM;
	  if(Field.equalsIgnoreCase("AMPM"))
	    return java.util.Calendar.AM_PM;
	  if(Field.equalsIgnoreCase("HOUR"))
	    return java.util.Calendar.HOUR;
	  if(Field.equalsIgnoreCase("HOUR_OF_DAY"))
	    return java.util.Calendar.HOUR_OF_DAY;
	  if(Field.equalsIgnoreCase("HOUROFDAY"))
	    return java.util.Calendar.HOUR_OF_DAY;
	  if(Field.equalsIgnoreCase("MINUTE"))
	    return java.util.Calendar.MINUTE;
	  if(Field.equalsIgnoreCase("SECOND"))
	    return java.util.Calendar.SECOND;
	  if(Field.equalsIgnoreCase("MILLISECOND"))
	    return java.util.Calendar.MILLISECOND;
	  if(Field.equalsIgnoreCase("ZONE_OFFSET"))
	    return java.util.Calendar.ZONE_OFFSET;
	  if(Field.equalsIgnoreCase("ZONEOFFSET"))
	    return java.util.Calendar.ZONE_OFFSET;
	  if(Field.equalsIgnoreCase("DST_OFFSET"))
	    return java.util.Calendar.DST_OFFSET;
	  if(Field.equalsIgnoreCase("DSTOFFSET"))
	    return java.util.Calendar.DST_OFFSET;
	  if(Field.equalsIgnoreCase("FIELD_COUNT"))
	    return java.util.Calendar.FIELD_COUNT;
	  if(Field.equalsIgnoreCase("FIELDCOUNT"))
	    return java.util.Calendar.FIELD_COUNT;
	
	  if(Field.equalsIgnoreCase("SUNDAY"))
	    return java.util.Calendar.SUNDAY;
	  if(Field.equalsIgnoreCase("MONDAY"))
	    return java.util.Calendar.MONDAY;
	  if(Field.equalsIgnoreCase("TUESDAY"))
	    return java.util.Calendar.TUESDAY;
	  if(Field.equalsIgnoreCase("WEDNESDAY"))
	    return java.util.Calendar.WEDNESDAY;
	  if(Field.equalsIgnoreCase("THURSDAY"))
	    return java.util.Calendar.THURSDAY;
	  if(Field.equalsIgnoreCase("FRIDAY"))
	    return java.util.Calendar.FRIDAY;
	  if(Field.equalsIgnoreCase("SATURDAY"))
	    return java.util.Calendar.SATURDAY;
	
	  if(Field.equalsIgnoreCase("JANUARY"))
	    return java.util.Calendar.JANUARY;
	  if(Field.equalsIgnoreCase("FEBRUARY"))
	    return java.util.Calendar.FEBRUARY;
	  if(Field.equalsIgnoreCase("MARCH"))
	    return java.util.Calendar.MARCH;
	  if(Field.equalsIgnoreCase("APRIL"))
	    return java.util.Calendar.APRIL;
	  if(Field.equalsIgnoreCase("MAY"))
	    return java.util.Calendar.MAY;
	  if(Field.equalsIgnoreCase("JUNE"))
	    return java.util.Calendar.JUNE;
	  if(Field.equalsIgnoreCase("JULY"))
	    return java.util.Calendar.JULY;
	  if(Field.equalsIgnoreCase("AUGUST"))
	    return java.util.Calendar.AUGUST;
	  if(Field.equalsIgnoreCase("SEPTEMBER"))
	    return java.util.Calendar.SEPTEMBER;
	  if(Field.equalsIgnoreCase("OCTOBER"))
	    return java.util.Calendar.OCTOBER;
	  if(Field.equalsIgnoreCase("NOVEMBER"))
	    return java.util.Calendar.NOVEMBER;
	  if(Field.equalsIgnoreCase("DECEMBER"))
	    return java.util.Calendar.DECEMBER;
	
	  if(Field.equalsIgnoreCase("UNDECIMBER"))
	    return java.util.Calendar.UNDECIMBER;
	  if(Field.equalsIgnoreCase("AM"))
	    return java.util.Calendar.AM;
	  if(Field.equalsIgnoreCase("PM"))
	    return java.util.Calendar.PM;
	//  if(Field.equalsIgnoreCase("ALL_STYLES"))
	//    return java.util.Calendar.ALL_STYLES;
	//  if(Field.equalsIgnoreCase("ALLSTYLES"))
	//    return java.util.Calendar.ALL_STYLES;
	//  if(Field.equalsIgnoreCase("SHORT"))
	//    return java.util.Calendar.SHORT;
	//  if(Field.equalsIgnoreCase("LONG"))
	//    return java.util.Calendar.LONG;
	
	  if(ThrowException)
	    throw new ServiceException("Unsupported Calendar Field '" + Field + "'");
	  else
	    return -1;
	}
	
	public static final Integer ExtractInteger
	        (IDataCursor Cursor, String VarName, boolean ThrowException)
	        throws ServiceException
	{
	  Object obj = IDataUtil.get(Cursor, VarName);
	  if(obj == null)
	  {
	    if(ThrowException)
	      throw new ServiceException
	              ("The Parameter '" + VarName + "' is undefined (null)");
	    else
	      return null;
	  }
	  else if(obj instanceof java.lang.String)
	  {
	    String it = (java.lang.String)obj;
	    return Integer.valueOf(it);
	  }
	  else if(obj instanceof java.lang.Integer)
	  {
	    return (java.lang.Integer)obj;
	  }
	  else
	  {
	    if(ThrowException)
	      throw new ServiceException
	              (
	              "The Parameter '" + VarName +
	              "' is not instance of Integer or String"
	              );
	    else
	      return null;
	  }
	}
	
	public static final int ExtractField(IDataCursor Cursor) throws ServiceException
	{
	  return ExtractField(Cursor, FIELD, true);
	}
	
	public static final int ExtractField(IDataCursor Cursor, String VarName)
	        throws ServiceException
	{
	  return ExtractField(Cursor, VarName, true);
	}
	
	public static final int ExtractField(IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  return ExtractField(Cursor, FIELD, ThrowException);
	}
	
	public static final int ExtractField
	        (IDataCursor Cursor, String VarName, boolean ThrowException)
	        throws ServiceException
	{
	  String fieldStr = IDataUtil.getString(Cursor, VarName);
	  if(fieldStr == null)
	    throw new ServiceException("The Parameter '" + VarName + "' is undefined");
	  return ParseField(fieldStr, ThrowException);
	}
	
	public static final java.util.Calendar ExtractCalendar(IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractCalendar(Cursor, true);
	}
	
	public static final java.util.Calendar ExtractCalendar
	        (IDataCursor Cursor, String VarName)
	        throws ServiceException
	{
	  return ExtractCalendar(Cursor, VarName, true);
	}
	
	public static final java.util.Calendar ExtractCalendar
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  return ExtractCalendar(Cursor, CALENDAR, ThrowException);
	}
	
	public static final java.util.Calendar ExtractCalendar
	        (IDataCursor Cursor, String VarName, boolean ThrowException)
	        throws ServiceException
	{
	  Object obj = IDataUtil.get(Cursor, VarName);
	  if
	          (
	          ThrowException &&
	          (obj == null || !(obj instanceof java.util.Calendar))
	          )
	    throw new ServiceException
	            (
	            "The Parameter '" + VarName + "' is undefined (null) or " +
	            "not an instance of java.util.Calendar"
	            );
	  return (java.util.Calendar)obj;
	}
	
	public static final IDataCursor GetAndCheckCursor(IData Document)
	        throws ServiceException
	{
	  // Initialize
	  IDataCursor idc = Document.getCursor();
	  if(idc == null)
	    throw new ServiceException("Failed to get Cursor to Pipeline");
	  return idc;
	}
	
	/*
	 * Web Methods Calendar Java Flow Shared Source ends
	 **************************************************************************/
	// --- <<IS-END-SHARED>> ---
}

