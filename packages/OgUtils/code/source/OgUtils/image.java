package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2006-06-28 09:50:38 GMT
// -----( ON-HOST: si28dmzdev

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class image

{
	// ---( internal utility methods )---

	final static image _instance = new image();

	static image _newInstance() { return new image(); }

	static image _cast(Object o) { return (image)o; }

	// ---( server methods )---




	public static final void imageConverter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(imageConverter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		try
		{
		
			java.io.File fIn = new java.io.File("c:\\ble.bmp");
			if(!fIn.exists())
				throw new ServiceException("Not exist");
		
		
			java.awt.image.BufferedImage bi = javax.imageio.ImageIO.read(fIn);
		if(bi==null)
			throw new ServiceException(" bi er null");
		
			java.io.File f = new java.io.File("c:\\myimage.png");
			javax.imageio.ImageIO.write(bi, "png", f);
		}
		catch(Exception e)
		{
			throw new ServiceException(e);
		}
		 
		// --- <<IS-END>> ---

                
	}
}

