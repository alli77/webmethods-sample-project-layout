<HTML>
  <HEAD>
    <TITLE>List All Loggers</TITLE>
    <META http-equiv="Pragma" content="no-cache">
    <META http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <META http-equiv="Expires" content="-1">
    <LINK rel="stylesheet" type="text/css" href="/WmRoot/webMethods.css">
    <SCRIPT type="text/javascript" src="/WmRoot/webMethods.js.txt"></SCRIPT>

<script language="javascript">
<!--

function checkDelete(logger) {

  var agree = confirm("Are you sure you want to delete the Logger\'" + logger + "\'?");
  if (agree)
    window.location.href = "loggerlist.dsp?mode=delete&Logger=" + logger;
  else
    return false;
}

// -->
</script>

</HEAD>

<BODY onload="setNavigation('/WmDB/db-generate.dsp', '/WmDB/doc/OnlineHelp/FRM_TAB_ServiceGen_GenerateNewDB.html', 'bla');">
  <TABLE width="100%">
    <TR>
      <TD class="menusection-Adapters" colspan="2">Loggers</TD>
    </TR>
    <TR>
%switch mode%
  %case 'add'%
    %invoke mappeddrives.config.ui:addDriveMap%
      <TD class="message" colspan="2">%value Message%</TD> 
    %endinvoke%
  %case 'delete'%
    %invoke mappeddrives.config.ui:deleteDriveMap%
      <TD class="message" colspan="2">%value Message%</TD> 
    %endinvoke%
  %case 'modify'%
    %invoke mappeddrives.config.ui:modifyDriveMap%
      <TD class="message" colspan="2">%value Message%</TD> 
    %endinvoke%
  %case 'test'%
    %invoke mappeddrives.config.ui:testDriveMap%
      <TD class="message" colspan="2">%value Message%</TD> 
    %endinvoke%
%endswitch%
    </TR>

%invoke KogunLogger.pub:getAllLoggers%

    <tr>
      <td colspan="7"><ul><li><a href="adddrive.dsp">Add new alias</a></ul></td>
    </tr>

    <TR>
      <TD><IMG SRC="/WmRoot/images/blank.gif" height=10 width=10></TD>
      <TD align="left">
        <TABLE class="tableView">
          <TR>
            <TD class="heading" align="left">&nbsp;&nbsp;Logger&nbsp;&nbsp;</TD>      
            <TD class="heading" align="left">&nbsp;&nbsp;Number of days&nbsp;&nbsp;</TD>
            <TD class="heading" align="left">&nbsp;&nbsp;Log level&nbsp;&nbsp;</TD>
            <TD class="heading" align="left">&nbsp;&nbsp;Description&nbsp;&nbsp;</TD>
            <TD class="heading" align="left">&nbsp;&nbsp;View&nbsp;&nbsp;</TD>
            <TD class="heading" align="left">&nbsp;&nbsp;Modify&nbsp;&nbsp;</TD>
            <TD class="heading" align="left">&nbsp;&nbsp;Delete&nbsp;&nbsp;</TD>
          </TR>
      %loop LoggerInfos% 
          <TR class="rowlabel">
          <TD align="left">&nbsp;&nbsp;  %value logger% &nbsp;&nbsp;</TD>
	    <TD align="left">&nbsp;&nbsp;  %value NumberOfDays% &nbsp;&nbsp;</TD>
	    <TD align="left">&nbsp;&nbsp;  %value loglevel% &nbsp;&nbsp;</TD>
	    <TD align="left">&nbsp;&nbsp;  %value description% &nbsp;&nbsp;</TD>
	    <TD align="center">&nbsp;&nbsp;<a href="driveslist.dsp?mode=test&Alias=%value logger%"><img src="/WmRoot/icons/checkdot.gif" border="0"></a>&nbsp;&nbsp;</TD>
          <TD align="center">&nbsp;&nbsp;<a href="modifydrive.dsp?Alias=%value logger%"><img src="/WmRoot/images/yellow_check.gif" border="0"></a>&nbsp;&nbsp;</TD>
          <TD align="center">&nbsp;&nbsp;<a href="#" onClick="checkDelete('%value logger%')";><img src="/WmRoot/icons/delete.gif" border="0"></a>&nbsp;&nbsp;</TD>
          </TR>
      %endloop%
        </TABLE>
      </TD>
    </TR>
  </TABLE>
</BODY>
</HTML>

%endinvoke%
  
