package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2017-02-27 15:29:26 GMT
// -----( ON-HOST: WM-ISdev01.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.List;
// --- <<IS-END-IMPORTS>> ---

public final class array

{
	// ---( internal utility methods )---

	final static array _instance = new array();

	static array _newInstance() { return new array(); }

	static array _cast(Object o) { return (array)o; }

	// ---( server methods )---




	public static final void reduceArray (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(reduceArray)>> ---
		// @sigtype java 3.5
		// [i] field:1:required input
		// [i] field:0:required seperator
		// [o] field:0:required val
		IDataCursor pC = pipeline.getCursor();
		
		String[] a = (String[]) IDataUtil.get(pC, "input");
		String seperator = (String) IDataUtil.get(pC, "seperator");
		String val = "";
		IDataUtil.put(pC, "val", val );
		
		if(a != null){
			for(int i = 0; i < a.length; i++){
				val += a[i];
				if(i != a.length - 1){
					val += seperator;
				}
			}
		}
		IDataUtil.put(pC, "val", val );
		// --- <<IS-END>> ---

                
	}
}

