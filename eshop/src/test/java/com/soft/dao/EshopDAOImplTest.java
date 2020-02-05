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

import com.soft.config.AppConfig;
import com.soft.config.DataAccessConfig;

//------------------------------------------------------------------------------

@ContextConfiguration(classes = {AppConfig.class, DataAccessConfig.class})
@ExtendWith(SpringExtension.class)
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
    	 if(eshopDAOImpl!=null){
    	  result =  eshopDAOImpl.testHSQLDB();
    	  Assertions.assertEquals(result, true, String.format("TEST FAILURE: HSQLDB "));
         }    	 
    	 else {
    	   Assertions.assertEquals(false, true, String.format("TEST FAILURE: eshopDAOImpl = NULL"));		 
    	 }        	
     }
}
//------------------------------------------------------------------------------