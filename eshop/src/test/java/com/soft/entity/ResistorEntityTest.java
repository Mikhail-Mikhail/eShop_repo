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

//JUnit5-tests for class "ResistorEntity":

public class ResistorEntityTest {
	
   //Class to test.
   private Class cls = ResistorEntity.class;
	    
   //Fields of testing class.
   final private static String[] fields = new String[] {"id", "category", "name", "description", "producer", "nominal", "nominalUnit", "rPrecision", "power", "powerUnit", "rPackage", "photo", "price", "quantity"};
		
   //Getters of testing class.
   final private static String[] getters = new String[] {"getId", "getCategory", "getName", "getDescription", "getProducer", "getNominal", "getNominalUnit", "getrPrecision", "getPower", "getPowerUnit", "getrPackage", "getPhoto", "getPrice", "getQuantity"};
   	
	   
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
      TestHelper.assertClassAnnotations(cls, Entity.class, Table.class);              
      
       //Tests for presence of field's annotations.                     
       TestHelper.assertFieldAnnotations(cls, "id", Id.class, Column.class, GeneratedValue.class, GenericGenerator.class);
               
         //Tests for presence of field's annotation @Column.
	      for(int i=1; i < fields.length; i++) {
	    	TestHelper.assertFieldAnnotations(cls, fields[i], Column.class);	  
	      }

         //Tests for presence of getter-method's annotations.	      
	      for(int i=0; i < getters.length; i++) {
	       TestHelper.assertGetterAnnotations(cls, getters[i]);	  
	      }	  
    }      
    
     
     @Test
     public void tableNameTest() {
      
       final String TABLE_NAME = "resistor";
       
        //Get annotation "@Table" for class. 
        Table t = TestHelper.getClassAnnotation(cls, Table.class);
    
         //Test table's name.
         Assertions.assertEquals(TABLE_NAME, t.name(), String.format("TEST FAILURE: Parameter \"name\" of annotation \"@table\" = "+"\""+t.name()+"\" instead of "+"\""+TABLE_NAME+"\""));              
     }  
     
   
     @Test
     public void idFieldAnnotationsTest() {
    	 
	      final String GENERATOR_VAL = "increment";
	      final String GENERIC_GENERATOR_NAME = "increment";
	      final String GENERIC_GENERATOR_STRATEGY = "increment";
	       
	       //Test for value of parameter "generator" of "@GeneratedValue" annotation.
	       GeneratedValue gv = TestHelper.getFieldAnnotation(cls, "id", GeneratedValue.class);
	       Assertions.assertEquals(GENERATOR_VAL, gv.generator(), String.format("TEST FAILURE: For field \"id\" parameter \"generator\" of annotation \"@GeneratedValue\" = "+"\""+gv.generator()+"\" instead of "+"\""+GENERATOR_VAL+"\""));
	       
	        //Test for value of parameter "name" of "@GenericGenerator" annotation.        
	        GenericGenerator gg = TestHelper.getFieldAnnotation(cls, "id", GenericGenerator.class);
	        Assertions.assertEquals(GENERIC_GENERATOR_NAME, gg.name(), String.format("TEST FAILURE: For field \"id\" parameter \"name\" of annotation \"@GenericGenerator\" = "+"\""+gg.name()+"\" instead of "+"\""+GENERIC_GENERATOR_NAME+"\""));            
	        
	         //Test for value of parameter "name" of "@GenericGenerator" annotation.                 
	         Assertions.assertEquals(GENERIC_GENERATOR_STRATEGY, gg.strategy(), String.format("TEST FAILURE: For field \"id\" parameter \"strategy\" of annotation \"@GenericGenerator\" = "+"\""+gg.strategy()+"\" instead of "+"\""+GENERIC_GENERATOR_STRATEGY+"\""));
     }
    
     @Test
     public void columnNameTest() {     	 
	      
	    //Values of parameter "name" of annotation @Column(name = "xxxxxx").
	    String[] columnNames = new String[] {"resistor_id", "category", "name", "description", "producer", "nominal", "nominal_unit", "r_precision", "power", "power_unit", "package", "photo", "price", "quantity"};	      
	       
	     Column column = null;
	     
	      //Compare actual and expected values of parameter "name" of annotation @Column(name = "xxxxxx").
	      for(int i=0; i<fields.length; i++) {
	        //Get annotation @Column for field.       	        
	        column = TestHelper.getFieldAnnotation(cls, fields[i], Column.class);      
	        Assertions.assertEquals(columnNames[i], column.name(), String.format("TEST FAILURE: For field \""+fields[i]+"\" actual parameter \"name\" of annotation \"@Column\" is "+"\""+column.name()+"\" instead of expected "+"\""+columnNames[i]+"\""));
	      } 	
     }      
}

