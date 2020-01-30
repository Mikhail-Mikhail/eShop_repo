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

//JUnit5-tests for class "LocaleMessageEntity":

public class LocaleMessageEntityTest {
	   
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
       TestHelper.assertClassAnnotations(LocaleMessageEntity.class, Entity.class, Table.class, Cache.class);              
       
        //Tests for presence of field's annotations.                     
        TestHelper.assertFieldAnnotations(LocaleMessageEntity.class, "id", Id.class, Column.class, GeneratedValue.class, GenericGenerator.class);
        TestHelper.assertFieldAnnotations(LocaleMessageEntity.class, "locale", Column.class);
        TestHelper.assertFieldAnnotations(LocaleMessageEntity.class, "msgKey", Column.class);
        TestHelper.assertFieldAnnotations(LocaleMessageEntity.class, "message", Column.class);      
       
         //Tests for presence of getter-method's annotations.                     
         TestHelper.assertGetterAnnotations(LocaleMessageEntity.class, "getId");                
         TestHelper.assertGetterAnnotations(LocaleMessageEntity.class, "getLocale");                 
         TestHelper.assertGetterAnnotations(LocaleMessageEntity.class, "getMsgKey");                  
         TestHelper.assertGetterAnnotations(LocaleMessageEntity.class, "getMessage");                  
     }  
     
    
     @Test
     public void tableNameTest() {
      
       final String TABLE_NAME = "locale";
       
        //Get annotation "@Table" for class. 
        Table t = TestHelper.getClassAnnotation(LocaleMessageEntity.class, Table.class);
    
         //Test table's name.
         Assertions.assertEquals(TABLE_NAME, t.name(), String.format("TEST FAILURE: Parameter \"name\" of annotation \"@table\" = "+"\""+t.name()+"\" instead of "+"\""+TABLE_NAME+"\""));              
     }  
            
     
     @Test
     public void idFieldAnnotationsTest() {
    	 
      final String GENERATOR_VAL = "increment";
      final String GENERIC_GENERATOR_NAME = "increment";
      final String GENERIC_GENERATOR_STRATEGY = "increment";
       
       //Test for value of parameter "generator" of "@GeneratedValue" annotation.
       GeneratedValue gv = TestHelper.getFieldAnnotation(LocaleMessageEntity.class, "id", GeneratedValue.class);
       Assertions.assertEquals(GENERATOR_VAL, gv.generator(), String.format("TEST FAILURE: For field \"id\" parameter \"generator\" of annotation \"@GeneratedValue\" = "+"\""+gv.generator()+"\" instead of "+"\""+GENERATOR_VAL+"\""));
       
        //Test for value of parameter "name" of "@GenericGenerator" annotation.        
        GenericGenerator gg = TestHelper.getFieldAnnotation(LocaleMessageEntity.class, "id", GenericGenerator.class);
        Assertions.assertEquals(GENERIC_GENERATOR_NAME, gg.name(), String.format("TEST FAILURE: For field \"id\" parameter \"name\" of annotation \"@GenericGenerator\" = "+"\""+gg.name()+"\" instead of "+"\""+GENERIC_GENERATOR_NAME+"\""));            
        
         //Test for value of parameter "name" of "@GenericGenerator" annotation.                 
         Assertions.assertEquals(GENERIC_GENERATOR_STRATEGY, gg.strategy(), String.format("TEST FAILURE: For field \"id\" parameter \"strategy\" of annotation \"@GenericGenerator\" = "+"\""+gg.strategy()+"\" instead of "+"\""+GENERIC_GENERATOR_STRATEGY+"\""));
     }
     
     
     @Test
     public void columnNameTest() {
    	 
      final String COLUMN_ID = "ID";	 
      final String COLUMN_LOCALE = "locale";
      final String COLUMN_MSGKEY = "msgkey";
      final String COLUMN_MESSAGE = "message";      
      
      Column column = null;

       //Get annotation @Column for field "id".      
       column = TestHelper.getFieldAnnotation(LocaleMessageEntity.class, "id", Column.class);      
       Assertions.assertEquals(COLUMN_ID, column.name(), String.format("TEST FAILURE: For field \"id\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_ID+"\""));

        //Get annotation @Column for field "locale".      
        column = TestHelper.getFieldAnnotation(LocaleMessageEntity.class, "locale", Column.class);      
        Assertions.assertEquals(COLUMN_LOCALE, column.name(), String.format("TEST FAILURE: For field \"locale\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_LOCALE+"\""));
       
         //Get annotation @Column for field "msgKey".      
         column = TestHelper.getFieldAnnotation(LocaleMessageEntity.class, "msgKey", Column.class);      
         Assertions.assertEquals(COLUMN_MSGKEY, column.name(), String.format("TEST FAILURE: For field \"msgKey\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_MSGKEY+"\""));
       
          //Get annotation @Column for field "message".      
          column = TestHelper.getFieldAnnotation(LocaleMessageEntity.class, "message", Column.class);      
          Assertions.assertEquals(COLUMN_MESSAGE, column.name(), String.format("TEST FAILURE: For field \"message\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_MESSAGE+"\""));
     }                          
}

