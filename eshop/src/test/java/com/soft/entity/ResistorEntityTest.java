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

public class ResistorEntityTest {
	   
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
       TestHelper.assertClassAnnotations(ResistorEntity.class, Entity.class, Table.class);              
       
        //Tests for presence of field's annotations.                     
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "id", Id.class, Column.class, GeneratedValue.class, GenericGenerator.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "category", Column.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "name", Column.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "description", Column.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "producer", Column.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "nominal", Column.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "nominalUnit", Column.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "rPrecision", Column.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "power", Column.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "powerUnit", Column.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "rPackage", Column.class);               
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "photo", Column.class);   
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "price", Column.class);
        TestHelper.assertFieldAnnotations(ResistorEntity.class, "quantity", Column.class);
       
         //Tests for presence of getter-method's annotations.                     
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getId");                
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getCategory");
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getName");
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getDescription");
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getProducer");
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getNominal");
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getNominalUnit");
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getrPrecision");
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getPower");
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getPowerUnit");
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getrPackage");                           
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getPhoto");   
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getPrice");
         TestHelper.assertGetterAnnotations(ResistorEntity.class, "getQuantity");
     }  
     
     
     @Test
     public void tableNameTest() {
      
       final String TABLE_NAME = "resistor";
       
        //Get annotation "@Table" for class. 
        Table t = TestHelper.getClassAnnotation(ResistorEntity.class, Table.class);
    
         //Test table's name.
         Assertions.assertEquals(TABLE_NAME, t.name(), String.format("TEST FAILURE: Parameter \"name\" of annotation \"@table\" = "+"\""+t.name()+"\" instead of "+"\""+TABLE_NAME+"\""));              
     }  
     
   
     @Test
     public void idFieldAnnotationsTest() {
    	 
	      final String GENERATOR_VAL = "increment";
	      final String GENERIC_GENERATOR_NAME = "increment";
	      final String GENERIC_GENERATOR_STRATEGY = "increment";
	       
	       //Test for value of parameter "generator" of "@GeneratedValue" annotation.
	       GeneratedValue gv = TestHelper.getFieldAnnotation(ResistorEntity.class, "id", GeneratedValue.class);
	       Assertions.assertEquals(GENERATOR_VAL, gv.generator(), String.format("TEST FAILURE: For field \"id\" parameter \"generator\" of annotation \"@GeneratedValue\" = "+"\""+gv.generator()+"\" instead of "+"\""+GENERATOR_VAL+"\""));
	       
	        //Test for value of parameter "name" of "@GenericGenerator" annotation.        
	        GenericGenerator gg = TestHelper.getFieldAnnotation(ResistorEntity.class, "id", GenericGenerator.class);
	        Assertions.assertEquals(GENERIC_GENERATOR_NAME, gg.name(), String.format("TEST FAILURE: For field \"id\" parameter \"name\" of annotation \"@GenericGenerator\" = "+"\""+gg.name()+"\" instead of "+"\""+GENERIC_GENERATOR_NAME+"\""));            
	        
	         //Test for value of parameter "name" of "@GenericGenerator" annotation.                 
	         Assertions.assertEquals(GENERIC_GENERATOR_STRATEGY, gg.strategy(), String.format("TEST FAILURE: For field \"id\" parameter \"strategy\" of annotation \"@GenericGenerator\" = "+"\""+gg.strategy()+"\" instead of "+"\""+GENERIC_GENERATOR_STRATEGY+"\""));
     }
    
     
     @Test
     public void columnNameTest() {
    	 
	      final String COLUMN_ID = "resistor_id";	 
	      final String COLUMN_CATEGORY = "category";
	      final String COLUMN_NAME = "name";
	      final String COLUMN_DESCRIPTION = "description";
	      final String COLUMN_PRODUCER = "producer";	 
	      final String COLUMN_NOMINAL = "nominal";
	      final String COLUMN_NOMINAL_UNIT = "nominal_unit";
	      final String COLUMN_RPRECISION = "r_precision";
	      final String COLUMN_POWER = "power";	 
	      final String COLUMN_POWER_UNIT = "power_unit";
	      final String COLUMN_PACKAGE = "package";
	      final String COLUMN_PHOTO = "photo";
	      final String COLUMN_PRICE = "price";	 
	      final String COLUMN_QUANTITY = "quantity";      
	      
	      Column column = null;
	
	       //Get annotation @Column for field "id".      
	       column = TestHelper.getFieldAnnotation(ResistorEntity.class, "id", Column.class);      
	       Assertions.assertEquals(COLUMN_ID, column.name(), String.format("TEST FAILURE: For field \"id\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_ID+"\""));
	
	        //Get annotation @Column for field "category".      
	        column = TestHelper.getFieldAnnotation(ResistorEntity.class, "category", Column.class);      
	        Assertions.assertEquals(COLUMN_CATEGORY, column.name(), String.format("TEST FAILURE: For field \"category\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_CATEGORY+"\""));
	
	         //Get annotation @Column for field "name".      
	         column = TestHelper.getFieldAnnotation(ResistorEntity.class, "name", Column.class);      
	         Assertions.assertEquals(COLUMN_NAME, column.name(), String.format("TEST FAILURE: For field \"name\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_NAME+"\""));
	
  	          //Get annotation @Column for field "description".      
	          column = TestHelper.getFieldAnnotation(ResistorEntity.class, "description", Column.class);      
	          Assertions.assertEquals(COLUMN_DESCRIPTION, column.name(), String.format("TEST FAILURE: For field \"description\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_DESCRIPTION+"\""));
	
	           //Get annotation @Column for field "producer".      
	           column = TestHelper.getFieldAnnotation(ResistorEntity.class, "producer", Column.class);      
	           Assertions.assertEquals(COLUMN_PRODUCER, column.name(), String.format("TEST FAILURE: For field \"producer\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_PRODUCER+"\""));
	
	            //Get annotation @Column for field "nominal".      
	            column = TestHelper.getFieldAnnotation(ResistorEntity.class, "nominal", Column.class);      
	            Assertions.assertEquals(COLUMN_NOMINAL, column.name(), String.format("TEST FAILURE: For field \"nominal\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_NOMINAL+"\""));
	
	             //Get annotation @Column for field "nominalUnit".      
	             column = TestHelper.getFieldAnnotation(ResistorEntity.class, "nominalUnit", Column.class);      
	             Assertions.assertEquals(COLUMN_NOMINAL_UNIT, column.name(), String.format("TEST FAILURE: For field \"nominalUnit\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_NOMINAL_UNIT+"\""));
	
	              //Get annotation @Column for field "rPrecision".      
	              column = TestHelper.getFieldAnnotation(ResistorEntity.class, "rPrecision", Column.class);      
	              Assertions.assertEquals(COLUMN_RPRECISION, column.name(), String.format("TEST FAILURE: For field \"rPrecision\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_RPRECISION+"\""));
	
	               //Get annotation @Column for field "power".      
	               column = TestHelper.getFieldAnnotation(ResistorEntity.class, "power", Column.class);      
	               Assertions.assertEquals(COLUMN_POWER, column.name(), String.format("TEST FAILURE: For field \"power\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_POWER+"\""));
	
	                //Get annotation @Column for field "powerUnit".      
	                column = TestHelper.getFieldAnnotation(ResistorEntity.class, "powerUnit", Column.class);      
	                Assertions.assertEquals(COLUMN_POWER_UNIT, column.name(), String.format("TEST FAILURE: For field \"powerUnit\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_POWER_UNIT+"\""));
	
	             //Get annotation @Column for field "rPackage".      
	             column = TestHelper.getFieldAnnotation(ResistorEntity.class, "rPackage", Column.class);      
	             Assertions.assertEquals(COLUMN_PACKAGE, column.name(), String.format("TEST FAILURE: For field \"rPackage\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_PACKAGE+"\""));

	           //Get annotation @Column for field "photo".      
	           column = TestHelper.getFieldAnnotation(ResistorEntity.class, "photo", Column.class);      
	           Assertions.assertEquals(COLUMN_PHOTO, column.name(), String.format("TEST FAILURE: For field \"photo\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_PHOTO+"\""));

	          //Get annotation @Column for field "price".      
	          column = TestHelper.getFieldAnnotation(ResistorEntity.class, "price", Column.class);      
	          Assertions.assertEquals(COLUMN_PRICE, column.name(), String.format("TEST FAILURE: For field \"price\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_PRICE+"\""));
		
	        //Get annotation @Column for field "quantity".      
	        column = TestHelper.getFieldAnnotation(ResistorEntity.class, "quantity", Column.class);      
	        Assertions.assertEquals(COLUMN_QUANTITY, column.name(), String.format("TEST FAILURE: For field \"quantity\" parameter \"name\" of annotation \"@Column\" = "+"\""+column.name()+"\" instead of "+"\""+COLUMN_QUANTITY+"\""));
     }                          
}

