package KogunLogger;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2006-06-27 17:26:19 GMT
// -----( ON-HOST: snari.kogun.is

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
// --- <<IS-END-IMPORTS>> ---

public final class test

{
	// ---( internal utility methods )---

	final static test _instance = new test();

	static test _newInstance() { return new test(); }

	static test _cast(Object o) { return (test)o; }

	// ---( server methods )---




	public static final void Untitled (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(Untitled)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		  try{IDataCursor pipelineCursor = pipeline.getCursor();
		  FileWriter f = new FileWriter("e:\\xxyy.txt");
		  IDataUtil.put( pipelineCursor, "encoding", f.getEncoding() );
		  pipelineCursor.destroy();
		
		}catch(Exception e)
		{}
		// --- <<IS-END>> ---

                
	}
}

