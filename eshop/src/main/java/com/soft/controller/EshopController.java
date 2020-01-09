//---------------------------------------------------- --------------------------
package com.soft.controller;
//-------------------------------------------------------------------------------

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.soft.dao.EshopDAOImpl;
import com.soft.entity.BaseEntity;
import com.soft.entity.CategoryEntity;
import com.soft.entity.LocaleMessageEntity;
import com.soft.entity.ProducerEntity;
import com.soft.entity.ResistorEntity;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

//-------------------------------------------------------------------------------

// Class of MVC-controller.

@Controller
public class EshopController {
	 
  @Autowired
  //Data access layer.
  private EshopDAOImpl eshopDaoImpl;	
       
  // Create logger which will log messages to server's log and files. 
  // Files are located in the folder:  ../glassfish5/glassfish/domains/domain1/config/mylog2/
  // Logger's configuration is set in file "log4j2.xml". 
  // For Linux folder "mylogs" is located at /home/mihail/mylogs 
  public static final Logger log = LogManager.getLogger(EshopController.class.getName());
  
    //Constants:
  
    //Number of product's categories displayed in a row.  
    final Integer MAX_ROW_LENGTH = 4;
    //Number of items to display on a page.  
	final Integer MAX_ITEMS_ON_PAGE = 20;
    //Number of page's reference to display on a page.  
	final Integer MAX_REFERENCES_ON_PAGE = 5;
  
   //_______________________________________________________________//
  
   // Request for "home.html":

   @RequestMapping(method=GET, path="/home.html")        
   public String renderHomePage(ModelMap model, HttpServletRequest request) {	   
	 
	 log.debug(""); 
     log.debug("[EshopController.renderHomePage()] --> Request for \"home.html\" received. ");
     
      try {
       //Get product's categories list form DB.	  
       List<CategoryEntity> categoryList = eshopDaoImpl.readCategoryList();
       
        log.debug("[EshopController.renderHomePage()] --> Categories list size = "+categoryList.size());
       
         //Add attribute to display all elements of "categoryList" on a page "home.html". 
         model.addAttribute("categoryList", categoryList);
       
          //List of categories row lists. Each row contains ROW_LENGTH categories.
          List<List<CategoryEntity>> rowsList = new ArrayList<List<CategoryEntity>>();
          //List of categories to display in a single row.
          List<CategoryEntity> row = new ArrayList<CategoryEntity>();
                              
            Iterator<CategoryEntity> iterator =  categoryList.iterator();
             while(iterator.hasNext()) {
    	  
    	       row.add(iterator.next());
         
    	        if((row.size()==MAX_ROW_LENGTH)||(!iterator.hasNext())) {
               //log.debug("[EshopController.renderHomePage()] --> Current row list size = "+row.size());
               //log.debug("[EshopController.renderHomePage()] --> Current row = "+row.toString());
                  rowsList.add(row);
                   row = new ArrayList<CategoryEntity>();
                }  
             }
                     
       //log.debug("[EshopController.renderHomePage()] --> rowsList list size = "+rowsList.size());
       //log.debug("[EshopController.renderHomePage()] --> rowsList list = "+rowsList.toString());
       
       //Add attribute to display all elements of "categoryList" in a rows by ROW_LENGTH elements on a page "home.html". 
       model.addAttribute("rowsList", rowsList);       
      }
      catch(Exception exc) {            	
         log.debug("[EshopController.renderHomePage()] --> EXCEPTION: "+exc.getMessage());
    	 log.debug("[EshopController.renderHomePage()] --> EXCEPTION TO STRING: "+exc.toString());         	
      } 
                   
    //Return page's name. 
    return "home.html";      
   }    

   
   //_______________________________________________________________//

   // Requests for images:

   @RequestMapping(method=GET, path="/image")
   public void showImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
	   
//	 log.debug(""); 
//	 log.debug("[EshopController.showImage()] --> Request for \"/image\" received. ");
//	 
//	 log.debug("[EshopController.showImage()] --> "+"Entity =  "+request.getParameter("entity")+"  Id = "+request.getParameter("id").toString());
	 
	  try {
	 
  	    //Read entity from DB by "name" and "id".
	    BaseEntity be = eshopDaoImpl.readEntityByNameAndId(request.getParameter("entity"), Long.parseLong(request.getParameter("id")));
	 
	     response.setContentType("image/jpeg"); 

	      //Read entity's photo as a byte array and transmit it to response.
          InputStream inpStream = new ByteArrayInputStream(be.getPhoto());
          IOUtils.copy(inpStream, response.getOutputStream());
	  }  
	  catch(Exception exc) {            	
	     log.debug("[EshopController.showImage()] --> EXCEPTION: "+exc.getMessage());
	   	 log.debug("[EshopController.showImage()] --> EXCEPTION TO STRING: "+exc.toString());         	
	  } 
   }      
   
   
   //_______________________________________________________________//   
   
   // Request for list of items for selected category:

   @RequestMapping(method=GET, path="/list")        
   public String renderCatalogContent(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
	  
	 CategoryEntity categoryEntity = null;  
	 
	  //Request's parameter.  
	  String categoryID = ""; 
	   
	  log.debug(""); 
      log.debug("[EshopController.renderCatalogContent()] --> Request for \"catalog\" received.");
           
       try {
    	  //Get "id" of selected category from request. 
    	  categoryID = request.getParameter("id");
log.debug("[EshopController.renderCatalogContent()] --> Request's parameter category_ID ="+categoryID);
           
    	   //Read entity of selected category from DB. 
           categoryEntity = (CategoryEntity) eshopDaoImpl.readEntityByNameAndId(CategoryEntity.class.getSimpleName(), Long.parseLong(categoryID));                   

log.debug("[EshopController.renderCatalogContent()] --> Entity name = "+categoryEntity.getEntityName());           
           //Read list of entities from DB.
           List<BaseEntity> itemsList = eshopDaoImpl.readEntityListByName(categoryEntity.getEntityName(), 0, MAX_ITEMS_ON_PAGE);
           

//---------------------
           //Get number of records in DB table.
           Long num = eshopDaoImpl.getTableSizeByTableName(categoryEntity.getEntityName());
log.debug("[EshopController.renderCatalogContent()] --> numberOfRecords = "+num);
           
           //Read full list of entities from DB.
           List<BaseEntity> itemsFullList = eshopDaoImpl.readEntityListByName(categoryEntity.getEntityName(), null, null);
           //Get number of items in the list.
           Integer numberOfItems = itemsFullList.size();
           
           Integer numberOfPages = 1;
           Integer numberOfRefGroups = 0;
           
            //Calculate number of pages.
            if(numberOfItems > MAX_ITEMS_ON_PAGE){
              if((numberOfItems % MAX_ITEMS_ON_PAGE)==0){
               numberOfPages = numberOfItems/MAX_ITEMS_ON_PAGE;	  
              }
              else {
               numberOfPages = numberOfItems/MAX_ITEMS_ON_PAGE + 1;  
              }
              
               
              numberOfRefGroups = 1;
               //Calculate number of reference's groups.
               if(numberOfPages > MAX_REFERENCES_ON_PAGE){
            	 if((numberOfPages % MAX_REFERENCES_ON_PAGE)==0){
            		 numberOfRefGroups = numberOfPages/MAX_REFERENCES_ON_PAGE;	  
                 }
                  else {
                	  numberOfRefGroups = numberOfPages/MAX_REFERENCES_ON_PAGE + 1;  
                  }  
               }
               
              //Add attribute to display page's references.  
              model.addAttribute("itemsList", itemsList);  
            }	
                         
            
log.debug("[EshopController.renderCatalogContent()] --> numberOfPages = "+numberOfPages);
log.debug("[EshopController.renderCatalogContent()] --> numberOfRefGroups = "+ numberOfRefGroups);
//---------------------           
           
log.debug("[EshopController.renderCatalogContent()] --> itemsList.length = "+itemsList.size());

            //Read list of producers from DB.
            List<BaseEntity> producerList = eshopDaoImpl.readEntityListByName(ProducerEntity.class.getSimpleName(), null, null);
           
         //Add attribute to display navigation line.  
         model.addAttribute("selectedCategory", categoryEntity);  
              
          //Add attribute to display list of items.  
          model.addAttribute("itemsList", itemsList);
         
           //Add attribute to display producers.  
           model.addAttribute("producerList", producerList);
       }
       catch(Exception exc) {            	
   	     log.debug("[EshopController.renderCatalogContent()] --> EXCEPTION: "+exc.getMessage());
   	     log.debug("[EshopController.renderCatalogContent()] --> EXCEPTION TO STRING: "+exc.toString());         	
   	   }              
            
    //Return page's name.  
    return "list.html";  
   }         
 //------------------------------------------------------------------------------- 
}