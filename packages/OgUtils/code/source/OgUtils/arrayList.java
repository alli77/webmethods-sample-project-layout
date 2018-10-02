package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-09-23 09:25:19 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.ArrayList;
// --- <<IS-END-IMPORTS>> ---

public final class arrayList

{
	// ---( internal utility methods )---

	final static arrayList _instance = new arrayList();

	static arrayList _newInstance() { return new arrayList(); }

	static arrayList _cast(Object o) { return (arrayList)o; }

	// ---( server methods )---




	public static final void add (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(add)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required object
		// [i] field:0:required index
		// [i] object:0:required ArrayList
		// [o] object:0:required ArrayList
		IDataCursor pC = pipeline.getCursor();
		
		ArrayList al = (ArrayList) IDataUtil.get(pC, "ArrayList");
		Object object = IDataUtil.get(pC, "object");
		String index = IDataUtil.getString(pC, "index");
		
		if (al == null) {
			al = new ArrayList();
			IDataUtil.put(pC, "ArrayList", al );
		}
		
		if (index == null || index == "") {
			al.add(object);
		} else {
			al.add(Integer.parseInt(index),object);
		}
		
		pC.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void contains (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(contains)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required object
		// [i] object:0:required ArrayList
		// [o] field:0:required contains
		IDataCursor pC = pipeline.getCursor();
		
		ArrayList al = (ArrayList) IDataUtil.get(pC, "ArrayList");
		Object object = IDataUtil.get(pC, "object");
		
		boolean contains = al.contains(object);
		
		IDataUtil.put( pC, "contains", contains );
		pC.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void newArrayList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(newArrayList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required ArrayList
		IDataCursor pC = pipeline.getCursor();
		
		IDataUtil.put(pC, "ArrayList", new ArrayList() );
		
		pC.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void remove (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(remove)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required index
		// [i] object:0:required object
		// [i] object:0:required ArrayList
		// [o] object:0:required ArrayList
		IDataCursor pC = pipeline.getCursor();
		
		ArrayList al = (ArrayList) IDataUtil.get(pC, "ArrayList");
		String index = IDataUtil.getString(pC, "index");
		Object object = IDataUtil.get(pC, "object");
		
		if (index!= null && index!="" ) {
			al.remove(Integer.parseInt(index));
		} else {
			int i = al.indexOf(object);
			al.remove(i);
		}
		
		pC.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void toIDataArray (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(toIDataArray)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ArrayList
		// [o] record:1:required IDataArray
		IDataCursor pC = pipeline.getCursor();
		
		ArrayList al = (ArrayList) IDataUtil.get(pC, "ArrayList");
		
		IData[] idA = new IData[al.size()];
		
		IDataUtil.put(pC, "IDataArray", al.toArray(idA) );
		
		pC.destroy();
		// --- <<IS-END>> ---

                
	}
}

