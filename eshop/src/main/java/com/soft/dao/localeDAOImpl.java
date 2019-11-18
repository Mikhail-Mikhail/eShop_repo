//------------------------------------------------------------------------------
//
// For testing this application it is necessary to create MySql-database with name "localeDB".
// To create database use SQL-script in the folder: i18n_db/src/main/resources/createSQL.sql
// In addition, create connection pool and datasource with name "jdbc/localeDB"
// in the administration's console of Glassfish server.
// 
//------------------------------------------------------------------------------
package com.soft.dao;
//------------------------------------------------------------------------------

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.soft.controller.MyController;
import com.soft.entity.MessageEntity;

//------------------------------------------------------------------------------

//Implementation of database's methods.

public class localeDAOImpl implements localeDAO{
	 	
      
  public localeDAOImpl() {		
  }
  
  public localeDAOImpl(SessionFactory sessionFactory) {	
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
       

	//Method to read from table "localetable" of database by means of Hibernate API.          
    @Override           
    public MessageEntity readMessageByKey(String messageKey, String msgLocale) {                    
       
        //Session with database.
        Session session; 
        
        //Reference to retrieved data.
        MessageEntity retrievedMessage = null;

           try { 
               //Open session to read from database.
               session = sessionFactory.openSession();
                  //Begin transaction.
                  session.beginTransaction();                                        

                    //Retrieve data from database.
                    //Result of this query will be cached.
                    List result = session.createQuery("SELECT DISTINCT msg FROM MessageEntity msg WHERE msgkey="+"'"+messageKey+"'"+" AND locale="+"'"+msgLocale+"'").setCacheable(true).setCacheRegion("MY_CACHE").list(); 

                      for (MessageEntity msg : (List<MessageEntity>) result) {                        
                        retrievedMessage = msg;   
                      } 
                                                                             
                  //Commit transaction.
                  session.getTransaction().commit();
                //Close session with a database. 
                session.close();                                               
           } 
           catch(Exception exc) {
        	 MyController.log.debug("[localeDAOImpl.readMessageByKey()] --> EXCEPTION: "+exc.getMessage());
             MyController.log.debug("[localeDAOImpl.readMessageByKey()] --> EXCEPTION TO STRING: "+exc.toString());           
           }           

      return retrievedMessage;     
    }                               
 }

