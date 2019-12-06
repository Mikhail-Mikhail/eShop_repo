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
  
//   public static final String ENGLISH = "en";
//   public static final String RUSSIAN = "ru";
//   public static final String ICONS_PATH = "/eshop/img/icons/";
//   
//   private String langName = "Русский";
//   private String langValue = "ru";   
//   private String langIcon = ICONS_PATH + "russian.png";
   
 
   //Request for "home.html":

   @RequestMapping(method=GET, path="/home.html")        
   public String renderHomePage(ModelMap model, HttpServletRequest request) {
	   
	 log.debug(""); 
     log.debug("Request for \"home.html\" received. ");
     
//      try {
////        setHomePageAttributes(model, ENGLISH);
//      }
//      catch(Exception exc) {            	
//   	    MyController.log.debug("[MyController.renderHomePage()] --> EXCEPTION: "+exc.getMessage());
//        MyController.log.debug("[MyController.renderHomePage()] --> EXCEPTION TO STRING: "+exc.toString());         	
//   	  }         
//       //Add attribute for language's label to display on page's header.
//       model.addAttribute("langLabelAttr", langName);
//     
//       //Add attribute for language's value.
//       model.addAttribute("langValueAttr", langValue);
//       
//       //Add attribute for language's icon.
//       model.addAttribute("langIconAttr", langIcon);
//       
//       //Add attribute for cart label.
//       model.addAttribute("cartLabelAttr", );
//       //Add attribute for login label.
//       model.addAttribute("loginLabelAttr", );
//       //Add attribute for registration label.
//       model.addAttribute("registrLabelAttr", );                           
              
    //Return page's name. 
    return "home.html";      
   }    
   
   
	   //Request to change language:
	
	   @RequestMapping(method=GET, path="/changelang")        
	   public ResponseEntity changeLanguage(ModelMap model, HttpServletRequest request) {      	      
		  
	      log.debug("Request for \"/changelang\" received. ");		      	      	      	      			      
	      
//  	          //Set language's name to display on the page's header.
//		      switch(request.getParameter("lang")) {	      
//		       case ENGLISH:
//		    	 langName = "Русский";
//		    	 langValue = "ru";
//		    	 langIcon = ICONS_PATH + "russian.png";
//		        break;   
//		        
//		       case RUSSIAN:
//			     langName = "English";
//			     langValue = "en";
//			     langIcon = ICONS_PATH + "english.png";
//			    break; 
//			   default:
//				 langName = "Русский";
//			     langValue = "ru";  
//			     langIcon = ICONS_PATH + "russian.png";
//		      }
	      	        
	      //Build and return response with status "ok".  
	      ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build(); 
		      
	    //Return response. 
	    return responseEntity;    
	   }	       		  

//------------------------------------------------------------------------------
 
//	    //Method to set attributes for home.html
//	   
//		boolean setHomePageAttributes(ModelMap model,String lang){
//			
//		  boolean res = false;
//		  
//		   try {
//		       //Add attribute for language's label to display on page's header.
//		       model.addAttribute("langLabelAttr", langName);
//			 
//			   //Add attribute for language's value.
//			   model.addAttribute("langValueAttr", langValue);
//			   
//			   //Add attribute for language's icon.
//			   model.addAttribute("langIconAttr", langIcon);
//			   
////			   //Add attribute for cart label.
////			   model.addAttribute("cartLabelAttr", );
////			   //Add attribute for login label.
////			   model.addAttribute("loginLabelAttr", );
////			   //Add attribute for registration label.
////			   model.addAttribute("registrLabelAttr", );
//			   
//			 res = true;   
//		   }
//		   catch(Exception exc) {            	
//			  MyController.log.debug("[MyController.setHomePageAttributes()] --> EXCEPTION: "+exc.getMessage());
//		      MyController.log.debug("[MyController.setHomePageAttributes()] --> EXCEPTION TO STRING: "+exc.toString());    
//		   }   
//		   finally {
//		     return res;
//		   }  
//		}
//------------------------------------------------------------------------------
}