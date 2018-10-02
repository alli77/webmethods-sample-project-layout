<HTML>

<HEAD>

<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<META HTTP-EQUIV="Expires" CONTENT="-1">


<LINK REL="stylesheet" TYPE="text/css" HREF="webMethods.css">

</HEAD>


<script>
function launchHelp()
   {
      if(parent.menu != null){
         window.open(parent.menu.document.forms["urlsaver"].helpURL.value, 'help', "directories=no,location=yes,menubar=yes,scrollbars=yes,status=yes,toolbar=yes,resizable=yes", true);
      }
   }


function loadPage(url)
  {
     window.location.replace(url);
  }


%ifvar message%
  %ifvar norefresh%%else%
    setTimeout("loadPage('top.dsp')", 30000);
        %endif%
%endif%



</script>



   <BODY  class="topbar" topmargin="0" leftmargin="0" marginwidth="0" marginheight="0">


<table border=0 cellspacing=0 cellpadding=0 height=47 width=100%>
<tr>
<td>

      <TABLE height=14 width=100% CELLSPACING=0 BORDER=0>

         <TR>

            <TD nowrap class="toptitle" width="100%">

              %value $host%
              ::
              Integration Server%ifvar text%
              ::
              %value text%%endif%
            </TD>

            <TD bgcolor="FFFFFF">

               <IMG src="images/newlogo.gif" border=0>
</TD>

         </TR>

      </TABLE>


</td>
</tr>
<tr height=100%>
<td>

<TABLE width=100% height=33 CELLSPACING=0 BORDER=0>

         <TR>
         		%ifvar adapter%
         		%else%
            %invoke wm.server.query:getKeyInfo%
              %ifvar keyExpired%
              <TD width=100%><center><A class="keymessage"
                HREF="settings-license.dsp"
                TARGET="body">License Key is Expired or Invalid.</A></center></TD>
              %else%
                %ifvar keyExpiresIn%
                <TD width=100%><center>
                  &nbsp;<A class="keymessage"
                  HREF="settings-license.dsp"
                  TARGET="body">%ifvar keyExpiresIn equals('0')%
                    License Key expires today.
                  %else%
                    License Key expires in about %value keyExpiresIn% days
                  %endif%</A></center></TD>

                %else%
                <TD nowrap width=100% class="topmenu">&nbsp;</TD>

                %endif%
              %endif%
            %endinvoke%
            %endif%
            <TD nowrap valign="bottom" class="topmenu">

               %ifvar adapter%
<A  href='javascript:window.parent.close();'>Close Window</A>

		%ifvar adapter equals('SAP')%| <a  target="body" href="/SAP/sapAbout_aboutPage.dsp">About</a>%endif%
                %ifvar help%| <A target='adapter-body' onclick="launchHelp();return false;" href='#'>Help</A>%endif%
               %else%
               <A target='body' href='server-shutdown.dsp%ifvar css%?css=%value css%%endif%'>
Shut Down and Restart</A>
 | <A target='_parent' href='/invoke/wm.server/disconnect'
               onclick="return confirm('OK to Log Off?')" >Log Off</A>
 | <A target='body' href='server-environment.dsp'>About</A>

                | <A target='body' onclick="launchHelp();return false;" href='#'>Help</A>&nbsp;
                %endif%
            </TD>

         </TR>
         <TR>

         </TR>
      </TABLE>

</td>
</tr>
</table></BODY>
</HTML>
