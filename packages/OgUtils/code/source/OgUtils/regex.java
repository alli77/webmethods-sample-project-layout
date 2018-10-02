package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2013-01-23 15:42:53 GMT
// -----( ON-HOST: WMISDEV2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.regex.Pattern;
import java.util.regex.Matcher;
// --- <<IS-END-IMPORTS>> ---

public final class regex

{
	// ---( internal utility methods )---

	final static regex _instance = new regex();

	static regex _newInstance() { return new regex(); }

	static regex _cast(Object o) { return (regex)o; }

	// ---( server methods )---




	public static final void CompilePattern (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(CompilePattern)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required RegEx
		// [i] field:1:optional Flags
		// [o] object:0:required Pattern
		/**************************************************************************
		 * Copy this to the Web Methods Java CompilePattern Flow
		 *
		 * java.util.regex.Pattern compile method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  RegEx (String)
		 *         Flags (String - optional)
		 *
		 * Output: Pattern (java.util.regex.Pattern)
		 *
		 * Revision History
		 * 110908 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110908 GOS Finished
		 *
		 */
		
		// Constants
		final String VarNameFlags = "Flags";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		String regEx = IDataUtil.getString(idc, REGEX);
		String[] flags = IDataUtil.getStringArray(idc, VarNameFlags);
		
		if(regEx == null)
		  throw new ServiceException("RegEx parameter is undefined");
		
		if(flags == null)
		  IDataUtil.put(idc, PATTERN, java.util.regex.Pattern.compile
		          (regEx));
		else
		  IDataUtil.put(idc, PATTERN, java.util.regex.Pattern.compile
		          (regEx, CreateFlags(flags)));
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java CompilePattern Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void MatcherAppendReplacement (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(MatcherAppendReplacement)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Matcher
		// [i] object:0:required StringBuffer
		// [i] field:0:optional Replacement
		// [o] object:0:required Matcher
		/**************************************************************************
		 * Copy this to the Web Methods Java MatcherAppendReplacement Flow
		 *
		 * java.util.regex.Matcher appendReplacement method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Matcher      (java.util.regex.Matcher)
		 *         StringBuffer (java.lang.StringBuffer)
		 *         Replacement  (String - optional)
		 *
		 * Output: Matcher      (java.util.regex.Matcher)
		 *
		 * Revision History
		 * 110910 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110910 GOS Finished
		 *
		 */
		    
		// Constants
		final String VarNameReplacement = "Replacement";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.regex.Matcher matcher = ExtractMatcher(idc, false);
		java.lang.StringBuffer stringBuffer = ExtractStringBuffer(idc, true);
		String replacement = IDataUtil.getString(idc, VarNameReplacement);
		
		if(matcher != null)
		  IDataUtil.put
		          (idc, MATCHER, matcher.appendReplacement(stringBuffer, replacement));
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java MatcherAppendReplacement Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void MatcherAppendTail (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(MatcherAppendTail)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Matcher
		// [i] object:0:required StringBuffer
		// [o] object:0:required StringBuffer
		/**************************************************************************
		 * Copy this to the Web Methods Java MatcherAppendTail Flow
		 *
		 * java.util.regex.Matcher appendTail method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Matcher      (java.util.regex.Matcher)
		 *         StringBuffer (java.lang.StringBuffer)
		 *
		 * Output: StringBuffer (java.lang.StringBuffer)
		 *
		 * Revision History
		 * 110912 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110912 GOS Finished
		 *
		 */
		    
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.regex.Matcher matcher = ExtractMatcher(idc, false);
		java.lang.StringBuffer stringBuffer = ExtractStringBuffer(idc, true);
		
		if(matcher != null)
		  IDataUtil.put
		          (idc, STRING_BUFFER, matcher.appendTail(stringBuffer));
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java MatcherAppendTail Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void MatcherFind (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(MatcherFind)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Matcher
		// [i] field:0:optional Start
		// [o] field:0:required Find
		/**************************************************************************
		 * Copy this to the Web Methods Java MatcherFind Flow
		 *
		 * java.util.regex.Matcher find method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Matcher (java.util.regex.Matcher)
		 *         Start   (String - Optional Integer)
		 *
		 * Output: Find    (String - Boolean)
		 *
		 * Revision History
		 * 110909 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110909 GOS Finished
		 *
		 */
		
		// Constants
		final String VarNameStart = "Start";
		final String VarNameFind = "Find";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.regex.Matcher matcher = ExtractMatcher(idc, false);
		Integer start = ExtractInteger(idc, VarNameStart, false);
		
		if(matcher != null)
		{
		  if(start == null)
		    IDataUtil.put(idc, VarNameFind, 
		            Boolean.toString(matcher.find()));
		  else
		    IDataUtil.put(idc, VarNameFind, 
		            Boolean.toString(matcher.find(start.intValue())));
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java MatcherFind Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void MatcherGroup (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(MatcherGroup)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Matcher
		// [i] field:0:optional GroupIndex
		// [o] field:0:optional Group
		/**************************************************************************
		 * Copy this to the Web Methods Java MatcherGroup Flow
		 *
		 * java.util.regex.Matcher group method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Matcher     (java.util.regex.Matcher)
		 *         GroupIndex  (String - Optional Integer)
		 *
		 * Output: Group       (String - Optional)
		 *
		 * Revision History
		 * 110912 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110912 GOS Finished
		 *
		 */
		
		// Constants
		final String VarNameGroupIndex = "GroupIndex";
		final String VarNameGroup = "Group";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.regex.Matcher matcher = ExtractMatcher(idc, false);
		Integer groupIndex = ExtractInteger(idc, VarNameGroupIndex, false);
		
		if(matcher != null)
		{
		  if(groupIndex == null)
		    IDataUtil.put(idc, VarNameGroup, matcher.group());
		  else
		    IDataUtil.put(idc, VarNameGroup, matcher.group(groupIndex.intValue()));
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java MatcherGroup Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void MatcherGroupCount (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(MatcherGroupCount)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Matcher
		// [o] field:0:required GroupCount
		/**************************************************************************
		 * Copy this to the Web Methods Java MatcherGroupCount Flow
		 *
		 * java.util.regex.Matcher groupCount method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Matcher     (java.util.regex.Matcher)
		 *
		 * Output: GroupCount  (String - Integer)
		 *
		 * Revision History
		 * 110912 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110912 GOS Finished
		 *
		 */
		
		// Constants
		final String VarNameGroupCount = "GroupCount";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.regex.Matcher matcher = ExtractMatcher(idc, false);
		
		if(matcher != null)
		  IDataUtil.put(idc, VarNameGroupCount, Integer.toString(matcher.groupCount()));
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java MatcherGroupCount Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void PatternMatcher (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(PatternMatcher)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Pattern
		// [i] object:0:optional Input
		// [i] field:0:optional Text
		// [o] object:0:required Matcher
		/**************************************************************************
		 * Copy this to the Web Methods Java PatternMatcher Flow
		 *
		 * java.util.regex.Pattern matcher method
		 *
		 * Creates a matcher that will match the given input against this pattern.
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Pattern       (java.util.regex.Pattern)
		 *         Input         (java.lang.CharSequence - optional)
		 *         Text          (String - optional)
		 *
		 * Output: Matcher       (java.util.regex.Matcher)
		 *
		 * Revision History
		 * 110909 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110909 GOS Finished
		 *
		 */
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.regex.Pattern pattern = ExtractPattern(idc, false);
		java.lang.CharSequence input = ExtractCharSequence(idc, false);
		String text = IDataUtil.getString(idc, TEXT);
		
		if(pattern != null)
		{
		  if(input == null)
		    IDataUtil.put(idc, MATCHER, pattern.matcher(text));
		  else
		    IDataUtil.put(idc, MATCHER, pattern.matcher(input));
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java PatternMatcher Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}



	public static final void PatternReplace (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(PatternReplace)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required in_string
		// [i] field:0:required pattern
		// [i] field:0:required replace
		// [o] field:0:required out_string
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		String in_string = IDataUtil.getString(idc, "in_string");
		String pattern = IDataUtil.getString(idc, "pattern");
		String replace = IDataUtil.getString(idc, "replace");
		String maskedText = in_string;
		
		// Do the replace
		try
		{
		    Pattern pPATTERN = Pattern.compile(pattern);
		    if(in_string != null && in_string.length() > 0) 
		    {
		        Matcher matcher = pPATTERN.matcher(in_string);  
		        if (matcher.find()) {
		            maskedText = matcher.replaceAll(replace);
		        }
		    } else {
		        maskedText = "";
		    }
		}
		catch (Exception e)	
		{
		//------------------------------------------------------------------------------
		  ServiceException e2 = new ServiceException("Exception (" +
		      e.getClass().getName() + "): " + e.getMessage());
		  e2.initCause(e);
		  throw e2;
		}
		
		
		IDataCursor pipelineCursorOut = pipeline.getCursor();
		IDataUtil.put(pipelineCursorOut, "out_string", maskedText);
		
		// Clean up
		idc.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void PatternSplit (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(PatternSplit)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required Pattern
		// [i] field:0:optional Limit
		// [i] object:0:optional Input
		// [i] field:0:optional Text
		// [o] field:1:required Split
		/**************************************************************************
		 * Copy this to the Web Methods Java PatternSplit Flow
		 *
		 * java.util.regex.Pattern split method
		 *
		 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
		 *
		 * Input:  Pattern       (java.util.regex.Pattern)
		 *         Limit         (String - optional integer
		 *         Input         (java.lang.CharSequence - optional)
		 *         Text          (String - optional)
		 *
		 * Output: Split   (String Array)
		 *
		 * Revision History
		 * 110909 GOS (geirmundur@skyrr.is) Created
		 *
		 * Unit test
		 * 110909 GOS Finished
		 *
		 */
		
		// Constants
		final String VarNameLimit = "Limit";
		final String VarNameSplit = "Split";
		
		// Initialize
		IDataCursor idc = GetAndCheckCursor(pipeline);
		
		java.util.regex.Pattern pattern = ExtractPattern(idc, false);
		java.lang.CharSequence input = ExtractCharSequence(idc, false);
		String text = IDataUtil.getString(idc, TEXT);
		
		Integer limit = ExtractInteger(idc, VarNameLimit, false);
		
		if(pattern != null)
		{
		  if(input == null)
		    if(limit == null)
		      IDataUtil.put(idc, VarNameSplit, pattern.split(text));
		    else
		      IDataUtil.put(idc, VarNameSplit, pattern.split(text, limit.intValue()));
		  else
		    if(limit == null)
		      IDataUtil.put(idc, VarNameSplit, pattern.split(input));
		    else
		      IDataUtil.put(idc, VarNameSplit, pattern.split(input, limit.intValue()));
		}
		
		// Clean up
		idc.destroy();
		
		/*
		 * Web Methods Java PatternSplit Flow ends
		 **************************************************************************/
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	/**************************************************************************
	 * Copy this to the Web Methods RegEx Java Flow Shared Source
	 *
	 * Copyright (c) 2011, Skyrr Ltd (www.skyrr.is). All rights reserved.
	 *
	 * Revision History
	 * 110908 GOS (geirmundur@skyrr.is) Created
	 *
	 * Unit test
	 * 110908 GOS Finished
	 *
	 */
	
	public static final String STRING_BUFFER = "StringBuffer";
	public static final String PATTERN = "Pattern";
	public static final String MATCHER = "Matcher";
	public static final String REGEX = "RegEx";
	public static final String INPUT = "Input";
	public static final String TEXT = "Text";
	
	public static final int CreateFlags(String[] Flags) throws ServiceException
	{
	  int flag = 0;
	  for(int i = Flags.length - 1; i >= 0; i--)
	    flag |= CreateFlag(Flags[i]);
	  return flag;
	}
	
	public static final int CreateFlag(String Flag) throws ServiceException
	{
	  if
	          (
	          Flag.equalsIgnoreCase("UNIXLINES") ||
	          Flag.equalsIgnoreCase("UNIX_LINES")
	          )
	    return java.util.regex.Pattern.UNIX_LINES;
	  else if
	          (
	          Flag.equalsIgnoreCase("CASEINSENSITIVE") ||
	          Flag.equalsIgnoreCase("CASE_INSENSITIVE")
	          )
	    return java.util.regex.Pattern.CASE_INSENSITIVE;
	  else if
	          (
	          Flag.equalsIgnoreCase("COMMENTS")
	          )
	    return java.util.regex.Pattern.COMMENTS;
	  else if
	          (
	          Flag.equalsIgnoreCase("MULTILINE")
	          )
	    return java.util.regex.Pattern.MULTILINE;
	  else if
	          (
	          Flag.equalsIgnoreCase("DOTALL")
	          )
	    return java.util.regex.Pattern.DOTALL;
	  else if
	          (
	          Flag.equalsIgnoreCase("UNICODECASE") ||
	          Flag.equalsIgnoreCase("UNICODE_CASE")
	          )
	    return java.util.regex.Pattern.UNICODE_CASE;
	  else if
	          (
	          Flag.equalsIgnoreCase("CANONEQ") ||
	          Flag.equalsIgnoreCase("CANON_EQ")
	          )
	    return java.util.regex.Pattern.CANON_EQ;
	  else
	    throw new ServiceException("'" + Flag + "' is not a valid flag");
	}
	
	public static final java.lang.StringBuffer ExtractStringBuffer
	        (IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractStringBuffer(Cursor, true);
	}
	
	public static final java.lang.StringBuffer ExtractStringBuffer
	        (IDataCursor Cursor, String VarName)
	        throws ServiceException
	{
	  return ExtractStringBuffer(Cursor, VarName, true);
	}
	
	public static final java.lang.StringBuffer ExtractStringBuffer
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  return ExtractStringBuffer(Cursor, STRING_BUFFER, ThrowException);
	}
	
	public static final java.lang.StringBuffer ExtractStringBuffer
	        (IDataCursor Cursor, String VarName, boolean ThrowException)
	        throws ServiceException
	{
	  Object obj = IDataUtil.get(Cursor, VarName);
	  if
	          (
	          ThrowException &&
	          (obj == null || !(obj instanceof java.lang.StringBuffer))
	          )
	    throw new ServiceException
	            (
	            "The Parameter '" + VarName + "' is undefined (null) or " +
	            "not an instance of java.lang.StringBuffer"
	            );
	  return (java.lang.StringBuffer)obj;
	}
	
	public static final java.lang.CharSequence ExtractCharSequence
	        (IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractCharSequence(Cursor, true);
	}
	
	public static final java.lang.CharSequence ExtractCharSequence
	        (IDataCursor Cursor, String VarName)
	        throws ServiceException
	{
	  return ExtractCharSequence(Cursor, VarName, true);
	}
	
	public static final java.lang.CharSequence ExtractCharSequence
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  return ExtractCharSequence(Cursor, INPUT, ThrowException);
	}
	
	public static final java.lang.CharSequence ExtractCharSequence
	        (IDataCursor Cursor, String VarName, boolean ThrowException)
	        throws ServiceException
	{
	  Object obj = IDataUtil.get(Cursor, VarName);
	  if
	          (
	          ThrowException &&
	          (obj == null || !(obj instanceof java.lang.CharSequence))
	          )
	    throw new ServiceException
	            (
	            "The Parameter '" + VarName + "' is undefined (null) or " +
	            "not an instance of java.lang.CharSequence"
	            );
	  return (java.lang.CharSequence)obj;
	}
	
	public static final java.util.regex.Pattern ExtractPattern(IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractPattern(Cursor, true);
	}
	
	public static final java.util.regex.Pattern ExtractPattern
	        (IDataCursor Cursor, String VarName)
	        throws ServiceException
	{
	  return ExtractPattern(Cursor, VarName, true);
	}
	
	public static final java.util.regex.Pattern ExtractPattern
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  return ExtractPattern(Cursor, PATTERN, ThrowException);
	}
	
	public static final java.util.regex.Pattern ExtractPattern
	        (IDataCursor Cursor, String VarName, boolean ThrowException)
	        throws ServiceException
	{
	  Object obj = IDataUtil.get(Cursor, VarName);
	  if
	          (
	          ThrowException &&
	          (obj == null || !(obj instanceof java.util.regex.Pattern))
	          )
	    throw new ServiceException
	            (
	            "The Parameter '" + VarName + "' is undefined (null) or " +
	            "not an instance of java.util.regex.Pattern"
	            );
	  return (java.util.regex.Pattern)obj;
	}
	
	public static final java.util.regex.Matcher ExtractMatcher(IDataCursor Cursor)
	        throws ServiceException
	{
	  return ExtractMatcher(Cursor, true);
	}
	
	public static final java.util.regex.Matcher ExtractMatcher
	        (IDataCursor Cursor, String VarName)
	        throws ServiceException
	{
	  return ExtractMatcher(Cursor, VarName, true);
	}
	
	public static final java.util.regex.Matcher ExtractMatcher
	        (IDataCursor Cursor, boolean ThrowException)
	        throws ServiceException
	{
	  return ExtractMatcher(Cursor, MATCHER, ThrowException);
	}
	
	public static final java.util.regex.Matcher ExtractMatcher
	        (IDataCursor Cursor, String VarName, boolean ThrowException)
	        throws ServiceException
	{
	  Object obj = IDataUtil.get(Cursor, VarName);
	  if
	          (
	          ThrowException &&
	          (obj == null || !(obj instanceof java.util.regex.Pattern))
	          )
	    throw new ServiceException
	            (
	            "The Parameter '" + VarName + "' is undefined (null) or " +
	            "not an instance of java.util.regex.Matcher"
	            );
	  return (java.util.regex.Matcher)obj;
	}
	
	public static final Integer ExtractInteger
	        (IDataCursor Cursor, String VarName, boolean ThrowException)
	        throws ServiceException
	{
	  Object obj = IDataUtil.get(Cursor, VarName);
	  if(obj == null)
	  {
	    if(ThrowException)
	      throw new ServiceException
	              ("The Parameter '" + VarName + "' is undefined (null)");
	    else
	      return null;
	  }
	  else if(obj instanceof java.lang.String)
	  {
	    String it = (java.lang.String)obj;
	    return Integer.valueOf(it);
	  }
	  else if(obj instanceof java.lang.Integer)
	  {
	    return (java.lang.Integer)obj;
	  }
	  else
	  {
	    if(ThrowException)
	      throw new ServiceException
	              (
	              "The Parameter '" + VarName + 
	              "' is not instance of Integer or String"
	              );
	    else
	      return null;
	  }
	}
	
	public static final IDataCursor GetAndCheckCursor(IData Document)
	        throws ServiceException
	{
	  // Initialize
	  IDataCursor idc = Document.getCursor();
	  if(idc == null)
	    throw new ServiceException("Failed to get Cursor to Pipeline");
	  return idc;
	}
	
	/*
	 * Web Methods RegEx Java Flow Shared Source ends
	 **************************************************************************/
	// --- <<IS-END-SHARED>> ---
}

