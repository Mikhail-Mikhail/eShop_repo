//---------------------------------------------------- --------------------------
package com.soft.controller;
//------------------------------------------------------------------------------

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.soft.dao.EshopDAOImpl;
import com.soft.entity.LocaleMessageEntity;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

//------------------------------------------------------------------------------

// Class of MVC-controller.

@Controller
public class MyController {
	 
  @Autowired
  private EshopDAOImpl eshopDaoImpl;	
     
  // Create logger which will log messages to GlassFish server's log and files. 
  // Files are located in the folder:  ../glassfish5/glassfish/domains/domain1/config/mylog2/
  // Logger's configuration is set in file "log4j2.xml". 
  // For Linux folder "mylogs" is located at /home/mihail/mylogs 
  public static final Logger log = LogManager.getLogger(MyController.class.getName()); 
  public static final Logger logHeader = LogManager.getLogger("MyHeadersLogger");     
  
   final private String ENGLISH = "en";
   final private String RUSSIAN = "ru";
   private String languageName = "Русский";
   private String languageValue = "ru";	
   
 
   //Request for "home.html":

   @RequestMapping(method=GET, path="/home.html")        
   public String renderHomePage(ModelMap model, HttpServletRequest request) {
	   
	 log.debug(""); 
     log.debug("Request for \"home.html\" received. ");  

      //Set model's attributes which is used for creation "home.html".                    
//      model.addAttribute("headerAttr", "eShop!");
//      model.addAttribute("homePage", true);
     
       //Add attribute for language's name to display on page's header.
       model.addAttribute("langNameAttr", languageName);
     
       //Add attribute for language's value.
       model.addAttribute("langValueAttr", languageValue);
               
      log.debug("Try to get locale message... ");
      LocaleMessageEntity localeMsgEntity = eshopDaoImpl.readLocaleMessageByKey("label.test", "en");
      log.debug("Locale message = "+localeMsgEntity.getMessage());
      
              
    //Return page's name. 
    return "home.html";      
   }    
   
   
	   //Request to change language:
	
	   @RequestMapping(method=GET, path="/changelang")        
	   public ResponseEntity changeLanguage(ModelMap model, HttpServletRequest request) {      	      
		  
	      log.debug("Request for \"/changelang\" received. ");	
	      
//	      model.addAttribute("Status", "Lang OK!");	      	      	      			       
	      
  	          //Set language's name to display on the page's header.
		      switch(request.getParameter("lang")) {	      
		       case ENGLISH:
		    	 languageName = "Русский";
		    	 languageValue = "ru";
		        break;   
		        
		       case RUSSIAN:
			     languageName = "English";
			     languageValue = "en";
			    break; 
			   default:
				 languageName = "Русский";
			     languageValue = "ru";  
		      }
	      
	        //Set attribute for language's name to display on page's header.
	        model.addAttribute("langNameAttr", languageName);
	        
	        //Set attribute for language's value.
	        model.addAttribute("langValueAttr", languageValue);
	        
	      //Build and return response with status "ok".  
	      ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build(); 
		      
	    //Return response. 
	    return responseEntity;    
	   }	       		  
}
//------------------------------------------------------------------------------