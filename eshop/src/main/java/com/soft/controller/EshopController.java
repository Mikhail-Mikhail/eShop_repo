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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

//------------------------------------------------------------------------------

// Class of MVC-controller.

@Controller
public class EshopController {
	 
  @Autowired
  //Data access layer.
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
     
      try {
       //Get product's categories list form DB.	  
       List<CategoryEntity > categoryList = eshopDaoImpl.readCategoryList();
      
        log.debug("[EshopController.renderCatalogPage()] --> Categories list size = "+categoryList.size());
       
       //Add attribute to display all elements of "categoryList" on a page "home.html". 
       model.addAttribute("categoryList", categoryList);
       
//       model.addAttribute("rowsQuantity", (int) 3);
//-----------------------
       
       List<List<CategoryEntity>> rowsList = new ArrayList<List<CategoryEntity>>();
       List<CategoryEntity> row = new ArrayList<CategoryEntity>();
       final int ROW_LENGTH = 4;
/*       
        for(CategoryEntity category : categoryList) {
          
          
           row.add(category);
            if(row.size()==ROW_LENGTH) {
              rowsList.add(row);
              row.clear();
            }
            else if(categoryList.) {
            	
            }
        }
*/
       
//Convert byte[of entities to files:
//for(CategoryEntity category:categoryList) {
// File file = new File(FILEPATH);		
//}
       
              
       
       Iterator<CategoryEntity> iterator =  categoryList.iterator();
       while(iterator.hasNext()) {
    	  
    	 row.add(iterator.next());
         
    	   if((row.size()==ROW_LENGTH)||(!iterator.hasNext())) {
           log.debug("[EshopController.renderCatalogPage()] --> Current row list size = "+row.size());
           log.debug("[EshopController.renderCatalogPage()] --> Current row = "+row.toString());
             rowsList.add(row);
             row = new ArrayList<CategoryEntity>();
           }  
       }
       
              
       log.debug("[EshopController.renderCatalogPage()] --> rowsList list size = "+rowsList.size());
       log.debug("[EshopController.renderCatalogPage()] --> rowsList list = "+rowsList.toString());
       
       
       model.addAttribute("rowsList", rowsList);
//-----------------------       
      }
      catch(Exception exc) {            	
         log.debug("[EshopController.renderHomePage()] --> EXCEPTION: "+exc.getMessage());
    	 log.debug("[EshopController.renderHomePage()] --> EXCEPTION TO STRING: "+exc.toString());         	
      } 
                   
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