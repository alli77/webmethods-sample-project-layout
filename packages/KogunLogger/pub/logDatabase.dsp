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

<script language="javascript">
function transfer(thepage)
{
  %ifvar logger%
  document.location.href="logDatabase.dsp?logger=%value logger%";
  %else%
  document.location.href=thepage;
  %endif%
}
function fetch( )
{
  document.location.href="logDatabase.dsp?logger=%value logger%&orderDirection="+document.logview.orderDirection.value+"&orderBy=6&lowestlevel="+document.logview.lowestlevel.value+"&timeFrom="+document.logview.timeFrom.value+"&timeTo="+document.logview.timeTo.value+"&likeType="+document.logview.likeType.value+"&likeData="+document.logview.likeData.value+"&likeXML="+document.logview.likeXML.value;
}
function fetch2( orderBy )
{
  document.location.href="logDatabase.dsp?logger=%value logger%&orderDirection="+document.logview.orderDirection.value+"&orderBy="+orderBy+"&lowestlevel="+document.logview.lowestlevel.value+"&timeFrom="+document.logview.timeFrom.value+"&timeTo="+document.logview.timeTo.value+"&likeType="+document.logview.likeType.value+"&likeData="+document.logview.likeData.value+"&likeXML="+document.logview.likeXML.value;
}

</script>


       <TABLE width=100%>
            <TR>
              <TD class="menusection-Logs" colspan="2">
                Logs &gt; %value logger%
              </TD>
            </TR>
            <TR>

    <FORM NAME="logview">

        %invoke old_db_hafthor:getLogWrapper%
	    %onerror%
	    <p>Error while fetching logfiles <br> %value status%; %value statusMessage%; %value errorMessage%
	%endinvoke%
         <td colspan=2 class="padding">&nbsp;</TD>
            </TR>
            <TR>
               <TD>
                  <TABLE class="tableView">
                    <TR>
                      <TD colspan=5 class="heading">Log display controls</TD>
                    </TR>
                    <TR>
                      <TD class="oddrow" nowrap>
                      Caller
                        %ifvar likeType%
                          <input name="likeType" type="text" value="%value likeType%" size="5" maxlength="30"></input>
                        %else%
                          <input name="likeType" type="text" size="5" maxlength="30"></input>
                        %endif%
                      </TD>
                      <TD class="oddrow" nowrap>
                      Description
                        %ifvar likeData%
                          <input name="likeData" type="text" value="%value likeData%" size="5" maxlength="30"></input>
                        %else%
                          <input name="likeData" type="text" size="5" maxlength="30"></input>
                        %endif%
                      </TD>
                      <TD class="oddrow" nowrap>
                      XML
                        %ifvar likeXML%
                          <input name="likeXML" type="text" value="%value likeXML%" size="5" maxlength="30"></input>
                        %else%
                          <input name="likeXML" type="text" size="5" maxlength="30"></input>
                        %endif%
                      </TD>
                      <TD class="oddrow" nowrap>
                      orderDirection
                        %ifvar orderDirection%
                          <input name="orderDirection" type="text" value="%value orderDirection%" size="5" maxlength="20"></input>
                        %else%
                          <input name="orderDirection" type="text" size="5" maxlength="20"></input>
                        %endif%
                      </TD>
                    </TR>
                    <TR>
                     <TD class="oddrow" nowrap>
                      Lowest level
                        %invoke KogunLogger.ui:getLevels%
                        %onerror%
                          <p>Error while fetching logfiles <br> %value error% %value errorMessage%</p>
                        %endinvoke%
                        %value selLevelString%
                      </TD>
                      <TD class="oddrow" nowrap>
                      timeFrom
                        %ifvar timeFrom%
                          <input name="timeFrom" type="text" value="%value timeFrom%" size="5" maxlength="20"></input>
                        %else%
                          <input name="timeFrom" type="text" size="5" maxlength="20"></input>
                        %endif%
                      </TD>
                      <TD class="oddrow" nowrap>
                      timeTo
                        %ifvar timeTo%
                          <input name="timeTo" type="text" value="%value timeTo%" size="5" maxlength="20"></input>
                        %else%
                          <input name="timeTo" type="text" size="5" maxlength="20"></input>
                        %endif%
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
</form>
            <TR>
        	<TD>
		  <TABLE class="tableView" width=100%>
			  <TR>
			    <TD class="heading" colspan="5">Log Entries</TD>
			  </TR>
			<tr>
				<td width="10%"><a href="javascript:fetch2('6')">Time stamp</a></td>
				<td width="15%"><a href="javascript:fetch2('2')">Caller</a></td>
				<td width="5%"><a href="javascript:fetch2('3')">Level</a></td>
				<td width="40%"><a href="javascript:fetch2('4')">Description</a></td>
				<td width="30%"><a href="javascript:fetch2('5')">XML</a></td>
			</tr>
			%loop logRecords%
			<tr class="oddrow-l">
				<td>%value LOGTIME%</td>
				<td>%value LOGTYPE%</td>
				<td>%value LOGLEVEL%</td>

				%ifvar XML%
					<td>%value LOGDATA%</td>
					<form name="myform" action="viewxml.dsp" method="post" target="_blank">
						<td valign="left"><textarea name="xmldata" cols="45" rows="4" style="background-color:#E0E0C0;" ondblclick="javascript:submit()">%value XML%</textarea></td>
					</form>
				%else%
					<td colspan="2">%value LOGDATA%</td>
				%endif%

			</tr>
			%endloop%
		   </TABLE>
	        </TD>
            </TR>
          </TABLE>

     </BODY>
