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
@Table(name = "transistor")
public class TransistorEntity extends BaseEntity{
	
  //Empty constructor, it's used by Hibernate.
  public TransistorEntity() {		
  }	  
  
   	
	 public TransistorEntity(Long id, Integer category, String name, String description, Integer producer,
	                       	 String conductanceType, Double gain, Double maxCurrent, Integer maxCurrentUnit, Integer tPackage, byte[] photo,
		                     Double price, Integer quantity) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.description = description;
		this.producer = producer;
		this.conductanceType = conductanceType;
		this.gain = gain;
		this.maxCurrent = maxCurrent;
		this.maxCurrentUnit = maxCurrentUnit;
		this.tPackage = tPackage;
		this.photo = photo;
		this.price = price;
		this.quantity = quantity;
     }

		@Id    
	    @Column(name = "transistor_id")    
	    @GeneratedValue(generator="increment")
	    @GenericGenerator(name="increment", strategy = "increment") 
	    private Long id;
	
	    @Column(name = "category")
	    private Integer category;
	    
	    @Column(name = "name")
	    private String name;
	    
	    @Column(name = "description")
	    private String description;
	    
	    @Column(name = "producer")
	    private Integer producer;
	    
	    @Column(name = "conductunce_type")
	    private String conductanceType;
	    
	    @Column(name = "gain")
	    private Double gain;
	    
	    @Column(name = "max_current")
	    private Double maxCurrent;
	    
	    @Column(name = "max_current_unit")
	    private Integer maxCurrentUnit;	    
	    
	    @Column(name = "package")
	    private Integer tPackage;
	    
	    @Column(name = "photo")
	    private byte[] photo;
	    
	    @Column(name = "price")
	    private Double price;
	    
	    @Column(name = "quantity")
	    private Integer quantity;
		
	     //Static method to create instance. It is used for unit tests.
	     public static BaseEntity createInstance() {
	       return new TransistorEntity(1L, 1, "IamTransistorEntity", "TransistorDescription", 1, "n-p-n", 100.5, 1.5, 1, 1, new byte[2], 400.785, 120); 
	     } 
	
		    public Long getId() {
				return id;
			}
	
	
			public void setId(Long id) {
				this.id = id;
			}
	
	
			public Integer getCategory() {
				return category;
			}
	
	
			public void setCategory(Integer category) {
				this.category = category;
			}
	
	
			public String getName() {
				return name;
			}
	
	
			public void setName(String name) {
				this.name = name;
			}
	
	
			public String getDescription() {
				return description;
			}
	
	
			public void setDescription(String description) {
				this.description = description;
			}
	
			
			public Integer getProducer() {
				return producer;
			}
	
	
			public void setProducer(Integer producer) {
				this.producer = producer;
			}
	
	
			public String getConductanceType() {
				return conductanceType;
			}
	
	
			public void setConductanceType(String conductanceType) {
				this.conductanceType = conductanceType;
			}
	
	
			public Double getGain() {
				return gain;
			}
	
	
			public void setGain(Double gain) {
				this.gain = gain;
			}
	
	
			public Double getMaxCurrent() {
				return maxCurrent;
			}
	
	
			public void setMaxCurrent(Double maxCurrent) {
				this.maxCurrent = maxCurrent;
			}
	
			
			public Integer getMaxCurrentUnit() {
				return maxCurrentUnit;
			}
	
	
			public void setMaxCurrentUnit(Integer maxCurrentUnit) {
				this.maxCurrentUnit = maxCurrentUnit;
			}
	
	
			public Integer gettPackage() {
				return tPackage;
			}
	
	
			public void settPackage(Integer tPackage) {
				this.tPackage = tPackage;
			}
	
			
			public byte[] getPhoto() {
				return photo;
			}
	
	
			public void setPhoto(byte[] photo) {
				this.photo = photo;
			}
	
	
			public Double getPrice() {
				return price;
			}
	
	
			public void setPrice(Double price) {
				this.price = price;
			}
	
	
			public Integer getQuantity() {
				return quantity;
			}
	
	
			public void setQuantity(Integer quantity) {
				this.quantity = quantity;
			}

			
			//Check if two instances are equal.
			@Override
	         public boolean equals(Object object) {
	            
	            if (!(object instanceof TransistorEntity)) {
	                return false;
	            }
	            
	             TransistorEntity other = (TransistorEntity) object;
	            
		            //Check equality of all fields:
		            if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
		                return false;
		            }
		            
		            if((this.category == null && other.category != null) || (this.category != null && !this.category.equals(other.category))) {
		                return false;
		             }
		            
		            
		             if((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
		                return false;
		             }
		            
		            
		             if((this.description == null && other.description != null) || (this.description != null && !this.description.equals(other.description))) {
		                return false;
		             }
		            
		            
		             if((this.producer == null && other.producer != null) || (this.producer != null && !this.producer.equals(other.producer))) {
		                return false;
		             }
		            
		            
		             if((this.conductanceType == null && other.conductanceType != null) || (this.conductanceType != null && !this.conductanceType.equals(other.conductanceType))) {
		                return false;
		             }
		            
		            
		             if((this.gain == null && other.gain != null) || (this.gain != null && !this.gain.equals(other.gain))) {
		                return false;
		             }
		            
		            
		             if((this.maxCurrent == null && other.maxCurrent != null) || (this.maxCurrent != null && !this.maxCurrent.equals(other.maxCurrent))) {
		                return false;
		             }
		            
		            
		             if((this.maxCurrentUnit == null && other.maxCurrentUnit != null) || (this.maxCurrentUnit != null && !this.maxCurrentUnit.equals(other.maxCurrentUnit))) {
		                return false;
		             }
	
		            
		             if((this.tPackage == null && other.tPackage != null) || (this.tPackage != null && !this.tPackage.equals(other.tPackage))) {
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
	                
		              if((this.price == null && other.price != null) || (this.price != null && !this.price.equals(other.price))) {
		                return false;
		              }
		            
		              if((this.quantity == null && other.quantity != null) || (this.quantity != null && !this.quantity.equals(other.quantity))) {
		                return false;
		              }	            
	            
	          return true;
	         }
	
	          @Override
	          public String toString() {	        	  	        	 	  
	        	  
	        	  return this.getClass().getCanonicalName()+" : [id = " + id +"  category = " + category + "  name = " + name + 
		        			 "  description = " + description + "  producer = " + producer + "  conductanceType = " + conductanceType + "  gain = " + gain +
		        			 "  maxCurrent = " + maxCurrent + "  maxCurrentUnit = " + maxCurrentUnit + "  tPackage = " + tPackage + "  photo = " + photo +
		        			 "  price = " + price + "  quantity = " + quantity + "]";
	          }	
}
//-------------------------------------------------------------------------------