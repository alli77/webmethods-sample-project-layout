<HTML>
<HEAD>
    <TITLE>Modify logger</TITLE>
    <META http-equiv="Pragma" content="no-cache">
    <META http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <META http-equiv="Expires" content="-1">
    <LINK rel="stylesheet" type="text/css" href="/WmRoot/webMethods.css">
    <SCRIPT type="text/javascript" src="/WmRoot/webMethods.js.txt"></SCRIPT>
    <SCRIPT type="text/javascript" src="diverse.js.txt"></SCRIPT>

<script language="JavaScript">
<!--

function submitIfValid(frm) {


if (isEmpty(frm.NumberOfDays)) {
    alert("Number of days must be specified.");
    frm.NumberOfDays.focus();
    return false;
  }
if (!validateNoDays(frm.NumberOfDays.value)) {
     return false;
   }
if (isEmpty(frm.NumberOfDays)) {
    alert("Number of days must be specified!");
    frm.NumberOfDays.focus();
    return false;
  }
frm.submit();
}

function validateNoDays(arg) {

  var legal = "1234567890";
  for (var i = 0; i < arg.length; i++)
  {
    var c = arg.charAt(i);
    if (legal.indexOf(c) == -1 )
    {
      alert("Valid characters in Number of days are: 0-9");
      return false;
    }
  }

  return true;
}

// -->
</script>



</HEAD>

<BODY>
<table width=100%>
  <tr class="menusection-Logs">
    <td colspan=2>
	<img style="float:right" src="/WmRoot/icons/blank.gif">
	<a href="javascript:history.back()">
	<img class="back" src="/WmRoot/icons/nav-back.gif" border=0></a>
	Logger setup
    </td>
  </tr>
</table>

%switch mode%
  %case 'modify'%
    %invoke KogunLogger.pub:modifySetup%
      <TD class="message" colspan="2">%value Message%</TD>
    %endinvoke%
%endswitch%

<table width=100% border=0>

  <FORM method="post" name="settings" action="editsetup.dsp" target="_self">
    <input type="hidden" name="mode" value="modify">
    <tr class="heading">
      <td colspan=2 align="left">%value activeIM% Logger setup </td>
    </tr>
    %invoke KogunLogger.ui:getModifySetup%
    %value tblModifyString%

  </FORM>
</table>
<FORM method="post" action="" target="_self">
<div class="action">
  <input type="hidden" name="activeIM" value=%value activeIM%>
  <input type="hidden" name="type" value="logger">
  <input type="button" value=" Save " onclick="document.settings.submit()">&nbsp;&nbsp;&nbsp;
  <input type="submit" value="Cancel">
</div>
</FORM>
</BODY>
</HTML>
%endinvoke%