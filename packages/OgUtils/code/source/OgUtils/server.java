package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2007-04-25 14:29:48 GMT
// -----( ON-HOST: VMISD

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class server

{
	// ---( internal utility methods )---

	final static server _instance = new server();

	static server _newInstance() { return new server(); }

	static server _cast(Object o) { return (server)o; }

	// ---( server methods )---




	public static final void getSessionId (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getSessionId)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required sessionId
		IDataCursor pipelineCursor = pipeline.getCursor();
		String strSessionId = com.wm.app.b2b.server.InvokeState.getCurrentSession().getSessionID();
		
		IDataUtil.put( pipelineCursor, "sessionId", strSessionId );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

