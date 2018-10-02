package KogunWord;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-01-08 08:26:29 GMT
// -----( ON-HOST: WM8DEV5.skyrr.local

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.hwpf.model.*;
import java.io.*;
// --- <<IS-END-IMPORTS>> ---

public final class hwpf

{
	// ---( internal utility methods )---

	final static hwpf _instance = new hwpf();

	static hwpf _newInstance() { return new hwpf(); }

	static hwpf _cast(Object o) { return (hwpf)o; }

	// ---( server methods )---




	public static final void Word2Forrest (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(Word2Forrest)>> ---
		// @sigtype java 3.5
		// [i] field:0:required WordFileLocation
		// [i] field:0:required ResultFileLocation
		// [o] field:0:required Status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	WordFileLocation = IDataUtil.getString( pipelineCursor, "WordFileLocation" );
			String	ResultFileLocation = IDataUtil.getString( pipelineCursor, "ResultFileLocation" );
		pipelineCursor.destroy();
		
		/*
		 * Please read the comments for the Java service to see what it does and how it works
		 * \u00C1stvaldur Sigur\u00F0sson - 07.01.2013
		 */
		
		Word2Forrest converter = null;
		String Status = null;
		try
		{
			if(WordFileLocation != null && ResultFileLocation != null)
			{
				OutputStream out = new FileOutputStream(new File(ResultFileLocation));
				converter = new Word2Forrest(new HWPFDocument(new FileInputStream(WordFileLocation)), out);
				out.close();
			    Status = "OK";
			}			
		}
		catch (Throwable t)
		{
			Status = "FAILED";
			t.printStackTrace();
		}
		
		/*
		 * Pipeline Out
		 */
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "Status", Status );
		pipelineCursor_1.destroy();
		
		
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static class Word2Forrest
	{
	  Writer _out;
	  HWPFDocument _doc;
	
	  public Word2Forrest(HWPFDocument doc, OutputStream stream)
	    throws IOException, UnsupportedEncodingException
	  {
	    OutputStreamWriter out = new OutputStreamWriter (stream, "UTF-8");
	    _out = out;
	    _doc = doc;
	
	    init ();
	    openDocument ();
	    openBody ();
	
	    Range r = doc.getRange ();
	    StyleSheet styleSheet = doc.getStyleSheet ();
	
	    int sectionLevel = 0;
	    int lenParagraph = r.numParagraphs ();
	    boolean inCode = false;
	    for (int x = 0; x < lenParagraph; x++)
	    {
	      Paragraph p = r.getParagraph (x);
	      String text = p.text ();
	      if (text.trim ().length () == 0)
	      {
	        continue;
	      }
	      StyleDescription paragraphStyle = styleSheet.getStyleDescription (p.
	        getStyleIndex ());
	      String styleName = paragraphStyle.getName();
	      if (styleName.startsWith ("Heading"))
	      {
	        if (inCode)
	        {
	          closeSource();
	          inCode = false;
	        }
	
	        int headerLevel = Integer.parseInt (styleName.substring (8));
	        if (headerLevel > sectionLevel)
	        {
	          openSection ();
	        }
	        else
	        {
	          for (int y = 0; y < (sectionLevel - headerLevel) + 1; y++)
	          {
	            closeSection ();
	          }
	          openSection ();
	        }
	        sectionLevel = headerLevel;
	        openTitle ();
	        writePlainText (text);
	        closeTitle ();
	      }
	      else
	      {
	        int cruns = p.numCharacterRuns ();
	        CharacterRun run = p.getCharacterRun (0);
	        String fontName = run.getFontName();
	        if (fontName.startsWith ("Courier"))
	        {
	          if (!inCode)
	          {
	            openSource ();
	            inCode = true;
	          }
	          writePlainText (p.text());
	        }
	        else
	        {
	          if (inCode)
	          {
	            inCode = false;
	            closeSource();
	          }
	          openParagraph();
	          writePlainText(p.text());
	          closeParagraph();
	        }
	      }
	    }
	    for (int x = 0; x < sectionLevel; x++)
	    {
	      closeSection();
	    }
	    closeBody();
	    closeDocument();
	    _out.flush();
	
	  }
	
	    public void init ()
	      throws IOException
	    {
	      _out.write ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
	      _out.write ("<!DOCTYPE document PUBLIC \"-//APACHE//DTD Documentation V1.1//EN\" \"./dtd/document-v11.dtd\">\r\n");
	    }
	
	    public void openDocument ()
	      throws IOException
	    {
	      _out.write ("<document>\r\n");
	    }
	    public void closeDocument ()
	      throws IOException
	    {
	      _out.write ("</document>\r\n");
	    }
	
	
	    public void openBody ()
	      throws IOException
	    {
	      _out.write ("<body>\r\n");
	    }
	
	    public void closeBody ()
	      throws IOException
	    {
	      _out.write ("</body>\r\n");
	    }
	
	
	    public void openSection ()
	      throws IOException
	    {
	      _out.write ("<section>");
	
	    }
	
	    public void closeSection ()
	      throws IOException
	    {
	      _out.write ("</section>");
	
	    }
	
	    public void openTitle ()
	      throws IOException
	    {
	      _out.write ("<title>");
	    }
	
	    public void closeTitle ()
	      throws IOException
	    {
	      _out.write ("</title>");
	    }
	
	    public void writePlainText (String text)
	      throws IOException
	    {
	      _out.write (text);
	    }
	
	    public void openParagraph ()
	      throws IOException
	    {
	      _out.write ("<p>");
	    }
	
	    public void closeParagraph ()
	      throws IOException
	    {
	      _out.write ("</p>");
	    }
	
	    public void openSource ()
	      throws IOException
	    {
	      _out.write ("<source><![CDATA[");
	    }
	    public void closeSource ()
	      throws IOException
	    {
	      _out.write ("]]></source>");
	    }
	}
	// --- <<IS-END-SHARED>> ---
}

