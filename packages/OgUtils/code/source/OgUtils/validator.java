package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-03-25 15:42:58 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import java.net.*;
// --- <<IS-END-IMPORTS>> ---

public final class validator

{
	// ---( internal utility methods )---

	final static validator _instance = new validator();

	static validator _newInstance() { return new validator(); }

	static validator _cast(Object o) { return (validator)o; }

	// ---( server methods )---




	public static final void CreditCardNumberValidation (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(CreditCardNumberValidation)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required CardNumber
		// [o] field:0:required isValid
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	CardNumber = IDataUtil.getString( pipelineCursor, "CardNumber" );
		
		boolean isValid = false;
		String firstChar = "";
		 
		if(CardNumber.length() > 1)
		{
			firstChar = CardNumber.substring(0, 1);
		
			if(firstChar.equals("3") || firstChar.equals("4") || firstChar.equals("5"))
				isValid = CheckCardNumber(CardNumber);
		}
		
		IDataUtil.put( pipelineCursor, "isValid", isValid );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void IpInRange (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IpInRange)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required range_starts
		// [i] field:0:required range_ends
		// [i] field:0:required ip_address
		// [o] field:0:required IsInRange
		IDataCursor inPipeline = pipeline.getCursor();
		String min = IDataUtil.getString(inPipeline, "range_starts"); 
		String max = IDataUtil.getString(inPipeline, "range_ends"); 
		String ip = IDataUtil.getString(inPipeline, "ip_address"); 
		inPipeline.destroy();
		
		try {
			long lmin = host2long(min);
			long lmax = host2long(max);
			long lip = host2long(ip); 
			String result = "true";
			
		   if (lip < lmin) 
		       {
		       result = "false";
		       } else if (lip > lmax) {
		       result = "false";
		       }
		IDataCursor outPipeline = pipeline.getCursor();
		IDataUtil.put(outPipeline, "IsInRange",result);
		outPipeline.destroy();
		} 
		catch (Exception e) {
		            e.printStackTrace();
		        }
		
		// --- <<IS-END>> ---

                
	}



	public static final void IsAllNotNullOrEmpty (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IsAllNotNullOrEmpty)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Doc
		// [i] field:1:required DocItemName
		// [o] field:0:required AllIsNotNullOrEmpty
		/**************************************************************************
		 * Copy this to the Web Methods Java IsAllNotNullOrEmpty Flow
		 */
		    
		// Constants
		final String VarNameDoc = "Doc";
		final String VarNameDocItemName = "DocItemName";
		final String VarNameAllIsNotNullOrEmpty = "AllIsNotNullOrEmpty";
		    
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		
		// Try to get the document List
		IData document = IDataUtil.getIData(idc, VarNameDoc);
		
		// Try to get the Item String List
		String[] itemname = IDataUtil.getStringArray(idc, VarNameDocItemName);
		
		if(itemname == null || itemname.length == 0)
		{
		  idc.destroy();
		  throw new ServiceException("DocItemName List is null or empty");
		}
		
		// Result variables
		boolean result = true;
		Object obj;
		
		// Check input for null
		if(document == null)
		{
		  result = false;
		}
		else
		{
		  // Get keyed List Cursor
		  IDataCursor documentCurs = document.getCursor();
		  if(documentCurs == null)
		  {
		    idc.destroy();
		    throw new ServiceException("Failed to get cursor for Doc");
		  }
		  
		  for(int i = itemname.length - 1; i >= 0; i--)
		  {
		    if((obj = IDataUtil.get(documentCurs, itemname[i])) == null)
		    {
		      result = false;
		      break;
		    }
		    else
		    {
		      if(obj.toString().length() == 0)
		      {
		        result = false;
		        break;
		      }
		    }
		  }
		
		  // Clean up
		  documentCurs.destroy();
		}
		
		// If true then add the result to the pipeline
		if(result)
		  IDataUtil.put
		          (
		          idc, 
		          VarNameAllIsNotNullOrEmpty, 
		          Boolean.toString(result).toLowerCase()
		          );
		        
		// Clean up
		idc.destroy();
		    
		/*
		 * Web Methods Java IsAllNotNullOrEmpty Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void IsAllNullOrEmpty (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IsAllNullOrEmpty)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Doc
		// [o] field:0:required AllIsNullOrEmpty
		/**************************************************************************
		 * Copy this to the Web Methods Java DocList2KeyedList Flow
		 */
		    
		// Constants
		final String VarNameDoc = "Doc";
		final String VarNameAllIsNullOrEmpty = "AllIsNullOrEmpty";
		    
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		
		// Try to get the document List
		IData document = IDataUtil.getIData(idc, VarNameDoc);
		
		// Result variables
		boolean result = true;
		Object obj;
		
		// Check input for null
		if(document != null)
		{
		  // Get keyed List Cursor
		  IDataCursor documentCurs = document.getCursor();
		  if(documentCurs == null)
		    throw new ServiceException("Failed to get cursor for Doc");
		
		  if(documentCurs.first())
		  {
		    do
		    {
		      if((obj = documentCurs.getValue()) != null)
		      {
		        if(obj.toString().length() != 0)
		        {
		          result = false;
		          break;
		        }
		      }
		    }
		    while(documentCurs.next());
		  }
		
		  // Clean up
		  documentCurs.destroy();
		}
		
		// If true then add the result to the pipeline
		if(result)
		  IDataUtil.put
		          (
		          idc, 
		          VarNameAllIsNullOrEmpty, 
		          Boolean.toString(result).toLowerCase()
		          );
		        
		// Clean up
		idc.destroy();
		    
		/*
		 * Web Methods Java DocList2KeyedList Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void IsOnlyOneNotNullOrEmpty (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(IsOnlyOneNotNullOrEmpty)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required Doc
		// [o] field:0:required OnlyOneIsNotNullOrEmpty
		/**************************************************************************
		 * Copy this to the Web Methods Java DocList2KeyedList Flow
		 */
		    
		// Constants
		final String VarNameDoc = "Doc";
		final String VarNameOnlyOneIsNotNullOrEmpty = "OnlyOneIsNotNullOrEmpty";
		    
		// Initialize
		IDataCursor idc = pipeline.getCursor();
		
		// Try to get the document List
		IData document = IDataUtil.getIData(idc, VarNameDoc);
		
		// Check input for null
		if(document == null)
		{
		  idc.destroy();
		  return;
		}
		
		// Get keyed List Cursor
		IDataCursor documentCurs = document.getCursor();
		if(documentCurs == null)
		  throw new ServiceException("Failed to get cursor for Doc");
		
		// Result variables
		boolean result = false;
		Object obj;
		
		if(documentCurs.first())
		{
		  do
		  {
		    if((obj = documentCurs.getValue()) != null)
		    {
		      if(obj.toString().length() != 0)
		      {
		        if(result)
		        {
		          result = false;
		          break;
		        }
		        else
		        {
		          result = true;
		        }
		      }
		    }
		  }
		  while(documentCurs.next());
		}
		
		// If true then add the result to the pipeline
		if(result)
		  IDataUtil.put
		          (
		          idc, 
		          VarNameOnlyOneIsNotNullOrEmpty, 
		          Boolean.toString(result).toLowerCase()
		          );
		        
		// Clean up
		documentCurs.destroy();
		idc.destroy();
		    
		/*
		 * Web Methods Java DocList2KeyedList Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void ssnValidation (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ssnValidation)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required ssn
		// [o] field:0:required ssnValidation
		IDataCursor idcPipeline = pipeline.getCursor();
		String strSsn = IDataUtil.getString(idcPipeline, "ssn"); 
		
		if(validateSsn(strSsn))
		{
			IDataUtil.put(idcPipeline, "ssnValidation","true");
		}
		else
		{
			IDataUtil.put(idcPipeline, "ssnValidation","false");
		}
		idcPipeline.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static boolean validateSsn(String strSsn)
	{
	if(strSsn == null)
	{
		return false;
	}
	    strSsn = strSsn.trim();
	
	    strSsn = strSsn.replaceAll("-","");
	
	    if (strSsn.length() == 10)
	    {
	        int iSum =   (Integer.parseInt(strSsn.substring(0,1)) * 3) +
	        (Integer.parseInt(strSsn.substring(1,2)) * 2) +
	        (Integer.parseInt(strSsn.substring(2,3)) * 7) +
	        (Integer.parseInt(strSsn.substring(3,4)) * 6) +
	        (Integer.parseInt(strSsn.substring(4,5)) * 5) +
	        (Integer.parseInt(strSsn.substring(5,6)) * 4) +
	        (Integer.parseInt(strSsn.substring(6,7)) * 3) +
	        (Integer.parseInt(strSsn.substring(7,8)) * 2);
	
	       	int iSum_t = 0;
	        if (iSum % 11 > 0)
	        {
	             iSum_t = (iSum / 11) + 1;
	        }
	        else
	    	{
	           iSum_t = iSum / 11;
	        }
	        if(Integer.parseInt(strSsn.substring(9,10))<8 && Integer.parseInt(strSsn.substring(9,10))>0) 
	       {
	             return false;
	       }
	
	
	        if ((iSum_t * 11) - iSum == Integer.parseInt(strSsn.substring(8,9))) 
	       {
	             return true;
	       }
	
	    }
	    return false;
	
	}
	
	public static long host2long(String host) {
	        long ip=0;
	        if (!Character.isDigit(host.charAt(0))) return -1;
	        int[] addr = ip2intarray(host);
	        if (addr == null) return -1;
	        for (int i=0;i<addr.length;++i) {
	            ip += ((long)(addr[i]>=0 ? addr[i] : 0)) << 8*(3-i);
	        }
	        return ip;
	    }
	
	    public static int[] ip2intarray(String host) {
	        int[] address = {-1,-1,-1,-1};
	        int i=0;
	        StringTokenizer tokens = new StringTokenizer(host,".");
	        if (tokens.countTokens() > 4) return null;
	        while (tokens.hasMoreTokens()) {
	            try {
	                address[i++] = Integer.parseInt(tokens.nextToken()) & 0xFF;
	            } catch(NumberFormatException nfe) {
	                return null;
	            }
	        }
	        return address;
	    }
	
	private static boolean CheckCardNumber(String CardNumber)
	{
		int NumberLen = 0;
		int CurrentNum = 0;
		String CurrentNumString = "";
		int Sum = 0;
	
		if(CardNumber == null)
			return false;
	
		NumberLen = CardNumber.length();
	
		if(NumberLen % 2 == 1)
		{
			CardNumber = "0" + CardNumber;
			NumberLen += 1;
		}
	
		for(int i = 0; i < NumberLen-1; i++)
		{
			CurrentNum = Integer.parseInt(CardNumber.substring(i, i + 1));
			
			if((i+1) % 2 == 1)
			{
				CurrentNum = CurrentNum * 2;
				if(CurrentNum < 10)
					CurrentNumString = "0" + CurrentNum;
				else
					CurrentNumString = "" + CurrentNum;
	
				CurrentNum = Integer.parseInt(CurrentNumString.substring(0, 1)) +
							 Integer.parseInt(CurrentNumString.substring(1, 2));
			}
	
			Sum += CurrentNum;
		}
		
		Sum = 10 - Sum % 10;
		if(Sum == 10)
			Sum = 0;
	
		CurrentNum = Integer.parseInt(CardNumber.substring(NumberLen - 1, NumberLen));
	
		if( Sum != CurrentNum)
			return false;
	
		return true;	
	}
	// --- <<IS-END-SHARED>> ---
}

