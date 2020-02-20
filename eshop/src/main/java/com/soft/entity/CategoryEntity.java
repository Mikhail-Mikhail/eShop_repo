//-------------------------------------------------------------------------------
package com.soft.entity;
//-------------------------------------------------------------------------------
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
//-------------------------------------------------------------------------------
import org.hibernate.annotations.Type;

@Entity
@Table(name = "category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE) 
public class CategoryEntity extends BaseEntity{
  //Empty constructor, it's used by Hibernate.
  public CategoryEntity() {		
  }
	  
   public CategoryEntity(Long id, String name, String entityName, byte[] photo) {
	super();
	this.id = id;
	this.name = name;
	this.entityName = entityName;
	this.photo = photo;
   }

	@Id    
    @Column(name = "category_id")    
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment") 
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "entity_name")
    private String entityName;
    
    @Column(name = "photo")        
    private byte[] photo;
        
     //Static method to create instance. It is used for unit tests.
     public static BaseEntity createInstance() {
       //Test's data.
       byte[] photo  = new byte[] {5, 7, 18};
    	            
      return new CategoryEntity(1L, "IamCategoryEntity", "MyCategory",  photo); 
     } 

		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
			
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;					
		}				
	
		public String getEntityName() {
			return entityName;
		}

		public void setEntityName(String entityName) {
			this.entityName = entityName;
		}
		
		public byte[] getPhoto() {
			return photo;
		}

		public void setPhoto(byte[] photo) {
			this.photo = photo;
		} 
		
		 //Check if two instances are equal.
	     @Override
         public boolean equals(Object object) {

            if(!(object instanceof CategoryEntity)) {
                return false;
            }
            
            CategoryEntity other = (CategoryEntity) object;
            
             //Check equality of all fields:
             if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                return false;
             }
             
              if((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
                 return false;
              }
              
               if((this.entityName == null && other.entityName != null) || (this.entityName != null && !this.entityName.equals(other.entityName))) {
                  return false;
               }
               
                //Check equality of fields "photo"(byte arrays). 
                if((this.photo == null && other.photo != null) || (this.photo != null && other.photo == null)) return false;
               
                if((this.photo != null && other.photo != null)) {
                  //Check array's length. 
                  if((this.photo.length != other.photo.length)) return false; 	
                    //Check equality of each array's element.
                    for(int i = 0; i < this.photo.length; i++){
                	  if(this.photo[i] != other.photo[i]) return false;	
                    }                 
                }
               
          //If all fields are equal.    
          return true;
         }

	      @Override
	      public String toString() {
	     	return this.getClass().getCanonicalName()+" : [id= " + id + "  name = " + name + "  entityName = "+ entityName + "  photo = "+ photo.toString() +"]";
	      }		
}
//-------------------------------------------------------------------------------