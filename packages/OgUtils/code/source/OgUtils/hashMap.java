package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2008-05-09 16:42:38 GMT
// -----( ON-HOST: VMISD

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.HashMap;
// --- <<IS-END-IMPORTS>> ---

public final class hashMap

{
	// ---( internal utility methods )---

	final static hashMap _instance = new hashMap();

	static hashMap _newInstance() { return new hashMap(); }

	static hashMap _cast(Object o) { return (hashMap)o; }

	// ---( server methods )---




	public static final void add2HashMap (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(add2HashMap)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required str
		// [i] field:0:required value
		// [i] object:0:required hash
		// [o] object:0:required hash
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	str = IDataUtil.getString( pipelineCursor, "str" );
		String	value = IDataUtil.getString( pipelineCursor, "value" );
		HashMap hash = ((HashMap) IDataUtil.get(pipelineCursor, "hash"));
		if (hash == null) 
			hash = new HashMap();
		hash.put(str,value);
		
		IDataUtil.put( pipelineCursor, "hash", hash );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void addObj2HashMap (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addObj2HashMap)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required key
		// [i] object:0:required value
		// [i] object:0:required hash
		// [o] object:0:required hash
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	str = IDataUtil.getString( pipelineCursor, "key" );
		Object	value = IDataUtil.get( pipelineCursor, "value" );
		HashMap hash = ((HashMap) IDataUtil.get(pipelineCursor, "hash"));
		if (hash == null) 
			hash = new HashMap();
		hash.put(str,value);
		
		IDataUtil.put( pipelineCursor, "hash", hash );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void get (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(get)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required hash
		// [i] field:0:required key
		// [o] object:0:required object
		IDataCursor idc = pipeline.getCursor();
		if (IDataUtil.get(idc, "hash") != null)
			IDataUtil.put(idc, "object", ((HashMap) IDataUtil.get(idc, "hash")).get(IDataUtil.getString(idc, "key")) );
		idc.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void hashMap2Array (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(hashMap2Array)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required hash
		// [o] field:1:required array
		IDataCursor pipelineCursor = pipeline.getCursor();
		HashMap	hash = ((HashMap) IDataUtil.get( pipelineCursor, "hash" ) );
		
		String[] array = ((String[]) hash.keySet().toArray(new String[1]));
		
		IDataUtil.put( pipelineCursor, "array", array );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void hashMap2ObjectArray (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(hashMap2ObjectArray)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required hash
		// [o] object:1:required objArray
		IDataCursor pipelineCursor = pipeline.getCursor();
		HashMap	hash = ((HashMap) IDataUtil.get( pipelineCursor, "hash" ) );
		java.util.Collection col = hash.values();
		Object[] array = ((Object[]) col.toArray(new Object[1]));
		
		IDataUtil.put( pipelineCursor, "objArray", array );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void hashMapToArray (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(hashMapToArray)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required hash
		// [o] record:1:required array
		IDataCursor pipelineCursor = pipeline.getCursor();
		HashMap	hash = ((HashMap) IDataUtil.get( pipelineCursor, "hash" ) );
		
		if(hash!=null)
		{
			java.util.Collection col = hash.values();
			IDataUtil.put( pipelineCursor, "array", col.toArray(new IData[col.size()]) );
		}
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void removeFromHashMap (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(removeFromHashMap)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required hash
		// [i] field:0:required key
		// [o] object:0:required value
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	str = IDataUtil.getString( pipelineCursor, "key" );
		HashMap hash = ((HashMap) IDataUtil.get(pipelineCursor, "hash"));
		if (hash == null) 
			return;
		Object o = hash.remove(str);
		
		IDataUtil.put( pipelineCursor, "value", o );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void size (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(size)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required hash
		// [o] field:0:required size
		IDataCursor idc = pipeline.getCursor();
		if (IDataUtil.get(idc, "hash") != null)
			IDataUtil.put(idc, "size", ""+((HashMap) IDataUtil.get(idc, "hash")).size() );
		idc.destroy();
		// --- <<IS-END>> ---

                
	}
}

