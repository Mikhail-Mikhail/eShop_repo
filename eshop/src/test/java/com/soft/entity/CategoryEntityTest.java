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
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

//------------------------------------------------------------------------------

//JUnit-tests:

public class CategoryEntityTest {
	
   //Reference to instance of testing class.
   CategoryEntity ce;
   
//   static byte[] bArr;
   
    //Execute before all tests.
    @BeforeAll
    public static void init() {       
//      bArr = new byte[2]; 
    }

    //Execute after all tests.
    @AfterAll
    public static void tearDown() {  
//      bArr = null;	
    } 

     @Test
     public void annotationsTest() {
    	 	   
       //Test for presence of class's annotations.	 
       TestHelper.assertClassAnnotations(CategoryEntity.class, Entity.class, Table.class, Cache.class);              
       
        //Tests for presence of field's annotations.                     
        TestHelper.assertFieldAnnotations(CategoryEntity.class, "id", Id.class, Column.class, GeneratedValue.class, GenericGenerator.class);
        TestHelper.assertFieldAnnotations(CategoryEntity.class, "name", Column.class);
        TestHelper.assertFieldAnnotations(CategoryEntity.class, "entityName", Column.class);
        TestHelper.assertFieldAnnotations(CategoryEntity.class, "photo", Column.class);      
       
         //Tests for presence of getter-method's annotations.                     
         TestHelper.assertGetterAnnotations(CategoryEntity.class, "getId");                
         TestHelper.assertGetterAnnotations(CategoryEntity.class, "getName");                 
         TestHelper.assertGetterAnnotations(CategoryEntity.class, "getEntityName");                  
         TestHelper.assertGetterAnnotations(CategoryEntity.class, "getPhoto");                  
     }  
     
     @Test
     public void tableNameTest() {
      
       final String TABLE_NAME = "category";
       
        //Get annotation "@Table" for class. 
        Table t = TestHelper.getClassAnnotation(CategoryEntity.class, Table.class);
    
         //Test table's name.
         Assertions.assertEquals(TABLE_NAME, t.name(), String.format("TEST FAILURE: Parameter \"name\" of annotation \"@table\" = "+"\""+t.name()+"\" instead of "+"\""+TABLE_NAME+"\""));              
     }  
}

