//------------------------------------------------------------------------------
package com.soft.controller;
//------------------------------------------------------------------------------
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.soft.config.AppConfig;

//------------------------------------------------------------------------------

// @RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration(classes={ AppConfig.class })
 public class EshopControllerTest {

   private MockMvc mockMvc;
	 
	@Test
	public void renderHomePageTest() {		
//	  mockMvc = MockMvcBuilders.annotationConfigSetup(AppConfig.class).build();		
	}
 }
//------------------------------------------------------------------------------
