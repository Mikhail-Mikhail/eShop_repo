//------------------------------------------------------------------------------
package com.soft.dao;
//------------------------------------------------------------------------------

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.soft.config.AppConfig;
import com.soft.config.DataAccessConfig;

//------------------------------------------------------------------------------

@ContextConfiguration(classes = {AppConfig.class, DataAccessConfig.class})
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ActiveProfiles("development")
public class EshopDAOImplTest {
	
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
     public void daoTest() { 
    	boolean result = false;
    	Integer size = 0;
    	
//    	eshopDAOImpl = null;
    	 if(eshopDAOImpl!=null){
    //	   result =  eshopDAOImpl.testHSQLDB();
    	  size = eshopDAOImpl.testHSQLDB();
    	   Assertions.assertEquals(3, size, String.format("TEST FAILURE: Size = "+size.toString()));
   // 	   Assertions.assertEquals(true, result, String.format("TEST FAILURE: HSQLDB"));
         }    	 
    	 else {
    	   Assertions.assertEquals(false, true, String.format("TEST FAILURE: eshopDAOImpl = NULL"));		 
    	 }        	
     }
}
//------------------------------------------------------------------------------