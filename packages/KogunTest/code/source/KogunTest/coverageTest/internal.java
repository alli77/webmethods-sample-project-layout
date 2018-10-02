package KogunTest.coverageTest;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2008-03-13 12:07:17 GMT
// -----( ON-HOST: VMISD

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.rmi.server.UID;
import com.wm.app.b2b.server.ServiceThread;
import com.wm.app.b2b.server.Package;
import com.wm.lang.ns.NSName;
import com.wm.app.b2b.server.FlowSvcImpl;
import java.lang.reflect.Method;
// --- <<IS-END-IMPORTS>> ---

public final class internal

{
	// ---( internal utility methods )---

	final static internal _instance = new internal();

	static internal _newInstance() { return new internal(); }

	static internal _cast(Object o) { return (internal)o; }

	// ---( server methods )---




	public static final void getNode2getNodes (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getNode2getNodes)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required node
		// [o] object:1:required getNodes
		IDataUtil.put(pipeline.getCursor(), "getNodes",
		((com.wm.app.b2b.server.FlowSvcImpl)IDataUtil.get(pipeline.getCursor(), "node")).getFlowRoot().getNodes() );
		// --- <<IS-END>> ---

                
	}



	public static final void getType (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getType)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required obj
		// [o] field:0:required str
		IDataUtil.put(pipeline.getCursor(), "str", IDataUtil.get(pipeline.getCursor(), "obj").toString());
		// --- <<IS-END>> ---

                
	}



	public static final void oneNode (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(oneNode)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required node
		// [o] field:0:required Count
		// [o] field:0:required Index
		// [o] field:0:required DisplayType
		// [o] field:0:required Enabled
		// [o] field:0:required hasNodes
		// [o] field:0:required Path
		// [o] object:1:required getNodes
		IDataUtil.put(pipeline.getCursor(), "Count", ""+((com.wm.lang.flow.FlowElement)IDataUtil.get(pipeline.getCursor(), "node")).getNodeCount() );
		IDataUtil.put(pipeline.getCursor(), "Index", ""+((com.wm.lang.flow.FlowElement)IDataUtil.get(pipeline.getCursor(), "node")).getNodeIndex() );
		IDataUtil.put(pipeline.getCursor(), "DisplayType", ""+((com.wm.lang.flow.FlowElement)IDataUtil.get(pipeline.getCursor(), "node")).getDisplayType() );
		IDataUtil.put(pipeline.getCursor(), "Enabled", ""+((com.wm.lang.flow.FlowElement)IDataUtil.get(pipeline.getCursor(), "node")).isEnabled() );
		IDataUtil.put(pipeline.getCursor(), "hasNodes", ""+((com.wm.lang.flow.FlowElement)IDataUtil.get(pipeline.getCursor(), "node")).hasNodes() );
		IDataUtil.put(pipeline.getCursor(), "Path", ""+((com.wm.lang.flow.FlowElement)IDataUtil.get(pipeline.getCursor(), "node")).getPath() );
		IDataUtil.put(pipeline.getCursor(), "getNodes", ((com.wm.lang.flow.FlowElement)IDataUtil.get(pipeline.getCursor(), "node")).getNodes() );
		// --- <<IS-END>> ---

                
	}
}

