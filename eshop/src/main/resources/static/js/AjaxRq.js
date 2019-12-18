//------------------------------------------------------------------------------

 "use strict" //Use strict mode ECMAScript 5.

//------------------------------------------------------------------------------

 // Call "PagePostConstruct()" function when the page first loads. 
 window.addEventListener("load", PagePostConstruct, false);
 
//------------------------------------------------------------------------------

 //Global variables:
   
 var langSelector;
 var catalogList;
 var catalogTable; 
 
 var homeURL = "/eshop/home.html";
 var catalogURL = "/eshop/catalog.html";
 
 var debugBox; //FOR DEBUG!
    
//------------------------------------------------------------------------------

  // Function is called after page loads.   
   
  function PagePostConstruct(){    
       
	//Find element to change language.  
	langSelector = document.getElementById("langChange");
	
    $('#catalogList').children().css("border", "1px solid red");
//	$('#catalogList').css("border", "1px solid red");
	
//	 //Find catalog table.  
//	 catalogTable = document.getElementById("catalogTable");	 
//
// 	 //Find catalog list.  
//	 catalogList = document.getElementById("catalogList");	 

//----------------	
//FOR DEBUG!  
debugBox = document.getElementById("debugBox");
//----------------

      //Register event's listeners.  
      SetEventListeners();            
  }
//------------------------------------------------------------------------------

  //Function to register event's listeners.
    
  function SetEventListeners() {                       
                
    //Set "onclick" event's listener for language selector.         
    langSelector.onclick = langSelectorOnClickHandler;	    
   } 
//------------------------------------------------------------------------------

  //Listener of event "onclick" for language selector.  

  function langSelectorOnClickHandler(){   	 
 	     
    //Request parameter.
    var par = "?lang="+langSelector.getAttribute('value');    

//-----------------------          
//Display debug message. 
debugBox.innerHTML = "Sending request...";
//-----------------------

      //Request for home.html with parameter "lang=ru" or "lang=en" to switch language.
      window.location.href = homeURL+par;
     
/*     
      //Send AJAX-request of type GET to server.       
      jQuery.ajax({
                   url: url,
                   type: "GET", 
                   headers: {
                     "Content-Type": undefined
                   },        
                   data: "lang="+langSelector.getAttribute('value'), 
                   processData: false,                                       
                   contentType: false, 
                   success: function(result) {                	   
                	 //Redirect to home.html  
                 // 	 window.location.href="home.html";  
                 //     debugBox.innerHTML = result.toString();     
                  }    
      });
   */   
  }
//------------------------------------------------------------------------------ 
  
//  //Listener of event "onclick" for elements to request Resistor's catalog.   
//
//  function resistorsOnClickHandler(){
//	 //Parameter of request.
//	 var par = "?group=resistors"; 
//
//	  //Request for catalog.html with parameter "group=resistors".
//	  window.location.href = catalogURL+par;
//  }	  
//------------------------------------------------------------------------------	  
  