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


			@Override
	         public boolean equals(Object object) {
	            // TODO: Warning - this method won't work in the case the id fields are not set.
	            if (!(object instanceof TransistorEntity)) {
	                return false;
	            }
	            TransistorEntity other = (TransistorEntity) object;
	            if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
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