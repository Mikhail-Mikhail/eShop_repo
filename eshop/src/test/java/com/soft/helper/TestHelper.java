//------------------------------------------------------------------------------
package com.soft.helper;
//------------------------------------------------------------------------------

import java.lang.annotation.Annotation;
import java.util.List;

//------------------------------------------------------------------------------

//Class of static methods for testing.

public class TestHelper {
	
	//Method to check presence of annotations. 
	public static void assertAnnotations(List<Class> expectedAnnotationClasses, List<Annotation> annotations) {
		
       //Compare quantity of expected and actual annotations.
	   if (expectedAnnotationClasses.size() != annotations.size()) {
	     throw new AssertionError(String.format("Expected %d annotations, but found %d", expectedAnnotationClasses.size(), annotations.size()));	      
	   }

        //Check presence of an expected annotation in the actual annotation's list.  
	    expectedAnnotationClasses.forEach(

	       ac -> {
	        long cnt  = annotations.stream().filter(a -> a.annotationType().isAssignableFrom(ac)).count();	         	           	            

	          if (cnt == 0) {
	            throw new AssertionError(String.format("No annotation of type %s found", ac.getName()));	          
	          }
	       }
	    );
    }
}
//------------------------------------------------------------------------------