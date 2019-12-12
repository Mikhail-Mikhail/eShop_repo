//------------------------------------------------------------------------------
package com.soft.dao;
//------------------------------------------------------------------------------


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.soft.entity.LocaleMessageEntity;
import com.soft.entity.CategoryEntity;

//------------------------------------------------------------------------------

//Interface of methods for DB access.

public interface EshopDAO {      
  
   //====================== Hibernate-based methods: ========================//
    
   //Initialization of database access by means of Hibernate API.  
   public void setSessionFactory(SessionFactory sessionFactory);      
        
     //Method to read from table "locale" of database by means of Hibernate API.      
     public LocaleMessageEntity readLocaleMessageByKey(String msgKey, String locale);
     
      //Method to read all data from table "category" by means of Hibernate API.      
      public List<CategoryEntity> readCategoryList();
}         
//------------------------------------------------------------------------------