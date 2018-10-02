<html>
<head>
</head>
<body>
%include ../../WmRoot/pub/b2bStyle.css%

%scope param(package='MappedDrives')%
%invoke wm.server.packages:packageInfo%
%endinvoke%
<table width=100%>
	<tr class="title">
		<td colspan=4>
			<p align="left"> <img style="float:right" src="/WmRoot/icons/blank.gif" width="15" height="15">
			<a href="javascript:history.back()"> <img class="back" src="/WmRoot/icons/nav-back.gif" border=0 width="15" height="15"></a>
			About "Loggers"</p>
		</td>
	</tr>	
	<tr>
		<td class="heading" colspan=4>Copyright</td>
	</tr>
	<tr>
		<td width=120><img src="klogo.gif" border=0 width="160" height="48"></td>
		<td class="rowdata" colspan=3> Copyright &copy; 2001-2004, <a href="http://www.kogun.biz">Kogun Ltd</a> All Rights Reserved.<br>
		<p>webMethods Integration Server is a trademark and webMethods is a registered trademark of webMethods, Inc. Other product and brand names are
       trademarks of their respective owners.
		</td>
	</tr>
	<tr>
		<td class="heading" colspan=4>Version</td>
	<tr>
	<tr>
		<td class="rowlabel" width="10%">Product</td>
		<td class="rowdata" colspan=3>Logger Adapter</td>
	</tr>
	<tr>
		<td class="rowdata"></td>
		<td class="rowdata" colspan=3 > For use with webMethods Integration Server version : 6.0 and up</td>
	</tr>
	<tr>
		<td class="rowlabel">Vendor Name</td>
		<td class="rowdata" colspan=3>Kogun Ltd</td>
	</tr>
	<tr>
		<td class="rowlabel">B2B Adapter Type</td>
		<td class="rowdata" colspan=3>Application Connector</td>
	</tr>
	<tr>
		<td class="rowlabel">Version</td>
		<td class="rowdata" colspan=3>%value version%</td>
	</tr>
	<tr>
		<td class="rowlabel">Build</td>
		<td class="rowdata" colspan=3>%value build%</td>
	</tr>
	<tr>
		<td class="rowlabel">Patch</td>
		<td class="rowdata" colspan=3>%value patch_nums%</td>
	</tr>
	<tr>
		<td class="heading" colspan=4>Integration Server Adapter Build Environment</td>
	<tr>
	<tr>
		<td class="rowlabel">Integration Server Version</td>
		<td class="rowdata" colspan=3>webMethods Integration Server 6.0.1</td>
	</tr>
	<tr>
		<td class="rowlabel">Backend Version</td>
		<td class="rowdata" colspan=3></td>
	</tr>
	<tr>
		<td class="rowlabel">Internal Dependency</td>
		<td class="rowdata" colspan=3>WmWin32,Utils</td>
	</tr>
	<tr>
		<td class="rowlabel">External Dependency</td>
		<td class="rowdata" colspan=3>Windows Operating System</td>
	</tr>
</table>


</body>
</html>

