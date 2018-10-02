package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2009-09-22 10:55:00 GMT
// -----( ON-HOST: wmisdev

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.data.IDataUtil;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class documentlist

{
	// ---( internal utility methods )---

	final static documentlist _instance = new documentlist();

	static documentlist _newInstance() { return new documentlist(); }

	static documentlist _cast(Object o) { return (documentlist)o; }

	// ---( server methods )---




	public static final void DocumentListDynamicKeyNames (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(DocumentListDynamicKeyNames)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required document
		// [i] field:1:required oldcolumnnames
		// [i] field:1:required newcolumnnames
		// [i] field:0:optional isAttribute {"true","false"}
		// [i] field:0:optional legalXml {"true","false"}
		// [o] record:1:required document
		IDataCursor pipelineCursor = pipeline.getCursor();
		String[] oldcolumnnames = IDataUtil.getStringArray( pipelineCursor, "oldcolumnnames" );
		String[] newcolumnnames = IDataUtil.getStringArray( pipelineCursor, "newcolumnnames" );
		String SisAttribute = IDataUtil.getString(pipelineCursor, "isAttribute");
		String SlegalXml = IDataUtil.getString(pipelineCursor, "legalXml");
		boolean isAttribute = false;
		if (SisAttribute==null)
			isAttribute = false;
		else if (SisAttribute.equals("true") )
			isAttribute = true;
		if (SlegalXml!=null)
			if (SlegalXml.equals("true") ) {
				for (int i = 0; i<newcolumnnames.length; i++) {
					newcolumnnames[i]=newcolumnnames[i].replaceAll(" ", "_");
				}
			}
		
		IData[]	document = IDataUtil.getIDataArray( pipelineCursor, "document" );
		if ( document != null) {
			IData[]	document2 = new IData[document.length];
			for ( int i = 0; i < document.length; i++ ) {
		if (document[i] != null ) {
				document2[i]=IDataFactory.create();
				for ( int j = 0; j<oldcolumnnames.length; j++) {
		IDataCursor idc2 = document2[i].getCursor();
		IDataCursor idc = document[i].getCursor();
					if (isAttribute)
						IDataUtil.put(idc2,	newcolumnnames[j],IDataUtil.get(idc,"@"+oldcolumnnames[j]));
					else
						IDataUtil.put(idc2,	newcolumnnames[j],IDataUtil.get(idc,oldcolumnnames[j]));
		idc.destroy();
		idc2.destroy();	
				}
		
		}
			}
			IDataUtil.put( pipelineCursor, "document", document2 );
		}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void categoriseDocument (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(categoriseDocument)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required list
		// [i] field:0:required attr
		// [i] field:1:required categories
    // Pipeline
    IDataCursor pipelineCursor = pipeline.getCursor();
    
    // Featch input parameters
    IData[] list = IDataUtil.getIDataArray(pipelineCursor, "list");
    String attr = IDataUtil.getString(pipelineCursor, "attr");
    String[] categories = IDataUtil.getStringArray(pipelineCursor, "categories");

    // Check the attr string
    if(attr == null)
      throw new ServiceException("Unable to featch attr");
    
    // Check the list length
    if(list == null)
      throw new ServiceException("Unable to featch list");
    int lengthList = list.length;
    if(lengthList == 0) return;
    
    // Check the cateogories length
    if(categories == null)
      throw new ServiceException("Unable to featch categories");
    int lengthCategories = categories.length;
    if (lengthCategories == 0) return;

    // Declare and create some vars
    int counters[] = new int[lengthCategories + 1];
    IDataCursor c = null;
    String v;
    boolean f;

    // Create temporary table and the real table
    IData[][] table = new IData[lengthCategories + 1][];
    IData[][] tmp = new IData[lengthCategories + 1][];
    for(int n = lengthCategories; n >= 0; n--)
      tmp[n] = new IData[lengthList];

    // Classify the list
    for(int n = 0; n < lengthList; n++)
    {
      f = false;
      c = list[n].getCursor();
      v = IDataUtil.getString(c, attr);
      if(v != null)
      {
        for(int i = lengthCategories - 1; i >= 0; i--)
        {
          if(categories[i].compareTo(v) == 0)
            {
              tmp[i][counters[i]++] = list[n];
              f = true;
            }
        }
      }
      // If item can not be classified to any category then put it in the
      // put it into the last one
      if(!f) tmp[lengthCategories][counters[lengthCategories]++] = list[n];
    }

    // Create the result holder
    //IData result = IDataFactory.create(lengthCategories + 1);
    //c = result.getCursor();
    
    // Create the result document
    IData[] tmplist;
    for(int i = lengthCategories - 1; i >= 0; i--)
    {
      if(counters[i] > 0)
      {
        tmplist = new IData[counters[i]];
        for(int n = 0; n < counters[i]; n++)
          tmplist[n] = tmp[i][n];
        IDataUtil.put(pipelineCursor, categories[i], tmplist);
      }
    }
    
    // Add the unclassified list to the document
    tmplist = new IData[counters[lengthCategories]];
    for (int n = 0; n < counters[lengthCategories]; n++)
      tmplist[n] = tmp[lengthCategories][n];
    IDataUtil.put(pipelineCursor, "_unclassified_", tmplist);
    
    // put the result into the pipelien
    //IDataUtil.put(pipelineCursor, "result", result);
        
    pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void documentToStringArray (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(documentToStringArray)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required doc
		// [i] field:0:optional values
		// [i] field:0:optional skipNullOrEmpty
		// [o] field:1:required list
    // Pipeline
    IDataCursor pipelineCursor = pipeline.getCursor();
    
    // Featch input parameters
    IData doc = IDataUtil.getIData(pipelineCursor, "doc");
    String values = IDataUtil.getString(pipelineCursor, "values");
    String skipNullOrEmpty = IDataUtil.getString(pipelineCursor, "skipNullOrEmpty");
 
    if(doc == null) return;
 
    IDataCursor c = doc.getCursor();
    ArrayList list = new ArrayList();
    
    if(values == null || values.length() == 0)
    {
      while(c.next())
      {
        list.add((Object)c.getKey());
      }
    }
    else
    {
      while(c.next())
      {
        String value = IDataUtil.getString(c);
        if(skipNullOrEmpty == null || (value != null && value.length() > 0))
          list.add((Object)value);
      }
    }

    String[] slist = new String[list.size()];
    list.toArray((Object[])slist);
    
    IDataUtil.put(pipelineCursor, "list", slist);
    c.destroy();    
    pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getItems (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getItems)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required list
		// [i] field:0:required attr
		// [i] field:0:required value
		// [o] record:1:required item
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		// list
		IData[]	list = IDataUtil.getIDataArray( pipelineCursor, "list" );
		String strAttr = IDataUtil.getString( pipelineCursor, "attr");
		String strValue = IDataUtil.getString( pipelineCursor, "value");
		IDataCursor curs = null;
		IData[] ans = null;
		IData[] item = new IData[list.length];
		int count=0;
		try {
		  for (int i=0; i<list.length; i++) {
			curs = list[i].getCursor();
			if ( strValue.equals( IDataUtil.getString( curs, strAttr) ) ) {
				item[count++] = list[i];
			}
			curs.destroy();
		  }
		  ans = new IData[count];
		  for (int i=0; i<count; i++)
			ans[i] = item[i];
		} catch(NumberFormatException e) {}
		
		IDataUtil.put( pipelineCursor, "item", ans  );
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void removeDuplicates (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(removeDuplicates)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required documentList
		// [o] record:1:required documentList
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		IData[]	inputArray = IDataUtil.getIDataArray( pipelineCursor, "documentList" );
		IDataUtil.remove( pipelineCursor, "documentList" );
		
		java.util.Vector vNoDuplicates = new java.util.Vector();
		
		IData idTemp;
		if(inputArray == null)
		{
			pipelineCursor.destroy();
			return;
		}
		
		for(int i=0; i < inputArray.length; i++)
		{
			boolean bFound = false;
			for(int k=0;k<vNoDuplicates.size();k++)
			{
				idTemp = (IData)vNoDuplicates.get(k);
				IDataCursor idTempcursor = idTemp.getCursor();
		
				if(compareDocs(inputArray[i].getCursor(),idTempcursor))
				{
					bFound=true;
				}
				idTempcursor.destroy();
			}
			if(!bFound)
			{
				vNoDuplicates.add( inputArray[i] );
			}
			
		}
		
		IData[] outputArray = (IData[]) vNoDuplicates.toArray( new IData[1]);
		
		
		
		IDataUtil.put( pipelineCursor, "documentList", outputArray );
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void reverse (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(reverse)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required input
		// [o] record:1:required input
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData[]	input = IDataUtil.getIDataArray( pipelineCursor, "input" );
		if ( input != null) {
			int left;
			int right;
			for (left=0,right=input.length-1; left<right; left++, right--) {
				IData temp = input[left];
				input[left]  = input[right];
				input[right] = temp;
			}
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void sortIDataArrayByKey (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(sortIDataArrayByKey)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required dataArray
		// [i] field:0:required key
		// [i] field:0:required compareType {"COMPARE_TYPE_COLLATION","COMPARE_TYPE_TIME"}
		// [i] field:0:required pattern
		// [i] field:0:required reverse {"true","false"}
		// [o] record:1:required dataArray
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData[]	dataArray = IDataUtil.getIDataArray( pipelineCursor, "dataArray" );
		String	key = IDataUtil.getString( pipelineCursor, "key" );
		String	compareType = IDataUtil.getString( pipelineCursor, "compareType" );
		String	pattern = IDataUtil.getString( pipelineCursor, "pattern" );
		String	reverse = IDataUtil.getString( pipelineCursor, "reverse" );
		int cType = 0;
		boolean rev;
		if (compareType == null) 
			cType=IDataUtil.COMPARE_TYPE_COLLATION;
		else {
			if ( compareType.equals("COMPARE_TYPE_COLLATION"))
				cType=IDataUtil.COMPARE_TYPE_COLLATION;
			if ( compareType.equals("COMPARE_TYPE_TIME"))
				cType=IDataUtil.COMPARE_TYPE_TIME;
		}
		if (reverse == null)
			rev=false;
		else {
			if ( reverse.equals("true"))
				rev = true;
			else 
				rev = false;
		}
		if ( dataArray != null) {
			IData[] dataArray_1 = IDataUtil.sortIDataArrayByKey(dataArray, key, cType, pattern, rev);
			IDataUtil.put( pipelineCursor, "dataArray", dataArray_1 );
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static boolean compareDocs(IDataCursor curs1, IDataCursor curs2)
	{
		if(curs1 ==null || curs2 == null)
			return true;
		if(!curs1.next())
		{
			return true;
		}
		else
		{
			String strKey = curs1.getKey();
			if( !curs2.first(strKey) )
			{
				return false;
			}
			if(curs1.getValue() instanceof String)
			{
				if(! ((String)curs1.getValue()).equals(((String)curs2.getValue())))
					return false;
			}
			if(curs1.getValue() instanceof IData)
			{
				IData idStuff = (IData) curs1.getValue();
				IData idStuff2 = (IData) curs2.getValue();
	
				IDataCursor stuffCursor =idStuff.getCursor();			
				IDataCursor stuffCursor2 =idStuff.getCursor();			
				compareDocs(stuffCursor,stuffCursor2);
	
			}
	/*		if(curs1.getValue() instanceof IData[])
			{
				
			}*/
			return compareDocs(curs1,curs2);
		}
		
		
	}
	// --- <<IS-END-SHARED>> ---
}

