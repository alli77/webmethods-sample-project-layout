package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2010-11-13 16:48:39 GMT
// -----( ON-HOST: wmisdev

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.util.*;
import java.math.BigDecimal;
// --- <<IS-END-IMPORTS>> ---

public final class math

{
	// ---( internal utility methods )---

	final static math _instance = new math();

	static math _newInstance() { return new math(); }

	static math _cast(Object o) { return (math)o; }

	// ---( server methods )---




	public static final void addBigDecimal (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addBigDecimal)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required num1
		// [i] field:0:required num2
		// [o] field:0:required value
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	num1 = IDataUtil.getString( pipelineCursor, "num1" );
		String	num2 = IDataUtil.getString( pipelineCursor, "num2" );
		
		BigDecimal bd1 = new BigDecimal(num1);
		BigDecimal bd2 = new BigDecimal(num2);
		
		
		
		BigDecimal val = bd1.add(bd2);
		
		
		// pipeline
		IDataUtil.put( pipelineCursor, "value", "" + val );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void sumIntegers (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(sumIntegers)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required pipeline
		// [o] field:0:required sum
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData	idInputDoc = IDataUtil.getIData( pipelineCursor, "pipeline" );
		
		int nTemp=0;
		
		if ( idInputDoc != null)
		{
			IDataCursor curInput = idInputDoc.getCursor();
			while(curInput.next())
			{
				if(curInput.getValue() instanceof String)
				{
					nTemp+=Integer.parseInt((String)curInput.getValue());
				}
			}
			curInput.destroy();
		}
		
		IDataUtil.put( pipelineCursor, "sum", nTemp+"" );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

