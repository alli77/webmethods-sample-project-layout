package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2007-10-30 13:14:14 GMT
// -----( ON-HOST: VMISD

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class ASync

{
	// ---( internal utility methods )---

	final static ASync _instance = new ASync();

	static ASync _newInstance() { return new ASync(); }

	static ASync _cast(Object o) { return (ASync)o; }

	// ---( server methods )---




	public static final void runAsyncThread (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(runAsyncThread)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required serviceFullName
		// [i] field:0:optional timeoutMs
		// [o] object:0:required newServiceThread
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	serviceFullName = IDataUtil.getString( pipelineCursor, "serviceFullName" );
		String	strTimeoutMs = IDataUtil.getString( pipelineCursor, "timeoutMs" );
		IData	pipe = IDataUtil.getIData( pipelineCursor, "pipe" );
		
		int nColonIndex=-1;
		long lTimeoutMs = 0;
		if((nColonIndex=serviceFullName.indexOf(":"))<0)
		{
			throw new ServiceException("Not valid service name");
		}
		if( strTimeoutMs !=null && strTimeoutMs.matches("\\A\\d+\\Z"))
		{
			lTimeoutMs = Long.parseLong(strTimeoutMs);
		}
		
		
		com.wm.app.b2b.server.ServiceThread serviceThread =null;
		try
		{
			serviceThread = com.wm.app.b2b.server.Service.doThreadInvoke( serviceFullName.substring(0,nColonIndex), serviceFullName.substring(nColonIndex+1), pipe, lTimeoutMs );
		}
		catch(com.wm.app.b2b.server.ISRuntimeException isr)
		{
			throw new ServiceException(isr);	
		}
		IDataUtil.put( pipelineCursor, "newServiceThread", serviceThread );
		
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}
}

