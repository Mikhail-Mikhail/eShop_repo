//------------------------------------------------------------------------------
package com.soft.entity;
//------------------------------------------------------------------------------

import org.junit.jupiter.api.Test;

import com.soft.helper.TestHelper;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.hibernate.annotations.Cache;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

//------------------------------------------------------------------------------

//JUnit-tests:

public class CategoryEntityTest {
	
   //Reference to instance of testing class.
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
       
//    	assertFalse(true, "Annots = "+CategoryEntity.class.getAnnotations().length);       
       
  // assertAnnotations(CategoryEntity.class, "id", Id.class, GeneratedValue.class, Column.class);  
       TestHelper.assertAnnotations(Arrays.asList(Entity.class, Table.class, Cache.class), Arrays.asList(CategoryEntity.class.getAnnotations()));             
     }    
     
     @Test
     public void secondTest() {
    	 	    
	   ce = new CategoryEntity(1L, "Resistors", "ResistorsEntity", bArr);
       assertTrue(ce.equals(ce));     
       assertEquals(12,12);  
     }          
}

