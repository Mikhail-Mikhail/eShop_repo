//------------------------------------------------------------------------------
package com.soft.entity;
//------------------------------------------------------------------------------

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

//------------------------------------------------------------------------------

//JUnit-tests:

public class CategoryEntityTest {
	
   //Reference to instance oftesting class..
   CategoryEntity ce;
   
   static byte[] bArr;
   
    //Execute before all tests.
    @BeforeAll
    public static void init() {       
      bArr = new byte[2]; 
    }

    //Execute after all tests.
    @AfterAll
    public static void tearDown() {  
      bArr = null;	
    } 

     @Test
     public void firstTest() {
    	 	    
	   ce = new CategoryEntity(1L, "Resistors", "ResistorsEntity", bArr);
	   assertTrue(ce.equals(ce));
       assertEquals(12,12);
       
//       AssertAnnotations.assertType(CategoryEntity.class, Entity.class, Table.class);
     }    
     
     @Test
     public void secondTest() {
    	 	    
	   ce = new CategoryEntity(1L, "Resistors", "ResistorsEntity", bArr);
       assertTrue(ce.equals(ce));     
       assertEquals(12,12);  
     }    
}

