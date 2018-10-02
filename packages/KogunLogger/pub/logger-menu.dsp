<HTML>
<HEAD>

<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">

<link rel="stylesheet" type="text/css" href="log.css">

<style>
   body {     border-top: 1px solid #97A6CB; }
</style>

<script src="menu.js.txt"></script>

</HEAD>

  %invoke KogunLogger.ui:getMenuTabs%
      

<BODY CLASS="menu" onload="initMenu('%value buttonUrls[0]/url%')">

<form name="urlsaver">
   <input type="hidden" name="helpURL" value="doc/OnlineHelp/WmRoot.htm#help-settings.dsp">
</form>


<table width="100%" cellspacing=0>

%ifvar buttonUrls%
<script>document.forms["urlsaver"].helpURL.value = '%scope buttonUrls[0]%%value tabhelp%%endscope%';</script>

<tr>
   <td class="menusection-Logs">
      <img src="/WmRoot/images/blank.gif" width="5" height="1" border="0">%value text%
   </td>
</tr>

%loop buttonUrls%

<tr>
   <td id="i%value url%" class="menuitem" onmouseover="menuMouseOver(this, '%value url%');" onmouseout="menuMouseOut(this);">
      
   <nobr><img valign="middle" src="/WmRoot/images/blank.gif" width="4" height="1" border="0">
         <img valign="middle" %ifvar url%name="%value url%"%endif% src="/WmRoot/images/blank.gif"
            height="8" width="8" border="0">&nbsp;
     %ifvar url equals('none')%<FONT CLASS="fakeanchor">%value name%</FONT>
        %else%<A id="a%value url%" TARGET="body"
           HREF="%value url%"
           onclick="adapterMenuClick('%value url%', '%value tabhelp%');">%value name%</A>%endif%</nobr>   
   </td>
</tr>

%endloop%

<tr>
   <td class="menuseparator"><img src="/WmRoot/images/blank.gif" width="3" height="3" border="0"></td>
</tr>

%endif%

</table>
%onerror%
            <p>Error while fetching menu <br> %value error% %value errorMessage%</p>
    %endinvoke%



</BODY>
</HTML>
