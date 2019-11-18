//---------------------------------------------------- --------------------------
package com.soft.controller;
//------------------------------------------------------------------------------

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.soft.dao.localeDAOImpl;
import com.soft.entity.MessageEntity;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

//------------------------------------------------------------------------------

// Class of MVC-controller.

@Controller
public class MyController {
	
  @Autowired
  private localeDAOImpl daoImpl;	
     
  // Create logger which will log messages to GlassFish server's log and files. 
  // Files are located in the folder:  ../glassfish5/glassfish/domains/domain1/config/mylog2/
  // Logger's configuration is set in file "log4j2.xml". 
  // For Linux folder "mylogs" is located at /home/mihail/mylogs 
  public static final Logger log = LogManager.getLogger(MyController.class.getName()); 
  public static final Logger logHeader = LogManager.getLogger("MyHeadersLogger");      
 
   //Request for "home.html":

   @RequestMapping(method=GET, path="/home.html")        
   public String renderHomePage(ModelMap model, HttpServletRequest request) {
	   
	 log.debug(""); 
     log.debug("Request for \"home.html\" received. ");  

      //Set model's attributes which is used for creation "home.html".                    
      model.addAttribute("headerAttr", "Hi! Enjoy to test internationalization example!");
      model.addAttribute("homePage", true);                    
              
    //Return page's name. 
    return "home.html";      
   }    
   
   
	   //Request for "greeting.html":
	
	   @RequestMapping(method=GET, path="/greeting.html")        
	   public String renderGreetingPage(ModelMap model, HttpServletRequest request) {      
	      
		  //Set model's attributes which is used for creation "greeting.html".                    
		  model.addAttribute("langSelected", true);
		  
	      log.debug("Request for \"greeting.html\" received. ");
	      
	      log.trace("Log Level = TRACE");
	      log.debug("Log Level = DEBUG");
	      log.info("Log Level = INFO");
	      log.warn("Log Level = WARN");
	      log.error("Log Level = ERROR");
	      log.fatal("Log Level = FATAL");
	      
	      logHeader.trace("logHeader Level = TRACE");
	      logHeader.debug("logHeader Level = DEBUG");
	      logHeader.info("logHeader Level = INFO");
	      logHeader.warn("logHeader Level = WARN");
	      logHeader.error("logHeader Level = ERROR");
	      logHeader.fatal("logHeader Level = FATAL");	      
	      	             
	    //Return page's name. 
	    return "greeting.html";      
	   }
	   
    
		   //Request for "text.html":
			
		   @RequestMapping(method=GET, path="/text.html")        
		   public String renderTextPage(ModelMap model, HttpServletRequest request) {      
		      
			  //Set model's attributes which is used for creation "text.html".                    
			  model.addAttribute("langSelected", true);
			  
		      logHeader.debug("Request for \"text.html\" received. ");       
		              
		    //Return page's name. 
		    return "text.html";      
		   }
}
//------------------------------------------------------------------------------