//------------------------------------------------------------------------------
package com.soft.dao;
//------------------------------------------------------------------------------


import org.hibernate.SessionFactory;

import com.soft.entity.MessageEntity;

//------------------------------------------------------------------------------

//Interface of methods for DB access.

public interface localeDAO {      
  
   //====================== Hibernate-based methods: ========================//
    
   //Initialization of database access by means of Hibernate API.  
   public void setSessionFactory(SessionFactory sessionFactory);      
        
     //Method to read from table "localetable" of database by means of Hibernate API.      
     public MessageEntity readMessageByKey(String msgKey, String locale);                    
}         
//------------------------------------------------------------------------------