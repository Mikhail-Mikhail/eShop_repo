//------------------------------------------------------------------------------
package com.soft.entity;
//------------------------------------------------------------------------------

import org.junit.jupiter.api.Test;
import com.soft.helper.TestHelper;
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

//JUnit5-tests for class "CategoryEntity":

public class CategoryEntityTest {
	   
    //Execute before all tests.
    @BeforeAll
    public static void init() {        
    }

    //Execute after all tests.
    @AfterAll
    public static void tearDown() {  
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
     
   
     @Test
     public void idFieldAnnotationsTest() {
    	 
      final String GENERATOR_VAL = "increment";
      final String GENERIC_GENERATOR_NAME = "increment";
      final String GENERIC_GENERATOR_STRATEGY = "increment";
       
       //Test for value of parameter "generator" of "@GeneratedValue" annotation.
       GeneratedValue gv = TestHelper.getFieldAnnotation(CategoryEntity.class, "id", GeneratedValue.class);
       Assertions.assertEquals(GENERATOR_VAL, gv.generator(), String.format("TEST FAILURE: For field \"id\" parameter \"generator\" of annotation \"@GeneratedValue\" = "+"\""+gv.generator()+"\" instead of "+"\""+GENERATOR_VAL+"\""));
       
        //Test for value of parameter "name" of "@GenericGenerator" annotation.        
        GenericGenerator gg = TestHelper.getFieldAnnotation(CategoryEntity.class, "id", GenericGenerator.class);
        Assertions.assertEquals(GENERIC_GENERATOR_NAME, gg.name(), String.format("TEST FAILURE: For field \"id\" parameter \"name\" of annotation \"@GenericGenerator\" = "+"\""+gg.name()+"\" instead of "+"\""+GENERIC_GENERATOR_NAME+"\""));            
        
         //Test for value of parameter "name" of "@GenericGenerator" annotation.                 
         Assertions.assertEquals(GENERIC_GENERATOR_STRATEGY, gg.strategy(), String.format("TEST FAILURE: For field \"id\" parameter \"strategy\" of annotation \"@GenericGenerator\" = "+"\""+gg.strategy()+"\" instead of "+"\""+GENERIC_GENERATOR_STRATEGY+"\""));
     }
     
     
     @Test
     public void columnNameTest() {
    	 
      final String COLUMN_ID = "category_id";	 
      final String COLUMN_NAME = "name";
      final String COLUMN_ENTITY_NAME = "entity_name";
      final String COLUMN_PHOTO = "photo";      
      
      Column column = null;

       //Get annotation @Column for field "id".      
       column = TestHelper.getFieldAnnotation(CategoryEntity.class, "id", Column.class);      
       Assertions.assertEquals(COLUMN_ID, column.name(), String.format("TEST FAILURE: For field \"id\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_ID+"\""));

        //Get annotation @Column for field "name".      
        column = TestHelper.getFieldAnnotation(CategoryEntity.class, "name", Column.class);      
        Assertions.assertEquals(COLUMN_NAME, column.name(), String.format("TEST FAILURE: For field \"name\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_NAME+"\""));
       
         //Get annotation @Column for field "entityName".      
         column = TestHelper.getFieldAnnotation(CategoryEntity.class, "entityName", Column.class);      
         Assertions.assertEquals(COLUMN_ENTITY_NAME, column.name(), String.format("TEST FAILURE: For field \"entityName\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_ENTITY_NAME+"\""));
       
          //Get annotation @Column for field "photo".      
          column = TestHelper.getFieldAnnotation(CategoryEntity.class, "photo", Column.class);      
          Assertions.assertEquals(COLUMN_PHOTO, column.name(), String.format("TEST FAILURE: For field \"photo\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_PHOTO+"\""));
     }                
}

