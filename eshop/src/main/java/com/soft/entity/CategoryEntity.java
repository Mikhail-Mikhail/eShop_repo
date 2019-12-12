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

@Entity
@Table(name = "category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CategoryEntity {
  //Empty constructor, it's used by Hibernate.
  public CategoryEntity() {		
  }
	
  public CategoryEntity(Long id, String name, byte[] photo) {	
	this.id = id;
	this.name = name;
	this.photo = photo;
  }

	@Id    
    @Column(name = "category_id")    
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment") 
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "photo")
    private byte[] photo;

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

		public byte[] getPhoto() {
			return photo;
		}

		public void setPhoto(byte[] photo) {
			this.photo = photo;
		} 
		
		
	     @Override
         public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set.
            if (!(object instanceof CategoryEntity)) {
                return false;
            }
            CategoryEntity other = (CategoryEntity) object;
            if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                return false;
            }
            return true;
         }

          @Override
          public String toString() {
            return "com.soft.entity.CategoryEntity[ id=" + id +"  name=" + name + "]";
          }   
}
//-------------------------------------------------------------------------------