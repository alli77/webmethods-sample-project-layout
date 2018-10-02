package skyrrremote;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2010-10-05 16:26:45 GMT
// -----( ON-HOST: rap.kogun.is

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.*;
import com.wm.util.coder.IDataCoder;
import com.wm.util.coder.IDataXMLCoder;
import com.wm.app.b2b.server.Service;
import com.wm.lang.ns.NSName;
import java.io.*;
import com.wm.app.b2b.client.Context;
// --- <<IS-END-IMPORTS>> ---

public final class internal

{
	// ---( internal utility methods )---

	final static internal _instance = new internal();

	static internal _newInstance() { return new internal(); }

	static internal _cast(Object o) { return (internal)o; }

	// ---( server methods )---




	public static final void BytesToPipeline (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(BytesToPipeline)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required sr_bytes
		try 
		  {
		    IDataUtil sr_util = new IDataUtil(); 
		    IDataCursor pipelineCursor = pipeline.getCursor();
		    pipelineCursor.first("sr_bytes");
		    byte[] sr_bytes = (byte [])  pipelineCursor.getValue();
		    IDataXMLCoder sr_IDataXMLCoder = new IDataXMLCoder();
		    IData sr_IData = sr_IDataXMLCoder.decodeFromBytes(sr_bytes);
		    sr_util.merge(sr_IData,pipeline);
		  }  
		catch(Exception e) 
		  {
		    throw new ServiceException(e);
		  }
		// --- <<IS-END>> ---

                
	}



	public static final void PipelineToBytes (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(PipelineToBytes)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required sr_bytes
		try 
		  {
		    IDataCursor pipelineCursor = pipeline.getCursor();
		    IDataXMLCoder sr_IDataXMLCoder = new IDataXMLCoder();
		    byte[] sr_bytes = sr_IDataXMLCoder.encodeToBytes(pipeline);
		    IDataUtil.put( pipelineCursor, "sr_bytes", sr_bytes );    
		
		  }  
		catch(Exception e) 
		  {
		    throw new ServiceException(e);
		  }
		// --- <<IS-END>> ---

                
	}



	public static final void PipelineToStream (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(PipelineToStream)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required sr_stream
		try 
		  {
		    IDataCursor pipelineCursor = pipeline.getCursor();
		    IDataXMLCoder sr_IDataXMLCoder = new IDataXMLCoder();
		    ByteArrayOutputStream sr_stream_out = new ByteArrayOutputStream();
		    sr_IDataXMLCoder.encode(sr_stream_out,pipeline);
		    ByteArrayInputStream sr_stream =  new ByteArrayInputStream(sr_stream_out.toByteArray());
		
		    IDataUtil.put( pipelineCursor, "sr_stream", sr_stream );    
		  }  
		catch(Exception e) 
		  {
		    throw new ServiceException(e);
		  }
		// --- <<IS-END>> ---

                
	}



	public static final void StreamToPipeline (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(StreamToPipeline)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required sr_stream
		try 
		  {
		    IDataUtil sr_util = new IDataUtil(); 
		    IDataCursor pipelineCursor = pipeline.getCursor();
		    pipelineCursor.first("sr_stream");
		    InputStream sr_stream = (InputStream)  pipelineCursor.getValue();
		    IDataXMLCoder sr_IDataXMLCoder = new IDataXMLCoder();
		    IData sr_IData = sr_IDataXMLCoder.decode(sr_stream);
		    sr_util.merge(sr_IData,pipeline);
		  }  
		catch(Exception e) 
		  {
		    throw new ServiceException(e);
		  }
		// --- <<IS-END>> ---

                
	}



	public static final void closeContext (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(closeContext)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required context
		try 
		  {
		    IDataCursor pipelineCursor = pipeline.getCursor();
		
		    pipelineCursor.first("context");
		    Context x = (Context)  pipelineCursor.getValue();
		
		    local_closeContext ( x ); 
		
		    IDataUtil.put( pipelineCursor, "context", null );
		  }  
		catch(Exception e) 
		  {
		    throw new ServiceException(e);
		  }
		// --- <<IS-END>> ---

                
	}



	public static final void invoke (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(invoke)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required sr_service
		try 
		  {
		    IDataCursor pipelineCursor = pipeline.getCursor();
		    pipelineCursor.first("sr_service");
		    String sr_service = (String)  pipelineCursor.getValue();
		
		    NSName n = NSName.create(sr_service);
		    
		    IData result = Service.doInvoke(n, pipeline);
		    IDataUtil.merge(result,pipeline);
		  }  
		catch(Exception e) 
		  {
		    throw new ServiceException(e);
		  }
		
		// --- <<IS-END>> ---

                
	}



	public static final void invokeContext (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(invokeContext)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required sr_server_ip
		// [i] field:0:required sr_server_port
		// [i] field:0:required sr_service
		// [i] field:0:required sr_server_user
		// [i] field:0:required sr_server_pass
		// [i] object:0:optional context
		// [i] field:0:required sr_failover_server_ip
		// [o] object:0:optional context
		try 
		  {
		    IDataCursor pipelineCursor = pipeline.getCursor();
		
		    pipelineCursor.first("sr_server_ip");
		    String sr_server_ip = (String)  pipelineCursor.getValue();
		
		    pipelineCursor.first("sr_server_port");
		    String sr_server_port = (String)  pipelineCursor.getValue();
		
		    pipelineCursor.first("sr_service");
		    String sr_service = (String)  pipelineCursor.getValue();
		
		    pipelineCursor.first("sr_server_user");
		    String sr_server_user = (String)  pipelineCursor.getValue();
		
		    pipelineCursor.first("sr_server_pass");
		    String sr_server_pass = (String)  pipelineCursor.getValue();
		
		    pipelineCursor.first("sr_failover_server_ip");
		    String sr_failover_server_ip = (String)  pipelineCursor.getValue();
		
		    boolean b;
		    Context x = null;
		
		    b = pipelineCursor.first("context");
		    if (b)
		      x = (Context)  pipelineCursor.getValue();
		    IData sr_IData;
		
		    if (x == null)
		    {
		      x = local_openContext(sr_server_ip,sr_server_port,sr_server_user,sr_server_pass,sr_failover_server_ip);
		      try
		      {
		        sr_IData = local_invokeContext (x,sr_service,pipeline);      
		      }
		      catch (Exception e)
		      {
		        local_closeContext ( x );  
		        throw new ServiceException(e);
		      }  
		      local_closeContext ( x );  
		    }
		    else
		    {
		       sr_IData = local_invokeContext (x, sr_service,pipeline);
		       IDataUtil.put( pipelineCursor, "context", x );
		    }
		    IDataUtil.merge(sr_IData,pipeline);
		  }  
		catch(Exception e) 
		  {
		    throw new ServiceException(e);
		  }
		// --- <<IS-END>> ---

                
	}



	public static final void openContext (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(openContext)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required sr_server_ip
		// [i] field:0:required sr_server_port
		// [i] field:0:required sr_service
		// [i] field:0:required sr_server_user
		// [i] field:0:required sr_server_pass
		// [i] field:0:required sr_failover_server_ip
		// [o] object:0:required context
		try 
		  {
		    IDataCursor pipelineCursor = pipeline.getCursor();
		
		    pipelineCursor.first("sr_server_ip");
		    String sr_server_ip = (String)  pipelineCursor.getValue();
		
		    pipelineCursor.first("sr_server_port");
		    String sr_server_port = (String)  pipelineCursor.getValue();
		
		    pipelineCursor.first("sr_service");
		    String sr_service = (String)  pipelineCursor.getValue();
		
		    pipelineCursor.first("sr_server_user");
		    String sr_server_user = (String)  pipelineCursor.getValue();
		
		    pipelineCursor.first("sr_server_pass");
		    String sr_server_pass = (String)  pipelineCursor.getValue();
		
		    pipelineCursor.first("sr_failover_server_ip");
		    String sr_failover_server_ip = (String)  pipelineCursor.getValue();
		
		    Context x = local_openContext(sr_server_ip,sr_server_port,sr_server_user,sr_server_pass,sr_failover_server_ip);
		
		    IDataUtil.put( pipelineCursor, "context", x );
		  }  
		catch(Exception e) 
		  {
		    throw new ServiceException(e);
		  }
		
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static Context local_openContext (
	  String server, String port,
	  String userName,
	  String password,
	  String failoverserver ) throws ServiceException
	{
	  try 
	  {
	    String serverport = server+":"+port;
	    Context x = new Context();
	    x.setRetryServer(failoverserver+":"+port);
	    x.connect(serverport, userName, password);
	
	    return x;
	  }
	  catch(Exception e) 
	  {
	    throw new ServiceException(e);
	  }
	}
	
	public static void local_closeContext (
	  Context x ) throws ServiceException
	{
	  try 
	  {
	    x.disconnect();
	    x = null;
	  }
	  catch(Exception e) 
	  {
	    throw new ServiceException(e);
	  }
	}
	
	public static IData local_invokeContext (
	  Context x, String service, IData data ) throws ServiceException
	{
	  try 
	  {
	    // parse the string
	    String[] z = service.split(":");
	    String packageName = z[0];
	    String serviceName = z[1];
	    return x.invoke(packageName, serviceName, data);
	  }
	  catch(Exception e) 
	  {
	    throw new ServiceException(e);
	  }
	}
	
	// --- <<IS-END-SHARED>> ---
}

