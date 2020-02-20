//------------------------------------------------------------------------------
package com.soft.dao;
//------------------------------------------------------------------------------

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.soft.config.AppConfig;
import com.soft.config.DataAccessConfig;
import com.soft.controller.EshopController;
import com.soft.entity.BaseEntity;
import com.soft.entity.CategoryEntity;
import com.soft.entity.LocaleMessageEntity;
import com.soft.entity.PersonEntity;

import javassist.tools.reflect.Reflection;

//------------------------------------------------------------------------------

@ContextConfiguration(classes = {AppConfig.class, DataAccessConfig.class})
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ActiveProfiles("development")
public class EshopDAOImplTest {
		
	//Get logger.
	Logger log = LogManager.getLogger(EshopController.class.getName());	
	
	@Autowired
	EshopDAOImpl eshopDAOImpl;
	
	 //Execute before all tests.
     @BeforeAll
     public static void init() {        
     }

     //Execute after all tests.
     @AfterAll
     public static void tearDown() {     	    	
     } 
    
     
   //Test of method "readLocaleMessageByKey()".
   @Test 
   public void readLocaleMessageByKeyTest(){
	   
	   try {
		    log.debug("");
			log.debug("[EshopDAOImplTest.readLocaleMessageByKeyTest()] --> Test of method \"EshopDAOImpl.readLocaleMessageByKey()\" in progress...");	
		    	  		  	  
			  //Create instance of "LocaleMessageEntity".
 		  	  LocaleMessageEntity lmeExpected = (LocaleMessageEntity) LocaleMessageEntity.createInstance();
 		      log.debug("Expected object = " + lmeExpected.toString());
		  	   
		  	    //Save entity to HSQLDB.
		  	    eshopDAOImpl.saveEntity(lmeExpected);
		  	   
		  	     //Read entity from HSQLDB.
		  	     LocaleMessageEntity lmeActual  = eshopDAOImpl.readLocaleMessageByKey(lmeExpected.getMsgKey(), lmeExpected.getLocale());		  	 
		  	   
		  	       log.debug("Expected object modified by Hibernate = " + lmeExpected.toString());
  		  	       log.debug("Actual object = " + lmeActual.toString());
		  	 		
  		  	        ///Check if expected and actual entities are equal.
		  	        boolean checkResult = lmeExpected.equals(lmeActual);
		  	        Assertions.assertEquals(checkResult, true, String.format("TEST FAILURE FOR CLASS \"EshopDAOImpl\": Method \"readLocaleMessageByKey()\" fails."));		  	   
		    	     
		     //Clear DB's table.  
			 eshopDAOImpl.clearTable(lmeExpected.getClass().getName()); 
		      	 	     		       	 	   
		  log.debug("[EshopDAOImplTest.readLocaleMessageByKeyTest()] --> Test of method \"EshopDAOImpl.readLocaleMessageByKey()\" successfully completed.");		       	        	        	    	      	    	    
		 }
		 catch(Exception exc) {                    	   
      	   log.debug("[EshopDAOImplTest.readLocaleMessageByKeyTest()] --> EXCEPTION: "+exc.getMessage());
           log.debug("[EshopDAOImplTest.readLocaleMessageByKeyTest()] --> EXCEPTION TO STRING: "+exc.toString());
      }	     	   
   }     
  
   
   
    //Test of method "readCategoryList()".
    @Test 
    public void readCategoryListTest(){
    	
    	boolean checkResult = false;
    	
    	 try {
    		  log.debug(""); 
 			  log.debug("[EshopDAOImplTest.readCategoryListTest()] --> Test of method \"EshopDAOImpl.readCategoryList()\" in progress...");	
 		    	  		  	  
 			   List<CategoryEntity> expectedList = new ArrayList();
 			   
 			    //Create instance of "CategoryEntity".
 		        CategoryEntity ce = (CategoryEntity) CategoryEntity.createInstance(); 		         		         
 		        
 		          //Add entity to list.
 		          expectedList.add(ce);
                     
 		           //Test's data.
 		           byte[] photo  = new byte[] {22, 1, 40, 88};

 		            //Create instance of "CategoryEntity".
                    ce = new CategoryEntity(2L, "IamCategoryEntity2", "MyCategory2", photo);   			  		  	  
  		             
                     //Add entity to list.
  		             expectedList.add(ce);
  		           
  		              //Save all entities to HSQLDB.
  		              for(CategoryEntity categoryEntity : expectedList) {
  		                log.debug("Entity to write to DB = " + categoryEntity.toString());	
   		 		  	     //Save entity to HSQLDB.
  		 		  	     eshopDAOImpl.saveEntity(categoryEntity);
  		              }
  		         
  		              log.debug("Expected list = " + expectedList.toString());  		          
 		  	   
  		              
                    //Read list of "CategoryEntity" from HSQLDB. 
 		  	        List<CategoryEntity> actualList = eshopDAOImpl.readCategoryList(); 

 		  	         log.debug("Actual list = " + actualList.toString());
 		  	         

   		  	          //Check if sizes of expected list and actual list are equal.
 		  	          if(expectedList.size()!=actualList.size()) checkResult = false;
 		  	           else {
 		  	        	
 		  	        	  Iterator<CategoryEntity> expectedIterator = expectedList.iterator();
 		  	        	  Iterator<CategoryEntity> actualIterator = actualList.iterator();
 		  	        	  
 		  	            	CategoryEntity ExpectedCategoryEntity = null;
		  	        		CategoryEntity ActualCategoryEntity = null;
		  	        				
 		  	        	   //Check if all entities in expected and actual lists are equal.  
 		  	        	   while(expectedIterator.hasNext() && actualIterator.hasNext()) {
 		  	        		   
 		  	        		 ExpectedCategoryEntity = expectedIterator.next();
 		  	        		 ActualCategoryEntity = actualIterator.next();
 		  	        		   
 		  	        		  if(!(ExpectedCategoryEntity.equals(ActualCategoryEntity))) {
 		  	        			//Lists are not equal.  
 		  	        		    checkResult = false; 		  	        		    
 		  	        		    break;	 
 		  	        		  }
 	 		  	        	//Lists are equal. 
 	 		  	        	checkResult = true; 
 	   		               }  
 		  	           }
   		              
		  	    Assertions.assertEquals(checkResult, true, String.format("TEST FAILURE FOR CLASS \"EshopDAOImpl\": Method \"readCategoryList()\" fails."));		  	   
 		    	     
 		     //Clear DB's table.  
 			 eshopDAOImpl.clearTable(ce.getClass().getName()); 
 		      	 	     		       	 	   
 		  log.debug("[EshopDAOImplTest.readCategoryListTest()] --> Test of method \"EshopDAOImpl.readCategoryList()\" successfully completed.");		       	        	        	    	      	    	    
 		 }
 		 catch(Exception exc) {                    	   
       	   log.debug("[EshopDAOImplTest.readCategoryListTest()] --> EXCEPTION: "+exc.getMessage());
            log.debug("[EshopDAOImplTest.readCategoryListTest()] --> EXCEPTION TO STRING: "+exc.toString());
         } 	
    }
    
    
      @Test 
      public void getTableSizeByTableNameTest() {
    	  
    	 Integer tableSize;
   	     String entityClassName; 
    	 
	    	try {
	    	  log.debug("");	
	    	  log.debug("[EshopDAOImplTest.getTableSizeByTableNameTest()] --> Test of method \"EshopDAOImpl.getTableSizeByTableNameTest()\" in progress...");	
	    	  
	    	   //Get list of all entity's classes in project.	
	    	   Reflections reflections = new Reflections("com.soft.entity");	    	   	    	 	    	  	    	      	  	    	  	    	   
	    	     Set<Class> entitiesClassSet = reflections.getTypesAnnotatedWith(javax.persistence.Entity.class).stream().collect(Collectors.toSet());
	    	     log.debug("[EshopDAOImplTest.getTableSizeByTableNameTest()] --> Entity classes: "+entitiesClassSet.toString());    	         	         	  
	    	          	     	    	     
	    	    //Check sizes of all DB tables. Tables are empty and sizes must be equal 0.  
	    	    for(Class entityClass : entitiesClassSet) {
	    	    	
	    	       //Get name of entity's class.	
	    		   entityClassName = entityClass.getSimpleName();
	    		    //Get table's size.
	    		    tableSize = eshopDAOImpl.getTableSizeByTableName(entityClassName);	
	    		     log.debug("[EshopDAOImplTest.getTableSizeByTableNameTest()] --> Entity: "+entityClassName+": tableSize = "+tableSize);
	    		 //Check if table's size is 0.
	   	    	 Assertions.assertEquals(0, tableSize, String.format("TEST FAILURE FOR CLASS \"EshopDAOImpl\": Method \"getTableSizeByTableName("+entityClassName+")\" returned \"size\" = "+tableSize.toString()));   
	    	    }
	    	    
	    	    //Populate DB's tables with data and check table's sizes again.
	    	    for(Class entityClass : entitiesClassSet) {
	    	    	
	    	       //Get static method of entity's class.	
	    	       Method createInstanceMethod = entityClass.getMethod("createInstance");
	    	        //Create entity's instance.
	       	        BaseEntity entity = (BaseEntity) createInstanceMethod.invoke(null);	
	       	        log.debug("[EshopDAOImplTest.getTableSizeByTableNameTest()] --> Entity: "+entity.toString());
	       	       
	       	         //Save entity to DB's table.  
	       	         eshopDAOImpl.saveEntity(entity);  
	     	     
	      	          //Get name of entity's class.	
	      		      entityClassName = entityClass.getSimpleName();
	      		     
	       	           //Get table's size.
	     		       tableSize = eshopDAOImpl.getTableSizeByTableName(entityClassName);
	     		       log.debug("[EshopDAOImplTest.getTableSizeByTableNameTest()] --> Entity: "+entityClassName+": tableSize = "+tableSize);
	     		   
	       	     Assertions.assertEquals(1, tableSize, String.format("TEST FAILURE FOR CLASS \"EshopDAOImpl\": Method \"getTableSizeByTableName("+entityClassName+")\" returned \"size\" = "+tableSize.toString()));   
	      	    }  	    	    	    	    
	    	  
	    	    //Clear all DB's tables and check table's sizes again.
	    	    for(Class entityClass : entitiesClassSet) {
	    	    		       	      	       	       	     	     
	      	        //Get name of entity's class.	
	      	        entityClassName = entityClass.getSimpleName();
	      	         
	      	         //Clear DB's table.  
		       	     eshopDAOImpl.clearTable(entityClassName); 
	      	 	     
	       	           //Get table's size.
	     		       tableSize = eshopDAOImpl.getTableSizeByTableName(entityClassName);
	     		       log.debug("[EshopDAOImplTest.getTableSizeByTableNameTest()] --> Entity: "+entityClassName+": tableSize = "+tableSize);
	     		   
	       	     Assertions.assertEquals(0, tableSize, String.format("TEST FAILURE FOR CLASS \"EshopDAOImpl\": Method \"getTableSizeByTableName("+entityClassName+")\" returned \"size\" = "+tableSize.toString()));   
	      	    }    	    	      	    	    
	    	}
	    	catch(Exception exc) {                    	   
	        	log.debug("[EshopDAOImplTest.getTableSizeByTableNameTest()] --> EXCEPTION: "+exc.getMessage());
	            log.debug("[EshopDAOImplTest.getTableSizeByTableNameTest()] --> EXCEPTION TO STRING: "+exc.toString());
	    	}	     	  
	  }
    
//     @Test 
//     public void daoTest() { 
//    	boolean result = false;
//    	Integer size = 0;
//    	
////    	eshopDAOImpl = null;
//    	 if(eshopDAOImpl!=null){
//    //	   result =  eshopDAOImpl.testHSQLDB();
//    	  size = eshopDAOImpl.testHSQLDB();
//    	   Assertions.assertEquals(2, size, String.format("TEST FAILURE: Size = "+size.toString()));
//   // 	   Assertions.assertEquals(true, result, String.format("TEST FAILURE: HSQLDB"));
//         }    	 
//    	 else {
//    	   Assertions.assertEquals(false, true, String.format("TEST FAILURE: eshopDAOImpl = NULL"));		 
//    	 }        	
//     }
}
//------------------------------------------------------------------------------