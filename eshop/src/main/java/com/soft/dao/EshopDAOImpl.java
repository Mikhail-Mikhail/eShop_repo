//------------------------------------------------------------------------------
package com.soft.dao;
//------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.soft.controller.EshopController;
import com.soft.entity.BaseEntity;
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
             
    //_______________________________________________________________//
    
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
                    //Result of this query will be cached. Caching is suitable for static data only!!!
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

  //_______________________________________________________________//

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

                  //Create query to retrieve data from database.
                  resultList = session.createQuery("FROM CategoryEntity").list();
                  
                  //The same query but the result will be cached.
                  //Caching is suitable for static data only!!!
                  //resultList = session.createQuery("FROM CategoryEntity").setCacheable(true).setCacheRegion("MY_CACHE").list();                
                                                                           
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
  
  
   //_______________________________________________________________//
  
   //Method to read entity by its "name" and "id" from any DB table.
  
   @Override 
   public BaseEntity readEntityByNameAndId(String entityName,Long id) {
		  
	  //Session with database.
	  Session session; 
	      
	      //Entity for result.
	      BaseEntity resultEntity = null;

	         try { 
	             //Open session to read from database.
	             session = sessionFactory.openSession();
	               //Begin transaction.
	               session.beginTransaction();                                        

 	                //Construct entity's "id" from entity's name.
	                //Entity's name has a format: NameEntity, where field Name - name of entity.
	                //Entity's "id" has a format: Name_id, where field Name - name of entity.
	                //To get entity's "id" from entity's name we should to take field "Name" from entity's name and append field "_id" to it.
	                Pattern pattern = Pattern.compile("Entity");
	                Matcher matcher = pattern.matcher(entityName);
	                String idStr = "";
	                 while (matcher.find()) {
	                	//EshopController.log.debug("[EshopDAOImpl.readEntityById()] --> RegExp: "+entityName.substring(0, matcher.start()));
	                	//Construct name of entity's "id" from entity's name.
	                	idStr = entityName.substring(0, matcher.start()).toLowerCase()+"_id";
	                 }	                	                

	                 //Retrieve data from database.
	                 //This query does not cache result. Caching is suitable for static data only!!!
	                 List resultList = session.createQuery("SELECT DISTINCT entity FROM "+entityName+" entity WHERE "+idStr+"="+"'"+id+"'").list();
	                
	                  //Get single entity from list.
                      for(BaseEntity entity : (List<BaseEntity>) resultList) {                        
                        resultEntity = entity;   
                      } 	                	                 
	                 
	               //Commit transaction.
	               session.getTransaction().commit();
	              //Close session with a database. 
	              session.close();                                               
	         } 
	         catch(Exception exc) {
	      	   EshopController.log.debug("[EshopDAOImpl.readEntityByNameAndId()] --> EXCEPTION: "+exc.getMessage());
	      	   EshopController.log.debug("[EshopDAOImpl.readEntityByNameAndId()] --> EXCEPTION TO STRING: "+exc.toString());           
	         }           

	 return resultEntity;     
   }
   
   
   //_______________________________________________________________//
     
   //Method to read entity list by "name" from any DB table.
   //
   //Parameters "startRecord" and "numOfRecords" set start index and number of records to read from DB.
   //If these parameters are "NULL", method will read all records.
   
   @Override      
   public List<BaseEntity> readEntityListByName(String entityName, Integer startRecord, Integer numOfRecords){
	  
	     //Session with database.
	     Session session; 
	      
	      //List of retrieved data.
	      List<BaseEntity> resultList = null;
	      
	         try { 
	             //Open session to read from database.
	             session = sessionFactory.openSession();
	                //Begin transaction.
	                session.beginTransaction();                                        

	                  //Create query to retrieve data from database.
	                   Query query= session.createQuery("FROM "+entityName);
	                    //Read all data if parameters are NULL.
	                    if((startRecord!=null)&&(numOfRecords!=null)) {
	                      query.setFirstResult(startRecord);
	                      query.setMaxResults(numOfRecords);
	                    } 
	                    resultList = query.list();	                                  
	                                                                           
	                //Commit transaction.
	                session.getTransaction().commit();
	              //Close session with a database. 
	              session.close();                                               
	         } 
	         catch(Exception exc) {
	      	   EshopController.log.debug("[EshopDAOImpl.readEntityListByName()] --> EXCEPTION: "+exc.getMessage());
	      	   EshopController.log.debug("[EshopDAOImpl.readEntityListByName()] --> EXCEPTION TO STRING: "+exc.toString());           
	         }           
	  
	 return resultList;      
   }
   
   //_______________________________________________________________//
      
   //Method to get total number of records in DB table.     
   
   public Integer getTableSizeByTableName(String tableName) {
	   
	   Long tableSize = null;
	  
  	     //Session with database.
	     Session session; 
	      
	      
	         try { 
	             //Open session to read from database.
	             session = sessionFactory.openSession();
	                //Begin transaction.
	                session.beginTransaction();                                        

	                  //Create query to retrieve data from database.
	                  Query query= session.createQuery("select count(*) from "+ tableName);
	                   
	                    tableSize = (Long) query.uniqueResult();                                  
	                                                                           
	                //Commit transaction.
	                session.getTransaction().commit();
	              //Close session with a database. 
	              session.close();                                               
	         } 
	         catch(Exception exc) {
	      	   EshopController.log.debug("[EshopDAOImpl.getTableSizeByTableName()] --> EXCEPTION: "+exc.getMessage());
	      	   EshopController.log.debug("[EshopDAOImpl.getTableSizeByTableName()] --> EXCEPTION TO STRING: "+exc.toString());           
	         }     
	         
	return tableSize.intValue();   
   }
   
   //_______________________________________________________________//
   
   
//!!!DEBUG METHOD:     
   
   public boolean testHSQLDB() {
	   
	 boolean result = false;
	 Long tableSize = null;
	 
      //Session with database.
      Session session;      
      	      
         try { 
             //Open session to read from database.
             session = sessionFactory.openSession();
                //Begin transaction.
                session.beginTransaction();                                        

                  //Create query.
              //    session.createNativeQuery("CREATE DATABASE mDB");
//                 session.createNativeQuery("CREATE TABLE pers(id INTEGER, name CHAR)").getFirstResult();//.executeUpdate();
//                 List res = session.createNativeQuery("SELECT * FROM person").getResultList();
                Query query= session.createQuery("select count(*) from person");
                
                Object obj = query.getSingleResult();
                
//                tableSize = (Long) query.uniqueResult();
//                  session.createNativeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES;");
                  
                //  Query query= session.createQuery("select count(*) from "+ tableName);                   
                                                                           
                //Commit transaction.
                session.getTransaction().commit();
              //Close session with a database. 
              session.close();
          
          result = true;   
         } 
         catch(Exception exc) {
      	   EshopController.log.debug("[EshopDAOImpl. testHSQLDB()] --> EXCEPTION: "+exc.getMessage());
      	   EshopController.log.debug("[EshopDAOImpl. testHSQLDB()] --> EXCEPTION TO STRING: "+exc.toString());
      	   
      	  result = false;
         }     	         
         finally {
           return result;
 //       	 return tableSize.intValue();        	 
         }
   }   
   
}
//------------------------------------------------------------------------------ 