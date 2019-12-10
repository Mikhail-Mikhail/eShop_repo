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
import com.soft.entity.CategoryEntity;
import com.soft.entity.LocaleMessageEntity;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;

//------------------------------------------------------------------------------

// Class of MVC-controller.

@Controller
public class EshopController {
	 
  @Autowired
  private EshopDAOImpl eshopDaoImpl;	
     
  // Create logger which will log messages to GlassFish server's log and files. 
  // Files are located in the folder:  ../glassfish5/glassfish/domains/domain1/config/mylog2/
  // Logger's configuration is set in file "log4j2.xml". 
  // For Linux folder "mylogs" is located at /home/mihail/mylogs 
  public static final Logger log = LogManager.getLogger(EshopController.class.getName());     
      
   //Request for "home.html":

   @RequestMapping(method=GET, path="/home.html")        
   public String renderHomePage(ModelMap model, HttpServletRequest request) {
	   
	 log.debug(""); 
     log.debug("[EshopController.renderCatalogPage()] --> Request for \"home.html\" received. ");
     
//------------------
     CategoryEntity categoryEntity1 = new CategoryEntity(1L, "Resistors");
     CategoryEntity categoryEntity2 = new CategoryEntity(2L, "Transistors");
     CategoryEntity categoryEntity3 = new CategoryEntity(2L, "Connectors");
     
      ArrayList<CategoryEntity> categoriesList = new ArrayList<CategoryEntity>();
      
       categoriesList.add(categoryEntity1);
       categoriesList.add(categoryEntity2);
       categoriesList.add(categoryEntity3);
       
     model.addAttribute("categoriesList", categoriesList);
     
//------------------     
                   
    //Return page's name. 
    return "home.html";      
   }         

   
   //Request for "catalog.html":

   @RequestMapping(method=GET, path="/catalog.html")        
   public String renderCatalogPage(ModelMap model, HttpServletRequest request) {
	  
	 //Request's parameter.  
	 String reqPar = ""; 
	   
	 log.debug(""); 
     log.debug("[EshopController.renderCatalogPage()] --> Request for \"catalog.html\" received.");
     
       try {
    	  reqPar = request.getParameter("group");
           log.debug("[EshopController.renderCatalogPage()] --> Request's parameter ="+reqPar);
       }
       catch(Exception exc) {            	
   	     log.debug("[EshopController.renderCatalogPage()] --> EXCEPTION: "+exc.getMessage());
   	     log.debug("[EshopController.renderCatalogPage()] --> EXCEPTION TO STRING: "+exc.toString());         	
   	   } 
       
      model.addAttribute("group", "Resistors");
                               
    //Return page's name. 
    return "catalog.html";      
   }         
//------------------------------------------------------------------------------ 
}