//------------------------------------------------------------------------------
package com.soft.config;
//------------------------------------------------------------------------------

import java.io.IOException;
import java.util.EnumSet;
import java.util.Properties;
import java.util.Set;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ehcache.jsr107.EhcacheCachingProvider;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cache.jcache.JCacheRegionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport.Action;
import org.hibernate.tool.schema.TargetType;
import org.hibernate.tool.schema.spi.SchemaManagementTool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.soft.controller.EshopController;
import com.soft.dao.EshopDAOImpl;

//------------------------------------------------------------------------------

// Configuration of Hibernate and database.

@Configuration
@EnableTransactionManagement
public class DataAccessConfig {
	
  //Get logger.
  Logger log = LogManager.getLogger(EshopController.class.getName());
    
//======================== First way of configuration ==========================

	
	//====== Profile's "development" configuration. ======// 
	//
	//(This profile is used for tests only. Use in memory HSQLDB for tests instead of MySql for production profile. )     

	@Profile("development")
    @Bean(name="DataSourceBean") 
    public DataSource getDevDataSource(){
		
       //Create dataSource for HSQLDB connection.
		
	   BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
	    //Create HSQLDB in memory. 
	    dataSource.setUrl("jdbc:hsqldb:mem:mymemdb;ifexists=false;sql.syntax_mys=true");
	    //Create HSQLDB in file located in the application folder.
        //dataSource.setUrl("jdbc:hsqldb:file:mymemdb;ifexists=false;sql.syntax_mys=true");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
				
     return dataSource;
    }	
	
	
	  @Profile("development")
      @Bean(name="SessionFactory")       
      @DependsOn("DataSourceBean") 
      public SessionFactory getDevSessionFactory(DataSource dataSource) throws IOException {  
         
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        
         //Reference to datasource.   
         localSessionFactoryBean.setDataSource(dataSource);
         
          //Define list of "@Entity" annotated classes.
//          localSessionFactoryBean.setAnnotatedClasses(com.soft.entity.LocaleMessageEntity.class, com.soft.entity.CategoryEntity.class, com.soft.entity.ResistorEntity.class);
         //Set package to scan for entities.
         localSessionFactoryBean.setPackagesToScan(new String[]{"com.soft.entity"});
                  
           //Create Hibernate's properties.          
           Properties prop = new Properties();
           
            //Set Hibernate's dialect for HSQLDB.
            prop.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");        
             //Enable second level cache(default value is true).
             prop.setProperty(Environment.USE_SECOND_LEVEL_CACHE, Boolean.TRUE.toString());
              //Enable "Query Cache" to cache query result.
              prop.setProperty(Environment.USE_QUERY_CACHE, Boolean.TRUE.toString());
               //Specify cache region factory class.
               prop.setProperty(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.jcache.JCacheRegionFactory");
                //Specify cache provider.
                prop.setProperty("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");
                 //Force Hibernate to create tables in HSQLDB for all entity's classes automatically on startup.                
                 prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
                 
                 
//!DO NOT REMOVE:
//Configuration to force Hibernate to create tables for entity's classes:                  
                 
//                  prop.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:mymemdb;ifexists=false;sql.syntax_mys=true");
//                  prop.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:mymemdb;user=sa;password=;ifexists=false;sql.syntax_mys=true");
                                       
//                    ServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().applySettings(prop).build();                       
//                       
//                       MetadataSources metadataSrc = new MetadataSources(standardServiceRegistry);
//                       metadataSrc.addAnnotatedClass(PersonEntity.class);
//                       metadataSrc.addAnnotatedClass(ResistorEntity.class);                      
//                       Metadata metadata = metadataSrc.getMetadataBuilder().build();
//                                                                                                                                                                          		     
             try {                    	
               //Set Hibernate's properties.                    
               localSessionFactoryBean.setHibernateProperties(prop); 
               
               localSessionFactoryBean.afterPropertiesSet();                                             
             }
             catch(Exception exc) {                    	   
           	   log.debug("[DataAcessConfig.getDevSessionFactory()] --> SetHibernateProperties EXCEPTION: "+exc.getMessage());
               log.debug("[DataAcessConfig.getDevSessionFactory()] --> SetHibernateProperties EXCEPTION TO STRING: "+exc.toString());
             }         
             

//!DO NOT REMOVE:
//Configuration to force Hibernate to create tables for entity's classes:  
             try {
               //Create tables in database for entity's classes.
//             new SchemaExport().execute(EnumSet.of(TargetType.DATABASE), Action.BOTH, metadata, standardServiceRegistry);
               //Create script file in application's folder.
//             new SchemaExport().setOutputFile("myscript.txt").create(EnumSet.of(TargetType.STDOUT, TargetType.SCRIPT), metadata);
             }
             catch(Exception exc) {                    	   
           	   log.debug("[DataAcessConfig.getDevSessionFactory()] --> SchemaExport EXCEPTION: "+exc.getMessage());
               log.debug("[DataAcessConfig.getDevSessionFactory()] --> SchemaExport EXCEPTION TO STRING: "+exc.toString());
             }
     
       return  localSessionFactoryBean.getObject();           
      }  
	  
	  
      //Bean of database's methods.
      @Profile("development")
      @Bean
      @DependsOn("SessionFactory")          
      public EshopDAOImpl getDevLocaleDAO(SessionFactory sessionFactory, DataSource dataSource) {                                    
        
         EshopDAOImpl instanceDAOImpl = new EshopDAOImpl();            
         
          //Initialize reference to a SessionFactoryBean for database's methods.              
          instanceDAOImpl.setSessionFactory(sessionFactory);
       
       return instanceDAOImpl;  
      }


    //====== Profile's "production" configuration. ======// 
  	//
  	//(This profile is used for production. Use MySql database for production instead of in memory HSQLDB for tests.)     
	
	
    // First way to create bean for connection with a database.
    // (This way of bean's creation is preferable instead of next below.)
    // It uses connection pool and datasource created manually on the server
    // to communicate with MySql database.
	@Profile("production")
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
	  @Profile("production")
      @Bean(name="SessionFactory")       
      @DependsOn("DataSourceBean") 
      public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {              
          
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        
         //Reference to datasource.   
         localSessionFactoryBean.setDataSource(dataSource);
         
          //Define list of "@Entity" annotated classes.
//          localSessionFactoryBean.setAnnotatedClasses(com.soft.entity.LocaleMessageEntity.class, com.soft.entity.CategoryEntity.class, com.soft.entity.ResistorEntity.class);
         //Set package to scan for entities.
         localSessionFactoryBean.setPackagesToScan(new String[]{"com.soft.entity"});
         
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
	      @Profile("production")
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
