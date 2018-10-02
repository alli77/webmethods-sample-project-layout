package KogunLogger;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2005-09-06 16:30:02 GMT
// -----( ON-HOST: snari.kogun.is

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.Date;
import java.util.Calendar;
import com.wm.lang.ns.NSName;
import com.wm.app.b2b.server.ServerAPI;
import com.wm.lang.ns.NSService;
import com.wm.app.b2b.server.InvokeState;
import java.util.Stack;
import java.io.*;
// --- <<IS-END-IMPORTS>> ---

public final class internal

{
	// ---( internal utility methods )---

	final static internal _instance = new internal();

	static internal _newInstance() { return new internal(); }

	static internal _cast(Object o) { return (internal)o; }

	// ---( server methods )---




	public static final void getServerName (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getServerName)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required ServerName
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		try
		{
		  IDataUtil.put(pipelineCursor,"ServerName",ServerAPI.getServerName());
		}
		catch(Exception e)
		{
		  IDataUtil.put(pipelineCursor,"ServerName","unknown");
		}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	static Integer getIntegerValue( IDataCursor pipelineCursor, String value ) {
	
	  Integer i = new Integer(0);
	 
	  boolean b = pipelineCursor.first(value);
	  if (b) 
	    i = i.valueOf ( (String) pipelineCursor.getValue() );
	  
	  return i;
	};
	// --- <<IS-END-SHARED>> ---
}

