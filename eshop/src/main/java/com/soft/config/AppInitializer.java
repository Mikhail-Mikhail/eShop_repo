//------------------------------------------------------------------------------
package com.soft.config;
//------------------------------------------------------------------------------

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//------------------------------------------------------------------------------

// Class of initialization.
// This class is auto-detected by the Servlet container.

public class AppInitializer implements WebApplicationInitializer{
            
    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        
      AnnotationConfigWebApplicationContext context;  
      
      //Use profile "production" defined in file "DataAccessConfig.java". 
      //It uses MySql database instead of HSQLDB for tests.
      sc.setInitParameter("spring.profiles.default", "production");   
      sc.setInitParameter("spring.profiles.active", "production");                    
             
       // Create "ApplicationContext" instance(i.e. Spring container), based on 
       // the configuration class "AppConfig". 
       context = new AnnotationConfigWebApplicationContext();       
       context.register(AppConfig.class, DataAccessConfig.class);
       context.setServletContext(sc);
       context.refresh(); 
       
        // Create and register DispatcherServlet.
        DispatcherServlet dispServlet = new DispatcherServlet(context);
         ServletRegistration.Dynamic registration = sc.addServlet("Dispatcher", dispServlet);
          registration.setLoadOnStartup(1);
                   
           // Define DispatcherServlet's URL mappings.
           // Set value "/" in order to map any URL to DispatcherServlet.
           // Value of "/*" doesn't work!!! Controller starts, but MVC-view will not be returned.          
           registration.addMapping("/");                
    }            
}
//------------------------------------------------------------------------------
