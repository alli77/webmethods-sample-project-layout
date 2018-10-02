package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2009-07-02 11:36:44 GMT
// -----( ON-HOST: wmisdev

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class encoding

{
	// ---( internal utility methods )---

	final static encoding _instance = new encoding();

	static encoding _newInstance() { return new encoding(); }

	static encoding _cast(Object o) { return (encoding)o; }

	// ---( server methods )---




	public static final void XmlEncodeUpperToNumberic (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(XmlEncodeUpperToNumberic)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required In
		// [i] field:0:optional Threshold
		// [o] field:0:required Out
		/**************************************************************************
		 * Copy this to the Web Methods Java XmlEncodeUpperToNumberic Flow
		 *
		 * Description
		 *
		 * Copyright \u00A9 2009, K\u00F6gun Ltd (www.kogun.is). All rights reserved.
		 *
		 * Input: String In
		 * Output: String Out
		 *
		 * Revision History
		 * 090511 GOS (geirmundur@kogun.is) Created
		 *
		 * Unit test
		 * 090511 GOS not finished
		 *
		 */
		
		// Constants
		final String VarNameIn = "In";
		final String VarNameThreshold = "Threshold";
		final String VarNameOut = "Out";
		
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		if(idc == null)
		  throw new ServiceException("Failed to get Cursor to Pipeline");
		
		char threshold = ExtractThreshold(idc, VarNameThreshold);
		String in = IDataUtil.getString(idc, VarNameIn);
		String out = EncodeUpperToNumberic(in, threshold);
		
		// Add the result to the pipeline
		if(out != null)
		  IDataUtil.put(idc, VarNameOut, out);
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java XmlEncodeUpperToNumberic Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	/**************************************************************************
	 * Copy this to the Web Methods Encoding Java Flow Shared Source
	 *
	 * Copyright \u00A9 2009, K\u00F6gun Ltd (www.kogun.is). All rights reserved.
	 *
	 * Revision History
	 * 090511 GOS (geirmundur@kogun.is) Created
	 *
	 * Unit test
	 * 090511 GOS not finished
	 *
	 */
	
	//public static final char DEFAULT_THRESHOLD = 'z';
	public static final char DEFAULT_THRESHOLD = 'z';
	
	public static final char ExtractThreshold(IDataCursor Cursor, String Key)
	{
	  String threshold = IDataUtil.getString(Cursor, Key);
	  if(threshold == null || threshold.length() == 0) return DEFAULT_THRESHOLD;
	  return threshold.charAt(0);
	}
	
	public static final void EncodeUpperToNumberic
	        (java.lang.StringBuffer Buffer, char Ch, char Threshold)
	{
	  if(Ch > Threshold)
	    Buffer.append("&#" + java.lang.Integer.toString((int)Ch) + ";");
	  else
	    Buffer.append(Ch);
	}
	
	public static final String EncodeUpperToNumberic(String In, char Threshold)
	{
	  if(In == null) return null;
	  java.lang.StringBuffer out = new java.lang.StringBuffer();
	  int length = In.length();
	  for(int i = 0; i < length; i++)
	   EncodeUpperToNumberic(out, In.charAt(i), Threshold);
	  return out.toString();
	}
	
	/*
	 * Web Methods Encoding Java Flow Shared Source ends
	 **************************************************************************/
	// --- <<IS-END-SHARED>> ---
}

