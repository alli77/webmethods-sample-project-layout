package OgUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-07-07 14:23:48 GMT
// -----( ON-HOST: wmisdev2.ITNET.IS

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import java.text.*;
// --- <<IS-END-IMPORTS>> ---

public final class date

{
	// ---( internal utility methods )---

	final static date _instance = new date();

	static date _newInstance() { return new date(); }

	static date _cast(Object o) { return (date)o; }

	// ---( server methods )---




	public static final void getAgeFromDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getAgeFromDate)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required birthday
		// [i] field:0:required strPattern
		// [o] field:0:required age
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	birthday = IDataUtil.getString( pipelineCursor, "birthday" );
			String	strPattern = IDataUtil.getString( pipelineCursor, "strPattern" );
			String age = "30";	
		
			java.text.SimpleDateFormat DateFormat = new java.text.SimpleDateFormat(strPattern, java.util.Locale.US);
			java.util.Date dDate = DateFormat.parse(birthday, (new java.text.ParsePosition(0)));
		        
		        java.util.Calendar calBirthday = java.util.Calendar.getInstance();
		        calBirthday.setTime(dDate);	
		
			java.util.Calendar cal = new java.util.GregorianCalendar(calBirthday.get(java.util.Calendar.YEAR),
								calBirthday.get(java.util.Calendar.MONTH), calBirthday.get(java.util.Calendar.DAY_OF_MONTH));
		     	java.util.Calendar now = new java.util.GregorianCalendar();
		     	int res = now.get(java.util.Calendar.YEAR) - cal.get(java.util.Calendar.YEAR);
		     	if((cal.get(java.util.Calendar.MONTH) > now.get(java.util.Calendar.MONTH))
		       		|| (cal.get(java.util.Calendar.MONTH) == now.get(java.util.Calendar.MONTH)
		      		&& cal.get(java.util.Calendar.DAY_OF_MONTH) > now.get(java.util.Calendar.DAY_OF_MONTH)))
		     	{
		        	res--;
		     	}
			
		        String sInt = "" + res;
		
			IDataUtil.put( pipelineCursor, "age", sInt );		
		pipelineCursor.destroy();
		
		// pipeline
		//IDataCursor pipelineCursor_1 = pipeline.getCursor();
		//IDataUtil.put( pipelineCursor_1, "age", "age" );
		//pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getDayOfWeek (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getDayOfWeek)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required date
		// [o] field:0:required dayOfWeek
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object objDate = IDataUtil.get( pipelineCursor, "date" );
		Date date = null;
		int dayOfWeek = 0;
		if(objDate != null)
		{
		  date = (Date)objDate;
		
		  dayOfWeek = date.getDay();
		 
		}
		
		IDataUtil.put( pipelineCursor, "dayOfWeek", dayOfWeek );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	//static long SEC = 100;
	//static long MIN = 60*SEC;
	//static long HOUR = MIN*60;
	//static long DAY = HOUR*24;
	
	static Integer getIntegerValue( IDataCursor pipelineCursor, String value ) {
	
	  Integer i = new Integer(0);
	 
	  boolean b = pipelineCursor.first(value);
	  if (b) 
	    i = i.valueOf ( (String) pipelineCursor.getValue() );
	  
	  return i;
	};
	
	static int getDays(GregorianCalendar g1, GregorianCalendar g2) {
	      int elapsed = 0;
	      GregorianCalendar gc1, gc2;
	
	      if (g2.after(g1)) {
	         gc2 = (GregorianCalendar) g2.clone();
	         gc1 = (GregorianCalendar) g1.clone();
	      }
	      else   {
	         gc2 = (GregorianCalendar) g1.clone();
	         gc1 = (GregorianCalendar) g2.clone();
	      }
	
	      gc1.clear(Calendar.MILLISECOND);
	      gc1.clear(Calendar.SECOND);
	      gc1.clear(Calendar.MINUTE);
	      gc1.clear(Calendar.HOUR_OF_DAY);
	
	      gc2.clear(Calendar.MILLISECOND);
	      gc2.clear(Calendar.SECOND);
	      gc2.clear(Calendar.MINUTE);
	      gc2.clear(Calendar.HOUR_OF_DAY);
	
	      while ( gc1.before(gc2) ) {
	         gc1.add(Calendar.DATE, 1);
	         elapsed++;
	      }
	      return elapsed;
	   }
	// --- <<IS-END-SHARED>> ---
}

