package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-02-11 09:45:46 GMT
// -----( ON-HOST: wmisdev

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class object

{
	// ---( internal utility methods )---

	final static object _instance = new object();

	static object _newInstance() { return new object(); }

	static object _cast(Object o) { return (object)o; }

	// ---( server methods )---




	public static final void isArray (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(isArray)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required object
		// [o] field:0:required isArray
		// [o] object:1:required objectlist
		// [o] field:1:required stringlist
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object object= ((Object) IDataUtil.get( pipelineCursor, "object" ) );
		if (object == null) {
			IDataUtil.put( pipelineCursor, "isArray", "false" );
		} else {
		boolean b = object.getClass().isArray();
		if (b) {
			IDataUtil.put( pipelineCursor, "isArray", "true" );
			IDataUtil.put( pipelineCursor, "objectlist", object );
			IDataUtil.putStringList( pipelineCursor, "objectlist", object );
		} else {
			IDataUtil.put( pipelineCursor, "isArray", "false" );
		}
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

