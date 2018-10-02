package KogunLogger;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2006-06-28 18:34:00 GMT
// -----( ON-HOST: snari.kogun.is

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void checkDates (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkDates)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required timeGap
		// [i] field:0:required dateToCheck
		// [o] object:0:required newDate
		try
		{
		  // pipeline
		  IDataCursor pipelineCursor = pipeline.getCursor();
		  String dateToCheck = IDataUtil.getString( pipelineCursor, "dateToCheck" );
		  String timeGap = IDataUtil.getString( pipelineCursor, "timeGap" );
		
		  long msecInOneDay = 24 * 60 * 60 * 1000;
		
		  Date d = new Date( dateToCheck );
		  long msec = d.getTime();  
		
		  Long l = new Long( timeGap );
		  long longGap = l.longValue();
		  
		  long gap = longGap * msecInOneDay;
		  long newMsec = msec - gap;
		
		  Date newDate = new Date( newMsec );
		
		  // pipeline
		  IDataUtil.put( pipelineCursor, "newDate", newDate );
		  pipelineCursor.destroy();
		}
		catch(Exception e )
		{
		  throw new ServiceException( e.getMessage() );
		}
		// --- <<IS-END>> ---

                
	}



	public static final void doesFileExist (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(doesFileExist)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required filepath
		// [o] field:0:required fileExists {"true","false"}
		try
		{
		  // pipeline
		  IDataCursor pipelineCursor = pipeline.getCursor();
		  String filepath = IDataUtil.getString( pipelineCursor, "filepath" );
		
		  File tempFile = new File( filepath );
		  boolean exists = tempFile.exists( );
		  String fileExists = Boolean.toString( exists );
		  // pipeline
		  IDataUtil.put( pipelineCursor, "fileExists", fileExists );
		  pipelineCursor.destroy();
		}
		catch(Exception e )
		{
		  throw new ServiceException( e.getMessage() );
		}
		// --- <<IS-END>> ---

                
	}



	public static final void fileGetLine (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(fileGetLine)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required BufferedReader
		// [o] field:0:required line
		try
		{
		  // pipeline
		  IDataCursor pipelineCursor = pipeline.getCursor( );
		  BufferedReader read = (BufferedReader) IDataUtil.get( pipelineCursor, "BufferedReader" );
		
		  String line = read.readLine();
		  IDataUtil.put( pipelineCursor, "line", line );
		  pipelineCursor.destroy( );
		  
		}
		catch(Exception e )
		{ 
		  throw new ServiceException( e.getMessage( ) );
		}   
		// --- <<IS-END>> ---

                
	}



	public static final void fileReadClose (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(fileReadClose)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required BufferedReader
		try
		{
		  // pipeline
		  IDataCursor pipelineCursor = pipeline.getCursor( );
		  BufferedReader read = (BufferedReader) IDataUtil.get( pipelineCursor, "BufferedReader" );
		
		  read.close();
		  pipelineCursor.destroy( );
		  
		}
		catch(Exception e )
		{ 
		  throw new ServiceException( e.getMessage( ) );
		}   
		// --- <<IS-END>> ---

                
	}



	public static final void fileReadOpen (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(fileReadOpen)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required path
		// [o] object:0:required BufferedReader
		try
		{
		  // pipeline
		  IDataCursor pipelineCursor = pipeline.getCursor( );
		  String  path = IDataUtil.getString( pipelineCursor, "path" );
		  
		
		  
		  BufferedReader read =  new BufferedReader(new FileReader( path ));  
		
		
		  IDataUtil.put( pipelineCursor, "BufferedReader", read );
		  pipelineCursor.destroy( );
		  
		}
		catch(Exception e )
		{ 
		  throw new ServiceException( e.getMessage( ) );
		}   
		// --- <<IS-END>> ---

                
	}



	public static final void firstChar (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(firstChar)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required string
		// [o] field:0:required char
		try{  
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		  String  data = IDataUtil.getString( pipelineCursor, "string" );
		
		  IDataUtil.put( pipelineCursor, "char", ""+data.charAt(0) );
		  pipelineCursor.destroy( );
		}
		catch(Exception e )
		{ 
		  throw new ServiceException( e.getMessage( ) );
		}   
		// --- <<IS-END>> ---

                
	}



	public static final void getLogFilePath (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getLogFilePath)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required logger
		// [i] field:0:required filedate
		// [i] field:0:optional filepath
		// [o] field:0:required logfilepath
		try
		{
		  // pipeline
		  IDataCursor pipelineCursor = pipeline.getCursor();
		  String  logger = IDataUtil.getString( pipelineCursor, "logger" );
		  String  filedate = IDataUtil.getString( pipelineCursor, "filedate" );
		  String  filepath = IDataUtil.getString( pipelineCursor, "filepath" );
		  String s;
		  if( filepath == null || filepath.length() == 0)  
			s = new String(logpath + logger + "_" + filedate + ".log");
		  else
		        s = new String(filepath + logger + "_" + filedate + ".log");
		
		
		  // pipeline
		  IDataUtil.put( pipelineCursor, "logfilepath", s );
		  pipelineCursor.destroy();
		}
		catch(Exception e )
		{
		  throw new ServiceException( e.getMessage() );
		}   
		// --- <<IS-END>> ---

                
	}



	public static final void getLogFilePathOnly (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getLogFilePathOnly)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required logger
		// [i] field:0:required filedate
		// [i] field:0:optional filepath
		// [o] field:0:required logfilepath
		try
		{
		  // pipeline
		  IDataCursor pipelineCursor = pipeline.getCursor();
		  String  logger = IDataUtil.getString( pipelineCursor, "logger" );
		  String  filedate = IDataUtil.getString( pipelineCursor, "filedate" );
		  String  filepath = IDataUtil.getString( pipelineCursor, "filepath" );
		  String s;
		  if( filepath == null || filepath.length() == 0)  
			s = new String(logpath);
		  else
		        s = new String(filepath);
		
		  // pipeline
		  IDataUtil.put( pipelineCursor, "logfilepath", s );
		  pipelineCursor.destroy();
		}
		catch(Exception e )
		{
		  throw new ServiceException( e.getMessage() );
		}   
		// --- <<IS-END>> ---

                
	}



	public static final void getPipelineStringValue (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getPipelineStringValue)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required name
		// [o] field:0:required value
		 // pipeline
		try
		{
		  IDataCursor pipelineCursor = pipeline.getCursor( );
		  String  name = IDataUtil.getString( pipelineCursor, "name" );
		  String  value = IDataUtil.getString( pipelineCursor, name );
		
		  IDataUtil.put( pipelineCursor, "value", value );
		  pipelineCursor.destroy( );
		}
		catch(Exception e )
		{ 
		  throw new ServiceException( e.getMessage( ) );
		}   
		// --- <<IS-END>> ---

                
	}



	public static final void getSessionID (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getSessionID)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required sessionId
		
		
		// pipeline
		
		String sid = com.wm.app.b2b.server.InvokeState.getCurrentSession().getSessionID(); 
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put( pipelineCursor, "sessionId",  sid);
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void lastChar (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(lastChar)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required string
		// [o] field:0:required char
		try{  
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		  String  data = IDataUtil.getString( pipelineCursor, "string" );
		
		  IDataUtil.put( pipelineCursor, "char", ""+data.charAt(data.length()-1) );
		  pipelineCursor.destroy( );
		}
		catch(Exception e )
		{ 
		  throw new ServiceException( e.getMessage( ) );
		}   
		// --- <<IS-END>> ---

                
	}



	public static final void log (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(log)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required logger
		// [i] field:0:required data
		// [i] field:0:required level {"DEBUG","INFO","ERROR"}
		// [i] field:0:required xml
		// [i] field:0:required loggerloglevel
		// [i] field:1:required levelList
		// [i] field:0:optional serviceName
		try
		{
		  IDataCursor pipelineCursor = pipeline.getCursor();
		  String  data = IDataUtil.getString( pipelineCursor, "data" );
		  String  importance = IDataUtil.getString( pipelineCursor, "level" );
		  String  loglevel = IDataUtil.getString( pipelineCursor, "loggerloglevel" );
		  String  logger = IDataUtil.getString( pipelineCursor, "logger" );
		  String  xml = IDataUtil.getString( pipelineCursor, "xml" );
		  String[] levelList = IDataUtil.getStringArray( pipelineCursor, "levelList" );
		  String serviceName = IDataUtil.getString( pipelineCursor, "serviceName" );
		  pipelineCursor.destroy(); 
		  com.wm.lang.ns.NSService serv = Service.getCallingService();
		  if( serviceName == null || serviceName == "" )
		  {
		    serviceName = (serv == null)?"":serv.toString();
		  }
		  doLog( logger, importance, data, xml, loglevel, serviceName, levelList );
		}
		catch(Exception e){ throw new ServiceException( e.toString());}
		// --- <<IS-END>> ---

                
	}



	public static final void logToPath (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(logToPath)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required logger
		// [i] field:0:required data
		// [i] field:0:required level {"DEBUG","INFO","ERROR"}
		// [i] field:0:required xml
		// [i] field:0:required loggerloglevel
		// [i] field:0:required filepath
		// [i] field:1:required levelList
		// [i] field:0:optional serviceName
		try
		{
		  IDataCursor pipelineCursor = pipeline.getCursor();
		  String  data = IDataUtil.getString( pipelineCursor, "data" );
		  String  importance = IDataUtil.getString( pipelineCursor, "level" );
		  String  loglevel = IDataUtil.getString( pipelineCursor, "loggerloglevel" );
		  String  logger = IDataUtil.getString( pipelineCursor, "logger" );
		  String  xml = IDataUtil.getString( pipelineCursor, "xml" );
		  String  filepath = IDataUtil.getString( pipelineCursor, "filepath");
		  String[] levelList = IDataUtil.getStringArray( pipelineCursor, "levelList" );
		  String serviceName = IDataUtil.getString( pipelineCursor, "serviceName" );
		  pipelineCursor.destroy();
		  com.wm.lang.ns.NSService serv = Service.getCallingService(); 
		  if( serviceName == null || serviceName == "" )
		  {
		    serviceName = (serv == null)?"":serv.toString();
		  }
		  doLogPath(filepath, logger, importance, data, xml, loglevel, serviceName, levelList );
		}
		catch(Exception e){ throw new ServiceException( e.toString());}
		// --- <<IS-END>> ---

                
	}



	public static final void reverseFileClose (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(reverseFileClose)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ReverseFileReader
		try
		{ 
		 IDataCursor pipelineCursor = pipeline.getCursor( );
		  ReverseFileReader rev = (ReverseFileReader) IDataUtil.get( pipelineCursor, "ReverseFileReader" );
		  rev.closeReverse( );  
		pipelineCursor.destroy( );
		}
		catch(Exception e )
		{ 
		  throw new ServiceException( e.getMessage( ) );
		}   
		// --- <<IS-END>> ---

                
	}



	public static final void reverseFileOpen (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(reverseFileOpen)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required path
		// [o] object:0:required ReverseFileReader
		try
		{
		  // pipeline
		  IDataCursor pipelineCursor = pipeline.getCursor( );
		  String  path = IDataUtil.getString( pipelineCursor, "path" );
		  
		
		  
		  ReverseFileReader rev =  new ReverseFileReader( path );  
		
		
		  IDataUtil.put( pipelineCursor, "ReverseFileReader", rev );
		  pipelineCursor.destroy( );
		  
		}
		catch(Exception e )
		{ 
		  throw new ServiceException( e.getMessage( ) );
		}   
		// --- <<IS-END>> ---

                
	}



	public static final void reverseGetLine (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(reverseGetLine)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ReverseFileReader
		// [o] field:0:required line
		try
		{
			IDataCursor pipelineCursor = pipeline.getCursor( );
			ReverseFileReader rev = (ReverseFileReader) IDataUtil.get( pipelineCursor, "ReverseFileReader" );
			String line = rev.readLine( );
			IDataUtil.put( pipelineCursor, "line", line );
			pipelineCursor.destroy( );
		}
		catch(Exception e )
		{ 
		  throw new ServiceException( e.getMessage( ) );
		}   
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	static String logpath = System.getProperty("user.dir") + File.separator + "logs" + File.separator;
	
	
	public static String LogFile ( String logger, Date toDay)
	{
	  String filedate = new SimpleDateFormat("yyyyMMdd").format(toDay);
	  String FileName = logpath + logger + "_" + filedate + ".log";
	  return FileName;
	}
	
	public static String LogFilePath (String filepath, String logger, Date toDay)
	{
	  String filedate = new SimpleDateFormat("yyyyMMdd").format(toDay);
	  String FileName = filepath + logger + "_" + filedate + ".log";
	  return FileName;
	}
	public static synchronized void doLog ( String logger, String importance, String msg, String xml, String loglevel, String caller, String[] levelList ) throws IOException
	{
	  try
	  {
	    boolean dolog = false;
		int indexLevel = 0; 
		int indexImp = 0;
		String temp;
		int length = levelList.length;
		
	    for( int i=0; i<length; i++ )
		{
			temp = levelList[i].toString();
			
			if( loglevel.equalsIgnoreCase(temp))   //temp == loglevel )
			{
				indexLevel = i;
			}
			if( importance.equalsIgnoreCase(temp) )
			{
				indexImp = i;
			}
		}
	    if ( indexLevel <= indexImp )
			dolog = true;
	    if( dolog ){
	      Date toDay = new Date();
	      String currdate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(toDay);
	      String sid = com.wm.app.b2b.server.InvokeState.getCurrentSession().getSessionID(); 
	      FileWriter fw = new FileWriter( LogFile(logger,toDay), true );
	      if ( (xml == "") || (xml == null) )
	        fw.write("{" + currdate + "}  {" + caller + "}  {" + importance + "}  {" + msg + "}  { }  {" + sid + "}\r\n");
	      else
	        fw.write("{" + currdate + "}  {" + caller + "}  {" + importance + "}  {" + msg + "}  {" + xml + "}  {" + sid + "}\r\n");
	      fw.flush();
	      fw.close();
	    }
	  }
	  catch(Exception e)
	  { throw new IOException( e.getMessage() );}
	}
	
	public static synchronized void doLogPath ( String filepath, String logger, String importance, String msg, String xml, String loglevel, String caller, String[] levelList ) throws IOException
	{
	  try
	  {
	    boolean dolog = false;
	    
		int indexLevel = 0; 
		int indexImp = 0;
		String temp;
		int length = levelList.length;
		
	    for( int i=0; i<length; i++ )
		{
			temp = levelList[i].toString();
			
			if( loglevel.equalsIgnoreCase(temp))//temp == loglevel )
			{
				indexLevel = i;
			}
			if( importance.equalsIgnoreCase(temp) )
			{
				indexImp = i;
			}
		}
	    if ( indexLevel <= indexImp )
			dolog = true;
	
	
	    if( dolog ){
	
	      Date toDay = new Date();
	      String currdate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(toDay);
	      String sid = com.wm.app.b2b.server.InvokeState.getCurrentSession().getSessionID(); 
	      FileWriter fw = new FileWriter( LogFilePath(filepath,logger,toDay), true );
	      if ( (xml == "") || (xml == null) )
	        fw.write("{" + currdate + "}  {" + caller + "}  {" + importance + "}  {" + msg + "}  { }  {" + sid + "}\r\n");
	      else
	        fw.write("{" + currdate + "}  {" + caller + "}  {" + importance + "}  {" + msg + "}  {" + xml + "}  {" + sid + "}\r\n");
	      fw.flush();
	      fw.close();
	    }
	  }
	  catch(Exception e)
	  { throw new IOException( e.getMessage() );}
	}
	
	/*******************************************************************
	 * Author:		Ryan D. Emerle
	 * Date:			10.12.2004
	 * Desc:			Reverse file reader.  Reads a file from the end to the
	 *						beginning
	 *
	 * Known Issues:
	 *						Does not support unicode!
	 *******************************************************************/
	
	public static class ReverseFileReader 
	{	
			private String filename;	
			private RandomAccessFile randomfile;	
			private long position;
			
			public ReverseFileReader (String filename) throws Exception 
	 		{		
				// Open up a random access file
				this.randomfile=new RandomAccessFile(filename,"r");
				// Set our seek position to the end of the file
				this.position=this.randomfile.length();
					
				// Seek to the end of the file
				this.randomfile.seek(this.position);
				//Move our pointer to the first valid position at the end of the file.
				String thisLine=this.randomfile.readLine();
				while(thisLine == null ) 
				{
					this.position--;
					this.randomfile.seek(this.position);
					thisLine=this.randomfile.readLine();
					this.randomfile.seek(this.position);
				}
			}	
			
			// Read one line from the current position towards the beginning
			public String readLine() throws Exception 
			{		
				int thisCode;
				char thisChar;
				String finalLine="";
				
				// If our position is less than zero already, we are at the beginning
				// with nothing to return.
				if ( this.position < 0 ) 
				{
						return null;
				}
				for(;;) 
				/////for(int i=0; i<2; i++)
				{
					// we've reached the beginning of the file
					if ( this.position < 0 ) 
					{
						break;
					}
					// Seek to the current position
					this.randomfile.seek(this.position);
					// Read the data at this position
					thisCode=this.randomfile.readByte();
			//////		thisChar = this.randomfile.readChar();
					thisChar=(char)thisCode;				
					// If this is a line break or carrige return, stop looking
					if (thisCode == 13 || thisCode == 10 ) 
					/////if (thisChar == '\n' || thisChar == '\r' ) 
					{
						// See if the previous character is also a line break character.
						// this accounts for crlf combinations
						this.randomfile.seek(this.position-1);
						int nextCode=this.randomfile.readByte();
						//////char nextChar = this.randomfile.readChar();
						if ( (thisCode == 10 && nextCode == 13) || (thisCode == 13 && nextCode == 10) ) 
						//////if ( (thisChar == '\r' && nextChar == '\n') || (thisChar == '\n' && nextChar == '\r') ) 					
						{
							// If we found another linebreak character, ignore it
							this.position=this.position-1;
						}
						// Move the pointer for the next readline
						this.position--;
						break;
					} 
					else 
					{
						// This is a valid character append to the string
						finalLine=thisChar + finalLine;
					}
					// Move to the next char
					this.position--;
				}
				// return the line
				return finalLine;
			}	
	
		public void closeReverse( ) throws IOException
		{
			try
			{		
				this.randomfile.close( );
			}
			catch(Exception e)
		  	{ 
				throw new IOException( e.getMessage() );
			}
		}
	
		
	}
	
		public static class ReverseReader extends RandomAccessFile 
		{
			public ReverseReader(File f) throws Exception
			{
				super(f,"r");
				seek(f.length());
			}
			public String readLineBack() throws Exception
			{
				char t;
				long pos = getFilePointer();
				pos+=2;
				do
				{
					pos-=2;
					if(pos < 0)
					{
						pos=0;
						break;
					}
					seek(pos);
					t = readChar();
				}while(t!='\n');
				String out = readLine();
				seek(pos);
				return out;
			}
	
	
		}
	// --- <<IS-END-SHARED>> ---
}

