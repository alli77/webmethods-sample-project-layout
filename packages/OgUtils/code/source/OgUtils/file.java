package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2007-10-12 10:59:12 GMT
// -----( ON-HOST: VMISD

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.FileWriter;
import java.io.BufferedWriter;
// --- <<IS-END-IMPORTS>> ---

public final class file

{
	// ---( internal utility methods )---

	final static file _instance = new file();

	static file _newInstance() { return new file(); }

	static file _cast(Object o) { return (file)o; }

	// ---( server methods )---




	public static final void fileExists (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(fileExists)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required fileName
		// [o] field:0:required exists
		IDataCursor pipelineCursor = pipeline.getCursor();
		String strFileName = IDataUtil.getString( pipelineCursor, "fileName");
		java.io.File f = null;
		boolean exists=false;
		if(strFileName!=null)
		{
			f = new java.io.File( strFileName );
			exists = f.exists();
		}
		
		IDataUtil.put(pipelineCursor, "exists", (exists?"true":"false"));
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void fullName2filename (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(fullName2filename)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required fullName
		// [o] field:0:required fileName
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	strFullName = IDataUtil.getString( pipelineCursor, "fullName" );
		String strFileName=null;
		if( strFullName!=null )
		{
			int nPos = strFullName.lastIndexOf(java.io.File.separatorChar);
			strFileName = strFullName.substring(nPos+1);
			IDataUtil.put( pipelineCursor, "fileName", strFileName );
		}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getFilesInFolder (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getFilesInFolder)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// --- <<IS-END>> ---

                
	}



	public static final void writeToFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeToFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required fileName
		// [i] field:0:required fileContent
		// [i] field:0:required overwriteFlag {"append","overwrite"}
		// [i] field:0:optional encoding
		IDataCursor idcPipeline = pipeline.getCursor();
		String strFilename = null;
		String 	strFileContent = null;
		String strOverwriteFlag = null;
		String strencoding = IDataUtil.getString(idcPipeline, "encoding"); 
		if (strencoding == null) 
			strencoding = "UTF-8";
		
		BufferedWriter fileWriter = null;
		
		// Check to see if the filename object is in the pipeline
		if (idcPipeline.first("fileName")) 
		{
				//get the filename out of the pipeline	
			try {					
				strFilename = new String( ((String)idcPipeline.getValue()).getBytes(strencoding), strencoding );	
			}
				catch (Exception e)
			{
				idcPipeline.destroy();
				throw new ServiceException("Problem with encoding");
			 }
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			idcPipeline.destroy();
			throw new ServiceException("Parameter filename is missing");
		}
		
		// Check to see if the fileContent object is in the pipeline
		if (idcPipeline.first("fileContent"))	
		{
				//get the fileContent out of the pipeline						
				strFileContent = (String) idcPipeline.getValue();
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			idcPipeline.destroy();
			throw new ServiceException("Parameter fileContent is missing");
		}
		
		
		// Check to see if the overwriteFlag object is in the pipeline
		if (idcPipeline.first("overwriteFlag"))	
		{
				//get the overwriteFlag out of the pipeline						
				strOverwriteFlag = (String)idcPipeline.getValue();	 
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			strOverwriteFlag = "overwrite";
		}
		
		// Try to create a BufferedWriter object.  Handle the exception if it fails.
		try
		{
				// Check to see if the overwriteFlag was set to overwrite
				if (!strOverwriteFlag.equals("append")) 			
				{
					//Create a new BufferedWriter object that will overwrite the old file
					fileWriter = new BufferedWriter(new FileWriter(strFilename, false));
				}
				// Check to see if the overwriteFlag was set to append
				else
				{
				//Create a new BufferedWriter object that will append to the old file
				fileWriter = new BufferedWriter(new FileWriter(strFilename, true));
				}
		fileWriter.write(strFileContent);
		fileWriter.close();
		}
		catch (Exception e)
		{
			idcPipeline.destroy();	
			throw new ServiceException(e.getMessage());
		}
		
		
		
		//Always destroy cursors that you created
		idcPipeline.destroy();	
		// --- <<IS-END>> ---

                
	}
}

