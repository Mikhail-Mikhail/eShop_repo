//-------------------------------------------------------------------------------
package com.soft.entity;
//-------------------------------------------------------------------------------
import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
<<<<<<< HEAD
=======

>>>>>>> temp
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
//-------------------------------------------------------------------------------

import com.soft.controller.EshopController;

<<<<<<< HEAD
=======

>>>>>>> temp
@Entity
@Table(name = "locale")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LocaleMessageEntity extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;
<<<<<<< HEAD
  
  //Get logger.
  Logger log = LogManager.getLogger(EshopController.class.getName());
	
=======
  	
>>>>>>> temp
   //Empty constructor, it's used by Hibernate.	   
   public LocaleMessageEntity() {
	 super();
   }
   
   public LocaleMessageEntity(String locale, String msgKey, String message) {
	      super();
		  this.locale = locale;
		  this.msgKey = msgKey;
		  this.message = message;
   }
   
    public LocaleMessageEntity(Long id, String locale, String msgKey, String message) {	
    	  super();
		  this.id = id;
		  this.locale = locale;
		  this.msgKey = msgKey;
		  this.message = message;
    }

	@Id    
    @Column(name = "ID")    
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment") 
    private Long id;

    @Column(name = "locale")
    private String locale;

    @Column(name = "msgkey")
    private String msgKey;

    @Column(name = "message")
    private String message;
    
     //Static method to create instance. It is used for unit tests.
     public static BaseEntity createInstance() {
       return new LocaleMessageEntity(1L, "MyLocale", "MyKey", "MyMessage"); 
     } 

		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
			
		public String getLocale() {
			return locale;
		}
	
		public void setLocale(String locale) {
			this.locale = locale;
		}
				
		public String getMsgKey() {
			return msgKey;
		}

		public void setMsgKey(String msgKey) {
			this.msgKey = msgKey;
		}
		
		public String getMessage() {
			return message;
		}
	
		public void setMessage(String message) {
			this.message = message;
		}
		
		 @Override
         public int hashCode() {
            int hash = 0;
            hash += (id != null ? id.hashCode() : 0);
            return hash;
         }
		 
		 
		 //Check if two instances are equal.
	     @Override
         public boolean equals(Object object) {
	    	 
            if (!(object instanceof LocaleMessageEntity)) {
               return false;
            }
            
<<<<<<< HEAD
             LocaleMessageEntity other = (LocaleMessageEntity) object;
             
              if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                return false;
              }
//------------------
//	            //Get fields of objects.
//	            Field[] fieldsThis = this.getClass().getFields();
//	            Field[] fieldsOther = object.getClass().getFields();
//	            
//	             //If objects have different numbers of fields.
//	             if(fieldsThis.length!=fieldsOther.length) return false;
//	             
//	              //Check if names of all fields are equal. 
//	              for (int i = 0; i < fieldsThis.length; i++) {
//	                try {                	
//	                  if(!(fieldsThis[i].getName().equals(fieldsOther[i].getName()))) {
//	                   return false;	 
//	                  }	                   
//	                } 
//	                catch(Exception exc) {
//	                  log.debug("[LocaleMessageEntity().equals()] --> EXCEPTION: "+exc.getMessage());
//	                  log.debug("[LocaleMessageEntity().equals()] --> EXCEPTION TO STRING: "+exc.toString());      
//	                }             
//	              }
//	             
//	              //Check if values of all fields are equal.
//	              for (int i = 0; i < fieldsThis.length; i++) {
//	                 try {                  	
//	                    if(!(fieldsThis[i].get(this).equals(fieldsOther[i].get(object)))) {
//	                     return false;	 
//	                    }
//	                 } 
//	                 catch(Exception exc) {
//	                   log.debug("[LocaleMessageEntity().equals()] --> EXCEPTION: "+exc.getMessage());
//	                   log.debug("[LocaleMessageEntity().equals()] --> EXCEPTION TO STRING: "+exc.toString());      
//	                 }             
//	               }
//------------------                        
            
=======
            LocaleMessageEntity other = (LocaleMessageEntity) object;
             
             //Check equality of all fields:
             if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                return false;
             }                        
              if ((this.locale == null && other.locale != null) || (this.locale != null && !this.locale.equals(other.locale))) {
                 return false;
              }
              
               if ((this.msgKey == null && other.msgKey != null) || (this.msgKey != null && !this.msgKey.equals(other.msgKey))) {
                  return false;
               }
               
                if ((this.message == null && other.message != null) || (this.message != null && !this.message.equals(other.message))) {
                   return false;
                }     
          //If all fields are equal.     
>>>>>>> temp
          return true;
         }
	     

	      @Override
	      public String toString() {
	     	return this.getClass().getCanonicalName()+" : [id = " + id +"  locale = " + locale + "  msgKey = " + msgKey + "  message = " + message + "]";
	      }
	     
	      
	      //Stub for abstract method of super class.
		  @Override
		  public byte[] getPhoto() {
			// TODO Auto-generated method stub
			return null;
		  }		  		  		  		   
}
//-------------------------------------------------------------------------------
