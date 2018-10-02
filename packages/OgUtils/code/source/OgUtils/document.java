package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2012-09-06 12:35:55 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.ArrayList;
// --- <<IS-END-IMPORTS>> ---

public final class document

{
	// ---( internal utility methods )---

	final static document _instance = new document();

	static document _newInstance() { return new document(); }

	static document _cast(Object o) { return (document)o; }

	// ---( server methods )---




	public static final void DocList2KeyedList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(DocList2KeyedList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required List
		// [i] field:0:required Key
		// [o] record:0:required KeyedList
		/**************************************************************************
		 * Copy this to the Web Methods Java DocList2KeyedList Flow
		 */
		    
		// Constants
		final String VarNameList = "List";
		final String VarNameKey = "Key";
		final String VarNameKeyedList = "KeyedList";
		    
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		
		// Try to get the document List
		IData[] docList = IDataUtil.getIDataArray(idc, VarNameList);
		
		// Try to get the key
		String key = IDataUtil.getString(idc, VarNameKey);
		
		// Check input for null
		if(docList == null || key == null)
		{
		  idc.destroy();
		  return;
		}
		
		// Create output candiate
		IData keyedList = IDataFactory.create();
		IDataCursor keyedListCurs = keyedList.getCursor();
		
		// Variables to use in walking
		String KeyValue;
		
		// Walk the list
		int length = docList.length;
		for(int i = 0; i < length; i++)
		{
		  IData doc = docList[i];
		  IDataCursor docCurs = doc.getCursor();
		  
		  // Get and check the key
		  if((KeyValue = IDataUtil.getString(docCurs, key)) != null)
		    IDataUtil.put(keyedListCurs, KeyValue, doc);
		  
		  // Document Cursor Clean Up
		  docCurs.destroy();
		}
		
		// Add the keyed document to the pipeline
		IDataUtil.put(idc, VarNameKeyedList, keyedList);
		        
		// Clean up
		keyedListCurs.destroy();
		idc.destroy();
		    
		/*
		 * Web Methods Java DocList2KeyedList Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void Document_add (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(Document_add)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required InputDocument
		// [i] object:0:required object2add
		// [i] object:1:required objectlist2add
		// [i] field:0:required key2add
		// [o] record:0:required OutputDocument
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		IData	InputDocument = IDataUtil.getIData( pipelineCursor, "InputDocument" );
		Object	object2add = IDataUtil.get( pipelineCursor, "object2add" );
		Object[] objectlist2add = IDataUtil.getObjectArray( pipelineCursor, "objectlist2add" );
		String	key2add = IDataUtil.getString( pipelineCursor, "key2add" );
		
		if ( InputDocument == null) {
			InputDocument = IDataFactory.create();
			IDataCursor IDC = InputDocument.getCursor();
			if (object2add != null)
				IDataUtil.put(IDC, key2add, object2add);
			else
				IDataUtil.put(IDC, key2add, objectlist2add);
			IDC.destroy();
		} else {
			IDataCursor IDC = InputDocument.getCursor();
			IDC.last();
			if (object2add != null)
				IDC.insertAfter(key2add, object2add);
			else
				IDC.insertAfter(key2add, objectlist2add);
			IDC.destroy();
		}
		
		IDataUtil.put( pipelineCursor, "OutputDocument", InputDocument );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void GetFromKeyedList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(GetFromKeyedList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required KeyedList
		// [i] field:0:required Key
		// [o] record:0:required Doc
		/**************************************************************************
		 * Copy this to the Web Methods Java GetFromKeyedList Flow
		 */
		    
		// Constants
		final String VarNameKey = "Key";
		final String VarNameKeyedList = "KeyedList";
		final String VarNameDocument = "Doc";
		    
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		
		// Try to get the keyed List
		IData keyedList = IDataUtil.getIData(idc, VarNameKeyedList);
		
		// Try to get the key
		String key = IDataUtil.getString(idc, VarNameKey);
		
		// Check input for null
		if(keyedList == null || key == null)
		{
		  idc.destroy();
		  return;
		}
		
		// Get keyed List Cursor
		IDataCursor keyedListCurs = keyedList.getCursor();
		if(keyedListCurs == null)
		  throw new ServiceException("Failed to get cursor for KeyedList");
		
		IData theDoc = IDataUtil.getIData(keyedListCurs, key);
		
		// Add the keyed document to the pipeline
		IDataUtil.put(idc, VarNameDocument, theDoc);
		        
		// Clean up
		keyedListCurs.destroy();
		idc.destroy();
		    
		/*
		 * Web Methods Java GetFromKeyedList Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void IDataCursor_destroy (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataCursor_destroy)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DocumentCursor
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataCursor DocumentCursor = ((IDataCursor) IDataUtil.get( pipelineCursor, "DocumentCursor" ) );
		DocumentCursor.destroy();
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataCursor_first (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataCursor_first)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DocumentCursor
		// [o] field:0:required first
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataCursor DocumentCursor = ((IDataCursor) IDataUtil.get( pipelineCursor, "DocumentCursor" ) );
		IDataUtil.put( pipelineCursor, "first", ""+DocumentCursor.first() );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataCursor_getValue (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataCursor_getValue)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DocumentCursor
		// [o] field:0:required key
		// [o] field:0:required value
		// [o] record:0:required Document
		// [o] record:1:required DocumentList
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataCursor DocumentCursor = ((IDataCursor) IDataUtil.get( pipelineCursor, "DocumentCursor" ) );
		
		IDataUtil.remove(pipelineCursor, "value");
		IDataUtil.remove(pipelineCursor, "Document");
		IDataUtil.remove(pipelineCursor, "DocumentList");
		
		IDataUtil.put(pipelineCursor, "key", DocumentCursor.getKey());
		
		if(DocumentCursor.getValue() instanceof IData)
			IDataUtil.put(pipelineCursor, "Document", DocumentCursor.getValue());
		else if(DocumentCursor.getValue() instanceof IData[])
			IDataUtil.put(pipelineCursor, "DocumentList", DocumentCursor.getValue());
		else 
			IDataUtil.put(pipelineCursor, "value", DocumentCursor.getValue());
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataCursor_getValueByKey (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataCursor_getValueByKey)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DocumentCursor
		// [i] field:0:required key
		// [o] field:0:required value
		// [o] record:0:required Document
		// [o] record:1:required DocumentList
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataCursor DocumentCursor = ((IDataCursor) IDataUtil.get( pipelineCursor, "DocumentCursor" ) );
		String key = IDataUtil.getString(pipelineCursor, "key");
		IDataUtil.remove(pipelineCursor, "value");
		IDataUtil.remove(pipelineCursor, "Document");
		IDataUtil.remove(pipelineCursor, "DocumentList");
		
		if(IDataUtil.get(DocumentCursor,key) instanceof IData)
			IDataUtil.put(pipelineCursor, "Document", IDataUtil.get(DocumentCursor,key));
		else if(IDataUtil.get(DocumentCursor,key) instanceof IData[])
			IDataUtil.put(pipelineCursor, "DocumentList", IDataUtil.get(DocumentCursor,key));
		else 
			IDataUtil.put(pipelineCursor, "value", IDataUtil.get(DocumentCursor,key));
		
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataCursor_last (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataCursor_last)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DocumentCursor
		// [o] field:0:required last
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataCursor DocumentCursor = ((IDataCursor) IDataUtil.get( pipelineCursor, "DocumentCursor" ) );
		IDataUtil.put( pipelineCursor, "last", ""+DocumentCursor.last() );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataCursor_next (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataCursor_next)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DocumentCursor
		// [i] field:0:optional next_key
		// [o] field:0:required hasNext
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataCursor DocumentCursor = ((IDataCursor) IDataUtil.get( pipelineCursor, "DocumentCursor" ) );
		String key = IDataUtil.getString(pipelineCursor, "next_key");
		if (key == null) {
			if (DocumentCursor.next() == true)
				IDataUtil.put( pipelineCursor, "hasNext", "true" );
			else 
				IDataUtil.put( pipelineCursor, "hasNext", "false" );
		} else {
			if (DocumentCursor.next(key) == true)
				IDataUtil.put( pipelineCursor, "hasNext", "true" );
			else 
				IDataUtil.put( pipelineCursor, "hasNext", "false" );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataCursor_setKey (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataCursor_setKey)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DocumentCursor
		// [i] field:0:required key
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataCursor DocumentCursor = ((IDataCursor) IDataUtil.get( pipelineCursor, "DocumentCursor" ) );
		String key= IDataUtil.getString(pipelineCursor, "key");
		DocumentCursor.setKey(key);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataCursor_setValue (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataCursor_setValue)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DocumentCursor
		// [i] object:0:required Value
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataCursor DocumentCursor = ((IDataCursor) IDataUtil.get( pipelineCursor, "DocumentCursor" ) );
		Object Value= IDataUtil.get(pipelineCursor, "Value");
		DocumentCursor.setValue(Value);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataCursor_size (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataCursor_size)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DocumentCursor
		// [i] record:0:required Document
		// [i] field:0:required returnList {"true","false"}
		// [o] field:1:required List
		// [o] field:0:required size
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataCursor cur;
		IData Document = IDataUtil.getIData( pipelineCursor, "Document");
		String returnList = IDataUtil.getString(pipelineCursor, "returnList");
		int size = 0;
		if (Document != null) {
			cur=Document.getCursor();
		} else {
			cur = ((IDataCursor) IDataUtil.get( pipelineCursor, "DocumentCursor" ) );
		}
		if (returnList == null) {
			returnList="false";
		}
		if (cur != null) {
			size=IDataUtil.size(cur);
			if (returnList.compareTo("true")==0) {
				String List[] = new String[size];
				for(int len=0; len<size; len++)
					List[len]=""+len;
				IDataUtil.put(pipelineCursor, "List", List);
			} 
		}
		if (Document != null) {
			cur.destroy();
		}
		IDataUtil.put(pipelineCursor, "size", ""+size);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_equals (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_equals)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Doc1
		// [i] record:0:required Doc2
		// [o] field:0:required equals
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData	Document1 = IDataUtil.getIData( pipelineCursor, "Doc1" );
		IData	Document2 = IDataUtil.getIData( pipelineCursor, "Doc2" );
		
		IDataUtil.put(pipelineCursor, "equals", ""+IDataUtil.equals(Document1, Document2));
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_get (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_get)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Document
		// [i] field:0:required Key
		// [o] object:0:required Object
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData	Document = IDataUtil.getIData( pipelineCursor, "Document" );
		String	Key = IDataUtil.getString( pipelineCursor, "Key" );
		if ( Document != null) {
			IDataCursor IDC = Document.getCursor();
			
			IDataUtil.put(pipelineCursor, "Object", IDataUtil.get(IDC, Key));
		
			IDC.destroy();
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_getCursor (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_getCursor)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Document
		// [o] object:0:required DocumentCursor
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData Document = IDataUtil.getIData( pipelineCursor, "Document" );
		if ( Document != null) {
			IDataUtil.put( pipelineCursor, "DocumentCursor", Document.getCursor() );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_getObjectArray_fromdoc_put_intopipe (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_getObjectArray_fromdoc_put_intopipe)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Document
		// [i] field:0:required GetLabel
		// [i] field:0:required PutLabel
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData Document = IDataUtil.getIData( pipelineCursor, "Document" );
		if ( Document != null) {
			String	GetLabel = IDataUtil.getString( pipelineCursor, "GetLabel" );
			IDataCursor dC=Document.getCursor();
			Object[] object = IDataUtil.getObjectArray( dC, GetLabel );
			dC.destroy();
			String	PutLabel = IDataUtil.getString( pipelineCursor, "PutLabel" );
			IDataUtil.put(pipelineCursor, PutLabel, object);
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_get_first_key (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_get_first_key)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required key_below
		// [i] field:0:optional count
		// [o] field:0:required key
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData	DocumentDT = IDataUtil.getIData( pipelineCursor, "key_below" );
		String count = IDataUtil.getString( pipelineCursor, "count");
		if (count == null)
			count="0";
		int cnt = Integer.parseInt(count);
		if ( DocumentDT != null) {
			IDataCursor docC = DocumentDT.getCursor();
			docC.first();
			for (int i=0; i<cnt; i++)
				docC.next();
			IDataUtil.put( pipelineCursor, "key", docC.getKey() );
		}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_get_fromdoc_put_intopipe (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_get_fromdoc_put_intopipe)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Document
		// [i] field:0:required GetLabel
		// [i] field:0:required PutLabel
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData Document = IDataUtil.getIData( pipelineCursor, "Document" );
		if ( Document != null) {
			String	GetLabel = IDataUtil.getString( pipelineCursor, "GetLabel" );
			IDataCursor dC=Document.getCursor();
			Object	object = IDataUtil.get( dC, GetLabel );
			dC.destroy();
			String	PutLabel = IDataUtil.getString( pipelineCursor, "PutLabel" );
			IDataUtil.put(pipelineCursor, PutLabel, object);
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_pipeline_getCursor (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_pipeline_getCursor)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required pipelineCursor
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put(pipelineCursor, "pipelineCursor", pipelineCursor);
		
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_put (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_put)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Document
		// [i] object:0:required object
		// [i] object:1:required objectlist
		// [i] field:0:required Label
		// [o] record:0:required Document
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData	Document = IDataUtil.getIData( pipelineCursor, "Document" );
		Object	object = IDataUtil.get( pipelineCursor, "object" );
		Object[] objectlist = IDataUtil.getObjectArray( pipelineCursor, "objectlist" );
		String	Label = IDataUtil.getString( pipelineCursor, "Label" );
		if ( Document != null) {
			IDataCursor IDC = Document.getCursor();
			if (object != null)
				IDataUtil.put(IDC, Label, object);
			else
				IDataUtil.put(IDC, Label, objectlist);
			IDC.destroy();
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_put_intopipe (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_put_intopipe)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required object
		// [i] field:0:required Label
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object	object = IDataUtil.get( pipelineCursor, "object" );
		String	Label = IDataUtil.getString( pipelineCursor, "Label" );
			IDataUtil.put(pipelineCursor, Label, object);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_remove (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_remove)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Document
		// [i] field:0:required Key
		// [o] record:0:required Document
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData	Document = IDataUtil.getIData( pipelineCursor, "Document" );
		String	Key = IDataUtil.getString( pipelineCursor, "Key" );
		if ( Document != null) {
			IDataCursor IDC = Document.getCursor();
			
			IDataUtil.remove(IDC, Key);
		
			IDC.destroy();
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IDataUtil_removeAttrubute (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IDataUtil_removeAttrubute)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Unt@itled
		// [i] - field:0:required @string
		// [i] - record:1:required @stuff
		// [i] -- field:0:required @scat
		// [i] -- field:0:required @crapp
		// [o] record:0:required Untitled3
		IDataCursor pipelineCursor = pipeline.getCursor();
		removeAttribute(pipelineCursor);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void KeyedList2DocList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(KeyedList2DocList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required KeyedList
		// [o] record:1:required List
		// [o] - field:0:required Key
		// [o] - field:0:required Value
    // Pipeline
    IDataCursor pipelineCursor = pipeline.getCursor();
    
    // Featch input parameters
    IData doc = IDataUtil.getIData(pipelineCursor, "KeyedList");
 
    if(doc == null) return;
 
    IDataCursor c = doc.getCursor();

    ArrayList list = new ArrayList();
    
      while(c.next())
      {
	IData item = IDataFactory.create();
	IDataCursor ic = item.getCursor();
	IDataUtil.put(ic,"Value", c.getValue());
	IDataUtil.put(ic,"Key", c.getKey());
	list.add(item);
	ic.destroy();
      }
    IData[] List = new IData[list.size()];

    list.toArray((Object[])List);

    IDataUtil.put(pipelineCursor, "List", List);
    c.destroy();    
    pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void Merge_Document (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(Merge_Document)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required src
		// [i] record:0:required dst
		// [o] record:0:required src
		// [o] record:0:required dst
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData src = IDataUtil.getIData( pipelineCursor, "src" );
		IData dst = IDataUtil.getIData( pipelineCursor, "dst");
		IDataUtil.merge(src, dst ) ;
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void compareDocuments (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(compareDocuments)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required document1
		// [i] record:0:required document2
		// [o] field:0:required isEqual
		// [o] field:0:required errorMsg
		IDataCursor pipelineCursor = pipeline.getCursor();
		String errorMsg = "";
		boolean bIsEqual = false;
		IData result = IDataFactory.create();
		IDataCursor rC=result.getCursor();
		IDataUtil.put(rC, "out", "");
		IData	document1 = IDataUtil.getIData( pipelineCursor, "document1" );
		IData	document2 = IDataUtil.getIData( pipelineCursor, "document2" );
		
		if ( document1 == null && document2 == null)
		{
			bIsEqual = true;
		}
		else if ( document1 == null || document2 == null)
		{
			bIsEqual = false;
		}
		else
		{
		IDataCursor dC1=document1.getCursor();
		IDataCursor dC2=document2.getCursor();
		IDataCursor dC1x=document2.getCursor();
		IDataCursor dC2x=document1.getCursor();
		
			try{
		
		//	IDataUtil.put(rC, "out", IDataUtil.getString(rC, "out")+"\n start");	
			bIsEqual = compareDocs( dC1, dC2, rC );	
			if (bIsEqual == true) {
		//		IDataUtil.put(rC, "out", IDataUtil.getString(rC, "out")+"\n start second ");	
				bIsEqual = compareDocs( dC1x, dC2x , rC );	
			}
			}catch(Exception e) {
				errorMsg += e.getMessage();
				bIsEqual = false;
			}
		dC1.destroy();
		dC2.destroy();
		dC1x.destroy();
		dC2x.destroy();
		}
		
		IDataUtil.put( pipelineCursor, "isEqual", bIsEqual?"true":"false" );
		IDataUtil.put( pipelineCursor, "errorMsg", IDataUtil.getString(rC, "out" ) );
		rC.destroy();
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void hasMoreData (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(hasMoreData)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DocumentCursor
		// [o] field:0:required hasMoreData
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataCursor DocumentCursor = ((IDataCursor) IDataUtil.get( pipelineCursor, "DocumentCursor" ) );
		if (DocumentCursor.hasMoreData() == true)
			IDataUtil.put( pipelineCursor, "hasMoreData", "true" );
		else 
			IDataUtil.put( pipelineCursor, "hasMoreData", "false" );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static boolean compareDocs(IDataCursor curs1, IDataCursor curs2, IDataCursor errorMsg) {
		if(curs1 ==null || curs2 == null)
			return true;
		if(!curs1.next()) {
			return true;
		} else  {
			String strKey = curs1.getKey();
	//	IDataUtil.put(errorMsg, "out", IDataUtil.getString(errorMsg, "out")+"\n Start ["+strKey+"] "+((String)curs1.getValue())+" " +((String)curs2.getValue()) );	
			if( !curs2.first(strKey) ) {
				IDataUtil.put(errorMsg, "out", IDataUtil.getString(errorMsg, "out")+"\n key not match ["+strKey+"] not in other doc ");
				return false;
			}
			if(curs1.getValue() instanceof String)
			{
				if( ((String)curs1.getValue()).equals( ((String)curs2.getValue()) ) == false ) {
					IDataUtil.put(errorMsg, "out", IDataUtil.getString(errorMsg, "out")+"\n value in "+strKey+" not match ["+((String)curs1.getValue())+"] !=["+((String)curs2.getValue())+"] ");
					return false;
				} else {
	
	//	IDataUtil.put(errorMsg, "out", IDataUtil.getString(errorMsg, "out")+"\n key match ["+strKey+"] "+((String)curs1.getValue())+" " +((String)curs2.getValue()) );	
					
				}
			}
			if(curs1.getValue() instanceof IData)
			{
				IData idStuff = ((IData) curs1.getValue());
				IData idStuff2 = ((IData)curs2.getValue());
	
				IDataCursor stuffCursor =idStuff.getCursor();			
				IDataCursor stuffCursor2 =idStuff2.getCursor();			
				boolean test = compareDocs(stuffCursor,stuffCursor2, errorMsg);
				stuffCursor.destroy();
				stuffCursor2.destroy();
				if (test == false)
					return false;
			}
			if(curs1.getValue() instanceof IData[])
			{
				IData[] idStuffArr = ((IData[]) curs1.getValue());
				IData[] idStuff2Arr = ((IData[])curs2.getValue());		
		
				for (int i=0; i<idStuffArr.length; i++) {
					IData idStuff = idStuffArr[i];
					IData idStuff2 = idStuff2Arr[i];
		
					IDataCursor stuffCursor =idStuff.getCursor();			
					IDataCursor stuffCursor2 =idStuff2.getCursor();			
					boolean test = compareDocs(stuffCursor,stuffCursor2, errorMsg);
					stuffCursor.destroy();
					stuffCursor2.destroy();
					if (test == false)
						return false;
				}
		
			}
			return compareDocs(curs1,curs2, errorMsg);
		}
		
		
	}
	
	
	
	public static void removeAttribute(IDataCursor cursor)
	{
		if(!cursor.next())
			return;
		String strKey = cursor.getKey();
		cursor.setKey(strKey.replaceFirst("@",""));
		if(cursor.getValue() instanceof IData)
		{
			IData idData = (IData)cursor.getValue();
			IDataCursor cursor2 = idData.getCursor();
			removeAttribute(cursor2);
			return;
		}
		else if(cursor.getValue() instanceof IData[])
		{
			IData[] idDataArray = (IData[])cursor.getValue();
			for(int i=0;i<idDataArray.length;i++)
			{
				IDataCursor cursor2 = idDataArray[i].getCursor();
				removeAttribute(cursor2);
			}
			return;
		}
		else
		{
			removeAttribute(cursor);
			return;
		}
	}
	
	
	
	// --- <<IS-END-SHARED>> ---
}

