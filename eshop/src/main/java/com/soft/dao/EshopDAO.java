//------------------------------------------------------------------------------
package com.soft.dao;
//------------------------------------------------------------------------------


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.soft.entity.LocaleMessageEntity;
import com.soft.entity.BaseEntity;
import com.soft.entity.CategoryEntity;

//------------------------------------------------------------------------------

//Interface of methods for DB access.

public interface EshopDAO {      
  
   //====================== Hibernate-based methods: ========================//
    
   //Initialization of database access.  
   public void setSessionFactory(SessionFactory sessionFactory);      
        
     //Method to read from table "locale" of database.      
     public LocaleMessageEntity readLocaleMessageByKey(String msgKey, String locale);
     
      //Method to read all data from table "category".      
      public List<CategoryEntity> readCategoryList();      
      
        //Method to read entity by its "name" and "id" from any DB table.     
        public BaseEntity readEntityByNameAndId(String entityName,Long id);
       
         //Method to read entity list by "name" from any DB table.     
         public List<BaseEntity> readEntityListByName(String entityName, Integer startRecord, Integer numOfRecords);
}         
//------------------------------------------------------------------------------