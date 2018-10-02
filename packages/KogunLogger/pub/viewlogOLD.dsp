<HTML>
  <HEAD>
    <TITLE>Logs</TITLE>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <META HTTP-EQUIV="Expires" CONTENT="-1">
    <META http-equiv="refresh" content="90">
    <LINK REL="stylesheet" TYPE="text/css" HREF="log.css">
    <SCRIPT>
    function checkEverything()
    {
      if (!verifyRequiredNonNegNumber('logform', 'numlines'))
        {
          alert("Number of lines to display must be a non negative number.");
          return false;
        }
      return true;  
    }
    </SCRIPT>
  </HEAD>
  <BODY>
  
%invoke KogunLogger.ui:getLog%
%onerror%
<p>Error while fetching logfiles <br> %value error% %value errorMessage%
%endinvoke%

<script language="javascript">
function transfer(thepage)
{
  %ifvar logger%
  document.location.href="viewlog.dsp?logger=%value logger%";
  %else%
  document.location.href=thepage;
  %endif%
}
function fetch( ){
  var decValue;
  if (document.logview.descending[0].checked){decValue = 1;} 
  else {decValue = 0;}
  document.location.href="viewlog.dsp?logger=%value logger%&firstline="+document.logview.firstline.value+"&filedate="+document.logview.filedate.value+"&lowestlevel="+document.logview.lowestlevel.value+"&numberoflines="+document.logview.numberoflines.value+"&descending="+decValue;
}
</script>

    <FORM NAME="logview">
            
       
                  
                <TABLE width=100%>
            <TR>
              <TD class="menusection-Logs" colspan="2">
                Logs &gt; %value logger%
              </TD>
            </TR>
            <TR>
         <td colspan=2 class="padding">&nbsp;</TD>
            </TR>
            <TR>
               <TD>
                  <TABLE class="tableView">
                    <TR>
                      <TD colspan=4 class="heading">Log display controls</TD>
                    </TR>  
                    <TR>
                      <TD class="oddrow" nowrap>
                      Date (yyyymmdd)
                        %ifvar filedate%
                          <input name="filedate" type="text" value="%value filedate%" size="8" maxlength="8"></input>
                        %else%
                          <input name="filedate" type="text" size="8" maxlength="8"></input>
                        %endif%
                      </TD>
                      <TD class="oddrow" nowrap>
                      First line
                        %ifvar firstline%
                          <input name="firstline" type="text" value="%value firstline%" size="5" maxlength="4"></input>
                        %else%
                          <input name="firstline" type="text" size="5" maxlength="4"></input>
                        %endif%
                      </TD>
                      <TD class="oddrow" nowrap>
                      Line count
                        %ifvar numberoflines%
                          <input name="numberoflines" type="text" value="%value numberoflines%" size="5" maxlength="4"></input>
                        %else%
                          <input name="numberoflines" type="text" size="5" maxlength="4"></input>
                        %endif%
                      </TD>
                    </TR>  
                    <TR>
                     <TD class="oddrow" nowrap>
                      Lowest level
                        %invoke log.ui:getLevels%
                        %onerror%
                          <p>Error while fetching logfiles <br> %value error% %value errorMessage%</p>
                        %endinvoke%
                        %value selLevelString%     
                      </TD>
                     <TD class="oddrow" nowrap>
                        %invoke log.ui:getDescending%
                        %onerror%
                          <p>Error while fetching logfiles <br> %value error% %value errorMessage%</p>
                        %endinvoke%
                        %value radDescString%     
                      </TD>
                      <TD class="oddrow">  <input type="button" value="Refresh" onclick="javascript:fetch();"></input></TD>
                    </TR>
                  </TABLE>
               </TD> 
              <TD class="padding">&nbsp;</TD>
            </TR> 
            <TR>
              <TD class="padding">&nbsp;</TD>
            </TR>
          
            <TR>
        <TD>
          <TABLE class="tableView" width=100%>
                  <TR>
                  
                    <TD class="heading">Log Entries</TD>
                    
                  </TR>  
                                   

                  
                  <TR>
                    <TD class="oddrow-l">
                      %ifvar logger%  
                        %value tblLogString%
                      %endif%
                    </TD>
                  </TR>

               </TABLE>
              </TD>
            </TR>
          </TABLE>
         </FORM>  
     </BODY>
</HTML>
