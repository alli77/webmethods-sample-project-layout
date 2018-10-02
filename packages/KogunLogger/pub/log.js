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
   function submitIfValid(frm) {
     
     arg = Trim(frm.logger.value);
     document.settings.logger.value = arg;
     if (isEmpty(frm.logger)) {
       alert("Logger name must be specified!");
       return false;
     }
     
     if (!validateLoggerName(frm.logger.value)) {
   	return false;	
     }
     
     if (!validateNoDays(frm.NumberOfDays.value)) {
     	return false;	
       }
   
   
     for(var i = 0; i < loggers.length; i++ ){
   	if(loggers[i] == frm.logger.value){
   		alert("Logger name already in use.");
   		frm.logger.select();
   		frm.logger.focus();
   		return false;
   	}
     }
   
     if (isEmpty(frm.NumberOfDays)) {
       alert("Number of days must be specified!");
       frm.NumberOfDays.focus();
       return false;
     }
     
     frm.submit();
   }

   function validateLoggerName(arg) {
   
     var legal = "ABCDEFGHIJKLMNOPQRSTUVWXZYZabcdefghijklmnopqrstuvwxyz1234567890_-";
     for (var i = 0; i < arg.length; i++)
     {
       var c = arg.charAt(i);
       if (legal.indexOf(c) == -1 )
       {
         if( c == " " )
           alert("Spaces are not allowed in Logger names.");
         else
           alert(c + " is not a legal character in Logger name.\nValid characters are:\nA-Z (uppercase and lowercase)\n0-9\nUnderscore ( _ )\nSeparator ( - )");
         return false;
       }
     }
   
     return true;
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