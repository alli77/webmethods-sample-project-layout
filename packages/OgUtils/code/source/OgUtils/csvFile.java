package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2006-08-16 11:59:24 GMT
// -----( ON-HOST: si28dmzdev

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class csvFile

{
	// ---( internal utility methods )---

	final static csvFile _instance = new csvFile();

	static csvFile _newInstance() { return new csvFile(); }

	static csvFile _cast(Object o) { return (csvFile)o; }

	// ---( server methods )---




	public static final void generateCSVString2 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(generateCSVString2)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required docList
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		IData[]	docList = IDataUtil.getIDataArray( pipelineCursor, "docList" );
		if ( docList != null)
		{
			for ( int i = 0; i < docList.length; i++ )
			{
				
			}
		}
		pipelineCursor.destroy();
		
		// pipeline
		// --- <<IS-END>> ---

                
	}
}

