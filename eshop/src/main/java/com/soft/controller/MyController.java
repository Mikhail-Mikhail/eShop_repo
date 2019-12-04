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
      model.addAttribute("headerAttr", "eShop!");
      model.addAttribute("homePage", true);                    
              
    //Return page's name. 
    return "home.html";      
   }    
   
   
	   //Request to change language:
	
	   @RequestMapping(method=GET, path="/changelang")        
	   public String changeLanguage(ModelMap model, HttpServletRequest request) {      	      
		  
	      log.debug("Request for \"/changelang\" received. ");	
	      
	      model.addAttribute("Status", "Lang OK!"); 
	      	             
	    //Return response. 
	    return "layout :: StatusFragment";      
	   }	       		  
}
//------------------------------------------------------------------------------