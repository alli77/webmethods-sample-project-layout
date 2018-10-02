package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2008-04-16 17:41:31 GMT
// -----( ON-HOST: VMISD

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class system

{
	// ---( internal utility methods )---

	final static system _instance = new system();

	static system _newInstance() { return new system(); }

	static system _cast(Object o) { return (system)o; }

	// ---( server methods )---




	public static final void System_getProperty (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(System_getProperty)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required name
		// [o] field:0:required value
		IDataCursor IDC = pipeline.getCursor();
		IDataUtil.put(IDC, "value", System.getProperty(IDataUtil.getString(IDC, "name"))) ;
		IDC.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void System_setProperty (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(System_setProperty)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required name
		// [i] field:0:required value
		IDataCursor IDC = pipeline.getCursor();
		if (IDataUtil.getString(IDC, "value") == null)
			System.setProperty(IDataUtil.getString(IDC, "name"), "") ;
		else
			System.setProperty(IDataUtil.getString(IDC, "name"), IDataUtil.getString(IDC, "value")) ;
		IDC.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void freeMemory (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(freeMemory)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required freeMem
		// [o] object:0:required freeMem_long
		IDataCursor pC = pipeline.getCursor();
		long freeMem = Runtime.getRuntime().freeMemory();
		IDataUtil.put(pC, "freeMem", String.valueOf(freeMem) );
		IDataUtil.put(pC, "freeMem_long", ((Object) new Long(freeMem) ) );
		pC.destroy();
		// --- <<IS-END>> ---

                
	}
}

