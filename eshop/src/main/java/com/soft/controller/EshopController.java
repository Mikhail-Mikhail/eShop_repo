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
import java.util.Locale;

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
          
     String lang = "en";
     
     try{
      lang = request.getParameter("lang");
     }
     catch(Exception exc) {  
      log.debug("[EshopController.renderHomePage()] --> EXCEPTION: "+exc.getMessage());
      log.debug("[EshopController.renderHomePage()] --> EXCEPTION TO STRING: "+exc.toString());      	      
     }
     
   
//     String catname = eshopDaoImpl.readLocaleMessageByKey("label.resistorName", lang).getMessage();

     CategoryEntity categoryEntity1 = new CategoryEntity(1L, eshopDaoImpl.readLocaleMessageByKey("locale_"+"resistor"+"CategoryName", lang).getMessage());
     CategoryEntity categoryEntity2 = new CategoryEntity(2L, eshopDaoImpl.readLocaleMessageByKey("locale_"+"transistor"+"CategoryName", lang).getMessage());
     CategoryEntity categoryEntity3 = new CategoryEntity(3L, eshopDaoImpl.readLocaleMessageByKey("locale_"+"ics"+"CategoryName", lang).getMessage());
     CategoryEntity categoryEntity4 = new CategoryEntity(4L, eshopDaoImpl.readLocaleMessageByKey("locale_"+"diode"+"CategoryName", lang).getMessage());
     CategoryEntity categoryEntity5 = new CategoryEntity(5L, eshopDaoImpl.readLocaleMessageByKey("locale_"+"capacitor"+"CategoryName", lang).getMessage());
     CategoryEntity categoryEntity6 = new CategoryEntity(6L, eshopDaoImpl.readLocaleMessageByKey("locale_"+"led"+"CategoryName", lang).getMessage());
     CategoryEntity categoryEntity7 = new CategoryEntity(7L, eshopDaoImpl.readLocaleMessageByKey("locale_"+"relay"+"CategoryName", lang).getMessage());
     CategoryEntity categoryEntity8 = new CategoryEntity(8L, eshopDaoImpl.readLocaleMessageByKey("locale_"+"connector"+"CategoryName", lang).getMessage());
     CategoryEntity categoryEntity9 = new CategoryEntity(9L, eshopDaoImpl.readLocaleMessageByKey("locale_"+"tumbler"+"CategoryName", lang).getMessage());
     CategoryEntity categoryEntity10 = new CategoryEntity(10L, eshopDaoImpl.readLocaleMessageByKey("locale_"+"powerSupply"+"CategoryName", lang).getMessage());
     
      ArrayList<CategoryEntity> categoriesList = new ArrayList<CategoryEntity>();
      
       categoriesList.add(categoryEntity1);
       categoriesList.add(categoryEntity2);
       categoriesList.add(categoryEntity3);
       categoriesList.add(categoryEntity4);
       categoriesList.add(categoryEntity5);
       categoriesList.add(categoryEntity6);
       categoriesList.add(categoryEntity7);
       categoriesList.add(categoryEntity8);
       categoriesList.add(categoryEntity9);
       categoriesList.add(categoryEntity10);
       
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