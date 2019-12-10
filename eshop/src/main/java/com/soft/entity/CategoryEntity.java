//-------------------------------------------------------------------------------
package com.soft.entity;
import javax.persistence.Column;
//-------------------------------------------------------------------------------
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//-------------------------------------------------------------------------------
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CategoryEntity {

  public CategoryEntity() {		
  }
	
  public CategoryEntity(Long id, String name) {	
	this.id = id;
	this.name = name;
  }

	@Id    
    @Column(name = "category_id")    
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment") 
    private Long id;

    @Column(name = "name")
    private String name;

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
}
//-------------------------------------------------------------------------------