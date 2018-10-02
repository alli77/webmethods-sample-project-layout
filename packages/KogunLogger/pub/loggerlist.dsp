<HTML>
  <HEAD>
    <TITLE>Logs</TITLE>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <META HTTP-EQUIV="Expires" CONTENT="-1">
    <LINK REL="stylesheet" TYPE="text/css" HREF="log.css">
    <SCRIPT type="text/javascript" src="log.js"></SCRIPT>
    <!--SCRIPT>
    function checkEverything()
    {
      if (!verifyRequiredNonNegNumber('logform', 'numlines'))
        {
          alert("Number of lines to display must be a non negative number.");
          return false;
        }
      return true;  
    }


   function checkDelete(logger) 
   {
	  var agree = confirm("Are you sure you want to delete the Logger \'" + logger + "\'?");
	  if (agree)
	    window.location.href = "loggerlist.dsp?mode=delete&logger=" + logger;
	  else
	    return false;
   }


    </SCRIPT-->
  </HEAD>
  <BODY> 


<script language="javascript">
function fetch( ){
  document.location.href="viewlog.dsp?logger="+  document.logform.logger.value;
}
</script>
    <FORM NAME="logform">
         <TABLE width=100%>
            <TR>
              <TD class="menusection-Logs" colspan="2">
                Loggers
              </TD>
            </TR>
    <TR>   
%switch mode%
  %case 'add'%
    %invoke KogunLogger.pub:saveLogger%
      <TD class="message" colspan="2">%value Message%</TD> 
    %endinvoke%
  %case 'delete'%
    %invoke KogunLogger.pub:deleteLogger%
      <TD class="message" colspan="2">%value Message%</TD> 
    %endinvoke%
  %case 'modify'%
    %invoke KogunLogger.pub:modifyLogger%
      <TD class="message" colspan="2">%value Message%</TD>
    %endinvoke%
%endswitch%

    </TR>

	<tr>
      	<td colspan="7"><ul><li><a href="addlogger.dsp">Add new logger</a></ul></td>
    	</tr>


            <TR>
         <td colspan=2 class="padding">&nbsp;</TD>
            </TR>
<TR>
      <TD><IMG SRC="/WmRoot/images/blank.gif" height=10 width=10></TD>
      <TD align="left">
        <TABLE class="tableView">

                     <TR>
                      <TD align="left">
                        %invoke KogunLogger.ui:getAllLoggersTable%
                        %value tblLoggersString% 
                        %onerror%
                          <p>Error while fetching logfiles <br> %value error% %value errorMessage%</p>
                        %endinvoke%
                            
                      </TD>
                    </TR>
                  </TABLE>
               </TD> 

          </TABLE>
         </FORM>  
     </BODY>
</HTML>
