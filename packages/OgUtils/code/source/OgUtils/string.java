package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2012-12-10 09:59:23 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class string

{
	// ---( internal utility methods )---

	final static string _instance = new string();

	static string _newInstance() { return new string(); }

	static string _cast(Object o) { return (string)o; }

	// ---( server methods )---




	public static final void MessageFormat (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(MessageFormat)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required Pattern
		// [i] object:1:required ObjectArray
		// [o] field:0:required Result
		/**************************************************************************
		 * Copy this to the Web Methods Java MessageFormat Flow
		 *
		 * A wraper around the java.text.MessageFormat format static method
		 *
		 * http://docs.oracle.com/javase/7/docs/api/java/text/MessageFormat.html
		 *
		 * Copyright (c) 2011, Skyrr ehf (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Pattern      (String)
		 *         ObjectArray  (ObjectArray)
		 * Output: Result       (String)
		 *
		 * Revision History
		 * 111219 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 111219 GOS Primary testing finished
		 *
		 */
		
		// Constants
		final String VarNamePattern = "Pattern";
		final String VarNameObjectArray = "ObjectArray";
		final String VarNameResult = "Result";
		
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		if(idc == null)
		  throw new ServiceException("Failed to get Cursor to Pipeline");
		
		String pattern = IDataUtil.getString(idc, VarNamePattern);
		Object[] objectArray = IDataUtil.getObjectArray(idc, VarNameObjectArray);
		if(pattern != null)
		{
		  String result;
		  if(objectArray == null)
		    result = pattern;
		  else
		    result = java.text.MessageFormat.format(pattern, objectArray);
		  IDataUtil.put(idc, VarNameResult, result);
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java MessageFormat Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void ReplacePattern (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ReplacePattern)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required Text
		// [i] field:0:required Pattern
		// [i] field:0:optional Replacement
		// [i] field:0:optional Command
		// [o] field:0:required Result
		/**************************************************************************
		 * Copy this to the Web Methods Java ReplacePattern Flow
		 *
		 * Copyright (c) 2011, Skyrr ehf (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Text         (String)
		 *         Pattern      (String)
		 *         Replacement  (String Optional)
		 *         Command      (String Optional)
		 * Output: Result       (String)
		 *
		 * Revision History
		 * 111229 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 111229 GOS Primary testing finished
		 *
		 */
		
		// Constants
		final String VarNameText = "Text";
		final String VarNamePattern = "Pattern";
		final String VarNameReplacement = "Replacement";
		final String VarNameCommand = "Command";
		final String VarNameResult = "Result";
		
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		if(idc == null)
		  throw new ServiceException("Failed to get Cursor to Pipeline");
		
		// Extract Parameters
		String text = IDataUtil.getString(idc, VarNameText);
		String pattern = IDataUtil.getString(idc, VarNamePattern);
		String replacement = IDataUtil.getString(idc, VarNameReplacement);
		String command = IDataUtil.getString(idc, VarNameCommand);
		
		if(command != null)
		{
		  if(command.equalsIgnoreCase("LF"))        // Line feed - Unix-like
		    replacement = "\n";
		  else if(command.equalsIgnoreCase("CR"))   // Carriage return
		    replacement = "\r";
		  else if(command.equalsIgnoreCase("CRLF")) // Microsoft Windows
		    replacement = "\r\n";
		  else if(command.equalsIgnoreCase("LFCR")) // Acorn BBC and RISC OS
		    replacement = "\n\r";
		  else if(command.equalsIgnoreCase("HT"))   // Vertical Tab
		    replacement = "\t";
		}
		
		if(text != null)
		{
		  java.lang.StringBuffer sb = new java.lang.StringBuffer();
		
		  if(pattern == null)
		  {
		    sb.append(text);
		  }
		  else
		  {
		    int i;
		    int patlen = pattern.length();
		    int length = text.length() - patlen;
		    for(i = 0; i < length; i++)
		    {
		      String sub = text.substring(i, i + patlen);
		      if(sub.equals(pattern))
		      {
		        sb.append(replacement);
		        i = i + patlen - 1;
		      }
		      else
		      {
		        sb.append(text.charAt(i));
		      }
		    }
		    String residue = text.substring(i);
		    if(residue.equals(pattern))
		      sb.append(replacement);
		    else
		      sb.append(residue);
		  }
		
		  IDataUtil.put(idc, VarNameResult, sb.toString());
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java ReplacePattern Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void StringVectorAdd (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(StringVectorAdd)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required StringVector
		// [i] field:0:required Value
		// [o] object:0:required StringVector
		/**************************************************************************
		 * Copy this to the Web Methods Java StringVectorAdd Flow
		 */
		
		// Constants
		final String VarNameValue = "Value";
		final String VarNameStringVector = "StringVector";
		
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		if(idc == null)
		  throw new ServiceException("Failed to get Cursor to Pipeline");
		
		// Try to get the Value
		String value = IDataUtil.getString(idc, VarNameValue);
		if(value == null)
		{
		  idc.destroy();
		  return;
		}
		
		// Try to get the String Vector
		Object stringVectorObject = IDataUtil.get(idc, VarNameStringVector);
		
		// Create the Vector Variables
		java.util.Vector vector;
		
		if(stringVectorObject instanceof java.util.Vector)
		  vector = (java.util.Vector)stringVectorObject;
		else
		  vector = new java.util.Vector();
		
		// Add the string
		vector.add(value);
		
		IDataUtil.put(idc, VarNameStringVector, vector);
		
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java StringVectorAdd Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void StringVectorContains (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(StringVectorContains)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required StringVector
		// [i] field:0:required Value
		// [o] field:0:required StringVectorContains
		/**************************************************************************
		 * Copy this to the Web Methods Java StringVectorContains Flow
		 */
		
		// Constants
		final String VarNameValue = "Value";
		final String VarNameStringVector = "StringVector";
		final String VarNameStringVectorContains = "StringVectorContains";
		
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		if(idc == null)
		  throw new ServiceException("Failed to get Cursor to Pipeline");
		
		// Try to get the Value
		String value = IDataUtil.getString(idc, VarNameValue);
		
		// Try to get the String Vector
		Object stringVectorObject = IDataUtil.get(idc, VarNameStringVector);
		
		// Create the Contains Variables
		boolean contains = false;
		
		if(stringVectorObject instanceof java.util.Vector)
		  contains = ((java.util.Vector)stringVectorObject).contains(value);
		
		IDataUtil.put
		        (
		        idc, 
		        VarNameStringVectorContains, 
		        Boolean.toString(contains).toLowerCase()
		        );
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java StringVectorContains Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void StringVectorToArray (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(StringVectorToArray)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required StringVector
		// [o] field:1:required Array
		/**************************************************************************
		 * Copy this to the Web Methods Java StringVectorToArray Flow
		 */
		
		// Constants
		final String VarNameStringVector = "StringVector";
		final String VarNameStringArray = "Array";
		
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		if(idc == null)
		  throw new ServiceException("Failed to get Cursor to Pipeline");
		
		// Try to get the String Vector
		Object stringVectorObject = IDataUtil.get(idc, VarNameStringVector);
		
		// Create the Contains Variables
		
		if(stringVectorObject instanceof java.util.Vector)
		{
		  java.util.Vector vector = (java.util.Vector)stringVectorObject;
		  String[] array = new String[vector.size()];
		  vector.toArray(array);
		  
		  IDataUtil.put
		          (
		          idc, 
		          VarNameStringArray, 
		          array
		          );
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java StringVectorToArray Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void compareTo (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(compareTo)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required string1
		// [i] field:0:required string2
		// [o] field:0:required compared
		IDataCursor pipelineCursor = pipeline.getCursor();
		String strString1    = IDataUtil.getString( pipelineCursor, "string1");
		String strString2    = IDataUtil.getString( pipelineCursor, "string2");
		
		
		
		IDataUtil.put(pipelineCursor, "compared", strString1.compareTo(strString2)+"");
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void formattedNumber2number (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(formattedNumber2number)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required formattedNumber
		// [i] field:0:required locale
		// [o] field:0:required number
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	strFormattedNumber = IDataUtil.getString( pipelineCursor, "formattedNumber" );
		String	strLocale = IDataUtil.getString( pipelineCursor, "locale" );
		
		if(strFormattedNumber==null || strFormattedNumber.trim().equals(""))
		{
			return;
		}
		
		try
		{
			java.text.NumberFormat nfFormatter = java.text.NumberFormat.getInstance( new java.util.Locale(strLocale));
			Number nNumber= nfFormatter.parse(strFormattedNumber);
			double dUnformatted = nNumber.doubleValue();
			IDataUtil.put( pipelineCursor, "number", dUnformatted+"" );
		}
		catch(Exception e)
		{
			throw new ServiceException(e.getMessage());
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void generalStringFill (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(generalStringFill)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required strFillPattern
		// [i] field:0:required nRemainingLength
		// [i] field:0:required strOrginal
		// [o] field:0:required stringWithFilling
		IDataCursor pipelineCursor = pipeline.getCursor();
		String strFilling = IDataUtil.getString( pipelineCursor, "strFillPattern");
		String strRemainingLength = IDataUtil.getString( pipelineCursor, "nRemainingLength");
		String strOrginal = IDataUtil.getString( pipelineCursor, "strOrginal");
		
		if(strOrginal!=null && !strOrginal.equals(""))
		{
		
			int nRemainingLength = 0;
			if (strRemainingLength!=null)
			{
				Integer tmp = Integer.valueOf(strRemainingLength);
				nRemainingLength = tmp.intValue();//Integer.valueOf(strRemainingLength);
			}
		
			//prevent error if what is to remain is longer than orginal string
			if(nRemainingLength>strOrginal.length())
				nRemainingLength=strOrginal.length();	
		
			StringBuffer sb = new StringBuffer();
		
			//extract what is to remain of orginal string
			String OrginalStringsRemains = "";
			sb.append(strOrginal);
			sb = sb.delete(0,strOrginal.length() - nRemainingLength);
			OrginalStringsRemains = sb.toString();
			
			//create filling
			sb = new StringBuffer();
			while(sb.length()< (strOrginal.length()-nRemainingLength))
				sb.append(strFilling);
			String completedFilling = sb.substring(0,strOrginal.length()-nRemainingLength);
				
			//concat filling and remains of orginal string
			String stringWithFilling = completedFilling + OrginalStringsRemains;
		
			IDataUtil.put(pipelineCursor, "stringWithFilling", stringWithFilling);
		}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getUUID (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getUUID)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required uuid
		// Pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		// UUID
		java.util.UUID uuid = java.util.UUID.randomUUID();
		
		// Put the result into the pipeline
		IDataUtil.put(pipelineCursor, "uuid", uuid.toString());
		   
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getValidMacaddress (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getValidMacaddress)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required mac
		// [i] field:0:required splitter
		// [o] field:0:required validMac
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	strMac = IDataUtil.getString( pipelineCursor, "mac" );
		String	strSplitter = IDataUtil.getString( pipelineCursor, "splitter");
		
		if(strMac == null || strSplitter== null)
		{
			pipelineCursor.destroy();
			return;
		}
		
		String regex="^(?:([0-9a-fA-F]{2})[:|-]?)(?:([0-9a-fA-F]{2})[:|-]?)(?:([0-9a-fA-F]{2})[:|-]?)(?:([0-9a-fA-F]{2})[:|-]?)(?:([0-9a-fA-F]{2})[:|-]?)(?:([0-9a-fA-F]{2}))$";
		        
		java.util.regex.Pattern pattRegex = java.util.regex.Pattern.compile(regex);
		java.util.regex.Matcher matRegex = pattRegex.matcher(strMac);
		
		
		
		if( matRegex.matches() && matRegex.groupCount()>0)
		{
			String strValidMac ="";
		
			//Note this looks like index out of bounds but groupCount returns last index instead of count. Stupid But nothing to do about it.
			for(int i =1;i <= matRegex.groupCount(); i++)
			{
		            if(i==1)
		            {
				strValidMac = matRegex.group(i);
		            }
		            else
		            {
				strValidMac = strValidMac+ strSplitter + matRegex.group(i);
		            }
			}
			IDataUtil.put( pipelineCursor, "validMac", strValidMac );
		}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void passwd_gen (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(passwd_gen)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required len
		// [o] field:0:required passwd
		IDataCursor pipeCurs = pipeline.getCursor();
		String len = IDataUtil.getString(pipeCurs, "len");
		int n = Integer.parseInt(len); 
		char[] pw = new char[n];
		int c  = 'A';
		int  r1 = 0;
		for (int i=0; i < n; i++) {
			do {
				r1 = (int)(Math.random() * 3);
				switch(r1) {
					case 0: c = '0' +  (int)(Math.random() * 10); break;
					case 1: c = 'a' +  (int)(Math.random() * 26); break;
					case 2: c = 'A' +  (int)(Math.random() * 26); break;
				}
			} while ( (char)c=='I' || 
				  (char)c=='o' ||
				  (char)c=='O' ||
				  (char)c=='0' || 
				  (char)c=='l' ||
				  (char)c=='1' ||
				  (char)c=='q' ||
				  (char)c=='Q' );
			pw[i] = (char)c;
		}
		String passwd = new String(pw);
		IDataUtil.put(pipeCurs, "passwd", passwd);
		pipeCurs.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void splitByCharacter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(splitByCharacter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required strLine
		// [i] field:0:required character
		// [o] field:0:required partOne
		// [o] field:0:required partTwo
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	strLine = IDataUtil.getString( pipelineCursor, "strLine" );
		String	character = IDataUtil.getString( pipelineCursor, "character" );
		
		String strPartOne =null;
		String strPartTwo =null;
		
		int nFirst=-1;
		int nLast =-1;
		
		if(strLine != null)
		{
		
			strLine = strLine.trim();
			if(strLine.length()<=0)
				return;
		
			nFirst = strLine.indexOf( character );
		
			strPartOne = strLine.substring(0,nFirst);
			
			nLast = strLine.lastIndexOf( character );
			strPartTwo = strLine.substring(nLast+1);
		
		}
		
		if(strPartOne!=null)
		IDataUtil.put( pipelineCursor, "partOne", strPartOne );
		if(strPartTwo!=null)
		IDataUtil.put( pipelineCursor, "partTwo", strPartTwo );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void splitFullNames (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(splitFullNames)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required fullName
		// [o] field:0:required firstName
		// [o] field:0:required lastName
		// [o] field:0:required middle
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	strFullName = IDataUtil.getString( pipelineCursor, "fullName" );
		String strLastName =null;
		String strFirstName =null;
		String strMiddle =null;
		
		int nFirst=-1;
		int nLast =-1;
		
		if(strFullName != null)
		{
		
			strFullName = strFullName.trim();
			if(strFullName.length()<=0)
				return;
		
			nFirst = strFullName.indexOf( " " );
			if(nFirst<=0)
			{
				strFirstName = strFullName;
				strLastName = strFullName;
			}
			else
			{
				strFirstName = strFullName.substring(0,nFirst);
			
				nLast = strFullName.lastIndexOf( " " );
				strLastName = strFullName.substring(nLast+1);
		
				//if(true)throw new ServiceException("ble"+nFirst+" " +nLast);
		
				if(nLast>nFirst)
				{
					strMiddle = strFullName.substring(nFirst+1, nLast);
					strMiddle = strMiddle.trim();
					if(strMiddle.length()<=0)
						strMiddle=null;
				} 
			}
		}
		
		if(strFirstName!=null)
		IDataUtil.put( pipelineCursor, "firstName", strFirstName );
		if(strLastName!=null)
		IDataUtil.put( pipelineCursor, "lastName", strLastName );
		if(strMiddle!=null)
		IDataUtil.put( pipelineCursor, "middle", strMiddle );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void stringDoc2String (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringDoc2String)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required document
		// [o] field:0:required output
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData	document = IDataUtil.getIData( pipelineCursor, "document" );
		
		String strOutput="";
		Object temp;
		if ( document != null)
		{
			IDataCursor documentCursor = document.getCursor();
			while(documentCursor.next())
			{
				strOutput+=documentCursor.getKey();
				if(documentCursor.getValue() instanceof String)
				{
					strOutput+=":\t"+((String)documentCursor.getValue());
				}	
				strOutput+="\n";
			}
		
			documentCursor.destroy();
		}
		IDataUtil.put( pipelineCursor, "output", strOutput );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void trim (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(trim)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required string
		// [o] field:0:required string
		IDataCursor pipelineCursor = pipeline.getCursor();
		String strInput    = IDataUtil.getString( pipelineCursor, "string");
		
		
		IDataUtil.put(pipelineCursor, "string", strInput!=null?strInput.trim():"");
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

