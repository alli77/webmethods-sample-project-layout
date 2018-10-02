package OgUtils.crypt;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-02-13 17:05:42 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.security.MessageDigest;
// --- <<IS-END-IMPORTS>> ---

public final class md5

{
	// ---( internal utility methods )---

	final static md5 _instance = new md5();

	static md5 _newInstance() { return new md5(); }

	static md5 _cast(Object o) { return (md5)o; }

	// ---( server methods )---




	public static final void hashString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(hashString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required original
		// [o] field:0:required md5hash
		// [o] field:0:optional error
		IDataCursor idc = pipeline.getCursor();
		String output = "";
		byte[] ascii;
		try
		{	
			String original = IDataUtil.getString(idc,"original");
			MessageDigest md = MessageDigest.getInstance("MD5");
			ascii = original.getBytes("ascii");
			md.update(ascii);
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(Integer.toHexString((b & 0xff) | 0x100).substring(1,3));
			}
			output = sb.toString();
		}
		catch(Exception ex)
		{
			output = "ERROR: Could not hash original";
			IDataUtil.put(idc,"error",ex.toString());
		}
		IDataUtil.put(idc,"md5hash",output);
		
		idc.destroy();
		// --- <<IS-END>> ---

                
	}
}

