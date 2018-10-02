package KogunLogger;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2008-09-19 11:11:52 GMT
// -----( ON-HOST: si28dmzisa

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import org.apache.log4j.*;
import java.io.*;
// --- <<IS-END-IMPORTS>> ---

public final class log4j

{
	// ---( internal utility methods )---

	final static log4j _instance = new log4j();

	static log4j _newInstance() { return new log4j(); }

	static log4j _cast(Object o) { return (log4j)o; }

	// ---( server methods )---




	public static final void get_server_cached (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(get_server_cached)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required KL_serv
		try {
			IDataCursor IDC = pipeline.getCursor();
			java.net.InetAddress hostname = java.net.InetAddress.getLocalHost();
			IDataUtil.put(IDC, "KL_serv", hostname.getHostName() + " "+ System.getProperty("os.arch") );
			IDC.destroy();
		} catch (Exception e) {
		}
		// --- <<IS-END>> ---

                
	}



	public static final void init_logger (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(init_logger)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required configfile
		try {
		IDataCursor IDC = pipeline.getCursor();
		logger = Logger.getLogger("WM.KogunLogger");
		MDC.put("KL_sn", "KogunLogger.log4j:init");
		MDC.put("KL_sid", com.wm.app.b2b.server.InvokeState.getCurrentSession().getSessionID() );
		MDC.remove("KL_xml");
		
		IData id = IDataFactory.create();
		IDataCursor cursor = id.getCursor();
		Service.doInvoke("KogunLogger.log4j", "get_server", id);
		MDC.put("KL_serv", IDataUtil.getString(cursor, "KL_serv"));
		cursor.destroy();
		
		id = IDataFactory.create();
		cursor = id.getCursor();
		Service.doInvoke("KogunLogger.log4j", "get_remote_ip", id);
		MDC.put("KL_ip", IDataUtil.getString(cursor, "remoteIp"));
		cursor.destroy();
		
		id = IDataFactory.create();
		cursor = id.getCursor();
		Service.doInvoke("utils.system", "getCurrentUser", id);
		MDC.put("KL_user", IDataUtil.getString(cursor, "user"));
		cursor.destroy();
		
		id = IDataFactory.create();
		cursor = id.getCursor();
		cursor.insertAfter("package", "KogunLogger" );
		Service.doInvoke("KogunLogger.log4j", "get_package_version", id);
		MDC.put("KL_ver", IDataUtil.getString(cursor, "version"));
		cursor.destroy();
		
		String configfile = IDataUtil.getString(IDC, "configfile");
		File log4j_config_file = new File(configfile);
		if (log4j_config_file.exists()) {
			PropertyConfigurator.configure(configfile);
			logger.info("Logger initialized..."); 
		}
		MDC.remove("KL_sn");
		MDC.remove("KL_sid");
		MDC.remove("KL_user");
		MDC.remove("KL_ip");
		MDC.remove("KL_ver");
		
		IDC.destroy();
		} catch(Exception e) { 
			try {
				IDataCursor IDC = pipeline.getCursor();
				IData id = IDataFactory.create();
				IDataCursor cursor = id.getCursor();
				IDataUtil.put(cursor, "message", "ERROR  - "+ e.toString()+ " - " + IDataUtil.getString(IDC, "data"));
				IDataUtil.put(cursor, "function", IDataUtil.getString(IDC, "logger"));
				Service.doInvoke("pub.flow", "debugLog", id);
				cursor.destroy();
				IDC.destroy();
			} catch (Exception et) { }
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
		// [i] field:0:required xml
		// [i] field:0:optional level {"DEBUG","INFO","WARNING","ERROR","ALERT","CRITICAL","EMERGENCY"}
		// [i] field:0:optional serviceName
		try {
			IDataCursor IDC = pipeline.getCursor();
		
			MDC.put("KL_sid", com.wm.app.b2b.server.InvokeState.getCurrentSession().getSessionID() );
			if (IDataUtil.getString(IDC,"xml") != null)
				MDC.put("KL_xml", IDataUtil.getString(IDC,"xml"));
			if (IDataUtil.getString(IDC,"serviceName") != null) 
				MDC.put("KL_sn", IDataUtil.getString(IDC,"serviceName"));
			if (MDC.get("KL_serv") == null) {
				IData id = IDataFactory.create();
				IDataCursor cursor = id.getCursor();
				Service.doInvoke("KogunLogger.log4j", "get_server", id);
				MDC.put("KL_serv", IDataUtil.getString(cursor, "KL_serv"));
				cursor.destroy();
			}
			if (MDC.get("KL_ip") == null) {
				IData id = IDataFactory.create();
				IDataCursor cursor = id.getCursor();
				Service.doInvoke("KogunLogger.log4j", "get_remote_ip", id);
				MDC.put("KL_ip", IDataUtil.getString(cursor, "remoteIp"));
				cursor.destroy();
			}
			if (MDC.get("KL_user") == null) {
				IData id = IDataFactory.create();
				IDataCursor cursor = id.getCursor();
				Service.doInvoke("utils.system", "getCurrentUser", id);
				MDC.put("KL_user", IDataUtil.getString(cursor, "user"));
				cursor.destroy();
			}
			if (MDC.get("KL_ver") == null) {
				IData id = IDataFactory.create();
				IDataCursor cursor = id.getCursor();
				cursor.insertAfter("package", IDataUtil.getString(IDC, "logger") );
				Service.doInvoke("KogunLogger.log4j", "get_package_version", id);
				MDC.put("KL_ver", IDataUtil.getString(cursor, "version"));
				cursor.destroy();
			}
			if (logger== null)
				Service.doInvoke("KogunLogger.log4j", "init", IDataFactory.create());
		
			logger = Logger.getLogger("WM."+IDataUtil.getString(IDC, "logger"));
			String level = IDataUtil.getString(IDC, "level");
		
			if (level == null )
				logger.debug(IDataUtil.getString(IDC, "data"));
			else if (level.equals("DEBUG")) 
				logger.debug(IDataUtil.getString(IDC, "data"));
			else if (level.equals("INFO")) 
				logger.info(IDataUtil.getString(IDC, "data"));
			else if (level.equals("WARNING")) 
				logger.warn(IDataUtil.getString(IDC, "data"));
			else if (level.equals("ERROR")) 
				logger.error(IDataUtil.getString(IDC, "data"));
			else if (level.equals("ALERT")) 
				logger.fatal(IDataUtil.getString(IDC, "data"));
			else if (level.equals("CRITICAL")) 
				logger.fatal(IDataUtil.getString(IDC, "data"));
			else if (level.equals("EMERGENCY")) 
				logger.fatal(IDataUtil.getString(IDC, "data"));
			else 
				logger.debug(IDataUtil.getString(IDC, "data"));
		
			MDC.remove("KL_xml");
			MDC.remove("KL_sn");
			MDC.remove("KL_sid");
			MDC.remove("KL_ver");
			MDC.remove("KL_user");
			MDC.remove("KL_ip");
			IDC.destroy();
		} catch(Exception e) { 
			try {
				IDataCursor IDC = pipeline.getCursor();
				IData id = IDataFactory.create();
				IDataCursor cursor = id.getCursor();
				IDataUtil.put(cursor, "message", "ERROR  - "+ e.toString()+ " - " + IDataUtil.getString(IDC, "data"));
				IDataUtil.put(cursor, "function", IDataUtil.getString(IDC, "logger"));
				Service.doInvoke("pub.flow", "debugLog", id);
				cursor.destroy();
				IDC.destroy();
			} catch (Exception et) { }
		}
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	static Logger logger;
	// --- <<IS-END-SHARED>> ---
}

