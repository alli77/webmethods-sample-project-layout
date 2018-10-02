package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2006-09-11 11:40:19 GMT
// -----( ON-HOST: si28dmzdev

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class timing

{
	// ---( internal utility methods )---

	final static timing _instance = new timing();

	static timing _newInstance() { return new timing(); }

	static timing _cast(Object o) { return (timing)o; }

	// ---( server methods )---




	public static final void end (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(end)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required start
		// [o] field:0:required msec
		Long end = new Long(System.currentTimeMillis());
		IDataCursor pipelineCursor = pipeline.getCursor();
		Long start = ((Long) IDataUtil.get( pipelineCursor, "start" ));
		if (start!= null)
			IDataUtil.put( pipelineCursor, "msec",  Long.toString( end.longValue()-start.longValue() ) );
		else 
			IDataUtil.put( pipelineCursor, "msec",  "?" );
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void start (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(start)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required start
		IDataCursor pipelineCursor = pipeline.getCursor();
		Long start = new Long(System.currentTimeMillis());
		IDataUtil.put( pipelineCursor, "start", ((Object) start) );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

