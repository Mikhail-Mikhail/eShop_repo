//------------------------------------------------------------------------------
package com.soft.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
//------------------------------------------------------------------------------
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.soft.config.AppConfig;
import com.soft.configuration.TestConfig;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

//------------------------------------------------------------------------------


//<parent>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-parent</artifactId>
//<version>2.2.2.RELEASE</version>
//<relativePath/> <!-- lookup parent from repository -->
//</parent>

//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-web</artifactId>
// <exclusions> <!-- Exclude default "Spring Boot" logging to enable "Log4j". -->
//   <exclusion>
//     <groupId>org.springframework.boot</groupId>
//     <artifactId>spring-boot-starter-logging</artifactId>
//   </exclusion>
// </exclusions>		    
//</dependency>



/*
//@SpringBootTest
 @ExtendWith(SpringExtension.class)
 @WebAppConfiguration()
 @ContextConfiguration(classes={ TestConfig.class })
 //@TestInstance(Lifecycle.PER_CLASS)
 //@AutoConfigureMockMvc
 public class EshopControllerTest {
	 
   @Autowired
   private WebApplicationContext wac;	

   private MockMvc mockMvc;
   
    @BeforeEach
    void setup() {
      this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

//   @Test
//   void getAccount() throws Exception {
//       mockMvc.perform(get("/toto")).andExpect(status().isOk());
//   }

	 
	@Test
	public void renderHomePageTest() throws Exception {
	  mockMvc.perform(get("/home.html")).andExpect(status().isOk());	
	}
 }
 */
//------------------------------------------------------------------------------
