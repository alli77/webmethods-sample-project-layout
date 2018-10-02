package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-12-05 19:06:18 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.SOAPMessage;
import com.wm.lang.ns.NSService;
import com.wm.app.b2b.server.ServiceThread;
import com.wm.util.QName;
import com.wm.lang.ns.NSRecord;
import java.io.ByteArrayInputStream;
import com.wm.lang.ns.NSField;
import com.wm.util.coder.XMLCoderWrapper;
import java.util.ArrayList;
// --- <<IS-END-IMPORTS>> ---

public final class flow

{
	// ---( internal utility methods )---

	final static flow _instance = new flow();

	static flow _newInstance() { return new flow(); }

	static flow _cast(Object o) { return (flow)o; }

	// ---( server methods )---




	public static final void GclearPipeline (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(GclearPipeline)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:1:optional preserve
        IDataCursor id = pipeline.getCursor();
        String preserve[] = null;
        String Gpreserve[] = null;
        if(id.first("preserve"))
        {
            preserve = IDataUtil.getStringArray(id);
        }
        if(id.first("GLOBALpreserve"))
        {
            Gpreserve = IDataUtil.getStringArray(id);
        }

        IData saved = null;
	IDataCursor idc =null;
        if((preserve != null && preserve.length > 0) || (Gpreserve != null && Gpreserve.length > 0) )
        {
            saved = IDataFactory.create();
            idc = saved.getCursor();
	}
	if(preserve != null && preserve.length > 0 ) {
            for(int i = 0; i < preserve.length; i++)
            {
                if(id.first(preserve[i]))
                {
                    do
                    {
                        idc.insertAfter(preserve[i], id.getValue());
                    } while(id.next(preserve[i]));
                }
            }
        }
	if(Gpreserve != null && Gpreserve.length > 0 ) {
	    if(id.first("GLOBALpreserve"))
		    idc.insertAfter("GLOBALpreserve", id.getValue());
            for(int i = 0; i < Gpreserve.length; i++)
            {
                if(id.first(Gpreserve[i]))
                {
                    do
                    {
                        idc.insertAfter(Gpreserve[i], id.getValue());
                    } while(id.next(Gpreserve[i]));
                }
            }
        }
        if((preserve != null && preserve.length > 0) || (Gpreserve != null && Gpreserve.length > 0) )
            idc.destroy();

        id.first();
        while(id.delete()) ;
        if(saved != null)
        {
            IDataUtil.append(saved, pipeline);
        }
	id.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void dropNilDocuments (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(dropNilDocuments)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		IDataCursor pipelineCursor = pipeline.getCursor();
		pipelineCursor.first();
		dropNils( pipelineCursor );
		
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void dropNullSpareEmptyVariables (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(dropNullSpareEmptyVariables)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		IDataCursor pipelineCursor = pipeline.getCursor();
		pipelineCursor.first();
		dropNullsSpareEmtpy( pipelineCursor );
		
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void dropNullVariables (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(dropNullVariables)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		IDataCursor pipelineCursor = pipeline.getCursor();
		pipelineCursor.first();
		dropNulls( pipelineCursor );
		
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void joinT (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(joinT)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ServiceThread
		// [o] record:0:required pipeline
		try {
		IDataCursor pipelineCursor = pipeline.getCursor();
		ServiceThread	ST = ((ServiceThread) IDataUtil.get( pipelineCursor, "ServiceThread" ));
		IDataUtil.put( pipelineCursor, "pipeline", ST.getIData() );
		pipelineCursor.destroy();
		}  catch(Exception e) {
			throw new ServiceException(e);
		}
		// --- <<IS-END>> ---

                
	}



	public static final void localTinvoke (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(localTinvoke)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required $service
		// [i] record:0:required pipeline
		// [i] field:0:required timeout
		// [o] object:0:required ServiceThread
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		//IDataCursor tmpcurs = tmp.getCursor();
		String service = IDataUtil.getString( pipelineCursor, "$service" );
		String folder = service.split(":")[0];
		String name = service.split(":")[1];
		String timeout = IDataUtil.getString( pipelineCursor, "timeout" );
		IData pipe = IDataUtil.getIData( pipelineCursor, "pipeline");
		try {
			IDataUtil.put(pipelineCursor, "ServiceThread", Service.doThreadInvoke(folder, name, pipe, -1));//Long.parseLong(timeout)));
			pipelineCursor.destroy();
		}  catch(Exception e) {
			pipelineCursor.destroy();
			throw new ServiceException(e.getMessage());
		}
		
		// --- <<IS-END>> ---

                
	}



	public static final void localinvoke (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(localinvoke)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required $service
		// [i] record:0:required pipeline
		// [o] record:0:required pipeline
		IDataCursor pidC = pipeline.getCursor();
		
		
		String service = IDataUtil.getString( pidC, "$service" );
		String folder = service.split(":")[0];
		String name = service.split(":")[1];
		IData pipe = IDataUtil.getIData(pidC, "pipeline");
		try {
			IDataUtil.put(pidC, "pipeline", Service.doInvoke(folder, name, pipe) );
			pidC.destroy();
		}  catch(Exception e) {
			pidC.destroy();
			throw new ServiceException(e);
		}
		
		// --- <<IS-END>> ---

                
	}



	public static final void localinvoke_dangerous (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(localinvoke_dangerous)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required $service
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		//IDataCursor tmpcurs = tmp.getCursor();
		String service = IDataUtil.getString( pipelineCursor, "$service" );
		String folder = service.split(":")[0];
		String name = service.split(":")[1];
		//IData pipe = IDataUtil.getIData( pipelineCursor, "pipeline");
		try {
			Service.doInvoke(folder, name, pipeline);
		}  catch(Exception e) {
			throw new ServiceException(e);
		}
		
		// --- <<IS-END>> ---

                
	}



	public static final void restorePipeline (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(restorePipeline)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required pipeXML
		// [i] field:0:optional merge {"true","false","new"}
		// [i] field:0:optional byte_encoding
		// [o] record:0:optional pipeline
		IDataCursor idc = pipeline.getCursor();
		String pipeXML = null;
		String merge = null;
		String encoding = null;
		if(idc.first("pipeXML")) {
			pipeXML = IDataUtil.getString(idc);
		}
		if(idc.first("merge")) {
			merge = IDataUtil.getString(idc);
		}
		if(idc.first("byte_encoding")) {
			encoding = IDataUtil.getString(idc);
		} else {
			encoding = "UTF-8";
		}
		
		try {
			if(merge == null || merge.equalsIgnoreCase("false")) {
				//clearPipeline(pipeline);
				Service.doInvoke("pub.flow", "clearPipeline", pipeline);
			}
			if (merge == null || merge.equalsIgnoreCase("false") || merge.equalsIgnoreCase("true") ) {
				XMLCoderWrapper xc = new XMLCoderWrapper();
				ByteArrayInputStream is = new ByteArrayInputStream(pipeXML.getBytes(encoding));
				IDataUtil.merge(xc.decode( is ), pipeline);
				is.close();
		        } else if (merge.equalsIgnoreCase("new") ){
				XMLCoderWrapper xc = new XMLCoderWrapper();
				ByteArrayInputStream is = new ByteArrayInputStream(pipeXML.getBytes(encoding));
				IData newpipe = IDataFactory.create();
				IDataUtil.merge(xc.decode( is ), newpipe);
				IDataUtil.put(idc, "pipeline", newpipe);
				is.close();
			}
		} catch(Exception e) {
			throw new ServiceException(e);
		}
		idc.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static void dropNullsSpareEmtpy(IDataCursor cursor) throws ServiceException
	{
		boolean bWasDeleted = false;
	
		if(cursor.getValue()==null )
		{
			//com.wm.app.b2b.server.ServerAPI.logError(new java.lang.Throwable(cursor.getKey()+"Deleted"));	
			if(!cursor.delete())return;
			bWasDeleted = true; 
		} else if(cursor.getValue() instanceof IData ) {
			IData idTemp = (IData)cursor.getValue();
			IDataCursor idCurs = idTemp.getCursor();
			idCurs.first();
			dropNullsSpareEmtpy(idCurs);
			idCurs.destroy();
		}
		else if(cursor.getValue() instanceof IData[])
		{
	
			ArrayList listArray = new ArrayList();
			
			IData[] idTempArray = (IData[])cursor.getValue();
			for(int i =0; i<idTempArray.length;i++)
			{
				if (idTempArray[i] != null) {
					IDataCursor idCurs = idTempArray[i].getCursor();
					idCurs.first();
					dropNullsSpareEmtpy(idCurs);
					idCurs.destroy();
					listArray.add(idTempArray[i]);
				}
			}
	
			IData[] newArray = new IData[listArray.size()];
			newArray = (IData[]) listArray.toArray(newArray);
			cursor.setValue(newArray);
		}
	
		if( bWasDeleted )
		{
			dropNullsSpareEmtpy(cursor);
		}
		else
		{
			if(cursor.next())
			{
				dropNullsSpareEmtpy(cursor);
			}	
		}
	}
	
	
	
	private static void dropNulls(IDataCursor cursor) throws ServiceException
	{
		boolean bWasDeleted = false;
	
		if(cursor.getValue()==null )
		{
			//com.wm.app.b2b.server.ServerAPI.logError(new java.lang.Throwable(cursor.getKey()+"Deleted"));	
			if(!cursor.delete())return;
			bWasDeleted = true; 
		}
		else if(cursor.getValue() instanceof String )
		{
			if( ((String)cursor.getValue()).equals("") )
			{
				if(!cursor.delete())return;
				bWasDeleted = true; 
			}
		}
		else if(cursor.getValue() instanceof IData )
		{
			IData idTemp = (IData)cursor.getValue();
			IDataCursor idCurs = idTemp.getCursor();
			idCurs.first();
			dropNulls(idCurs);
			idCurs.destroy();
		}
		else if(cursor.getValue() instanceof IData[])
		{
	
			ArrayList listArray = new ArrayList();
			
			IData[] idTempArray = (IData[])cursor.getValue();
			for(int i =0; i<idTempArray.length;i++)
			{
				if (idTempArray[i] != null) {
					IDataCursor idCurs = idTempArray[i].getCursor();
					idCurs.first();
					dropNulls(idCurs);
					idCurs.destroy();
					listArray.add(idTempArray[i]);
				}
			}
	
			IData[] newArray = new IData[listArray.size()];
			newArray = (IData[]) listArray.toArray(newArray);
			cursor.setValue(newArray);
		}
	
		if( bWasDeleted )
		{
			dropNulls(cursor);
		}
		else
		{
			if(cursor.next())
			{
				dropNulls(cursor);
			}	
		}
	}
	
	private static void dropNils(IDataCursor cursor) throws ServiceException
	{
		boolean bWasDeleted = false;
	//	com.wm.app.b2b.server.ServerAPI.logError(new java.lang.Throwable(cursor.getKey()+" Start"));	
		if(cursor.getValue() instanceof IData )
		{
			IData idTemp = (IData)cursor.getValue();
			IDataCursor idCurs = idTemp.getCursor();
	
			String str = IDataUtil.getString(idCurs, "@xsi:nil");
			if (str != null) {
				if (str.compareTo("true")==0 ) {
	//				com.wm.app.b2b.server.ServerAPI.logError(new java.lang.Throwable(cursor.getKey()+"Deleted"));	
					if(!cursor.delete())return;
					bWasDeleted = true; 
				} else {
	//				com.wm.app.b2b.server.ServerAPI.logError(new java.lang.Throwable(cursor.getKey()+" not true"));	
					idCurs.first();
					dropNils(idCurs);
				}
			} else {
	//			com.wm.app.b2b.server.ServerAPI.logError(new java.lang.Throwable(cursor.getKey()+" str null"));	
				idCurs.first();
				dropNils(idCurs);
			}
			idCurs.destroy();
		}
		else if(cursor.getValue() instanceof IData[])
		{
			IData[] idTempArray = (IData[])cursor.getValue();
			for(int i =0; i<idTempArray.length;i++)
			{
				IDataCursor idCurs = idTempArray[i].getCursor();
				idCurs.first();
				dropNils(idCurs);
				idCurs.destroy();
			}
		}
	
		if( bWasDeleted )
		{
			dropNils(cursor);
		}
		else
		{
			if(cursor.next())
			{
				dropNils(cursor);
			}	
		}
	}
	// --- <<IS-END-SHARED>> ---
}

