//------------------------------------------------------------------------------
package com.soft.dao;
//------------------------------------------------------------------------------

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

//------------------------------------------------------------------------------

@ContextConfiguration
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
    	 
    	boolean result =  eshopDAOImpl.testHSQLDB();    	
        Assertions.assertEquals(result, true, String.format("TEST FAILURE: HSQLDB "));	
     }
}
//------------------------------------------------------------------------------