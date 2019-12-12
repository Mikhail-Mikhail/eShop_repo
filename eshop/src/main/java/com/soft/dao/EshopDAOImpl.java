 
//------------------------------------------------------------------------------
package com.soft.dao;
//------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.soft.controller.EshopController;
import com.soft.entity.CategoryEntity;
import com.soft.entity.LocaleMessageEntity;

//------------------------------------------------------------------------------

//Implementation of database's methods.

public class EshopDAOImpl implements EshopDAO{
	 	
      
  public EshopDAOImpl() {		
  }
  
  public EshopDAOImpl(SessionFactory sessionFactory) {	
	this.sessionFactory = sessionFactory;
  }

  //Reference to a LocalSessionFactoryBean defined in the file DataAccessConfig.java.  
  //It is used to access to the database by means of Hibernate API.
  private SessionFactory sessionFactory;  
  
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;   
    }
    
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    
    //====================== Hibernate-based methods: ========================//  
       

	//Method to read from table "locale" of database by means of Hibernate API.          
    @Override           
    public LocaleMessageEntity readLocaleMessageByKey(String messageKey, String msgLocale) {                    
       
        //Session with database.
        Session session; 
        
        //Reference to retrieved data.
        LocaleMessageEntity localeMessage = null;

           try { 
               //Open session to read from database.
               session = sessionFactory.openSession();
                  //Begin transaction.
                  session.beginTransaction();                                        

                    //Retrieve data from database.
                    //Result of this query will be cached.
                    List result = session.createQuery("SELECT DISTINCT msg FROM LocaleMessageEntity msg WHERE msgkey="+"'"+messageKey+"'"+" AND locale="+"'"+msgLocale+"'").setCacheable(true).setCacheRegion("MY_CACHE").list(); 

                      for(LocaleMessageEntity msg : (List<LocaleMessageEntity>) result) {                        
                    	localeMessage = msg;   
                      } 
                                                                             
                  //Commit transaction.
                  session.getTransaction().commit();
                //Close session with a database. 
                session.close();                                               
           } 
           catch(Exception exc) {
        	 EshopController.log.debug("[EshopDAOImpl.readLocaleMessageByKey()] --> EXCEPTION: "+exc.getMessage());
        	 EshopController.log.debug("[EshopDAOImpl.readLocaleMessageByKey()] --> EXCEPTION TO STRING: "+exc.toString());           
           }           

      return localeMessage;     
    }                                

 

  //Method to read all data from table "category" by means of Hibernate API.  
  @Override 
  public List<CategoryEntity> readCategoryList(){
	  
      //Session with database.
      Session session; 
      
      //List of retrieved data.
      List<CategoryEntity> resultList = null;

         try { 
             //Open session to read from database.
             session = sessionFactory.openSession();
                //Begin transaction.
                session.beginTransaction();                                        

                  //Retrieve data from database.
                  //Result of this query will be cached.
                  resultList = session.createQuery("FROM CategoryEntity").setCacheable(true).setCacheRegion("MY_CACHE").list();                    
                                                                           
                //Commit transaction.
                session.getTransaction().commit();
              //Close session with a database. 
              session.close();                                               
         } 
         catch(Exception exc) {
      	   EshopController.log.debug("[EshopDAOImpl.readCategoryList()] --> EXCEPTION: "+exc.getMessage());
      	   EshopController.log.debug("[EshopDAOImpl.readCategoryList()] --> EXCEPTION TO STRING: "+exc.toString());           
         }           

    return resultList;     
  }
}
//------------------------------------------------------------------------------ 