package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2010-07-06 16:37:10 GMT
// -----( ON-HOST: wmisdev

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class setOperators

{
	// ---( internal utility methods )---

	final static setOperators _instance = new setOperators();

	static setOperators _newInstance() { return new setOperators(); }

	static setOperators _cast(Object o) { return (setOperators)o; }

	// ---( server methods )---




	public static final void minus (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(minus)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:1:required a
		// [i] field:1:required b
		// [o] field:1:required minus
		IDataCursor pipelineCursor = pipeline.getCursor();
		String[] a = IDataUtil.getStringArray( pipelineCursor, "a" );
		String[] b = IDataUtil.getStringArray( pipelineCursor, "b" );
		
		if(a==null)
		{
			pipelineCursor.destroy();	
			return;
		}
		
		if(b==null)
		{
			IDataUtil.put( pipelineCursor, "minus", a );
			
			pipelineCursor.destroy();	
			return;
		}
		java.util.Vector vAMinB = new java.util.Vector();
		
		boolean inB = false;
		for(int ca=0; ca<a.length; ca++)
		{
			for(int cb=0; cb<b.length; cb++)
			{
				if(a[ca].equalsIgnoreCase(b[cb]))
				{
					inB=true;
					break;
				}
			}
			if(!inB)
			{
				boolean isAlreadyInResult = false;
				for(int k=0; k<vAMinB.size();k++)
				{
					if(a[ca].equalsIgnoreCase((String)vAMinB.get(k)))
					{
						isAlreadyInResult =true;
					}
				}
				if(!isAlreadyInResult)
				{
					vAMinB.add(a[ca]);
				}
			}
			inB=false;
		}
		
		
		
		if(vAMinB.size()>0)
		{
			IDataUtil.put( pipelineCursor, "minus", vAMinB.toArray(new String[1]) );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

