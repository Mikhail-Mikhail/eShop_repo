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
@Table(name = "resistor")
public class ResistorEntity extends BaseEntity{
	
  //Empty constructor, it's used by Hibernate.
  public ResistorEntity() {		
  }	  

	public ResistorEntity(Long id, Integer category, String name, String description, Integer producer, Double nominal,
		                  Integer nominalUnit, Double rPrecision, Double power, Integer powerUnit, Integer rPackage, byte[] photo,
		                   Double price, Integer quantity) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.description = description;
		this.producer = producer;
		this.nominal = nominal;
		this.nominalUnit = nominalUnit;
		this.rPrecision = rPrecision;
		this.power = power;
		this.powerUnit = powerUnit;
		this.rPackage = rPackage;
		this.photo = photo;
		this.price = price;
		this.quantity = quantity;
    }

		@Id    
	    @Column(name = "resistor_id")    
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
	    
	    @Column(name = "nominal")
	    private Double nominal;
	    
	    @Column(name = "nominal_unit")
	    private Integer nominalUnit;
	    
	    @Column(name = "r_precision")
	    private Double rPrecision;
	    
	    @Column(name = "power")
	    private Double power;
	    
	    @Column(name = "power_unit")
	    private Integer powerUnit;
	    
	    @Column(name = "package")
	    private Integer rPackage;
	    
	    @Column(name = "photo")
	    private byte[] photo;
	    
	    @Column(name = "price")
	    private Double price;
	    
	    @Column(name = "quantity")
	    private Integer quantity;	
	    
	    //Static method to create instance. It is used for unit tests.
	     public static BaseEntity createInstance() {
	       return new ResistorEntity(1L, 1, "IamResistorEntity", "ResistorDescription", 1, 2.2, 1, 1.5, 0.125, 1, 1, new byte[2], 100.25, 200); 
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
	
			public Double getNominal() {
				return nominal;
			}
	
			public void setNominal(Double nominal) {
				this.nominal = nominal;
			}
		
			public Integer getNominalUnit() {
				return nominalUnit;
			}
	
			public void setNominalUnit(Integer nominalUnit) {
				this.nominalUnit = nominalUnit;
			}
	
			public Double getrPrecision() {
				return rPrecision;
			}
	
			public void setrPrecision(Double rPrecision) {
				this.rPrecision = rPrecision;
			}
	
			public Double getPower() {
				return power;
			}
	
			public void setPower(Double power) {
				this.power = power;
			}
	
			public Integer getPowerUnit() {
				return powerUnit;
			}
	
			public void setPowerUnit(Integer powerUnit) {
				this.powerUnit = powerUnit;
			}
	
			public Integer getrPackage() {
				return rPackage;
			}
	
			public void setrPackage(Integer rPackage) {
				this.rPackage = rPackage;
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

	            if (!(object instanceof ResistorEntity)) {
	                return false;
	            }
	            	            
	            ResistorEntity other = (ResistorEntity) object;
	            
	             //Check equality of all fields:
	             if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
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
	            
	            
	             if((this.nominal == null && other.nominal != null) || (this.nominal != null && !this.nominal.equals(other.nominal))) {
	                return false;
	             }
	            
	            
	             if((this.nominalUnit == null && other.nominalUnit != null) || (this.nominalUnit != null && !this.nominalUnit.equals(other.nominalUnit))) {
	                return false;
	             }
	            
	            
	             if((this.rPrecision == null && other.rPrecision != null) || (this.rPrecision != null && !this.rPrecision.equals(other.rPrecision))) {
	                return false;
	             }
	            
	            
	             if((this.power == null && other.power != null) || (this.power != null && !this.power.equals(other.power))) {
	                return false;
	             }

	            
	             if((this.powerUnit == null && other.powerUnit != null) || (this.powerUnit != null && !this.powerUnit.equals(other.powerUnit))) {
	                return false;
	             }
	            
	            
	             if((this.rPackage == null && other.rPackage != null) || (this.rPackage != null && !this.rPackage.equals(other.rPackage))) {
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
	        			 "  description = " + description + "  producer = " + producer + "  nominal = " + nominal + "  nominalUnit = " + nominalUnit +
	        			 "  rPrecision = " + rPrecision + "  power = " + power + "  powerUnit = " + powerUnit + "  rPackage = " + rPackage + "  photo = " + photo +
	        			 "  price = " + price + "  quantity = " + quantity + "]";
	          }
}
//-------------------------------------------------------------------------------