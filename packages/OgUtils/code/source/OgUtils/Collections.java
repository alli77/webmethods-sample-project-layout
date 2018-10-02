package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2012-03-08 08:33:52 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class Collections

{
	// ---( internal utility methods )---

	final static Collections _instance = new Collections();

	static Collections _newInstance() { return new Collections(); }

	static Collections _cast(Object o) { return (Collections)o; }

	// ---( server methods )---




	public static final void CreateArrayList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(CreateArrayList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required ArrayList
		/**************************************************************************
		 * Copy this to the Web Methods Java ArrayList Flow
		 *
		 * Create new java.util.Vector
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Output: New ArrayList object
		 *
		 * Revision History
		 * 110118 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110118 GOS not finished
		 *
		 */
		
		// Constants
		final String VarNameArrayList = "ArrayList";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		// Add the result to the pipeline
		IDataUtil.put(idc, VarNameArrayList, new java.util.ArrayList());
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java CreateArrayList Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void CreateHashMap (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(CreateHashMap)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required Map
		/**************************************************************************
		 * Copy this to the Web Methods Java CreateHashMap Flow
		 *
		 * Create new java.util.HashMap
		 *
		 * Copyright \u00A9 2009, K\u00F6gun Ltd (www.kogun.is). All rights reserved.
		 *
		 * Output: New HashMap object
		 *
		 * Revision History
		 * 090316 GOS (geirmundur@kogun.is) Created
		 *
		 * Unit test
		 * 090316 GOS not finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.HashMap hashMap = new java.util.HashMap();
		
		// Add the result to the pipeline
		IDataUtil.put(idc, MAP, hashMap);
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java CreateHashMap Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void CreateHashSet (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(CreateHashSet)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required HashSet
		/**************************************************************************
		 * Copy this to the Web Methods Java CreateHashSet Flow
		 *
		 * Create new java.util.HashMap
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Output: New HashMap object
		 *
		 * Revision History
		 * 110118 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110118 GOS Finished
		 *
		 */
		
		// Constants
		final String VarNameHashSet = "HashSet";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.HashSet hashSet = new java.util.HashSet();
		
		// Add the result to the pipeline
		IDataUtil.put(idc, VarNameHashSet, hashSet);
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java CreateHashSet Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void EntryGetKey (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(EntryGetKey)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Entry
		// [o] object:0:required Key
		/**************************************************************************
		 * Copy this to the Web Methods Java EntryGetKey Flow
		 *
		 * java.util.Map.Entry getKey method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Entry (java.util.Map.Entry)
		 * Output: Key   (java.lang.Object)
		 *
		 * Revision History
		 * 110120 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110120 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Map.Entry entry = ExtractEntry(idc, false);
		
		if(entry != null)
		{
		  Object key = entry.getKey();
		  if(key != null)
		    IDataUtil.put(idc, KEY, key);
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java EntryGetKey Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void EntryGetValue (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(EntryGetValue)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Entry
		// [o] object:0:required Value
		/**************************************************************************
		 * Copy this to the Web Methods Java EntryGetValue Flow
		 *
		 * java.util.Map.Entry getValue method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Entry (java.util.Map.Entry)
		 * Output: Value (java.lang.Object)
		 *
		 * Revision History
		 * 110120 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110120 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Map.Entry entry = ExtractEntry(idc, false);
		
		if(entry != null)
		{
		  Object value = entry.getValue();
		  if(value != null)
		    IDataUtil.put(idc, VALUE, value);
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java EntryGetValue Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void IteratorHasNext (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IteratorHasNext)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Iterator
		// [o] field:0:optional HasNext
		/**************************************************************************
		 * Copy this to the Web Methods Java IteratorHasNext Flow
		 *
		 * java.util.Iterator hasNext method
		 *
		 * Copyright \u00A9 2009, K\u00F6gun Ltd (www.kogun.is). All rights reserved.
		 *
		 * Input: java.util.Iterator Iterator
		 * Output: String HasNext ('true' or null)
		 *
		 * Revision History
		 * 090319 GOS (geirmundur@kogun.is) Created
		 *
		 * Unit test
		 * 090319 GOS not finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Iterator it = ExtractIterator(idc, false);
		
		boolean result = false;
		if(it != null)
		  result = it.hasNext();
		
		// Add the result to the pipeline
		if(result)
		  IDataUtil.put(idc, HAS_NEXT, Boolean.toString(result).toLowerCase());
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java IteratorHasNext Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void IteratorNext (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IteratorNext)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Iterator
		// [o] object:0:optional Next
		/**************************************************************************
		 * Copy this to the Web Methods Java IteratorNext Flow
		 *
		 * java.util.Iterator next method
		 *
		 * Copyright \u00A9 2009, K\u00F6gun Ltd (www.kogun.is). All rights reserved.
		 *
		 * Input: java.util.Iterator Iterator
		 * Output: Object Next
		 *
		 * Revision History
		 * 090319 GOS (geirmundur@kogun.is) Created
		 *
		 * Unit test
		 * 090319 GOS not finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		java.util.Iterator it = ExtractIterator(idc, false);
		
		Object result = null;
		if(it != null)
		  result = it.next();
		
		// Add the result to the pipeline
		if(result != null)
		  IDataUtil.put(idc, NEXT, result);
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java IteratorNext Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void ListAdd (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ListAdd)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required List
		// [i] object:0:optional Value
		// [i] field:0:optional ValueString
		/**************************************************************************
		 * Copy this to the Web Methods Java ListAdd Flow
		 *
		 * java.util.List add method
		 *
		 * Copyright \u00A9 2009, K\u00F6gun Ltd (www.kogun.is). All rights reserved.
		 *
		 * Input:
		 *   java.util.List List
		 *   Object         Value
		 *   String         ValueString
		 *
		 * Revision History
		 * 090316 GOS (geirmundur@kogun.is) Created
		 * 110509 GOS Add support for String Value
		 *
		 * Unit test
		 * 110509 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.List list = ExtractList(idc);
		
		Object objValue = IDataUtil.get(idc, VALUE);
		String strValue = IDataUtil.getString(idc, VALUE_STRING);
		
		if(objValue != null)
		  list.add(objValue);
		else if(strValue != null)
		  list.add(strValue); 
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java ListAdd Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void ListIterator (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ListIterator)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required List
		// [o] object:0:required Iterator
		/**************************************************************************
		 * Copy this to the Web Methods Java ListIterator Flow
		 *
		 * java.util.List iterator method
		 *
		 * Copyright \u00A9 2009, K\u00F6gun Ltd (www.kogun.is). All rights reserved.
		 *
		 * Input: java.util.List List
		 * Output: java.util.Iterator Iterator
		 *
		 * Revision History
		 * 090316 GOS (geirmundur@kogun.is) Created
		 *
		 * Unit test
		 * 090316 GOS not finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.List list = ExtractList(idc);
		
		if(list != null)
		{
		  java.util.Iterator iterator = list.iterator();
		  IDataUtil.put(idc, ITERATOR, iterator);
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java ListIterator Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void MapContainsKey (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(MapContainsKey)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Map
		// [i] object:0:optional Key
		// [i] field:0:optional KeyString
		// [o] field:0:optional ContainsKey
		/**************************************************************************
		 * Copy this to the Web Methods Java MapContainsKey Flow
		 *
		 * java.util.Map containsKey method
		 *
		 * Copyright \u00A9 2009, K\u00F6gun Ltd (www.kogun.is). All rights reserved.
		 *
		 * Input:
		 *   java.util.Map Map
		 *   Object        Key
		 *   String        KeyString
		 * Output:
		 *   boolean       ContainsKey
		 *
		 * Revision History
		 * 090316 GOS (geirmundur@kogun.is) Created
		 *
		 * Unit test
		 * 090316 GOS not finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Map map = ExtractMap(idc);
		
		Object objKey = IDataUtil.get(idc, KEY);
		String strKey = IDataUtil.getString(idc, KEY_STRING);
		
		boolean containsKey = false;
		
		if(objKey != null)
		  containsKey = map.containsKey(objKey);
		else if(strKey != null)
		  containsKey = map.containsKey(strKey);
		
		IDataUtil.put(idc, CONTAINS_KEY, Boolean.toString(containsKey));
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java MapContainsKey Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void MapEntrySet (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(MapEntrySet)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Map
		// [o] object:0:required Set
		/**************************************************************************
		 * Copy this to the Web Methods Java MapEntrySet Flow
		 *
		 * java.util.Map entrySet method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input: Map (java.util.Map)
		 * Output: Set (java.util.Set)
		 *
		 * Revision History
		 * 110120 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110120 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Map map = ExtractMap(idc, false);
		
		IDataUtil.put(idc, SET, map.entrySet());
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java MapEntrySet Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void MapGet (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(MapGet)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Map
		// [i] object:0:optional Key
		// [i] field:0:optional KeyString
		// [o] object:0:optional Value
		/**************************************************************************
		 * Copy this to the Web Methods Java MapGet Flow
		 *
		 * java.util.Map get method
		 *
		 * Copyright \u00A9 2009, K\u00F6gun Ltd (www.kogun.is). All rights reserved.
		 *
		 * Input:
		 *   java.util.Map Map
		 *   Object        Key
		 *   String        KeyString
		 * Output:
		 *   Object        Value
		 *
		 * Revision History
		 * 090316 GOS (geirmundur@kogun.is) Created
		 * 110509 GOS Add support for String Key
		 *
		 * Unit test
		 * 110509 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Map map = ExtractMap(idc);
		
		Object objKey = IDataUtil.get(idc, KEY);
		String strKey = IDataUtil.getString(idc, KEY_STRING);
		
		if(objKey != null)
		{
		  Object objValue = map.get(objKey);
		  IDataUtil.put(idc, VALUE, objValue);
		}
		else if(strKey != null)
		{
		  Object objValue = map.get(strKey);
		  IDataUtil.put(idc, VALUE, objValue);
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java MapGet Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void MapPut (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(MapPut)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Map
		// [i] object:0:optional Key
		// [i] field:0:optional KeyString
		// [i] object:0:optional Value
		// [i] field:0:optional ValueString
		/**************************************************************************
		 * Copy this to the Web Methods Java MapPut Flow
		 *
		 * java.util.Map put method
		 *
		 * Copyright \u00A9 2009, K\u00F6gun Ltd (www.kogun.is). All rights reserved.
		 *
		 * Input:
		 *   java.util.Map Map
		 *   Object        Key
		 *   String        KeyString
		 *   Object        Value
		 *   String        ValueString
		 *
		 * Revision History
		 * 090316 GOS (geirmundur@kogun.is) Created
		 * 110509 GOS Added Support for String Key and Value
		 *
		 * Unit test
		 * 090316 GOS not finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Map map = ExtractMap(idc);
		
		Object objKey = IDataUtil.get(idc, KEY);
		String strKey = IDataUtil.getString(idc, KEY_STRING);
		Object objValue = IDataUtil.get(idc, VALUE);
		String strValue = IDataUtil.getString(idc, VALUE_STRING);
		
		if(objKey != null && objValue != null)
		  map.put(objKey, objValue);
		else if(strKey != null && strValue != null)
		  map.put(strKey, strValue);
		else if(objKey != null && strValue != null)
		  map.put(objKey, strValue);
		else if(strKey != null && objValue != null)
		  map.put(strKey, objValue);
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java MapPut Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void SetAdd (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(SetAdd)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Set
		// [i] object:0:optional Object
		// [i] field:0:optional String
		/**************************************************************************
		 * Copy this to the Web Methods Java SetAdd Flow
		 *
		 * java.util.Set add method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input: Set     (java.util.Set)
		 *        Object  (Object)
		 *        String  (String)
		 *
		 * Revision History
		 * 110118 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110118 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Set set = ExtractSet(idc);
		java.lang.Object obj = ExtractObject(idc);
		java.lang.String str = IDataUtil.getString(idc, STRING);
		
		if(set != null)
		{
		  if(str != null)
		    set.add(str);
		  else
		    set.add(obj);
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java SetAdd Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void SetClear (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(SetClear)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Set
		/**************************************************************************
		 * Copy this to the Web Methods Java SetClear Flow
		 *
		 * java.util.Set clear method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input: Set (java.util.Set)
		 *
		 * Revision History
		 * 110118 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110118 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Set set = ExtractSet(idc);
		
		if(set != null)
		  set.clear();
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java SetClear Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void SetContains (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(SetContains)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		/**************************************************************************
		 * Copy this to the Web Methods Java SetContains Flow
		 *
		 * java.util.Set contains method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Set      (java.util.Set)
		 *         Object   (java.lang.Object)
		 *         String   (String)
		 * Output: Contains (String from boolean)
		 *
		 * Revision History
		 * 110118 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110118 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Set set = ExtractSet(idc, false);
		java.lang.Object obj = ExtractObject(idc);
		java.lang.String str = IDataUtil.getString(idc, STRING);
		
		boolean result = false;
		
		if(set != null)
		{
		  if(str != null)
		    result = set.contains(str);
		  else
		    result = set.contains(obj);
		}
		
		if(result)
		  IDataUtil.put(idc, CONTAINS, Boolean.toString(result).toLowerCase());
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java SetContains Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void SetIterator (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(SetIterator)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Set
		// [o] object:0:required Iterator
		/**************************************************************************
		 * Copy this to the Web Methods Java SetIterator Flow
		 *
		 * java.util.Set iterator method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Set      (java.util.Set)
		 *         Object   (java.lang.Object)
		 * Output: Contains (String from boolean)
		 *
		 * Revision History
		 * 110118 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110118 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.Set set = ExtractSet(idc);
		
		if(set != null)
		{
		  Object iterator = set.iterator();
		  IDataUtil.put(idc, ITERATOR, iterator);
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java SetIterator Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	/**************************************************************************
	 * Copy this to the Web Methods Collections Java Flow Shared Source
	 *
	 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
	 *
	 * Revision History
	 * 110118 GOS (geirmundur@skyrr.is) Created
	 *
	 * Unit test
	 * 110118 GOS Finished
	 *
	 */
	
	// Parameter Names
	public static final String CONTAINS_VALUE = "ContainsValue";
	public static final String CONTAINS_KEY = "ContainsKey";
	public static final String CONTAINS = "Contains";
	public static final String ITERATOR = "Iterator";
	public static final String IS_EMPTY = "IsEmpty";
	public static final String HAS_NEXT = "HasNext";
	public static final String OBJECT = "Object";
	public static final String ARRAY = "Array";
	public static final String ENTRY = "Entry";
	public static final String VALUE = "Value";
	public static final String LIST = "List";
	public static final String SIZE = "Size";
	public static final String NEXT = "Next";
	public static final String MAP = "Map";
	public static final String SET = "Set";
	public static final String KEY = "Key";
	
	// String Parameter Names
	public static final String VALUE_STRING = "ValueString";
	public static final String KEY_STRING = "KeyString";
	public static final String STRING = "String";
	
	public static final IDataCursor GetAndCheckCursor(IData Document)
	        throws ServiceException
	{
	  // Initialize
	  IDataCursor idc = Document.getCursor();
	  if(idc == null)
	    throw new ServiceException("Failed to get Cursor to Pipeline");
	  return idc;
	}
	
	public static final java.lang.Object ExtractObject(IDataCursor Cursor)
	        throws ServiceException
	{
	  return IDataUtil.get(Cursor, OBJECT);
	}
	
	public static final java.util.Iterator ExtractIterator(IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractIterator(Cursor, true);
	}
	
	public static final java.util.Iterator ExtractIterator
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  Object objIterator = IDataUtil.get(Cursor, ITERATOR);
	
	  if
	          (
	          ThrowException &&
	          (objIterator == null || !(objIterator instanceof java.util.Iterator))
	          )
	    throw new ServiceException
	            (
	            "Iterator is undefined (null) or " +
	            "not an instance of java.util.Iterator"
	            );
	
	  return (java.util.Iterator)objIterator;
	}
	
	public static final java.util.Map ExtractMap(IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractMap(Cursor, true);
	}
	
	public static final java.util.Map ExtractMap
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  Object objMap = IDataUtil.get(Cursor, MAP);
	  if(ThrowException && (objMap == null || !(objMap instanceof java.util.Map)))
	    throw new ServiceException
	            ("Map is undefined (null) or not an instance of java.util.Map");
	  return (java.util.Map)objMap;
	}
	
	public static final java.util.Map.Entry ExtractEntry(IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractEntry(Cursor, true);
	}
	
	public static final java.util.Map.Entry ExtractEntry
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  Object obj = IDataUtil.get(Cursor, ENTRY);
	  if(ThrowException && (obj == null || !(obj instanceof java.util.Map.Entry)))
	    throw new ServiceException
	            (
	            "Entry is undefined (null) or " +
	            "not an instance of java.util.Map.Entry"
	            );
	  return (java.util.Map.Entry)obj;
	}
	
	public static final java.util.Set ExtractSet(IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractSet(Cursor, true);
	}
	
	public static final java.util.Set ExtractSet
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  Object objSet = IDataUtil.get(Cursor, SET);
	  if
	          (
	          ThrowException &&
	          (objSet == null || !(objSet instanceof java.util.Set))
	          )
	    throw new ServiceException
	            ("Set is undefined (null) or not an instance of java.util.Set");
	  return (java.util.Set)objSet;
	}
	
	public static final java.util.List ExtractList(IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractList(Cursor, true);
	}
	
	public static final java.util.List ExtractList
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  Object objList = IDataUtil.get(Cursor, LIST);
	  if
	          (
	          ThrowException &&
	          (objList == null || !(objList instanceof java.util.List))
	          )
	    throw new ServiceException
	            ("List is undefined (null) or not an instance of java.util.List");
	  return (java.util.List)objList;
	}
	
	/*
	 * Web Methods Collections Java Flow Shared Source ends
	 **************************************************************************/
	// --- <<IS-END-SHARED>> ---
}

