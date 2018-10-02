package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2017-04-27 15:19:05 GMT
// -----( ON-HOST: WM-ISDEV.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class typeCast

{
	// ---( internal utility methods )---

	final static typeCast _instance = new typeCast();

	static typeCast _newInstance() { return new typeCast(); }

	static typeCast _cast(Object o) { return (typeCast)o; }

	// ---( server methods )---




	public static final void date2string (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(date2string)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required d8In
		// [o] field:0:required d8Out
		IDataCursor idcur = pipeline.getCursor();
		java.util.Date din = (java.util.Date)IDataUtil.get(idcur, "d8In");
		idcur.destroy();
		
		String dout = "";
		if( din != null )
			dout = din.toString();
		
		idcur = pipeline.getCursor();
		IDataUtil.put(idcur, "d8Out", dout);
		idcur.destroy();
		
		
		
		
		// --- <<IS-END>> ---

                
	}



	public static final void int2string (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(int2string)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required int
		// [o] field:0:required string
		IDataCursor pipelineCursor = pipeline.getCursor();
		Integer nInt    = (Integer)IDataUtil.get( pipelineCursor, "int");
		if (nInt!=null)
			IDataUtil.put(pipelineCursor, "string", nInt.toString());
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void long2string (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(long2string)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required int
		// [o] field:0:required string
		IDataCursor pipelineCursor = pipeline.getCursor();
		Long nLong    = (Long)IDataUtil.get( pipelineCursor, "long");
		if (nLong!=null)
			IDataUtil.put(pipelineCursor, "string", nLong.toString());
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void string2boolean (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(string2boolean)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required string
		// [o] object:0:required boolean
		IDataCursor pipelineCursor = pipeline.getCursor();
		String str    = IDataUtil.getString( pipelineCursor, "string");
		if (str!=null) {
			Boolean i = Boolean.valueOf(str);
			IDataUtil.put(pipelineCursor, "boolean", ((Object)i) );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void string2int (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(string2int)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required string
		// [o] object:0:required int
		IDataCursor pipelineCursor = pipeline.getCursor();
		String str    = IDataUtil.getString( pipelineCursor, "string");
		if (str!=null) {
			Integer i = Integer.valueOf(str);
			IDataUtil.put(pipelineCursor, "int", ((Object)i) );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void string2long (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(string2long)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required string
		// [o] object:0:required long
		IDataCursor pipelineCursor = pipeline.getCursor();
		String str    = IDataUtil.getString( pipelineCursor, "string");
		if (str!=null) {
			long l = Long.parseLong(str);
			IDataUtil.put(pipelineCursor, "long", ((Object)l) );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void string2short (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(string2short)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required string
		// [o] object:0:required short
		IDataCursor pipelineCursor = pipeline.getCursor();
		String str    = IDataUtil.getString( pipelineCursor, "string");
		if (str!=null) {
			short l = Short.parseShort(str);
			IDataUtil.put(pipelineCursor, "short", ((Object)l) );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

