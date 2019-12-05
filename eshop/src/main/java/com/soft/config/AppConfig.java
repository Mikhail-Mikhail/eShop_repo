//------------------------------------------------------------------------------
package com.soft.config;
//------------------------------------------------------------------------------

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.soft.controller.MyController;
import com.soft.dao.EshopDAOImpl;
import com.soft.entity.LocaleMessageEntity;

//------------------------------------------------------------------------------

//Configuration class for application.


@SuppressWarnings("deprecation")
@Configuration
//Scan package "com.soft.controller" for searching of the MVC-controller.
@ComponentScan(basePackages = "com.soft.controller") 
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware{

    private static final String ENCODING = StandardCharsets.UTF_8.name(); // "utf-8";

    private ApplicationContext applicationContext;            
   
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }                              

        //Thymeleaf view resolver.
        @Bean
        public ViewResolver viewResolver() {
            ThymeleafViewResolver viewresolver = new ThymeleafViewResolver();
             viewresolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());        
             // NOTE 'order' and 'viewNames' are optional
             viewresolver.setOrder(1);
             viewresolver.setViewNames(new String[] {"*.html", "*.xhtml", "*::*"});      
             //Set encoding.
             viewresolver.setCharacterEncoding(ENCODING);             

         return viewresolver;    
        }
        
        
        //Thymeleaf template engine.
        @Bean
        public TemplateEngine templateEngine() {
           SpringTemplateEngine templateEngine = new SpringTemplateEngine();
             templateEngine.setTemplateResolver(templateResolver());
             // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
             // speed up execution in most scenarios, but might be incompatible
             // with specific cases when expressions in one template are reused
             // across different data types, so this flag is "false" by default
             // for safer backwards compatibility.
             templateEngine.setEnableSpringELCompiler(true);              
             
         return templateEngine;     
        }

        
        //Thymeleaf template resolver.
        @Bean
        public ITemplateResolver templateResolver() {
            // SpringResourceTemplateResolver automatically integrates with Spring's own
            // resource resolution infrastructure, which is highly recommended.
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
             templateResolver.setApplicationContext(applicationContext);
               templateResolver.setPrefix("classpath:/templates/");
               templateResolver.setSuffix(".html");

              // HTML is the default value, added here for the sake of clarity.
              templateResolver.setTemplateMode(TemplateMode.HTML);

               // Template cache is true by default. Set to false if you want
               // templates to be automatically updated when modified.
               templateResolver.setCacheable(true);                              
               
               //Set encoding.
               templateResolver.setCharacterEncoding(ENCODING);
               
         return templateResolver;
        }  
             
        
         
         //Message source bean for i18n.
         @Component("messageSource")         
         public class DBMessageSource extends AbstractMessageSource {

            @Autowired
            private EshopDAOImpl eshopDaoImpl;

             private static final String DEFAULT_LOCALE_CODE = "en";

             @Override
             protected MessageFormat resolveCode(String key, Locale locale) {
              
               LocaleMessageEntity  localeMessageEntity = null; 
            	             	             	 
            	try {
            		localeMessageEntity = eshopDaoImpl.readLocaleMessageByKey(key, locale.toString());
            	}
            	catch(Exception exc) {            	
            	   MyController.log.debug("[AppConfig.DBMessageSource.resolveCode()] --> EXCEPTION: "+exc.getMessage());
                   MyController.log.debug("[AppConfig.DBMessageSource.resolveCode()] --> EXCEPTION TO STRING: "+exc.toString());         	
            	}            	
            	 
              return new MessageFormat(localeMessageEntity.getMessage(), locale);	 
             }
         }         
                  
         
//          //Cookie locale resolver.
//          @Bean
//          public LocaleResolver localeResolver() {
//        	//Use cookie resolver. It will send cookie to the client according with selected locale.  
//            return new CookieLocaleResolver();
//          }
          
          //Session locale resolver.
          @Bean(name = "localeResolver")
          public SessionLocaleResolver getSessionLocaleResolver(){
            // Create a SessionLocaleResolver object.
            SessionLocaleResolver localeResolver = new SessionLocaleResolver();
             // Set default locale in session.
             localeResolver.setDefaultLocale(Locale.ENGLISH);
             
           return localeResolver;
          }
          
           //Locale change interceptor.
           //It intercepts incoming requests with parameter "lang" and pass it's value("en" or "ru") to resolver.
           //Resolver will call method "resolveCode(String key, Locale locale)" of bean "messageSource" with value("en" or "ru") of parameter "locale" to get message.
           @Override
           public void addInterceptors(InterceptorRegistry registry) {
              LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
              localeChangeInterceptor.setParamName("lang");
              registry.addInterceptor(localeChangeInterceptor);
           }
              
            //Define location of static resources(css, images, js).
            @Override    
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
              registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
              registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
              registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
            }                         
}
//------------------------------------------------------------------------------
