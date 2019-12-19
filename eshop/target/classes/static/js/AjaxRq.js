//------------------------------------------------------------------------------

 "use strict" //Use strict mode ECMAScript 5.

//------------------------------------------------------------------------------

 // Call "PagePostConstruct()" function when the page first loads. 
 window.addEventListener("load", PagePostConstruct, false);
 
//------------------------------------------------------------------------------

 //Global variables:
   
 var langSelector; 
 
 var homeURL = "/eshop/home.html";
 
 var debugBox; //FOR DEBUG!
    
//------------------------------------------------------------------------------

  // Function is called after page loads.   
   
  function PagePostConstruct(){    
       
	//Find element to change language.  
	langSelector = document.getElementById("langChange");
	

	  //Find all elements of catalog list and set its "onclick" handlers.
	  $('#catalogList').children().each(function(i, entry) {
		   entry.onclick = function(){
			   var url = "/eshop/catalog";
			   var data = "id="+entry.value
			     
			     //Send AJAX-request.
			     sendAjaxRequest("GET", url, data, showCatalog);			
		   }
      });
	 
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

  //Function to send AJAX-request.
  
  function sendAjaxRequest(requestType, url, data, callbackFunc){
  
	      //Send AJAX-request.       
	      jQuery.ajax({
	                   url: url,
	                   type: requestType, 
	                   headers: {
	                     "Content-Type": undefined
	                   },        
	                   data: data, 
	                   processData: false,                                       
	                   contentType: false, 
	                   success: function(result) {                	   
	                	  callbackFunc(result);       
	                  }    
	      }); 
  }	      
//------------------------------------------------------------------------------	
  
  function showCatalog(result){	 
	alert("Response recieved!!!");
//	$("content-container").
  }
//------------------------------------------------------------------------------  