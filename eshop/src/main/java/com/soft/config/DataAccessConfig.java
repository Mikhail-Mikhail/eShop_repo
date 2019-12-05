//------------------------------------------------------------------------------
package com.soft.config;
//------------------------------------------------------------------------------

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;

import org.ehcache.jsr107.EhcacheCachingProvider;
import org.hibernate.SessionFactory;
import org.hibernate.cache.jcache.JCacheRegionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.soft.dao.EshopDAOImpl;

//------------------------------------------------------------------------------

// Configuration of Hibernate and database.

@Configuration
@EnableTransactionManagement
public class DataAccessConfig {
    
//======================== First way of configuration ==========================
    
    // First way to create bean for connection with a database.
    // (This way of bean's creation is preferable instead of next below.)
    // It uses connection pool and datasource created manually on the server
    // to communicate with MySql database.
    @Bean(name="DataSourceBean") 
    public DataSource getDataSource(){
       final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
          dsLookup.setResourceRef(true);
          DataSource dataSource = dsLookup.getDataSource("jdbc/eshop_db");      	         
     return dataSource;
    }
   
    // Second way to create bean for connection with a database.
    // (This way of bean's creation is not preferable instead of previous above.)
    // It uses connection pool and datasource created manually on the server
    // to communicate with MySql database.
//    @Bean(name="DataSourceBean") 
//    public DataSource getDataSource() throws IllegalArgumentException, NamingException {                         
//     
//       JndiObjectFactoryBean objectFactory = new JndiObjectFactoryBean();
//      
//         objectFactory.setLookupOnStartup(true);
//     
//           //Set the name of server's datasource that provide connection with database.
//           //Datasource "jdbc/eshop_db" must be created on the server.
//           objectFactory.setJndiName("jdbc/eshop_db");
//        
//            objectFactory.setResourceRef(true);
//            objectFactory.setProxyInterface(DataSource.class);
//            objectFactory.afterPropertiesSet();
//                      
//     return (DataSource) objectFactory.getObject();
//    }
        
      //Bean for Hibernate's initialization.
      @Bean(name="SessionFactory")       
      @DependsOn("DataSourceBean") 
      public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {              
          
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        
         //Reference to datasource.   
         localSessionFactoryBean.setDataSource(dataSource);
         
          //Define list of "@Entity" annotated classes.
          localSessionFactoryBean.setAnnotatedClasses(com.soft.entity.LocaleMessageEntity.class);
         
           //Create Hibernate's properties.          
           Properties prop = new Properties();
           
            //Set Hibernate's dialect.
            prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
             //Enable second level cache(default value is true).
             prop.setProperty(Environment.USE_SECOND_LEVEL_CACHE, Boolean.TRUE.toString());
              //Enable "Query Cache" to cache query result.
              prop.setProperty(Environment.USE_QUERY_CACHE, Boolean.TRUE.toString());
               //Specify cache region factory class.
               prop.setProperty(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.jcache.JCacheRegionFactory");
                //Specify cache provider.
                prop.setProperty("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");
       		              
             //Set Hibernate's properties.                    
             localSessionFactoryBean.setHibernateProperties(prop);  
                                 
             localSessionFactoryBean.afterPropertiesSet();
     
       return  localSessionFactoryBean.getObject();           
      }  
           
          //Bean of database's methods.
          @Bean
          @DependsOn("SessionFactory")          
          public EshopDAOImpl getLocaleDAO(SessionFactory sessionFactory, DataSource dataSource) {                                    
            
             EshopDAOImpl instanceDAOImpl = new EshopDAOImpl();
               
              //Inject datasource for JDBC.
//              instanceDAOImpl.setDataSource(dataSource); 
             
              //Initialize reference to a SessionFactoryBean for database's methods.              
              instanceDAOImpl.setSessionFactory(sessionFactory);
           
           return instanceDAOImpl;  
          }
                             
          
          // Transaction's manager for JDBC transactions only.
          // It cannot be used for Hibernate transactions.
          // You should use "HibernateTransactionManager" for transactional 
          // methods based on Hibernate API.
//          @Bean
//          public PlatformTransactionManager transactionManager() {
//             DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//             transactionManager.setDataSource(getDataSource());             
//           return transactionManager;
//          }  
     
          //Transaction's manager for Hibernate transactions and JDBC transactions.          
          @Bean
          @DependsOn("SessionFactory")
          public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
             HibernateTransactionManager transactionManager = new HibernateTransactionManager();
             transactionManager.setDataSource(getDataSource());
             transactionManager.setSessionFactory(sessionFactory);
           return transactionManager;
          }  
//==============================================================================          
          
//======================= Second way of configuration ==========================
    
//    // First way to create bean for connection with a database.
//    // (This way of bean's creation is preferable instead of next below.)
//    // It uses connection pool and datasource created manually on the Glassfish server
//    // to communicate with MySql database.
//    @Bean
//    public DataSource getDataSource(){
//       final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//          dsLookup.setResourceRef(true);
//          DataSource dataSource = dsLookup.getDataSource("jdbc/localeDB");
//     return dataSource;
//    }
//   
//    // Second way to create bean for connection with a database.
//    // (This way of bean's creation is not preferable instead of previous above.)
//    // It uses connection pool and datasource created manually on the Glassfish server
//    // to communicate with MySql database.
////    @Bean
////    public DataSource getDataSource() throws IllegalArgumentException, NamingException {                         
////    
////      JndiObjectFactoryBean objectFactory = new JndiObjectFactoryBean();
////      
////       objectFactory.setLookupOnStartup(true);
////     
////        //Set the name of server's datasource that provide connection with database.
////        //Datasource "jdbc/localeDB" must be created on the server.
////        objectFactory.setJndiName("jdbc/localeDB");
////        
////        objectFactory.setResourceRef(true);
////        objectFactory.setProxyInterface(DataSource.class);
////        objectFactory.afterPropertiesSet();
////                      
////     return (DataSource) objectFactory.getObject();
////    }
//    
//    
//      //Bean for Hibernate's initialization.
//      @Bean      
//      public SessionFactory getSessionFactory() throws IllegalArgumentException, NamingException, IOException {                          
//          
//         LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        
//           //Reference to datasource.   
//           sessionFactory.setDataSource(getDataSource());
//
//             //Define list of annotated entity's classes.
//             sessionFactory.setAnnotatedClasses(com.soft.entity.MessageEntity.class);
//         
//              //Set Hibernate's dialect.
//              sessionFactory.setHibernateProperties((Properties) new Properties().setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect"));          
//         
//               sessionFactory.afterPropertiesSet();
//        
//       return sessionFactory.getObject();            
//      }  
//           
//          //Bean of database's methods.
//          @Bean
//          public UserAccountsDAOImpl getUserAccountsDAO() throws IllegalArgumentException, NamingException, IOException {                                    
//            
//             UserAccountsDAOImpl userAccountsDAO = new UserAccountsDAOImpl();
//
//              SessionFactory sessionFactory = getSessionFactory();             
//
//                //Initialize reference to a SessionFactory for database's methods.              
//                userAccountsDAO.setSessionFactory(sessionFactory);
//           
//           return userAccountsDAO;  
//          }
//==============================================================================
          
}
//------------------------------------------------------------------------------
