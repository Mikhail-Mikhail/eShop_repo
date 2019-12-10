//-------------------------------------------------------------------------------
package com.soft.entity;
//-------------------------------------------------------------------------------
import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
//-------------------------------------------------------------------------------

@Entity
@Table(name = "locale")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LocaleMessageEntity implements Serializable {

  private static final long serialVersionUID = 1L;
	
   //Empty constructor, used by Hibernate.	   
   public LocaleMessageEntity() { 
   }
   
   public LocaleMessageEntity(String locale, String msgKey, String message) {			
		  this.locale = locale;
		  this.msgKey = msgKey;
		  this.message = message;
   }
   
    public LocaleMessageEntity(Long id, String locale, String msgKey, String message) {	
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
		 
	     @Override
         public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set.
            if (!(object instanceof LocaleMessageEntity)) {
                return false;
            }
            LocaleMessageEntity other = (LocaleMessageEntity) object;
            if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                return false;
            }
            return true;
         }

          @Override
          public String toString() {
            return "com.soft.entity.LocaleMessageEntity[ id=" + id + " ]";
          }   
}
//-------------------------------------------------------------------------------
