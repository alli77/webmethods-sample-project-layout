package OgUtils.soap;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2008-04-08 17:34:02 GMT
// -----( ON-HOST: VMISD

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class nil

{
	// ---( internal utility methods )---

	final static nil _instance = new nil();

	static nil _newInstance() { return new nil(); }

	static nil _cast(Object o) { return (nil)o; }

	// ---( server methods )---




	public static final void buildNilDT (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(buildNilDT)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Doc
		// [o] record:0:required buildDoc
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData[]	dt = IDataUtil.getIDataArray( pipelineCursor, "dt" );
		IData	Doc = IDataUtil.getIData( pipelineCursor, "Doc" );
		if ( dt != null && Doc != null) {
			IData	buildDoc = IDataFactory.create();
			IDataCursor buildC = buildDoc.getCursor();
			IDataCursor DocC = Doc.getCursor();
			buildNilDT(dt, DocC, buildC );
			IDataUtil.put( pipelineCursor, "buildDoc", buildDoc );
			buildC.destroy();
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static void buildNilDT(IData[] dt, IDataCursor Doc, IDataCursor buildDoc ) throws ServiceException {
		IData nilObj = IDataFactory.create(1);
		IDataUtil.put(nilObj.getCursor(), "@xsi:nil", "true");
		for(int i =0; i<dt.length;i++) {
			String name = IDataUtil.getString(dt[i].getCursor(), "name");
			boolean nillable = IDataUtil.getBoolean(dt[i].getCursor(), "nillable");
			IData[] dt2 = IDataUtil.getIDataArray(dt[i].getCursor(), "dt");
			if (dt2 != null) {
				IData buildDoc2 = IDataFactory.create();
				if (IDataUtil.get(Doc, name) == null ) {
					if (nillable)
						IDataUtil.put(buildDoc, name, nilObj);
				} else {
					if (IDataUtil.get(Doc, name) instanceof IData) {
						buildNilDT(dt2, IDataUtil.getIData(Doc, name).getCursor(), buildDoc2.getCursor());
						IDataUtil.put(buildDoc, name, buildDoc2);
					} else if (IDataUtil.get(Doc, name) instanceof IData[]) {
						IData[] arr = new IData[IDataUtil.getIDataArray(Doc, name).length];
						for(int j =0; j<arr.length;j++) {
							arr[j]=IDataFactory.create();
							buildNilDT(dt2, IDataUtil.getIDataArray(Doc, name)[j].getCursor(), arr[j].getCursor());
						}
						IDataUtil.put(buildDoc, name, arr);
					}
				}
			} else {
				if (IDataUtil.get(Doc, name) != null )
					IDataUtil.put(buildDoc, name, IDataUtil.get(Doc, name) );
				else
					if (nillable) 
						IDataUtil.put(buildDoc, name, nilObj);
			}
		}
	}
	// --- <<IS-END-SHARED>> ---
}

