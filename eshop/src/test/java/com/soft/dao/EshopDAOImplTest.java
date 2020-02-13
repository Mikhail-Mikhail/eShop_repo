//------------------------------------------------------------------------------
package com.soft.dao;
//------------------------------------------------------------------------------

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
    
    
      @Test 
      public void getTableSizeByTableNameTest() {
    	 
    	try {
    	  //Get list of all entities in project.	
    	  Reflections reflections = new Reflections("com.soft.entity");
    	  Set<String> entitySet = reflections.getTypesAnnotatedWith(javax.persistence.Entity.class).stream().map(Class::getName).collect(Collectors.toSet());
    	 
    	  log.debug("[EshopDAOImplTest.getTableSizeByTableNameTest()] --> Entities: "+entitySet.toString());
    	      	  
    	   Integer tableSize;
    	   
//	    	 PersonEntity personEntity = new PersonEntity(1L, "Mike");
//	    	 eshopDAOImpl.saveEntity(personEntity);
    	   
    	    for(String entityClassName : entitySet) {
    		   
    		 tableSize = eshopDAOImpl.getTableSizeByTableName(entityClassName);	
    		 log.debug("[EshopDAOImplTest.getTableSizeByTableNameTest()] --> Entity "+entityClassName+": tableSize = "+tableSize);
   	    	  Assertions.assertEquals(0, tableSize, String.format("TEST FAILURE FOR CLASS \"EshopDAOImpl\": Method \"getTableSizeByTableName("+entityClassName+")\" returned \"size\" = "+tableSize.toString()));   
    	    }
    	 
//    		String entityClassName = PersonEntity.class.getSimpleName(); 
//	    	tableSize = eshopDAOImpl.getTableSizeByTableName(entityClassName);	
//	    	Assertions.assertEquals(0, tableSize, String.format("TEST FAILURE FOR CLASS \"EshopDAOImpl\": Method \"getTableSizeByTableName("+entityClassName+")\" returned \"size\" = "+tableSize.toString()));
//	    	
//	    	 PersonEntity personEntity = new PersonEntity(1L, "Mike");
//	    	 eshopDAOImpl.saveEntity(personEntity);
//	    	  tableSize = eshopDAOImpl.getTableSizeByTableName(entityClassName);	
//	     	  Assertions.assertEquals(1, tableSize, String.format("TEST FAILURE FOR CLASS \"EshopDAOImpl\": Method \"getTableSizeByTableName("+entityClassName+")\" returned \"size\" = "+tableSize.toString()));	     	  	     	  
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