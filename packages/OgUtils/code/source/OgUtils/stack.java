package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2006-12-07 15:58:29 GMT
// -----( ON-HOST: si28dmzdev

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.Stack;
// --- <<IS-END-IMPORTS>> ---

public final class stack

{
	// ---( internal utility methods )---

	final static stack _instance = new stack();

	static stack _newInstance() { return new stack(); }

	static stack _cast(Object o) { return (stack)o; }

	// ---( server methods )---




	public static final void empty (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(empty)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required stack
		// [o] object:0:required stack
		// [o] field:0:required isEmpty
		IDataCursor pipelineCursor = pipeline.getCursor();
		Stack	stack = ((Stack) IDataUtil.get( pipelineCursor, "stack" ) );
		if (stack.empty() == true)
			IDataUtil.put( pipelineCursor, "isEmpty", "true" );
		else
			IDataUtil.put( pipelineCursor, "isEmpty", "false" );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void peek (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(peek)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required stack
		// [o] object:0:required stack
		// [o] field:0:required element
		IDataCursor pipelineCursor = pipeline.getCursor();
		Stack	stack = ((Stack) IDataUtil.get( pipelineCursor, "stack" ) );
		
		IDataUtil.put( pipelineCursor, "element", stack.peek().toString() );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void pop (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(pop)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required stack
		// [o] object:0:required stack
		// [o] field:0:required element
		IDataCursor pipelineCursor = pipeline.getCursor();
		Stack	stack = ((Stack) IDataUtil.get( pipelineCursor, "stack" ) );
		
		IDataUtil.put( pipelineCursor, "element", stack.pop().toString() );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void push (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(push)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required stack
		// [i] field:0:required element
		// [o] object:0:required stack
		IDataCursor pipelineCursor = pipeline.getCursor();
		Stack	stack = ((Stack) IDataUtil.get( pipelineCursor, "stack" ) );
		String	element = IDataUtil.getString( pipelineCursor, "element" );
		
		if ( stack == null)
			stack = new Stack();
		
		stack.push(element);
		
		IDataUtil.put( pipelineCursor, "stack", stack );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void toArray (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(toArray)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required stack
		// [o] object:0:required stack
		// [o] field:1:required elements
		IDataCursor pipelineCursor = pipeline.getCursor();
		Stack	stack = ((Stack) IDataUtil.get( pipelineCursor, "stack" ) );
		
		IDataUtil.put( pipelineCursor, "elements", stack.toArray(new String[1]) );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

