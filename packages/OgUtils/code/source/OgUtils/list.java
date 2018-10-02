package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2013-05-06 09:23:27 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.HashMap;
// --- <<IS-END-IMPORTS>> ---

public final class list

{
	// ---( internal utility methods )---

	final static list _instance = new list();

	static list _newInstance() { return new list(); }

	static list _cast(Object o) { return (list)o; }

	// ---( server methods )---




	public static final void ObjectArray2iDataArray (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ObjectArray2iDataArray)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:1:required Objects
		// [o] record:1:required IDatas
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object[] array = ((Object[]) IDataUtil.get( pipelineCursor, "Objects"  ));
		IData[] IDatas = ((IData[]) array);
		IDataUtil.put( pipelineCursor, "IDatas", IDatas );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void arrayToList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(arrayToList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:1:required array
		// [o] object:0:required list
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object[] array = IDataUtil.getObjectArray( pipelineCursor, "array" );
		java.util.List lList = null;
		
		if(array != null)
		{//NOTE: This might seems to be stupid to make new ArrayList, while the asList function
		//is supposed to return java.util.List. But this is necessary. The asList function returns
		//java.util.Arrays$ArrayList, which is just a mapping on top of the array. Therfore the 
		//functions add en remove doesnot work for it. By newing the ArrayList you get a proper
		//full functional ArrayList. SO DONT REMOVE THE "new java.util.ArrayList" OR YOU WILL DIE.
			lList = new java.util.ArrayList( java.util.Arrays.asList(array));
			IDataUtil.put( pipelineCursor, "list", lList );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void documentsToList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(documentsToList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required pipeline
		// [o] record:1:required documents
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData pipe = IDataUtil.getIData(pipelineCursor,"pipeline");
		if (pipe != null ) {
			IDataCursor pCursor = pipe.getCursor();
			java.util.ArrayList alDocs = new java.util.ArrayList();
		
			while(pCursor.next()) {
				if(pCursor.getValue() instanceof IData)	{
					alDocs.add(pCursor.getValue());
				}
			}
		
			if (alDocs.size() > 0) {
				IData[]	documents = (IData[])alDocs.toArray(new IData[alDocs.size()]);
				IDataUtil.put( pipelineCursor, "documents", documents );
			}
			pCursor.destroy();
		}
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void filterDocumentList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(filterDocumentList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required InList
		// [i] field:1:required Filter
		// [i] field:0:required Key
		// [o] record:1:required OutList
		/**************************************************************************
		 * Copy this to the Web Methods Java filterDocumentList Flow
		 */
		    
		// Constants
		final String VarNameInList = "InList";
		final String VarNameOutList = "OutList";
		final String VarNameFilter = "Filter";
		final String VarNameKey = "Key";
		    
		// Initialize pipeline cursor
		IDataCursor idc = pipeline.getCursor();
		
		// Try to get the input
		IData[] inlist = IDataUtil.getIDataArray(idc, VarNameInList);
		String[] filter = IDataUtil.getStringArray(idc, VarNameFilter);
		String key = IDataUtil.getString(idc, VarNameKey);
		
		// Check input for null or empty lists
		if(inlist == null || filter == null || inlist.length == 0 || filter.length == 0)
		{
		  idc.destroy();
		  return;
		}
		
		// Check key input for null or empty string
		if(key == null || key.length() == 0)
		{
		  idc.destroy();
		  throw new ServiceException("Key is missing or empty string");
		}
		
		// Convert filter to list
		java.util.ArrayList filterlist = new java.util.ArrayList();
		for(int n = filter.length - 1; n >= 0; n--)
		  filterlist.add(filter[n]);
		
		// Create the output array
		java.util.ArrayList outarray = new java.util.ArrayList();
		
		// Walk the In List
		int length = inlist.length;
		for(int i = 0; i < length; i++)
		{
		  // Skip item if it is null
		  if(inlist[i] == null) continue;
		  IDataCursor item = inlist[i].getCursor();
		  if(filterlist.contains(IDataUtil.getString(item, key)))
		    outarray.add(inlist[i]);
		  item.destroy(); // Clean up item
		}
		
		// If output array is not empty add the array to the pipeline
		if(!outarray.isEmpty())
		{
		  IData[] outlist = new IData[outarray.size()];
		  outarray.toArray(outlist);
		  IDataUtil.put(idc, VarNameOutList, outlist);
		}
		        
		// Clean up
		idc.destroy();
		    
		/*
		 * Web Methods Java filterDocumentList Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void get (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(get)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required list
		// [i] field:0:required index
		// [o] object:0:required element
		IDataCursor pipelineCursor = pipeline.getCursor();
		java.util.List list =(java.util.List) IDataUtil.get( pipelineCursor, "list" );
		String strIndex = IDataUtil.getString( pipelineCursor, "index" );
		int nIndex = -1;
		if(strIndex!=null && strIndex.matches("\\A\\d+\\Z"))
		{
			nIndex = Integer.parseInt(strIndex);
		}
		else
		{
			throw new ServiceException("Invalid format of index");
		}
		
		if(list!=null)
		{
			IDataUtil.put( pipelineCursor, "element", list.get(nIndex) );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void listsTotalSize (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(listsTotalSize)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required pipe
		// [o] field:0:required totalSizeOfLists
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData	pipe = IDataUtil.getIData( pipelineCursor, "pipe" );
		int nTotalSizeOfLists=0;
		if ( pipe != null)
		{
			IDataCursor pipeCursor = pipe.getCursor();
			
			while(pipeCursor.next())
			{
				if(pipeCursor.getValue() instanceof Object[])
				{
					nTotalSizeOfLists += ((Object[])pipeCursor.getValue()).length;
				}
			}
			pipeCursor.destroy();
		}
		
		IDataUtil.put( pipelineCursor, "totalSizeOfLists", nTotalSizeOfLists+"" );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void remove (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(remove)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required list
		// [i] field:0:required index
		// [o] object:0:required element
		IDataCursor pipelineCursor = pipeline.getCursor();
		java.util.List list =(java.util.List) IDataUtil.get( pipelineCursor, "list" );
		String strIndex = IDataUtil.getString( pipelineCursor, "index" );
		int nIndex = -1;
		if(strIndex!=null && strIndex.matches("\\A\\d+\\Z"))
		{
			nIndex = Integer.parseInt(strIndex);
		}
		else
		{
			throw new ServiceException("Invalid format of index");
		}
		
		if(list!=null)
		{
			IDataUtil.put( pipelineCursor, "element", list.remove(nIndex) );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void size (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(size)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required list
		// [o] field:0:required size
		IDataCursor pipelineCursor = pipeline.getCursor();
		java.util.List list =(java.util.List) IDataUtil.get( pipelineCursor, "list" );
		if(list!=null)
			IDataUtil.put( pipelineCursor, "size", list.size()+"" );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void updateItem (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(updateItem)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required list
		// [i] record:0:required item
		// [i] field:0:required index
		// [o] record:1:required list
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		// list
		IData[]	list = IDataUtil.getIDataArray( pipelineCursor, "list" );
		String strIndex = IDataUtil.getString( pipelineCursor, "index");
		
		IData item = IDataUtil.getIData( pipelineCursor, "item" );;
		
		try {
		  int index = Integer.parseInt(strIndex);
		
		  list[index] = item;
		
		}
		catch(NumberFormatException e) {
			throw new ServiceException(e.getMessage());
		}
		
		IDataUtil.put( pipelineCursor, "list", list );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

