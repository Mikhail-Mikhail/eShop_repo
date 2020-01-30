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
@Table(name = "producer")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProducerEntity extends BaseEntity{
  //Empty constructor, it's used by Hibernate.
  public ProducerEntity() {		
  }	   

   public ProducerEntity(Long id, Integer producerCategory, String producerName) {
	 super();
	 this.id = id;
	 this.producerCategory = producerCategory;
	 this.producerName = producerName;
   }

	@Id    
    @Column(name = "producer_id")    
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment") 
    private Long id;

    @Column(name = "producer_category")
    private Integer producerCategory;
        
    @Column(name = "producer_name")
    private String producerName;
                  		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public Integer getProducerCategory() {
			return producerCategory;
		}
		
		public void setProducerCategory(Integer producerCategory) {
			this.producerCategory = producerCategory;
		}
		
		public String getProducerName() {
			return producerName;
		}
		
		public void setProducerName(String producerName) {
			this.producerName = producerName;
		}
		
		//Stub method implementation to extend abstract "BaseEntity" class.
		@Override
		public byte[] getPhoto() {
			// TODO Auto-generated method stub
			return null;
		}   

		@Override
         public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set.
            if (!(object instanceof ProducerEntity)) {
                return false;
            }
            ProducerEntity other = (ProducerEntity) object;
            if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                return false;
            }
            return true;
         }

          @Override
          public String toString() {
            return "com.soft.entity.ProducerEntity[ id=" + id +"  name=" + producerName + "]";
          }		
}
//-------------------------------------------------------------------------------