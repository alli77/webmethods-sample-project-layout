package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-09-15 13:26:45 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class stringBuffer

{
	// ---( internal utility methods )---

	final static stringBuffer _instance = new stringBuffer();

	static stringBuffer _newInstance() { return new stringBuffer(); }

	static stringBuffer _cast(Object o) { return (stringBuffer)o; }

	// ---( server methods )---




	public static final void CreateStringBuffer (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(CreateStringBuffer)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:optional Length
		// [i] field:0:optional Str
		// [o] object:0:required StringBuffer
		/**************************************************************************
		 * Copy this to the Web Methods Java CreateStringBuffer Flow
		 *
		 * java.lang.StringBuffer Constructors
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Length (String - optional integer)
		 *         Str    (String - optional)
		 *
		 * Output: StringBuffer (java.lang.StringBuffer)
		 *
		 * Revision History
		 * 110910 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110910 GOS Finished
		 *
		 */
		
		// Constants
		final String VarNameLength = "Length";
		final String VarNameStr = "Str";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		String str = IDataUtil.getString(idc, VarNameStr);
		Integer length = ExtractInteger(idc, VarNameLength, false);
		
		if(str == null && length == null)
		  IDataUtil.put
		          (idc, STRING_BUFFER, new java.lang.StringBuffer());
		else if (str != null)
		  IDataUtil.put
		          (idc, STRING_BUFFER, new java.lang.StringBuffer(str));
		else if (length != null)
		  IDataUtil.put
		          (idc, STRING_BUFFER, new java.lang.StringBuffer(length.intValue()));
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java CreateStringBuffer Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void ToString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ToString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required StringBuffer
		// [o] field:0:required ToString
		/**************************************************************************
		 * Copy this to the Web Methods Java StringBufferToString Flow
		 *
		 * java.lang.StringBuffer toString Method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  StringBuffer (java.lang.StringBuffer)
		 *
		 * Output: ToString     (String)
		 *
		 * Revision History
		 * 110915 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110915 GOS Finished
		 *
		 */
		
		// Constants
		final String VarNameToString = "ToString";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.lang.StringBuffer sb = ExtractStringBuffer(idc, false);
		
		if(sb != null)
		  IDataUtil.put(idc, VarNameToString, sb.toString());
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java StringBufferToString Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	/**************************************************************************
	 * Copy this to the Web Methods StringBuffer Java Flow Shared Source
	 *
	 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
	 *
	 * Revision History
	 * 110908 GOS (geirmundur@skyrr.is) Created
	 *
	 * Unit test
	 * 110908 GOS Finished
	 *
	 */
	
	public static final String STRING_BUFFER = "StringBuffer";
	
	public static final java.lang.StringBuffer ExtractStringBuffer
	        (IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractStringBuffer(Cursor, true);
	}
	
	public static final java.lang.StringBuffer ExtractStringBuffer
	        (IDataCursor Cursor, String VarName)
	        throws ServiceException
	{
	  return ExtractStringBuffer(Cursor, VarName, true);
	}
	
	public static final java.lang.StringBuffer ExtractStringBuffer
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  return ExtractStringBuffer(Cursor, STRING_BUFFER, ThrowException);
	}
	
	public static final java.lang.StringBuffer ExtractStringBuffer
	        (IDataCursor Cursor, String VarName, boolean ThrowException)
	        throws ServiceException
	{
	  Object obj = IDataUtil.get(Cursor, VarName);
	  if
	          (
	          ThrowException &&
	          (obj == null || !(obj instanceof java.lang.StringBuffer))
	          )
	    throw new ServiceException
	            (
	            "The Parameter '" + VarName + "' is undefined (null) or " +
	            "not an instance of java.lang.StringBuffer"
	            );
	  return (java.lang.StringBuffer)obj;
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
	 * Web Methods StringBuffer Java Flow Shared Source ends
	 **************************************************************************/
	// --- <<IS-END-SHARED>> ---
}

