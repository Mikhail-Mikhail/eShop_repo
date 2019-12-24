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
	
	  //Find all elements of catalog list and catalog table to set their "onclick" handlers.
	  $.merge($('#catalogList').children(), $('#catalogTable').find("td")).each(function(i, entry) {
		   entry.onclick = function(){
			   var url = "/eshop/list";
			   var data = "id="+entry.getAttribute('value');
			     
			     //Send AJAX-request to show content of selected category.
			     sendAjaxRequest("GET", url, data, showCategoryContent);			
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

  //Function to display content of the selected category.
  
  function showCategoryContent(result){

//----------------
//	 var str =  $(result).find(".item-name").each(function(i, entry) {
//		   entry.onclick = function(){		   
//			   var url = "/eshop/item";
//			   var data = entry.getAttribute('value');
//			     
//			     //Send AJAX-request to show content of selected item.
//			     sendAjaxRequest("GET", url, data, showItemContent);			
//		   }
//    });
//	 
//	//Insert result of AJAX-request into "content-container".
//    $(".content-container").html(str);	 
//	  
//	  
	  
	  //$.each(result, function(i, val) {   	  
  
//----------------		  
//	 $(".content-container").html("");	  
	  
	//Insert result of AJAX-request into "content-container".
	$(".content-container").html(result);
	
	  //Find all items of selected category and set their "onclick" handlers.
	  $(".item-name").each(function(i, entry) {
		   entry.onclick = function(){		   
			   var url = "/eshop/item";
			   var data = entry.getAttribute('value');
			     
			     //Send AJAX-request to show content of selected item.
			     sendAjaxRequest("GET", url, data, showItemContent);			
		   }
    });	  	 
  }
//------------------------------------------------------------------------------  
  
 //Function to display content of the selected item.
  
  function showItemContent(result){	 

	//Insert result of AJAX-request into "content-container".
	$(".content-container").html(result);	
  }
//------------------------------------------------------------------------------  