package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2017-01-16 09:44:28 GMT
// -----( ON-HOST: wmisdev2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import org.json.*;
import java.util.Iterator;
// --- <<IS-END-IMPORTS>> ---

public final class json

{
	// ---( internal utility methods )---

	final static json _instance = new json();

	static json _newInstance() { return new json(); }

	static json _cast(Object o) { return (json)o; }

	// ---( server methods )---




	public static final void idata2json (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(idata2json)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Document
		// [o] field:0:required json
		IDataCursor IDC = pipeline.getCursor(); 
		
		IData doc = IDataUtil.getIData(IDC, "Document");
		IDataCursor cursor = doc.getCursor();
		JSONObject json = new JSONObject();
		
		try {
		  cursor.first();
		  walk_idata(cursor, json);
		} catch (Exception e) {
		  throw new ServiceException(e.getClass()+" "+e.getMessage());
		}
		
		IDataUtil.put(IDC, "json", json.toString());
		cursor.destroy();
		IDC.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void idataList2json (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(idataList2json)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		IDataCursor idc = pipeline.getCursor(); 
		try {
			IData[] docs = IDataUtil.getIDataArray(idc, "Documents");
			if (docs != null) {
				JSONArray jsonArray = new JSONArray();
				for(int i = 0; i < docs.length; i++) {
					IDataCursor cursor = docs[i].getCursor();
					try {
						while(cursor.next()) {
							JSONObject jsonObj = new JSONObject();
							walk_idata(cursor, jsonObj);
							jsonArray.put(jsonObj); 
						}
					} finally {
						if (cursor != null) {
							cursor.destroy();
						}
					}
				}
				IDataUtil.put(idc, "json", jsonArray.toString());
			}
		} catch (Exception e) {
			throw new ServiceException(e.getClass() + " " + e.getMessage());
		} finally {
			idc.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void json2idata (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(json2idata)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required json
		// [o] record:0:required Document
		IDataCursor IDC = pipeline.getCursor();
		IData out_idata = 
		IDataFactory.create();
		IDataCursor outC = out_idata.getCursor();
		String s=IDataUtil.getString(IDC, "json");
		try {
		  JSONObject json = new JSONObject(s);
		  walk_json(json, outC);
		} catch (Exception e) {
		  throw new ServiceException(e.getClass()+" "+e.getMessage());
		}
		IDataUtil.put(IDC, "Document", out_idata);
		outC.destroy();
		
		IDC.destroy(); 
		// --- <<IS-END>> ---

                
	}



	public static final void json2idata_v2 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(json2idata_v2)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required json
		// [o] record:0:required Document
		IDataCursor IDC = pipeline.getCursor();
		IData out_idata = 
		IDataFactory.create();
		IDataCursor outC = out_idata.getCursor();
		String s=IDataUtil.getString(IDC, "json");
		try {
		  JSONObject json = new JSONObject(s);
		  walk_json(json, outC);
		} catch (Exception e) {
		  throw new ServiceException(e.getClass()+" "+e.getMessage());
		}
		IDataUtil.put(IDC, "Document", out_idata);
		outC.destroy();
		
		IDC.destroy(); 
		// --- <<IS-END>> ---

                
	}



	public static final void xml2json (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(xml2json)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required xmlstr
		// [o] field:0:required out_json
		IDataCursor pipelineCursor = pipeline.getCursor();
		String s = IDataUtil.getString(pipelineCursor, "xmlstr");
		try{  
		  JSONObject obj=XML.toJSONObject(s);
		  IDataUtil.put(pipelineCursor, "out_json", ""+obj);
		} catch (Exception e) {
		throw new ServiceException(e.getClass()+" "+e.getMessage());
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static void walk_idata(IDataCursor cursor, JSONObject json) throws Exception {
		if(cursor.getValue()==null ) {
			json.put(cursor.getKey(), "");
		} else if(cursor.getValue() instanceof IData ) {
			IDataCursor innerC = ((IData)cursor.getValue()).getCursor();
			innerC.first();
			JSONObject innerJ = new JSONObject();
			walk_idata(innerC, innerJ);
			json.put(cursor.getKey(), innerJ);
			innerC.destroy();
		} else if(cursor.getValue() instanceof IData[] ) {
			IData[] iarr = ((IData[])cursor.getValue());
			JSONArray jarr = new JSONArray();
			for(int i=0; i<iarr.length; i++) {
				IDataCursor innerC = iarr[i].getCursor();
				innerC.first();
				JSONObject innerJ = new JSONObject();
				walk_idata(innerC, innerJ);
				jarr.put(i, innerJ);
				innerC.destroy();			
			}
			json.put(cursor.getKey(), jarr);
		} else {
			json.put(cursor.getKey(), cursor.getValue());
		}
	
		if(cursor.next()) {
			walk_idata(cursor, json);
		}	
	}
	
	private static void walk_json(JSONObject json, IDataCursor cursor) throws Exception {
	  Iterator it = json.keys();
	  while (it.hasNext()) {
		String key = ((String) it.next());
		Object obj = json.get(key);
	    if (obj instanceof JSONObject) {
			JSONObject jO = ((JSONObject) obj);
			IData newID = IDataFactory.create();
			IDataCursor newC = newID.getCursor();
	        walk_json(jO, newC);
			newC.destroy();
			IDataUtil.put(cursor, ((String) key), newID);
		} else if (obj instanceof JSONArray) {
			JSONArray jA = ((JSONArray) obj);
			IData[] IA = new IData[jA.length()];
			for(int i=0; i<jA.length(); i++){
				IA[i]=IDataFactory.create();
				IDataCursor iAC= IA[i].getCursor();
				walk_json(((JSONObject)jA.get(i)),iAC);
				iAC.destroy();
			}
			IDataUtil.put(cursor, ((String) key), IA);
		} else if (obj.getClass().getName().compareTo("org.json.JSONObject$Null") == 0){
	      IDataUtil.put(cursor, ((String) key), null);		
		} else {
	      IDataUtil.put(cursor, ((String) key), obj);
	    }
	  }
	}
	// --- <<IS-END-SHARED>> ---
}

