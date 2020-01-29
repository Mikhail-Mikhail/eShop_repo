//------------------------------------------------------------------------------
package com.soft.helper;
//------------------------------------------------------------------------------

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;

import com.soft.entity.CategoryEntity;

//------------------------------------------------------------------------------

//Class of static methods for testing.

public class TestHelper {
	
	//Method to check presence of annotations. 
	public static void assertAnnotations(String testElementName, List<Class> expectedAnnotationClasses, List<Annotation> actualAnnotations) {
		
       //Compare quantity of expected and actual annotations.
	   if (expectedAnnotationClasses.size() != actualAnnotations.size()) {
	     throw new AssertionError(String.format("TEST FAILURE: "+testElementName+". Expected %d annotations, but found %d .", expectedAnnotationClasses.size(), actualAnnotations.size()));	      
	   }

        //Check presence of an expected annotation in the actual annotation's list.  
	    expectedAnnotationClasses.forEach(

	       ac -> {
	        long cnt  = actualAnnotations.stream().filter(a -> a.annotationType().isAssignableFrom(ac)).count();	         	           	            

	          if (cnt == 0) {
	            throw new AssertionError(String.format("TEST FAILURE: "+testElementName+". No annotation of type %s found.", ac.getName()));	          
	          }
	       }
	    );
    }
	
	
	  //Method to check class's annotations.
	  //If class has no annotation third parameter "annotationClasses" should be omitted.
	  public static void assertClassAnnotations(Class cls, Class... annotationClasses) {		 

		 try {
	        assertAnnotations("Class "+"\""+cls.getCanonicalName()+"\"", Arrays.asList(annotationClasses), Arrays.asList(cls.getAnnotations()));		        		        		    
	     } 
		 catch (Exception e) {
	       throw new AssertionError(e);
		 }
	  }
	
  	  //Method to check field's annotations.
	  //If field has no annotation third parameter "annotationClasses" should be omitted.
	  public static void assertFieldAnnotations(Class c, String fieldName, Class... annotationClasses) {		 

		 try {
	        assertAnnotations("Field "+"\""+fieldName+"\"", Arrays.asList(annotationClasses), Arrays.asList(c.getDeclaredField(fieldName).getAnnotations()));		        		        		    
	     } 
		 catch (NoSuchFieldException nsfe) {
 	       throw new AssertionError(nsfe);
		 }
	  }
	  
  	  //Method to check getter-method's annotations.
	  //If method has no annotation third parameter "annotationClasses" should be omitted.
	  public static void assertGetterAnnotations(Class c, String methodName, Class...annotationClasses) {
		     
		 try {  
		    assertAnnotations("Method "+"\""+methodName+"\"", Arrays.asList(annotationClasses), Arrays.asList(c.getDeclaredMethod(methodName).getAnnotations()));		        		        		     
         } 
  	     catch (NoSuchMethodException nsfe) {
	        throw new AssertionError(nsfe);
		 }
	  }
	  	  
	    //Method to get class's annotation. 
	    public static <T extends Annotation> T getClassAnnotation(Class<?> c, Class<T> annotation) {		
		  return (T) c.getAnnotation(annotation);
		}
}
//------------------------------------------------------------------------------