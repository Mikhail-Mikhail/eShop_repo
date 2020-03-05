//------------------------------------------------------------------------------
package com.soft.configuration;
//------------------------------------------------------------------------------

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

//------------------------------------------------------------------------------

@Configuration
@ComponentScan(basePackages = "com.soft.controller")
public class TestConfig {
		
//	@Bean
//	public ViewResolver getViewResolver() {
//		
//	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("classpath:/templates/");
//		resolver.setSuffix(".html");
//		
//	 return resolver;		
//	}	

	
//   private static final String ENCODING = StandardCharsets.UTF_8.name(); // "utf-8";
//	
//	  //Thymeleaf view resolver.
//    @Bean
//    public ViewResolver viewResolver() {
//        ThymeleafViewResolver viewresolver = new ThymeleafViewResolver();
//         viewresolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());        
//         // NOTE 'order' and 'viewNames' are optional
//         viewresolver.setOrder(1);
//         viewresolver.setViewNames(new String[] {"*.html", "*.xhtml", "*::*"});      
//         //Set encoding.
//         viewresolver.setCharacterEncoding(ENCODING);             
//
//     return viewresolver;    
//    }
//    
//    
//    //Thymeleaf template engine.
//    @Bean
//    public TemplateEngine templateEngine() {
//       SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//         templateEngine.setTemplateResolver(templateResolver());
//         // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
//         // speed up execution in most scenarios, but might be incompatible
//         // with specific cases when expressions in one template are reused
//         // across different data types, so this flag is "false" by default
//         // for safer backwards compatibility.
//         templateEngine.setEnableSpringELCompiler(true);              
//         
//     return templateEngine;     
//    }
//
//    
//    //Thymeleaf template resolver.
//    @Bean
//    public ITemplateResolver templateResolver() {
//        // SpringResourceTemplateResolver automatically integrates with Spring's own
//        // resource resolution infrastructure, which is highly recommended.
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//         templateResolver.setApplicationContext(applicationContext);
//           templateResolver.setPrefix("classpath:/templates/");
//           templateResolver.setSuffix(".html");
//
//          // HTML is the default value, added here for the sake of clarity.
//          templateResolver.setTemplateMode(TemplateMode.HTML);
//
//           // Template cache is true by default. Set to false if you want
//           // templates to be automatically updated when modified.
//           templateResolver.setCacheable(true);                              
//           
//           //Set encoding.
//           templateResolver.setCharacterEncoding(ENCODING);
//           
//     return templateResolver;
//    }  	
}
//------------------------------------------------------------------------------