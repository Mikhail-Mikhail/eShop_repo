//------------------------------------------------------------------------------

 "use strict" //Use strict mode ECMAScript 5.

//------------------------------------------------------------------------------

 // Call "PagePostConstruct()" function when the page first loads. 
 window.addEventListener("load", PagePostConstruct, false);
 
//------------------------------------------------------------------------------

 //Global variables:
   
 var langSelector;
 
 var debugBox; //FOR DEBUG!
    
//------------------------------------------------------------------------------

  // Function is called after page loads.   
   
  function PagePostConstruct(){    
       
	//Find element to change language.  
	langSelector = document.getElementById("langChange");
	 	  
	//FOR DEBUG!  
	debugBox = document.getElementById("debugBox");
	
      //Register event's listeners.  
      SetEventListeners();            
  }
//------------------------------------------------------------------------------

  //Function to register event's listeners.
    
  function SetEventListeners() {                       
                
    //Set listener of event "onclick" for language selector.         
    langSelector.onclick = langSelectorOnClickHandler;	
   } 
//------------------------------------------------------------------------------

  //Listener of event "onclick" for language selector.  

  function langSelectorOnClickHandler(){   	 
 	  
    // URL of request.
    var url = '/eshop/changelang';    
    var files;
          
     //Display message. 
     debugBox.innerHTML = "Sending request...";          
   
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
                	 window.location.href="home.html";  
                     /* debugBox.innerHTML = result.toString(); */    
                  }  
      });            
  }
//------------------------------------------------------------------------------       