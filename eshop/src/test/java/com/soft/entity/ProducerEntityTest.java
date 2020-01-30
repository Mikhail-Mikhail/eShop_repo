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

public class ProducerEntityTest {
	   
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
	       TestHelper.assertClassAnnotations(ProducerEntity.class, Entity.class, Table.class, Cache.class);              
	       
	        //Tests for presence of field's annotations.                     
	        TestHelper.assertFieldAnnotations(ProducerEntity.class, "id", Id.class, Column.class, GeneratedValue.class, GenericGenerator.class);
	        TestHelper.assertFieldAnnotations(ProducerEntity.class, "producerCategory", Column.class);
	        TestHelper.assertFieldAnnotations(ProducerEntity.class, "producerName", Column.class);            
	       
	         //Tests for presence of getter-method's annotations.                     
	         TestHelper.assertGetterAnnotations(ProducerEntity.class, "getId");                
	         TestHelper.assertGetterAnnotations(ProducerEntity.class, "getProducerCategory");                 
	         TestHelper.assertGetterAnnotations(ProducerEntity.class, "getProducerName");                                            
     }  
     
   
     @Test
     public void tableNameTest() {
      
       final String TABLE_NAME = "producer";
       
        //Get annotation "@Table" for class. 
        Table t = TestHelper.getClassAnnotation(ProducerEntity.class, Table.class);
    
         //Test table's name.
         Assertions.assertEquals(TABLE_NAME, t.name(), String.format("TEST FAILURE: Parameter \"name\" of annotation \"@table\" = "+"\""+t.name()+"\" instead of "+"\""+TABLE_NAME+"\""));              
     }  
     
  
     @Test
     public void idFieldAnnotationsTest() {
    	 
	      final String GENERATOR_VAL = "increment";
	      final String GENERIC_GENERATOR_NAME = "increment";
	      final String GENERIC_GENERATOR_STRATEGY = "increment";
	       
	       //Test for value of parameter "generator" of "@GeneratedValue" annotation.
	       GeneratedValue gv = TestHelper.getFieldAnnotation(ProducerEntity.class, "id", GeneratedValue.class);
	       Assertions.assertEquals(GENERATOR_VAL, gv.generator(), String.format("TEST FAILURE: For field \"id\" parameter \"generator\" of annotation \"@GeneratedValue\" = "+"\""+gv.generator()+"\" instead of "+"\""+GENERATOR_VAL+"\""));
	       
	        //Test for value of parameter "name" of "@GenericGenerator" annotation.        
	        GenericGenerator gg = TestHelper.getFieldAnnotation(ProducerEntity.class, "id", GenericGenerator.class);
	        Assertions.assertEquals(GENERIC_GENERATOR_NAME, gg.name(), String.format("TEST FAILURE: For field \"id\" parameter \"name\" of annotation \"@GenericGenerator\" = "+"\""+gg.name()+"\" instead of "+"\""+GENERIC_GENERATOR_NAME+"\""));            
	        
	         //Test for value of parameter "name" of "@GenericGenerator" annotation.                 
	         Assertions.assertEquals(GENERIC_GENERATOR_STRATEGY, gg.strategy(), String.format("TEST FAILURE: For field \"id\" parameter \"strategy\" of annotation \"@GenericGenerator\" = "+"\""+gg.strategy()+"\" instead of "+"\""+GENERIC_GENERATOR_STRATEGY+"\""));
     }
     
     
     @Test
     public void columnNameTest() {
    	 
	      final String COLUMN_ID = "producer_id";	 
	      final String COLUMN_PRODUCER_CATEGORY = "producer_category";
	      final String COLUMN_PRODUCER_NAME = "producer_name";            
	      
	      Column column = null;
	
	       //Get annotation @Column for field "producer_id".      
	       column = TestHelper.getFieldAnnotation(ProducerEntity.class, "id", Column.class);      
	       Assertions.assertEquals(COLUMN_ID, column.name(), String.format("TEST FAILURE: For field \"id\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_ID+"\""));
	
	        //Get annotation @Column for field "producer_category".      
	        column = TestHelper.getFieldAnnotation(ProducerEntity.class, "producerCategory", Column.class);      
	        Assertions.assertEquals(COLUMN_PRODUCER_CATEGORY, column.name(), String.format("TEST FAILURE: For field \"producerCategory\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_PRODUCER_CATEGORY+"\""));
	       
	         //Get annotation @Column for field "producer_name".      
	         column = TestHelper.getFieldAnnotation(ProducerEntity.class, "producerName", Column.class);      
	         Assertions.assertEquals(COLUMN_PRODUCER_NAME, column.name(), String.format("TEST FAILURE: For field \"producerName\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_PRODUCER_NAME+"\""));       
     }               
}

