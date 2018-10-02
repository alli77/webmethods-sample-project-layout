package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2013-12-30 11:16:27 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.Hashtable;
// --- <<IS-END-IMPORTS>> ---

public final class hashTable

{
	// ---( internal utility methods )---

	final static hashTable _instance = new hashTable();

	static hashTable _newInstance() { return new hashTable(); }

	static hashTable _cast(Object o) { return (hashTable)o; }

	// ---( server methods )---




	public static final void hashTableToArray (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(hashTableToArray)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required hash
		// [o] record:1:required array
		IDataCursor pipelineCursor = pipeline.getCursor();
		Hashtable hash = ((Hashtable) IDataUtil.get( pipelineCursor, "hash" ) );
		
		if(hash!=null)
		{
			java.util.Collection col = hash.values();
			IDataUtil.put( pipelineCursor, "array", col.toArray(new IData[col.size()]) );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

